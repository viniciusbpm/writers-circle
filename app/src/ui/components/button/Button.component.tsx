import './index.css';

interface ComponentProps {
  type: 'primary' | 'secondary';
  children: string;
  className?: string;
  // onClick?: (event: React.ChangeEvent<HTMLInputElement>) => void;
}

const Button = ({ type = 'primary', children, className }: ComponentProps) => {
  return <button className={`${type}-button ${className}`}>{children}</button>;
};

export default Button;
