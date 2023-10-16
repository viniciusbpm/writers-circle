import './index.css';

interface ComponentProps {
  type: 'primary' | 'secondary';
  content: string;
  className?: string;
  // onClick?: (event: React.ChangeEvent<HTMLInputElement>) => void;
}

const Button = ({ type = 'primary', content, className }: ComponentProps) => {
  return <button className={`${type}-button ${className}`}>{content}</button>;
};

export default Button;
