import './index.css';

interface ComponentProps {
  children?: string;
  color?: 'white' | 'red' | 'gray' | 'black';
  path: string;
  className?: string;
  underline?: boolean;
}

const Link = ({
  children = '',
  color = 'black',
  path,
  className = '',
  underline,
}: ComponentProps) => {
  return (
    <a
      href={path}
      className={`link ${className} link-${color} ${
        underline ? 'link-underline' : ''
      }`}
    >
      {children}
    </a>
  );
};

export default Link;
