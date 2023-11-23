import './index.css';
import logo from '../../../assets/img/logo.png';
import { useState } from 'react';
import { AxiosError } from 'axios';
import FormInput from '../../components/form-input/FormInput.component';
import Button from '../../components/button/Button.component';
import Title from '../../components/title/Title.component';
import Link from '../../components/link/Link.component';
import useAuthFunctions from '../../../api/hooks/useAuthFunctions.hooks';
import toast from 'react-hot-toast';
import { useNavigate } from 'react-router-dom';

const LoginScreen = () => {
  const { login } = useAuthFunctions();
  const navigate = useNavigate();
  const [loginInput, setLoginInput] = useState({
    username: { value: '' },
    password: { value: '' },
  });

  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = event.currentTarget;
    setLoginInput((oldFormInput) => ({
      ...oldFormInput,
      [name]: { value: value },
    }));
  };

  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    try {
      const user = await login(
        loginInput.username.value,
        loginInput.password.value
      );
    } catch (error) {
      if (error instanceof AxiosError) {
        toast.error(error.response?.data.message);
      }
    }
  };

  return (
    <div className="login-box">
      <div className="login-left-side">
        <img src={logo} className="login-logo" alt="Writers Circle" />
        <form className="login-form" onSubmit={handleSubmit}>
          <FormInput
            label="Username:"
            type="text"
            name="username"
            id="username"
            onChange={handleChange}
            required
          />
          <FormInput
            label="Senha:"
            type="password"
            name="password"
            id="password"
            onChange={handleChange}
            required
          />
          <Button type="primary">Entrar</Button>
        </form>
        <p>
          Não possui uma conta?{' '}
          <Link path="/registro" underline>
            Cadastre-se
          </Link>
        </p>
      </div>
      <div className="login-right-side">
        <Title type="h2" size="large" color="white" weight="normal">
          "Escrever é esquecer. A literatura é a maneira mais agradável de
          ignorar a vida."
        </Title>
      </div>
    </div>
  );
};

export default LoginScreen;
