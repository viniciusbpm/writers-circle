import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import LoginScreen from './ui/screens/login/LoginScreen.screen';
import { Toaster } from 'react-hot-toast';
import RegisterScreen from './ui/screens/register/RegisterScreen.screen';
import ProfileConfigScreen from './ui/screens/profile-config/ProfileConfigScreen.screen';
import CommunityScreen from './ui/screens/community/CommunityScreen.screen';
import ChallengesScreen from './ui/screens/challenges/ChallengesScreen.screen';
import ShopScreen from './ui/screens/shop/ShopScreen.screen';
import ChallengeDetailsScreen from './ui/screens/challenge-details/ChallengeDetailsScreen.screen';
import UserProfileScreen from './ui/screens/user-profile/UserProfileScreen.screen';
import UserDetailsScreen from './ui/screens/user-details/UserDetailsScreen.screen';
import ChallengeAnswersScreen from './ui/screens/challenge-answers/ChallengeAnswersScreen.screen';
import AnswerChallengeScreen from './ui/screens/answer-challenge/AnswerChallengeScreen.screen';
import ArticleScreen from './ui/screens/article/ArticleScreen.screen';
import BookPageScreen from './ui/screens/book-page/BookPageScreen.screen';

const router = createBrowserRouter([
  {
    path: '/',
    element: <LoginScreen />,
  },
  {
    path: '/registro',
    element: <RegisterScreen />,
  },
  {
    path: '/configuracoes-perfil',
    element: <ProfileConfigScreen />,
  },
  {
    path: '/comunidade',
    element: <CommunityScreen />,
  },
  {
    path: '/desafios',
    element: <ChallengesScreen />,
  },
  {
    path: '/loja',
    element: <ShopScreen />,
  },
  {
    path: '/desafio/idDesafio',
    element: <ChallengeDetailsScreen />,
  },
  {
    path: '/desafio/idDesafio/respostas',
    element: <ChallengeAnswersScreen />,
  },
  {
    path: '/desafio/idDesafio/responder',
    element: <AnswerChallengeScreen />,
  },
  {
    path: '/usuario/idUsuario',
    element: <UserProfileScreen />,
  },
  {
    path: '/usuario/idUsuario/detalhes',
    element: <UserDetailsScreen />,
  },
  {
    path: '/artigos/idArtigo',
    element: <ArticleScreen />,
  },
  {
    path: '/obras/idObra',
    element: <BookPageScreen />,
  },
]);

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <Toaster />
    <RouterProvider router={router} />
  </React.StrictMode>
);
