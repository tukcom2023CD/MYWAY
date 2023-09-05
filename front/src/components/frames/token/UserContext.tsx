import React, {
  createContext,
  useState,
  useEffect,
  useContext,
  useMemo,
} from "react";
import { useNavigate } from "react-router-dom";

type User = {
  token: string;
  nickname: string;
  isNewUser: boolean;
};

type UserContextType = [
  User | null,
  React.Dispatch<React.SetStateAction<User | null>>
];

const UserContext = createContext<UserContextType | undefined>(undefined);

export const useUser = (): UserContextType => {
  const context = useContext(UserContext);
  if (!context) {
    throw new Error("useUser must be used within a UserProvider");
  }
  return context;
};

export const UserProvider: React.FC<{ children: React.ReactNode }> = ({
  children,
}) => {
  const [user, setUser] = useState<User | null>(null);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchTokenFromCookie = () => {
      const cookies = document.cookie.split("; ");
      const tokenCookie = cookies.find((cookie) => cookie.startsWith("token="));
      return tokenCookie ? tokenCookie.split("=")[1] : null;
    };

    const token = fetchTokenFromCookie();

    if (token) {
      const storedNickname = localStorage.getItem("nickname");
      const isNewUser = localStorage.getItem("isNewUser") === "true";

      if (storedNickname) {
        setUser({ token, nickname: storedNickname, isNewUser });
      } else {
        setUser({ token, nickname: "Guest", isNewUser: true });
        localStorage.setItem("isNewUser", "true");
        navigate("/ChangeNickname");
      }
    }
  }, [navigate]);

  const value = useMemo(() => [user, setUser] as UserContextType, [user]);

  return <UserContext.Provider value={value}>{children}</UserContext.Provider>;
};
