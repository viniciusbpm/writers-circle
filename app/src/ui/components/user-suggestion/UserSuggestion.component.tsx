import './index.css';
import placeholder from '../../../assets/img/user-placeholder.png';
import Title from '../title/Title.component';
import Button from '../button/Button.component';

interface ComponentProps {
  name: string;
}

const UserSuggestion = ({ name }: ComponentProps) => {
  return (
    <div className="suggestion-box">
      <img className="user-suggested-img" src={placeholder} alt="" />
      <div className="user-suggested-info">
        <Title type="h3">{name}</Title>
      </div>
      <Button type="secondary" className="add-suggested-friend">
        Adicionar amigo
      </Button>
    </div>
  );
};

export default UserSuggestion;
