import { useState } from "react";
import { styled } from "styled-components";

const ControlContainer = styled.div`
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
  margin-bottom: 1.5rem;
`;

const Label = styled.label`
  display: block;
  margin-bottom: 0.5rem;
  font-size: 0.75rem;
  font-weight: 700;
  letter-spacing: 0.1em;
  text-transform: uppercase;
  color: ${({invalid}) => invalid ? '#f87171' : '#6b7280'};
`;

const Input = styled.input`
  width: 100%;
  padding: 0.75rem 1rem;
  line-height: 1.5;
  background-color: #d1d5db;
  color: #374151;
  border: 1px solid transparent;
  border-radius: 0.25rem;
  box-shadow: 0 1px 3px 0 rgba(0, 0, 0, 0.1), 0 1px 2px 0 rgba(0, 0, 0, 0.06);
`;

// const ConrolConter = () => {}
export default function AuthInputs() {
  const [enteredEmail, setEnteredEmail] = useState("");
  const [enteredPassword, setEnteredPassword] = useState("");
  const [submitted, setSubmitted] = useState(false);

  function handleInputChange(identifier, value) {
    if (identifier === "email") {
      setEnteredEmail(value);
    } else {
      setEnteredPassword(value);
    }
  }

  function handleLogin() {
    setSubmitted(true);
  }

  const emailNotValid = submitted && !enteredEmail.includes("@"); // 이메일 값에 @가 없으면 미유효
  const passwordNotValid = submitted && enteredPassword.trim().length < 6; // 패스워드가 6자 미만이면 미유효

  return (
    <div id="auth-inputs">
      <ControlContainer>
        <p className="paragraph">
        {/* <Label className={`label ${emailNotValid ? "invalid" : ""}`}> */}
          <Label invalid={emailNotValid}>Email</Label>          
          <Input
            type="email"
            //  style={{
            //   backgroundColor: emailNotValid ? '#fed2f2' : '#d1d5db'
            //  }}
            onChange={(event) => handleInputChange("email", event.target.value)}
          />
        </p>
        <p>
          <Label className={`lable ${passwordNotValid ? "invalid" : ""}`}>
            Password
          </Label>
          <Input
            type="password"
            className={passwordNotValid ? "invalid" : undefined}
            onChange={(event) =>
              handleInputChange("password", event.target.value)
            }
          />
        </p>
      </ControlContainer>
      <div className="actions">
        <button type="button" className="text-button">
          계정생성
        </button>
        <button className="button" onClick={handleLogin}>
          로그인
        </button>
      </div>
    </div>
  );
}
