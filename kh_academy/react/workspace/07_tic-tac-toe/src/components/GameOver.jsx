export default function GameOver({winner, onRestart}){
    return(
        <div id="game-over">
            <h2>Game Over!</h2>
            {winner && <p>{winner}의 승리!</p>}
            {!winner && <p>비겼습니다!</p>}
            <p>
                <button onClick={onRestart}>재시작!</button>
            </p>
        </div>
    )
}