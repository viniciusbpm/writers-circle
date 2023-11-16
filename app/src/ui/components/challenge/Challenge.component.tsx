import Text from '../text/Text.component';
import Title from '../title/Title.component';
import './index.css';
import clock from '../../../assets/img/clock-icon.svg';
import arrow from '../../../assets/img/arrow-icon.svg';

interface ComponentProps {
  title: string;
  description: string;
  imageUrl: string;
}

const Challenge = ({ title, description, imageUrl }: ComponentProps) => {
  return (
    <div className="challenge-box">
      <img className="challenge-image" src={imageUrl} alt={title} />
      <div className="challenge-text">
        <div className="challenge-title-and-description">
          <Title size="small" type="h2">
            {title}
          </Title>
          <Text color="gray">{description}</Text>
        </div>
        <div className="challenge-bottom">
          <div className="challenge-time-left">
            <img src={clock} />
            <Text color="gray">3 dias restantes</Text>
          </div>
          <button className="enter-challenge-button">
            <Text className="enter-challenge-text">Ver desafio</Text>
            <img src={arrow}></img>
          </button>
        </div>
      </div>
    </div>
  );
};

export default Challenge;
