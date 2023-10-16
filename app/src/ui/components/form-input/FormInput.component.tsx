import './index.css';

interface ComponentProps {
  label: string;
  type: string;
  name?: string;
  id?: string;
  onChange: (event: React.ChangeEvent<HTMLInputElement>) => void;
  required?: boolean;
  className?: string;
}

const FormInput = ({
  label,
  type,
  onChange,
  required = false,
  name = label,
  id = label,
  className,
}: ComponentProps) => {
  return (
    <div className={`input-box ${className}`}>
      <label htmlFor={id}>{label}</label>
      <input
        type={type}
        name={name}
        id={id}
        onChange={onChange}
        required={required}
        className="input"
      />
    </div>
  );
};

export default FormInput;
