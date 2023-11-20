import './index.css';
import user from '../../../assets/img/user-placeholder.png';
import Title from '../title/Title.component';
import Text from '../text/Text.component';
import like from '../../../assets/img/heart-icon.svg';
import Button from '../button/Button.component';

interface ComponentProps {
  user: string;
  answer: string;
  likes: number;
  title: string;
}

const ChallengeAnswer = ({ user, answer, likes, title }: ComponentProps) => {
  return (
    <div className="challenge-answer-box">
      <div className="challenge-answer-top">
        <Title className="challenge-answer-top-title">{title}</Title>
      </div>
      <div className="challenge-answer-text-box">
        <Text className="challenge-answer-text">{answer}</Text>
      </div>
      <div className="challenge-answer-bottom">
        <div className="challenge-answer-bottom-like-box">
          <button className="challenge-answer-bottom-like-button">
            <img src={like} alt="Like" />
          </button>
          <Text>{likes.toString()}</Text>
        </div>
        <Text
          color="gray"
          className="challenge-answer-bottom-user"
        >{`Publicado por ${user}`}</Text>
      </div>
    </div>
  );
};

export default ChallengeAnswer;
