import React, { useState } from 'react';
import Menu from '../../components/frames/Side/Sidebar';
import TaskPopup from '../../components/Popup/TaskPopup';

function Task() {
  const [groups, setGroups] = useState([
    // 그룹과 아이템 데이터 초기화
    {
      id: 'group-1',
      name: '할 일',
      items: [
        {
          id: 'item-1',
          content: '다른 팀원이 생성한 프로젝트에 지원하는 기능',
          name: '팀 지원 기능',
          category: '개발',
        },
      ],
    },
    {
      id: 'group-2',
      name: '진행중',
      items: [
        {
          id: 'item-4',
          content: '최종 데모 체크',
          name: '최종 데모',
          category: '개발, 커뮤니케이션',
        },
      ],
    },
    {
      id: 'group-3',
      name: '완료',
      items: [
        {
          id: 'item-6',
          content: '아고라 질문 생성 기능',
          name: 'Agora 질문',
          category: '개발',
        },
        {
          id: 'item-7',
          content: '아고라 답변 기능',
          name: 'Agora 답변',
          category: '개발',
        },
        {
          id: 'item-8',
          content: 'task page refactory',
          name: 'task page',
          category: '리팩토링',
        },
        {
          id: 'item-9',
          content: 'pivot table 비교 기능',
          name: 'pivot table 비교',
          category: '개발',
        },
      ],
    },
  ]);

  const onDragStart = (
    event: React.DragEvent<HTMLDivElement>,
    groupId: string,
    itemId: string
  ) => {
    event.dataTransfer.setData('groupId', groupId);
    event.dataTransfer.setData('itemId', itemId);
  };

  const onDragOver = (event: { preventDefault: () => void }) => {
    event.preventDefault();
  };

  const onDrop = (
    event: React.DragEvent<HTMLDivElement>,
    destinationGroupId: string
  ) => {
    const groupId = event.dataTransfer.getData('groupId');
    const itemId = event.dataTransfer.getData('itemId');

    const updatedGroups = groups.map((group) => {
      if (group.id === groupId) {
        const updatedItems = group.items.filter((item) => item.id !== itemId);
        return {
          ...group,
          items: updatedItems,
        };
      }
      if (group.id === destinationGroupId) {
        const item = groups
          .find((group) => group.id === groupId)
          ?.items.find((item) => item.id === itemId);
        if (item) {
          return {
            ...group,
            items: [...group.items, item],
          };
        }
      }
      return group;
    });

    setGroups(updatedGroups);
  };

  const onDragEnter = (event: React.DragEvent<HTMLDivElement>) => {
    event.preventDefault();
    event.currentTarget.classList.add('drag-over');
  };

  const onDragLeave = (event: React.DragEvent<HTMLDivElement>) => {
    event.currentTarget.classList.remove('drag-over');
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
          {groups.map((group) => (
            <div
              key={group.id}
              className='flex flex-col flex-1 h-[700px] mr-2 ml-2 bg-[#d4d4d4] overflow-y-auto border-[#4a4a4a] border-2'
            >
              <div
                className='flex text-xl font-bold border p-2 mb-3 w-full bg-white'
                style={{ position: 'sticky', top: 0, zIndex: 999 }}
              >
                {group.name}
              </div>
              <div className='overflow-auto'>
                {group.items.map((item) => (
                  <div
                    key={item.id}
                    className='flex flex-col m-auto mb-3 w-[260px] h-[200px] rounded-[10px] bg-white'
                    draggable
                    onDragStart={(event) =>
                      onDragStart(event, group.id, item.id)
                    }
                    onDragOver={onDragOver}
                    onDrop={(event) => onDrop(event, group.id)}
                    onDragEnter={onDragEnter}
                    onDragLeave={onDragLeave}
                  >
                    <div className='flex justify-between items-center p-2 border w-full'>
                      {item.name}
                      <p>30P</p>
                    </div>
                    <div className='flex border justify-between items-center p-2'>
                      <p>sample</p>
                      {item.category}
                    </div>
                    <div className='flex flex-col p-2'>{item.content}</div>
                  </div>
                ))}
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

export default Task;
