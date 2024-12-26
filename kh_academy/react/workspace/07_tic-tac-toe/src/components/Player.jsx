import { useState } from 'react';

export default function Player({initialName, symbol, isActive, onChangeName}) {
  const [playerName, setPlayerName] = useState(initialName);
  const [ isEditing, setIsEditing] = useState(false);

  function handleEditClick(){
    setIsEditing((editing)=> !editing); // isEditing:false => isEditing:true
    
    if(isEditing){
      onChangeName(symbol, playerName);
    }
  }

  function handleChange(event){
    console.log(event.target.value);
    setPlayerName(event.target.value);
  }

  let editablePlayerName = <span className="player-name">{playerName}</span>;
  if(isEditing){
    editablePlayerName = <input type="text" required value={playerName} onChange={handleChange}/>;
  }
  return (
    <li className={isActive ? 'active' : undefined}>
      <span className="player">
        {editablePlayerName}
        <span className="player-symbol">{symbol}</span>
      </span>
      <button onClick={handleEditClick}>{isEditing ? '저장' : '편집'}</button>
    </li>
  );
}
