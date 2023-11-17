import NavBar from '../../components/nav-bar/NavBar.component';
import Text from '../../components/text/Text.component';
import brush from '..//../../assets/img/brush-icon.svg';
import Title from '../../components/title/Title.component';
import './index.css';
import ShopItem from '../../components/shop-item/ShopItem.component';

const ShopScreen = () => {
  return (
    <div className="shop-container">
      <NavBar currentPage="loja" />
      <div className="shop-box">
        <div className="shop-top">
          <Title weight="normal">
            Personalize seu perfil com os itens da loja!
          </Title>
          <div className="shop-user-ink">
            <img className="shop-user-ink-image" src={brush} />
            <Text className="shop-user-ink-text">230 tintas</Text>
          </div>
        </div>
        <div className="shop-content">
          <ShopItem
            name="Escritor iniciante"
            type="title"
            price={100}
            acquired
          />
          <ShopItem
            name="Escritor intermediário"
            type="title"
            price={100}
            acquired
          />
          <ShopItem name="Escritor avançado" type="title" price={100} />
          <ShopItem name="Aprendiz de Asimov" type="title" price={100} />
          <ShopItem
            name="Aprendiz de Tolkien"
            type="title"
            price={100}
            acquired
          />
          <ShopItem name="Machadinho" type="title" price={100} />
        </div>
      </div>
    </div>
  );
};

export default ShopScreen;
