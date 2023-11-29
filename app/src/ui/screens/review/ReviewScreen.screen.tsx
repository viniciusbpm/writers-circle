import NavBar from '../../components/nav-bar/NavBar.component';
import Text from '../../components/text/Text.component';
import Title from '../../components/title/Title.component';
import img from '../../../assets/img/article-placeholder.png';
import './index.css';
import { useParams } from 'react-router-dom';
import { useEffect, useState } from 'react';
import useReviewFunctions, {
  ReviewResponse,
} from '../../../api/hooks/useReviewFunctions.hooks';

const ReviewScreen = () => {
  const { postId } = useParams();
  const { detail } = useReviewFunctions();
  const [postInfo, setPostInfo] = useState<ReviewResponse>();

  useEffect(() => {
    const fetchReview = async () => {
      const postIdNumber = parseInt(postId!);
      const data = await detail(postIdNumber);
      setPostInfo(data);
    };
    fetchReview();
  }, []);

  return (
    <div className="article-box">
      <NavBar currentPage="comunidade" />
      <div className="article-content">
        <img src={postInfo?.imagem} className="article-image" />
        <Title className="article-title">{postInfo?.titulo}</Title>
        <Text
          color="black"
          className="article-rating"
        >{`Nota: ${postInfo?.nota.toString()}`}</Text>
        <Text color="gray">{postInfo?.conteudo}</Text>
        <Text className="article-author">{`Escrito por: ${postInfo?.autor}`}</Text>
      </div>
    </div>
  );
};

export default ReviewScreen;
