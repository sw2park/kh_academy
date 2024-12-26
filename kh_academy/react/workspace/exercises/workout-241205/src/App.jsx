import React from "react";

import Workout from "./Workout.jsx";

const workouts = [
  {
    title: "푸쉬업",
    description: "30개 하기",
    time: 1000 * 60 * 3,
  },
  {
    title: "스쿼트",
    description: "30개하기",
    time: 1000 * 60 * 2,
  },
  {
    title: "풀업",
    description: "10개하기",
    time: 1000 * 60 * 3,
  },
];

function App() {
  const [completedWorkouts, setCompletedWorkouts] = React.useState([]);

  function handleWorkoutComplete(workoutTitle) {
    setCompletedWorkouts((prevCompletedWorkouts) => [
      ...prevCompletedWorkouts,
      workoutTitle,
    ]);
  }

  return (
    <main>
      <section>
        <h2>수행할 운동을 선택하세요</h2>
        <ul>
          {workouts.map((workout) => (
            <li key={workout.title}>
              <Workout
                {...workout}
                onComplete={() => handleWorkoutComplete(workout.title)}
              />
            </li>
          ))}
        </ul>
      </section>

      <section>
        <h2>Completed workouts</h2>
        <ul>
          {completedWorkouts.map((workoutTitle, index) => (
            <li key={index}>{workoutTitle}</li>
          ))}
        </ul>
      </section>
    </main>
  );
}

export default App;