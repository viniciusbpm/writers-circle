import './index.css';

interface ComponentProps {
  type: 'primary' | 'secondary';
  children: string | JSX.Element[] | JSX.Element;
  className?: string;
  onClick?: (event: React.MouseEvent<HTMLButtonElement, MouseEvent>) => void;
}

const Button = ({
  type = 'primary',
  children,
  className = '',
  onClick,
}: ComponentProps) => {
  return (
    <button className={`button ${type}-button ${className}`} onClick={onClick}>
      {children}
    </button>
  );
};

export default Button;
