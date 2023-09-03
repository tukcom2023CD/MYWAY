import React, {
  createContext,
  useState,
  useEffect,
  useContext,
  useMemo,
} from "react";

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
  const [showNicknamePopup, setShowNicknamePopup] = useState(false);

  useEffect(() => {
    const isLoginSuccessful = true;

    if (isLoginSuccessful) {
      const token = "some_token";
      const storedNickname = localStorage.getItem("nickname");

      if (storedNickname) {
        setUser({ token, nickname: storedNickname, isNewUser: false });
      } else {
        setShowNicknamePopup(true);
        setUser({ token, nickname: "Guest", isNewUser: true });
      }
    }
  }, []);

  const setNicknameAndHidePopup = (nickname: string) => {
    if (user) {
      setUser({ ...user, nickname });
    }
    localStorage.setItem("nickname", nickname);
    setShowNicknamePopup(false);
  };

  const value = useMemo(() => [user, setUser] as UserContextType, [user]);

  return (
    <UserContext.Provider value={value}>
      {children}
      {showNicknamePopup && (
        <div>
          <h2>Please set your nickname</h2>
          <input
            type='text'
            placeholder='Enter your nickname'
            onBlur={(e) => setNicknameAndHidePopup(e.target.value)}
          />
        </div>
      )}
    </UserContext.Provider>
  );
};
