import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import LoginScreen from './ui/screens/login/LoginScreen.screen';
import { Toaster } from 'react-hot-toast';
import RegisterScreen from './ui/screens/register/RegisterScreen.screen';
import ProfileConfigScreen from './ui/screens/profile-config/ProfileConfigScreen.screen';
import CommunityScreen from './ui/screens/community/CommunityScreen.screen';

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
]);

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <Toaster />
    <RouterProvider router={router} />
  </React.StrictMode>
);
