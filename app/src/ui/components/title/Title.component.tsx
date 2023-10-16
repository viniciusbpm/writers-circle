import './index.css';

interface ComponentProps {
  children?: string;
  type?: 'h1' | 'h2' | 'h3';
  className?: string;
  size?: 'small' | 'medium' | 'large';
  color?: 'white' | 'red' | 'gray';
  bold?: boolean;
  weight?: 'bold' | 'normal';
}

const Title = ({
  children,
  type = 'h1',
  className = '',
  size,
  color,
  weight,
}: ComponentProps) => {
  switch (type) {
    case 'h1':
      return (
        <h1
          className={`title-${size} title-${color} title-${weight} ${className}`}
        >
          {children}
        </h1>
      );
    case 'h2':
      return (
        <h2
          className={`title-${size} title-${color} title-${weight} ${className}`}
        >
          {children}
        </h2>
      );
    case 'h3':
      return (
        <h3
          className={`title-${size} title-${color} title-${weight} ${className}`}
        >
          {children}
        </h3>
      );
  }
};

export default Title;
