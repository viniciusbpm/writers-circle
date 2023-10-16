import './index.css';

interface ComponentProps {
  children?: string;
  color?: 'white' | 'red' | 'gray' | 'black';
  path: string;
  className?: string;
}

const Link = ({
  children = '',
  color = 'black',
  path,
  className = '',
}: ComponentProps) => {
  return (
    <a href={path} className={`link ${className} link-${color}`}>
      {children}
    </a>
  );
};

export default Link;
