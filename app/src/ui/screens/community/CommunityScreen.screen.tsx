import './index.css';
import NavBar from '../../components/nav-bar/NavBar.component';
import Title from '../../components/title/Title.component';
import UserSuggestion from '../../components/user-suggestion/UserSuggestion.component';
import Button from '../../components/button/Button.component';
import Post from '../../components/post/Post.component';
import useReviewFunctions, {
  PageableReviewResponse,
} from '../../../api/hooks/useReviewFunctions.hooks';
import { useEffect, useState } from 'react';
import useUserFunctions, {
  SuggestionsResponse,
} from '../../../api/hooks/useUserFunctions.hooks';

const CommunityScreen = () => {
  const { list } = useReviewFunctions();
  const { suggestions } = useUserFunctions();
  const [posts, setPosts] = useState<PageableReviewResponse>();
  const [postsPage, setPostsPage] = useState(0);
  const [userSuggestionPage] = useState(0);
  const [userSuggestions, setUserSuggestions] = useState<SuggestionsResponse>();

  useEffect(() => {
    const fetchPosts = async () => {
      const data = await list(postsPage);
      setPosts(data);
    };
    fetchPosts();
  }, []);

  useEffect(() => {
    const fetchUserSuggestions = async () => {
      const data = await suggestions(userSuggestionPage);
      setUserSuggestions(data);
    };
    fetchUserSuggestions();
  }, []);

  const handleClickLoadMorePosts = async () => {
    setPostsPage(postsPage + 1);
    await list(postsPage);
  };

  return (
    <div className="community-container">
      <NavBar currentPage="comunidade" />
      <div className="content-box">
        <div className="user-suggestions">
          <Title
            size="small"
            weight="normal"
            className="user-suggestions-title"
          >
            Usuários sugeridos:
          </Title>
          {userSuggestions?.content?.map((item) => (
            <UserSuggestion name={item.username} />
          ))}
          {!userSuggestions?.last ? (
            <Button type="primary" className="load-more-button">
              Carregar mais
            </Button>
          ) : null}
        </div>
        <div className="posts">
          {posts?.content?.map((item) => (
            <Post
              id={item.id}
              key={item.id}
              title={item.titulo}
              description={item.conteudo}
              imageUrl={item.imagem}
            />
          ))}
          {!posts?.last ? (
            <Button type="primary" onClick={handleClickLoadMorePosts}>
              Mostrar mais
            </Button>
          ) : null}
        </div>
      </div>
    </div>
  );
};

export default CommunityScreen;
