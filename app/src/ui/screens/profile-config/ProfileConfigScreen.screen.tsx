import Button from '../../components/button/Button.component';
import Title from '../../components/title/Title.component';
import { useState } from 'react';
import './index.css';
import placeholder from '../../../assets/img/add-image-placeholder.png';
import { useNavigate } from 'react-router-dom';

const ProfileConfigScreen = () => {
  const [page, setPage] = useState(0);
  const navigate = useNavigate();

  const showContent = () => {
    if (page === 0) {
      return (
        <>
          <Title size="large">
            Bem vindo PaulOtt! Antes de começar a utilizar o Writers Circle,
            vamos fazer a configuração inicial do seu perfil
          </Title>
          <Button
            className="next-config-button"
            type="primary"
            onClick={handleClickEvent}
          >
            Próximo
          </Button>
        </>
      );
    }

    if (page === 1) {
      return (
        <>
          <Title size="large">Adicione uma foto de perfil:</Title>
          <button className="add-profile-picture-button">
            <img src={placeholder} />
          </button>
          <Button
            type="secondary"
            onClick={handleClickEvent}
            className="skip-config-button"
          >
            Pular
          </Button>
        </>
      );
    }

    if (page === 2) {
      return (
        <>
          <Title size="large">Adicione uma bio ao seu perfil</Title>
          <textarea
            className="bio"
            name="bio"
            id="bio"
            cols={115}
            rows={15}
          ></textarea>
          <Button
            className="next-config-button"
            type="primary"
            onClick={handleClickEvent}
          >
            Próximo
          </Button>
          <Button
            type="secondary"
            onClick={handleClickEvent}
            className="skip-config-button"
          >
            Pular
          </Button>
        </>
      );
    }

    if (page === 3) {
      return (
        <>
          <Title size="large">
            Escolha um ou mais gêneros que você possui interesse:
          </Title>
          <input
            className="genre-search-input"
            type="text"
            name="genre"
            id="genre"
          />
          <Button
            className="next-config-button"
            type="primary"
            onClick={handleClickEvent}
          >
            Próximo
          </Button>
        </>
      );
    }

    if (page === 4) {
      return (
        <>
          <Title className="favorites-title" size="large">
            Adicione algumas informações para a recomendação de amigos:
          </Title>
          <Title className="favorites-input-title" weight="normal">
            Qual seu escritor favorito?
          </Title>
          <input
            className="favorites-input"
            type="text"
            name="genre"
            id="genre"
          />
          <Title className="favorites-input-title" size="large" weight="normal">
            Qual seu livro favorito?
          </Title>
          <input
            className="favorites-input"
            type="text"
            name="genre"
            id="genre"
          />
          <Button
            className="next-config-button"
            type="primary"
            onClick={handleClickEvent}
          >
            Próximo
          </Button>
          <Button
            type="secondary"
            onClick={handleClickEvent}
            className="skip-config-button"
          >
            Pular
          </Button>
        </>
      );
    }
  };

  const handleClickEvent = () => {
    if (page != 4) {
      setPage(page + 1);
    } else {
      navigate('/');
    }
  };

  return (
    <div className="profile-config-box">
      <div className="profile-config-text-box">{showContent()}</div>
    </div>
  );
};

export default ProfileConfigScreen;
