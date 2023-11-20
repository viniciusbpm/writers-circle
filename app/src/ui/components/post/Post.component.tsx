import Text from '../text/Text.component';
import Title from '../title/Title.component';
import './index.css';
import calendar from '../../../assets/img/calendar-icon.svg';

interface ComponentProps {
  title: string;
  description: string;
  imageUrl: string;
  className?: string;
}

const Post = ({
  title,
  description,
  imageUrl,
  className = '',
}: ComponentProps) => {
  return (
    <div className={`post-box ${className}`}>
      <div className="post-author"></div>
      <div className="post-content">
        <img className="post-image" src={imageUrl} alt={title} />
        <div className="post-text-box">
          <div className="post-title-description-box">
            <Title type="h3">{title}</Title>
            <Text color="gray" className="post-description">
              {description}
            </Text>
          </div>
          <div className="post-data">
            <img src={calendar} alt="" />
            <Text className="post-data-text" color="gray">
              Hoje às 21:00
            </Text>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Post;
