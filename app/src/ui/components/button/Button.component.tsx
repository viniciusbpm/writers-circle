import './index.css';

interface ComponentProps {
  type: 'primary' | 'secondary';
  children: string;
  className?: string;
  onClick?: (event: React.MouseEvent<HTMLButtonElement, MouseEvent>) => void;
}

const Button = ({
  type = 'primary',
  children,
  className,
  onClick,
}: ComponentProps) => {
  return (
    <button className={`button ${type}-button ${className}`} onClick={onClick}>
      {children}
    </button>
  );
};

export default Button;
