import Button from '../../components/button/Button.component';
import Title from '../../components/title/Title.component';
import { useState, useEffect } from 'react';
import './index.css';
import placeholder from '../../../assets/img/add-image-placeholder.png';
import { useNavigate } from 'react-router-dom';
import useGenreFunctions, {
  GenreResponse,
} from '../../../api/hooks/useGenreFunctions.hooks';
import GenreSearchResult from '../../components/genre-search-result/GenreSearchResult.component';
import SelectedGenre from '../../components/selected-genre/SelectedGenre.component';
import useProfileConfigFunctions from '../../../api/hooks/useProfileConfigFunctions.hooks';
import { useCookies } from 'react-cookie';

const ProfileConfigScreen = () => {
  const [page, setPage] = useState(0);
  const [cookie, setCookie] = useCookies();
  const navigate = useNavigate();
  const { list } = useGenreFunctions();
  const { sendConfig } = useProfileConfigFunctions();
  const [searchText, setSearchText] = useState('');
  const [profileGenres, setProfileGenres] = useState<string[]>([]);
  const [genreList, setGenreList] = useState<GenreResponse[]>([]);
  const [profileConfig, setProfileConfig] = useState({
    imgUrl: '',
    bio: '',
    favAuthor: '',
    favBook: '',
  });

  const handleChange = (
    event:
      | React.ChangeEvent<HTMLTextAreaElement>
      | React.ChangeEvent<HTMLInputElement>
  ) => {
    const { name, value } = event.currentTarget;
    setProfileConfig((oldFormInput) => ({
      ...oldFormInput,
      [name]: value,
    }));
  };

  const handleChangeSearchInput = (
    event: React.ChangeEvent<HTMLInputElement>
  ) => {
    setSearchText(event.currentTarget.value);
  };

  const handleClickOnGenreFromList = (
    event: React.MouseEvent<HTMLElement, MouseEvent>
  ) => {
    if (
      profileGenres.length < 5 &&
      !profileGenres.includes(event.currentTarget.innerText)
    ) {
      setProfileGenres([...profileGenres, event.currentTarget.innerText]);
    }
  };

  const handleClickOnSelectedGenre = (
    event: React.MouseEvent<HTMLElement, MouseEvent>
  ) => {
    const genres = profileGenres.filter(
      (item) => item !== event.currentTarget.innerText
    );
    setProfileGenres(genres);
  };

  const handleClickOnFinalButton = () => {
    const genres = genreList?.filter((genre) =>
      profileGenres.includes(genre.nome)
    );
    try {
      sendConfig(
        genres,
        profileConfig.favAuthor,
        profileConfig.imgUrl,
        profileConfig.bio,
        profileConfig.favBook
      );
      console.log(profileConfig);
      navigate('/comunidade');
    } catch (error) {
      console.log('deu erro');
    }
  };

  useEffect(() => {
    const fetchGenres = async () => {
      const data = await list();
      setGenreList(data);
    };

    fetchGenres();
  }, []);

  const showContent = () => {
    if (page === 0) {
      return (
        <>
          <Title size="large" className="profile-config-title">
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
          <img
            src={profileConfig.imgUrl ? profileConfig.imgUrl : placeholder}
            className="add-profile-picture-image"
          />
          <input
            type="text"
            name="imgUrl"
            id="img-url"
            placeholder="Digite aqui o URL da imagem..."
            className="add-profile-picture-input"
            onChange={handleChange}
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
            onChange={handleChange}
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
          <Title size="medium">
            Escolha até 5 gêneros que você possui interesse:
          </Title>
          <input
            className="genre-search-input"
            type="text"
            name="genre"
            id="genre"
            onChange={handleChangeSearchInput}
          />
          <div className="genre-search-results-box">
            {searchText != ''
              ? genreList
                  ?.filter((item) =>
                    item.nome.toLowerCase().includes(searchText.toLowerCase())
                  )
                  .map((item) => (
                    <GenreSearchResult
                      key={item.id}
                      name={item.nome}
                      onClick={handleClickOnGenreFromList}
                    />
                  ))
              : null}
          </div>
          <Button
            className="next-config-button"
            type="primary"
            onClick={handleClickEvent}
            disabled={profileGenres.length === 0}
          >
            Próximo
          </Button>
          <div className="selected-genres">
            {genreList
              ?.filter((item) => profileGenres.includes(item.nome))
              .map((item) => (
                <SelectedGenre
                  key={item.id}
                  name={item.nome}
                  onClick={handleClickOnSelectedGenre}
                />
              ))}
          </div>
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
            name="favAuthor"
            id="genre"
            onChange={handleChange}
          />
          <Title className="favorites-input-title" size="large" weight="normal">
            Qual seu livro favorito?
          </Title>
          <input
            className="favorites-input"
            type="text"
            name="favBook"
            id="genre"
            onChange={handleChange}
          />
          <Button
            className="next-config-button"
            type="primary"
            onClick={handleClickOnFinalButton}
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
