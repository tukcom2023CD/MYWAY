import React, {
  createContext,
  useState,
  useEffect,
  useContext,
  useMemo,
} from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

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

interface Member {
  id: number;
  name: string;
}

interface Team {
  id: number;
  name: string;
  industryGroup: string;
}

interface TeamData {
  id: number;
  rank: string;
  isAcceptMember: boolean;
  isAcceptTeam: boolean;
  nickname: string;
  member: Member;
  team: Team;
}

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
  const [teamData, setTeamData] = useState<TeamData[]>();
  const navigate = useNavigate();

  useEffect(() => {
    const fetchTokenFromCookie = () => {
      const cookies = document.cookie.split("; ");
      const tokenCookie = cookies.find((cookie) => cookie.startsWith("token="));
      return tokenCookie ? tokenCookie.split("=")[1] : null;
    };

    const fetchTeamData = async () => {
      try {
        const response = await axios.get("staffs/myteam");
        setTeamData(response.data);
        if (response.data && response.data[0]?.nickname === "sample") {
          navigate("/ChangeNickname");
        }
      } catch (error) {
        console.error(error);
      }
    };

    const token = fetchTokenFromCookie();
    const storedNickname = localStorage.getItem("nickname");

    if (token) {
      if (storedNickname) {
        setUser({ token, nickname: storedNickname, isNewUser: false });
      } else {
        setUser({ token, nickname: "Guest", isNewUser: true });
        fetchTeamData();
      }
    }
  }, [navigate]);

  const value = useMemo(() => [user, setUser] as UserContextType, [user]);

  return <UserContext.Provider value={value}>{children}</UserContext.Provider>;
};
