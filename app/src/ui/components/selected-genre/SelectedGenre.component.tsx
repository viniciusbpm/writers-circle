import Text from '../text/Text.component';
import './index.css';
import trash from '../../../assets/img/delete-icon.svg';

interface ComponentProps {
  name: string;
  onClick?: (event: React.MouseEvent<HTMLElement, MouseEvent>) => void;
}

const SelectedGenre = ({ name, onClick }: ComponentProps) => {
  return (
    <div className="selected-genre" onClick={onClick}>
      <Text color="red" className="selected-genre-text">
        {name}
      </Text>
      <img className="selected-genre-delete-icon" src={trash} />
    </div>
  );
};

export default SelectedGenre;
