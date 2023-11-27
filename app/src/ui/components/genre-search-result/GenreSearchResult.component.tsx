import Text from '../text/Text.component';
import './index.css';

interface ComponentProps {
  name: string;
  onClick?: (event: React.MouseEvent<HTMLElement, MouseEvent>) => void;
}

const GenreSearchResult = ({ name, onClick }: ComponentProps) => {
  return (
    <div className="genre-search-result" onClick={onClick}>
      <Text className="genre-search-result-text">{name}</Text>
    </div>
  );
};

export default GenreSearchResult;
