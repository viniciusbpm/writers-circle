import Text from '../text/Text.component';
import './index.css';

interface ComponentProps {
  infoTitle: string;
  infoContent: string;
}

const UserDetailsInfo = ({ infoTitle, infoContent }: ComponentProps) => {
  return (
    <div className="user-details-info-box">
      <Text>{infoTitle}</Text>
      <Text color="gray">{infoContent}</Text>
    </div>
  );
};

export default UserDetailsInfo;
