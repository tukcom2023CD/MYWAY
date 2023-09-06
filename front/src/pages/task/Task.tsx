import React, { useState, useEffect } from "react";
import { useUser } from "../../components/frames/token/UserContext";
import Menu from "../../components/frames/Side/Sidebar";
import TaskPopup from "../../components/Popup/TaskPopup";

function Task() {
  const [user] = useUser();
  const currentNickname = user ? user.nickname : "권순호";

  const initialGroups = [
    {
      id: "group-1",
      name: "할 일",
      items: [
        {
          id: "item-1",
          content: "최종 데모 영상 제출 14일까지",
          name: "최종 데모 영상 제출",
          category: "개발",
          owner: "최정훈",
        },
        {
          id: "item-2",
          content: "5차 발표 피드백 내용 수정",
          name: "5차 발표 피드백",
          category: "개발",
          owner: "최정훈",
        },
      ],
    },
    {
      id: "group-2",
      name: "진행중",
      items: [
        {
          id: "item-3",
          content: "5차 발표 데모",
          name: "5차 발표",
          category: "커뮤니케이션",
          owner: "최정훈",
        },
        {
          id: "item-6",
          content: "관리자 등급 이상만 수정 가능",
          name: "관리자 전용",
          category: "커뮤니케이션",
          owner: "권순호",
        },
      ],
    },
    {
      id: "group-3",
      name: "완료",
      items: [
        {
          id: "item-4",
          content: "5차 발표에 사용할 데모 기능 구현",
          name: "데모 기능 구현",
          category: "개발",
          owner: "최정훈",
        },
        {
          id: "item-5",
          content: "프론트 코드 리팩토링",
          name: "코드 리팩토링",
          category: "리팩토링",
          owner: "최정훈",
        },
      ],
    },
  ];

  const [groups, setGroups] = useState(() => {
    const savedGroups = localStorage.getItem("groups");
    return savedGroups ? JSON.parse(savedGroups) : initialGroups;
  });

  useEffect(() => {
    const savedGroups = localStorage.getItem("groups");
    if (savedGroups) {
      const parsedGroups = JSON.parse(savedGroups);
      setGroups(parsedGroups);
    }
  }, []);

  useEffect(() => {
    localStorage.setItem("groups", JSON.stringify(groups));
  }, [groups]);

  const onDragStart = (
    event: React.DragEvent<HTMLDivElement>,
    groupId: string,
    itemId: string,
    itemOwner: string
  ) => {
    if (currentNickname !== "최정훈" || currentNickname === itemOwner) {
      if (groupId && itemId) {
        event.dataTransfer.setData("groupId", groupId);
        event.dataTransfer.setData("itemId", itemId);
      }
    } else {
      alert("드래그앤 드랍 권한이 없습니다.");
      event.preventDefault();
    }
  };

  const onDragOver = (event: { preventDefault: () => void }) => {
    event.preventDefault();
  };

  const onDrop = (
    event: React.DragEvent<HTMLDivElement>,
    destinationGroupId: string
  ) => {
    const sourceGroupId = event.dataTransfer.getData("groupId");
    const itemId = event.dataTransfer.getData("itemId");

    const sourceGroup = groups.find(
      (group: { id: string }) => group.id === sourceGroupId
    );
    const destinationGroup = groups.find(
      (group: { id: string }) => group.id === destinationGroupId
    );

    if (sourceGroup && destinationGroup) {
      const item = sourceGroup.items.find(
        (item: { id: string }) => item.id === itemId
      );
      if (item) {
        const newSourceItems = sourceGroup.items.filter(
          (i: { id: string }) => i.id !== itemId
        );
        sourceGroup.items = newSourceItems;

        destinationGroup.items.push(item);

        setGroups([...groups]);
      }
    }
  };

  const onDragEnter = (event: React.DragEvent<HTMLDivElement>) => {
    event.preventDefault();
    event.currentTarget.classList.add("drag-over");
  };

  const onDragLeave = (event: React.DragEvent<HTMLDivElement>) => {
    event.currentTarget.classList.remove("drag-over");
  };

  return (
    <div className='flex m-auto w-[1440px] h-[100vh]'>
      <div>
        <Menu />
      </div>
      <div className='flex flex-col justfiy-center items-center m-auto w-[1024px] h-[800px] bg-white rounded-[10px] border'>
        <div className='flex justify-between items-center w-full p-5 h-[50px] bg-[#6A6A6A]'>
          <p className='text-white text-md font-bold'>테스크 리스트</p>
          <TaskPopup />
        </div>
        <div className='flex w-[950px] h-[690px] mt-5'>
          {groups.map(
            (group: {
              id: React.Key | null | undefined;
              name:
                | string
                | number
                | boolean
                | React.ReactElement<
                    any,
                    string | React.JSXElementConstructor<any>
                  >
                | React.ReactFragment
                | React.ReactPortal
                | null
                | undefined;
              items: {
                id: React.Key | null | undefined;
                name:
                  | string
                  | number
                  | boolean
                  | React.ReactElement<
                      any,
                      string | React.JSXElementConstructor<any>
                    >
                  | React.ReactFragment
                  | React.ReactPortal
                  | null
                  | undefined;
                category:
                  | string
                  | number
                  | boolean
                  | React.ReactElement<
                      any,
                      string | React.JSXElementConstructor<any>
                    >
                  | React.ReactFragment
                  | React.ReactPortal
                  | null
                  | undefined;
                content:
                  | string
                  | number
                  | boolean
                  | React.ReactElement<
                      any,
                      string | React.JSXElementConstructor<any>
                    >
                  | React.ReactFragment
                  | React.ReactPortal
                  | null
                  | undefined;
              }[];
            }) => (
              <div
                key={group.id}
                className='flex flex-col flex-1 h-[700px] mr-2 ml-2 bg-[#d4d4d4] overflow-y-auto border-[#4a4a4a] border-2'
              >
                <div
                  className='flex text-xl font-bold border p-2 mb-3 w-full bg-white'
                  style={{ position: "sticky", top: 0, zIndex: 999 }}
                >
                  {group.name}
                </div>
                <div className='overflow-auto'>
                  {group.items.map(
                    (item: {
                      id: React.Key | null | undefined;
                      name:
                        | string
                        | number
                        | boolean
                        | React.ReactElement<
                            any,
                            string | React.JSXElementConstructor<any>
                          >
                        | React.ReactFragment
                        | React.ReactPortal
                        | null
                        | undefined;
                      category:
                        | string
                        | number
                        | boolean
                        | React.ReactElement<
                            any,
                            string | React.JSXElementConstructor<any>
                          >
                        | React.ReactFragment
                        | React.ReactPortal
                        | null
                        | undefined;
                      content:
                        | string
                        | number
                        | boolean
                        | React.ReactElement<
                            any,
                            string | React.JSXElementConstructor<any>
                          >
                        | React.ReactFragment
                        | React.ReactPortal
                        | null
                        | undefined;
                    }) => (
                      <div
                        key={item.id ? item.id : Math.random().toString()}
                        className='flex flex-col m-auto mb-3 w-[260px] h-[200px] rounded-[10px] bg-white'
                        draggable
                        onDragStart={(event) => {
                          if (item.id && group.id) {
                            const itemAsAny = item as any;
                            onDragStart(
                              event,
                              group.id.toString(),
                              item.id.toString(),
                              itemAsAny.owner
                            );
                          }
                        }}
                        onDragOver={onDragOver}
                        onDrop={(event) => onDrop(event, group.id as string)}
                        onDragEnter={onDragEnter}
                        onDragLeave={onDragLeave}
                      >
                        <div className='flex justify-between items-center p-2 border w-full'>
                          {item.name}
                          <p>30P</p>
                        </div>
                        <div className='flex border justify-between items-center p-2'>
                          <p>{(item as any).owner}</p>
                          {item.category}
                        </div>
                        <div className='flex flex-col p-2'>{item.content}</div>
                      </div>
                    )
                  )}
                </div>
              </div>
            )
          )}
        </div>
      </div>
    </div>
  );
}

export default Task;
