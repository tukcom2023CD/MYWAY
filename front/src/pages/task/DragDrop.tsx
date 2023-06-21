import React from 'react';
import { Draggable, DraggableProvided } from 'react-beautiful-dnd';

interface Group {
  id: string;
  name: string;
  items: {
    id: string;
    content: string;
    name: string;
    category: string;
  }[];
}

interface DragDropProps {
  group: Group;
  items: {
    id: string;
    content: string;
    name: string;
    category: string;
  }[];
  provided: DraggableProvided;
  item: {
    id: string;
    content: string;
    name: string;
    category: string;
  };
}

const DragDrop: React.FC<DragDropProps> = ({
  group,
  items,
  provided,
  item,
}) => (
  <div
    className='flex flex-col p-5 w-full h-[300px] rounded-[15px] mb-3 border'
    ref={provided.innerRef}
    {...provided.draggableProps}
    {...provided.dragHandleProps}
  >
    {item.content}
    {item.name}
    {item.category}
  </div>
);

export default DragDrop;
