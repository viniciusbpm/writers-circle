import ChallengeAnswer from '../../components/challenge-answer/ChallengeAnswer.component';
import NavBar from '../../components/nav-bar/NavBar.component';
import './index.css';

const ChallengeAnswersScreen = () => {
  return (
    <div className="challenge-answers-box">
      <NavBar currentPage="desafios" />
      <div className="challenge-answers-content">
        <ChallengeAnswer
          user="Kirchmair"
          answer="Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
          likes={20}
          title="Lorem Ipsum"
        />
        <ChallengeAnswer
          user="Kirchmair"
          answer="Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
          likes={20}
          title="Lorem Ipsum"
        />
        <ChallengeAnswer
          user="Kirchmair"
          answer="Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
          likes={20}
          title="Lorem Ipsum"
        />
        <ChallengeAnswer
          user="Kirchmair"
          answer="Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
          likes={20}
          title="Lorem Ipsum"
        />
      </div>
    </div>
  );
};

export default ChallengeAnswersScreen;
