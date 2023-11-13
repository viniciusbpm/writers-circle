import './index.css';

interface ComponentProps {
  children?: string;
  className?: string;
  color?: 'black' | 'gray';
}

const Text = ({ children, className, color = 'black' }: ComponentProps) => {
  return <p className={`${className} text-${color}`}>{children}</p>;
};

export default Text;
