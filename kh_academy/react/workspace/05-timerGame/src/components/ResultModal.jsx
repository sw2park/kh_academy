import { forwardRef } from "react"

const ResultModal = forwardRef(function ResultModal({result, targetTime}, ref) {
    return <dialog ref={ref} className="result-modal" >
        <h2>You {result}</h2>
        <p> 목표시간 : <strong>{targetTime}</strong>초</p>
        <p> 남은시간 : <strong>X</strong>초</p>
        <form method="dialog">
            <button>닫기</button>
        </form>
    </dialog>
})

export default ResultModal;