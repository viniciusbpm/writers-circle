import './index.css';

interface ComponentProps {
  type: 'primary' | 'secondary';
  children: string | JSX.Element[] | JSX.Element;
  className?: string;
  onClick?: (event: React.MouseEvent<HTMLButtonElement, MouseEvent>) => void;
  disabled?: boolean;
}

const Button = ({
  type = 'primary',
  children,
  className = '',
  onClick,
  disabled = false,
}: ComponentProps) => {
  return (
    <button
      className={`button ${type}-button ${className} ${
        disabled ? 'button-disabled' : ''
      }`}
      onClick={onClick}
      disabled={disabled}
    >
      {children}
    </button>
  );
};

export default Button;
