import Link from '../../components/link/Link.component';
import NavBar from '../../components/nav-bar/NavBar.component';
import challengeImage from '../../../assets/img/challenge-placeholder.png';
import './index.css';
import Text from '../../components/text/Text.component';
import Button from '../../components/button/Button.component';
import Title from '../../components/title/Title.component';

const ChallengeDetailsScreen = () => {
  return (
    <div className="challenge-details-box">
      <NavBar currentPage="desafios" />
      <div className="challenge-details-content">
        <div className="challenge-details-image-box">
          <img className="challenge-details-image" src={challengeImage} />
          <Text className="challenge-details-suggested-by">
            Desafio sugerido por LoremIpsum
          </Text>
        </div>
        <div className="challenge-details-text">
          <div className="challenge-details-text-top">
            <Title className="challenge-details-title">
              Crie uma história de romance em um parágrafo
            </Title>
            <Text className="challenge-details-description" color="gray">
              Quanto tempo leva para a chama do amor surgir? 3 meses? 2 semanas?
              Ou 1 parágrafo?
            </Text>
          </div>
          <div className="challenge-details-text-bottom">
            <Button type="primary">Iniciar</Button>
            <Link color="red" path="">
              Ver histórias da comunidade
            </Link>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ChallengeDetailsScreen;
