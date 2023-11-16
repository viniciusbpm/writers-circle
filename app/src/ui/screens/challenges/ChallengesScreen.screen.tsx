import Challenge from '../../components/challenge/Challenge.component';
import NavBar from '../../components/nav-bar/NavBar.component';
import './index.css';
import challengeimg from '../../../assets/img/challenge-placeholder.png';

const ChallengesScreen = () => {
  return (
    <div className="challenges-container">
      <NavBar currentPage="desafios" />
      <div className="challenges-content">
        <Challenge
          imageUrl={challengeimg}
          title="Nos conte sua versão da história"
          description="Nós começamos, você termina. Crie sua própria versão dessa história e veja as diferentes interpretações da comunidade."
        />
        <Challenge
          imageUrl={challengeimg}
          title="Nos conte sua versão da história"
          description="Nós começamos, você termina. Crie sua própria versão dessa história e veja as diferentes interpretações da comunidade."
        />
        <Challenge
          imageUrl={challengeimg}
          title="Nos conte sua versão da história"
          description="Nós começamos, você termina. Crie sua própria versão dessa história e veja as diferentes interpretações da comunidade."
        />
        <Challenge
          imageUrl={challengeimg}
          title="Nos conte sua versão da história"
          description="Nós começamos, você termina. Crie sua própria versão dessa história e veja as diferentes interpretações da comunidade."
        />
      </div>
    </div>
  );
};

export default ChallengesScreen;
