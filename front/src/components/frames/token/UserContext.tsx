import React, { createContext, useState, useContext, useMemo } from "react";

type User = {
  token: string;
};

type UserContextType = [
  User | null,
  React.Dispatch<React.SetStateAction<User | null>>
];

const UserContext = createContext<UserContextType | undefined>(undefined);

export const useUser = () => {
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

  const value = useMemo(() => [user, setUser] as UserContextType, [user]);

  return <UserContext.Provider value={value}>{children}</UserContext.Provider>;
};
