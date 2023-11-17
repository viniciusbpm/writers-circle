import Button from '../button/Button.component';
import Text from '../text/Text.component';
import Title from '../title/Title.component';
import brush from '../../../assets/img/brush-white.svg';
import './index.css';

interface ComponentProps {
  name: string;
  type: 'title' | 'badge';
  price: number;
  acquired?: boolean;
}

const ShopItem = ({ name, type, price, acquired = false }: ComponentProps) => {
  return (
    <div className="item-container">
      <Title type="h3" className="shop-item-name">
        {name}
      </Title>
      <Text className="shop-item-type">
        {type === 'title' ? 'Título' : 'Medalha'}
      </Text>
      <Button
        type="primary"
        className={`shop-item-button ${acquired ? 'shop-item-acquired' : ''}`}
      >
        {acquired ? <></> : <img src={brush} className="shop-item-brush" />}
        <Text className="shop-item-price">
          {acquired ? 'COMPRADO' : `${price}`}
        </Text>
      </Button>
    </div>
  );
};

export default ShopItem;
