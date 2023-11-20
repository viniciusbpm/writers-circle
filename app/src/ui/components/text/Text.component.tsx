import './index.css';

interface ComponentProps {
  children?: string;
  className?: string;
  color?: 'black' | 'gray' | 'red';
}

const Text = ({ children, className, color = 'black' }: ComponentProps) => {
  return <p className={`text ${className} text-${color}`}>{children}</p>;
};

export default Text;
