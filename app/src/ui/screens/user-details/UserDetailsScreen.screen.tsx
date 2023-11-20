import NavBar from '../../components/nav-bar/NavBar.component';
import user from '../../../assets/img/user-placeholder.png';
import './index.css';
import Title from '../../components/title/Title.component';
import Text from '../../components/text/Text.component';
import UserDetailsInfo from '../../components/user-details-info/UserDetailsInfo.component';
import Link from '../../components/link/Link.component';

const UserDetailsScreen = () => {
  return (
    <div className="user-details-box">
      <NavBar currentPage="minha-area" />
      <div className="user-details-content">
        <div className="user-details-image-box">
          <img src={user} className="user-details-image" />
          <Link
            path="/usuario/idUsuario"
            color="red"
            className="user-details-image-return-button"
          >
            Voltar
          </Link>
        </div>
        <div className="user-details-text">
          <Title type="h2">PaulOtt</Title>
          <Text color="gray">
            Lorem Ipsum is simply dummy text of the printing and typesetting
            industry. Lorem Ipsum has been the industry's standard dummy text.
          </Text>
          <div className="user-details-text-user-info">
            <UserDetailsInfo
              infoTitle="Livro favorito:"
              infoContent="LoremIpsum"
            />
            <UserDetailsInfo
              infoTitle="Autor favorito:"
              infoContent="LoremIpsum"
            />
            <UserDetailsInfo infoTitle="Obras publicadas:" infoContent="5" />
            <UserDetailsInfo
              infoTitle="Data de nascimento:"
              infoContent="22/11/2005"
            />
            <UserDetailsInfo
              infoTitle="Membro desde:"
              infoContent="22/11/2010"
            />
            <UserDetailsInfo
              infoTitle="Gêneros de interesse:"
              infoContent="Fantasia, Ficção científica, Distopia, Ação e aventura, 
              Ficção Policial, Horror."
            />
          </div>
        </div>
      </div>
    </div>
  );
};

export default UserDetailsScreen;
