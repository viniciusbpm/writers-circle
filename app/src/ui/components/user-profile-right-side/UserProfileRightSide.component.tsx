import { useState } from 'react';
import Button from '../button/Button.component';
import './index.css';
import Post from '../post/Post.component';

const UserProfileRightSide = () => {
  const [currentPage, setCurrentPage] = useState('Publicações');

  const handleClickEvent = (
    event: React.MouseEvent<HTMLButtonElement, MouseEvent>
  ) => {
    setCurrentPage(event.currentTarget.innerText);
  };

  return (
    <div className="user-profile-right-side">
      <div className="user-profile-nav-bar">
        <Button
          type="primary"
          className={`user-profile-nav-bar-button ${
            currentPage === 'Publicações'
              ? 'user-profile-nav-bar-current-page'
              : ''
          }`}
          onClick={handleClickEvent}
        >
          Publicações
        </Button>
        <Button
          type="primary"
          className={`user-profile-nav-bar-button ${
            currentPage === 'Obras' ? 'user-profile-nav-bar-current-page' : ''
          }`}
          onClick={handleClickEvent}
        >
          Obras
        </Button>
        <Button
          type="primary"
          className={`user-profile-nav-bar-button ${
            currentPage === 'Amigos' ? 'user-profile-nav-bar-current-page' : ''
          }`}
          onClick={handleClickEvent}
        >
          Amigos
        </Button>
      </div>
      <div className="user-profile-right-side-content">
        <Post
          title="post jamais visto"
          description="jamais"
          imageUrl="https://images.mubicdn.net/images/cast_member/3686/cache-6742-1650540236/image-w856.jpg?size=800x"
          className="user-profile-post"
        />
        <Post
          title="post jamais visto"
          description="jamais"
          imageUrl="https://images.mubicdn.net/images/cast_member/3686/cache-6742-1650540236/image-w856.jpg?size=800x"
          className="user-profile-post"
        />
        <Post
          title="post jamais visto"
          description="jamais"
          imageUrl="https://images.mubicdn.net/images/cast_member/3686/cache-6742-1650540236/image-w856.jpg?size=800x"
          className="user-profile-post"
        />
        <Post
          title="post jamais visto"
          description="jamais"
          imageUrl="https://images.mubicdn.net/images/cast_member/3686/cache-6742-1650540236/image-w856.jpg?size=800x"
          className="user-profile-post"
        />
        <Post
          title="post jamais visto"
          description="jamais"
          imageUrl="https://images.mubicdn.net/images/cast_member/3686/cache-6742-1650540236/image-w856.jpg?size=800x"
          className="user-profile-post"
        />
      </div>
    </div>
  );
};

export default UserProfileRightSide;
