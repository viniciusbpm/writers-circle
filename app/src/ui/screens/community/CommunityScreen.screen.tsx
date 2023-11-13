import './index.css';
import NavBar from '../../components/nav-bar/NavBar.component';
import Title from '../../components/title/Title.component';
import UserSuggestion from '../../components/user-suggestion/UserSuggestion.component';
import Button from '../../components/button/Button.component';
import Post from '../../components/post/Post.component';
import post from '../../../assets/img/post-placeholder.png';

const CommunityScreen = () => {
  return (
    <div className="community-container">
      <NavBar currentPage="comunidade" />
      <div className="content-box">
        <div className="user-suggestions">
          <Title size="small" weight="normal">
            Usuários sugeridos:
          </Title>
          <UserSuggestion name="PmNunes" bio="asdaosdas..." />
          <UserSuggestion name="PmNunes" bio="asdaosdas..." />
          <UserSuggestion name="PmNunes" bio="asdaosdas..." />
          <UserSuggestion name="PmNunes" bio="asdaosdas..." />
          <UserSuggestion name="PmNunes" bio="asdaosdas..." />
          <Button type="primary" className="load-more-button">
            Carregar mais
          </Button>
        </div>
        <div className="posts">
          <Post
            title="Titulo do livro"
            description="Um livro"
            imageUrl={post}
          />
          <Post
            title="Titulo do livro"
            description="Lorem Ipsum is simply dummasddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssy texdsa as dasd as da sd sa da sad asd as das das das t of the asdasdasdasasdasdasdasdasdasadsasdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadasdasdasdasdasdasdaddprinting and typesetting has... asd asd as das d as dsa d aas dsad asd asd as  d as das das d as d as d as d as das d  as asd  s aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
            imageUrl={post}
          />
          <Post
            title="Titulo do livro"
            description="Lorem Ipsum is simply dummasddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssy texdsa as dasd as da sd sa da sad asd as das das das t of the asdasdasdasasdasdasdasdasdasadsasdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadasdasdasdasdasdasdaddprinting and typesetting has... asd asd as das d as dsa d aas dsad asd asd as  d as das das d as d as d as d as das d  as asd  s aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
            imageUrl={post}
          />
          <Post
            title="Titulo do livro"
            description="Lorem Ipsum is simply dummasddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssy texdsa as dasd as da sd sa da sad asd as das das das t of the asdasdasdasasdasdasdasdasdasadsasdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadasdasdasdasdasdasdaddprinting and typesetting has... asd asd as das d as dsa d aas dsad asd asd as  d as das das d as d as d as d as das d  as asd  s aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
            imageUrl={post}
          />
          <Post
            title="Titulo do livro"
            description="Lorem Ipsum is simply dummasddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssy texdsa as dasd as da sd sa da sad asd as das das das t of the asdasdasdasasdasdasdasdasdasadsasdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadasdasdasdasdasdasdaddprinting and typesetting has... asd asd as das d as dsa d aas dsad asd asd as  d as das das d as d as d as d as das d  as asd  s aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
            imageUrl={post}
          />
          <Button type="primary" className="load-more-button">
            Carregar mais
          </Button>
        </div>
      </div>
    </div>
  );
};

export default CommunityScreen;
