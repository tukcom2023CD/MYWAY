import React, {
  createContext,
  useState,
  useEffect,
  useContext,
  useMemo,
} from "react";
import Modal from "react-modal";

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
  const [modalIsOpen, setIsOpen] = useState(false);

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
        setIsOpen(true);
        setUser({ token, nickname: "Guest", isNewUser: true });
        localStorage.setItem("isNewUser", "true");
      }
    }
  }, []);

  const setNicknameAndHidePopup = (nickname: string) => {
    if (user) {
      setUser({ ...user, nickname, isNewUser: false });
    }
    localStorage.setItem("nickname", nickname);
    localStorage.setItem("isNewUser", "false");
    setIsOpen(false);
  };

  const value = useMemo(() => [user, setUser] as UserContextType, [user]);

  return (
    <UserContext.Provider value={value}>
      {children}
      <Modal
        className='w-[100vw] h-[100vh] flex justify-center items-center fixed bg-[#404040]'
        isOpen={modalIsOpen}
        onRequestClose={() => setIsOpen(false)}
        contentLabel='Nickname Modal'
      >
        <form className='border flex flex-col justify-center items-center m-auto bg-white w-[480px] h-[600px] rounded-[30px]'>
          <label
            htmlFor='summary'
            className='mb-4 w-[430px] font-bold text-[20px]'
          >
            닉네임 변경
            <input
              type='text'
              placeholder='닉네임을 입력하세요.'
              className='text-[20px] w-[430px] border-b-2'
              onBlur={(e) => setNicknameAndHidePopup(e.target.value)}
            />
          </label>
          <button
            type='submit'
            className='flex justify-center items-center w-[100px] h-[40px] rounded-[10px] bg-[#4A4A4A] text-white text-[15px]'
          >
            변경하기
          </button>
        </form>
      </Modal>
    </UserContext.Provider>
  );
};
