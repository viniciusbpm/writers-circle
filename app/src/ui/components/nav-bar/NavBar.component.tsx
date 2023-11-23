import './index.css';
import Link from '../link/Link.component';
import logo from '../../../assets/img/nav-bar-logo.png';
import notifications from '../../../assets/img/notificacoes.svg';

interface ComponentProps {
  currentPage?: 'comunidade' | 'desafios' | 'loja' | 'minha-area';
}

const NavBar = ({ currentPage }: ComponentProps) => {
  return (
    <div className="navigation-bar">
      <Link className="nav-bar-logo-button" path="/comunidade">
        <img className="nav-bar-logo" src={logo} alt="Writers Circle" />
      </Link>
      <div>
        <Link
          path="/comunidade"
          color="white"
          className={`nav-bar-item ${
            currentPage === 'comunidade' ? 'current-page' : ''
          }`}
        >
          Comunidade
        </Link>
        <Link
          path="/desafios"
          color="white"
          className={`nav-bar-item ${
            currentPage === 'desafios' ? 'current-page' : ''
          }`}
        >
          Desafios
        </Link>
        <Link
          path="/loja"
          color="white"
          className={`nav-bar-item ${
            currentPage === 'loja' ? 'current-page' : ''
          }`}
        >
          Loja
        </Link>
        <Link
          path="/usuario/idUsuario"
          color="white"
          className={`nav-bar-item ${
            currentPage === 'minha-area' ? 'current-page' : ''
          }`}
        >
          Minha área
        </Link>
      </div>
      <button className="notifications-button">
        <img src={notifications} />
      </button>
    </div>
  );
};

export default NavBar;
