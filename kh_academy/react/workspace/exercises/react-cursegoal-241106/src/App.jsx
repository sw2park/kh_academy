import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

const CURSEARR = [
  {title : "리액트 배우기", description : "와 재밌다"},
  {title : "JS도 배우기", description : "심화과정"},
  {title : "프로그래밍 배우기", description : "와 재밌네"},
]

export function CourseGoal({title = '제목이 설정되지 않았습니다.', 
                            description = '내용이 설정되지 않았습니다.'}) {
  return (
    <li>
      <h2>{title}</h2>
      <p>{description}</p>
    </li>
  );
}

function App() {
  return (
    <div id="app" data-testid="app">
      <h1>연습문제3</h1>
      <p>하나의 컴포넌트로 다수의 출력을! 🎯</p>
      <ul>
        <CourseGoal {...CURSEARR[0]}/>
        <CourseGoal {...CURSEARR[1]}/>
        <CourseGoal {...CURSEARR[2]}/>
      </ul>
    </div>
  );
}

export default App
