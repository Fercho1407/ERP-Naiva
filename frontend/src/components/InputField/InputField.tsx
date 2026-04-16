import type { InputHTMLAttributes } from "react";
import "./InputField.css";

type InputFieldProps = {
  label: string;
  name: string;
  error?: string;
} & InputHTMLAttributes<HTMLInputElement>;

const InputField = ({ label, name, error, ...props }: InputFieldProps) => {
  return (
    <div className="input-field">
      <label className="input-field__label" htmlFor={name}>
        {label}
      </label>

      <input className="input-field__input" id={name} name={name} {...props} />

      {error && <span className="input-field__error">{error}</span>}
    </div>
  );
};

export default InputField;