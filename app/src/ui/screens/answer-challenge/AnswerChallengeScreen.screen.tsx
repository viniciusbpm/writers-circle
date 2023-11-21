import Button from '../../components/button/Button.component';
import NavBar from '../../components/nav-bar/NavBar.component';
import Text from '../../components/text/Text.component';
import Title from '../../components/title/Title.component';
import './index.css';

const AnswerChallengeScreen = () => {
  return (
    <div className="answer-challenge-box">
      <NavBar currentPage="desafios" />
      <div className="answer-challenge-content">
        <div className="challenge-title-and-description">
          <Title className="answer-challenge-title" type="h2" weight="normal">
            Crie uma história de romance em um parágrafo
          </Title>
          <Text color="gray" className="answer-challenge-description">
            Quanto tempo leva para a chama do amor surgir? 3 meses? 2 semanas?
            Ou 1 parágrafo?
          </Text>
        </div>
        <Title className="answer-challenge-label" type="h2">
          Envie sua resposta ao desafio:
        </Title>
        <input
          type="text"
          name="answer-title"
          id="answer-title"
          className="answer-challenge-title-input"
          placeholder="Escreva o título do seu texto aqui..."
        />
        <textarea
          id="answer"
          name="answer"
          className="answer-challenge-textbox"
          placeholder="Escreva seu texto aqui..."
        ></textarea>
        <Button type="primary" className="answer-challenge-button">
          Enviar
        </Button>
      </div>
    </div>
  );
};

export default AnswerChallengeScreen;
