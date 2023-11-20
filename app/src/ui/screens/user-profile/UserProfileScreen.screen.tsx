import NavBar from '../../components/nav-bar/NavBar.component';
import UserProfileRightSide from '../../components/user-profile-right-side/UserProfileRightSide.component';
import './index.css';
import userPlaceholder from '../../../assets/img/user-placeholder.png';
import Title from '../../components/title/Title.component';
import brush from '../../../assets/img/brush-icon.svg';
import redArrow from '../../../assets/img/red-arrow-icon.svg';
import Text from '../../components/text/Text.component';
import Link from '../../components/link/Link.component';
import { useNavigate } from 'react-router-dom';

const UserProfileScreen = () => {
  const navigate = useNavigate();

  const handleClickEvent = () => {
    navigate('/usuario/idUsuario/detalhes');
  };

  return (
    <div className="user-profile-box">
      <NavBar currentPage="minha-area" />
      <div className="user-profile-content">
        <div className="user-profile-info">
          <img src={userPlaceholder} className="user-profile-info-image" />
          <Title type="h2">PaulOtt</Title>
          <div className="user-profile-info-ink">
            <img src={brush} />
            <Text>250 tintas</Text>
          </div>
          <Text color="gray" className="user-profile-info-bio">
            Lorem Ipsum is simply dummy text of the printing and typesetting
            industry. Lorem Ipsum has been the industry's standard dummy text
          </Text>
          <button
            className="user-profile-info-button"
            onClick={handleClickEvent}
          >
            <Text color="red" className="user-profile-info-link">
              Ver mais
            </Text>
            <img src={redArrow} />
          </button>
        </div>
        <UserProfileRightSide />
      </div>
    </div>
  );
};

export default UserProfileScreen;
