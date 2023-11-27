import './index.css';
import logo from '../../../assets/img/logo.png';
import { useState, useEffect } from 'react';
import { AxiosError } from 'axios';
import FormInput from '../../components/form-input/FormInput.component';
import Button from '../../components/button/Button.component';
import Title from '../../components/title/Title.component';
import Link from '../../components/link/Link.component';
import useAuthFunctions from '../../../api/hooks/useAuthFunctions.hooks';
import toast from 'react-hot-toast';
import { useNavigate } from 'react-router-dom';
import usePhraseFunctions from '../../../api/hooks/usePhraseFunctions.hooks';
import Text from '../../components/text/Text.component';
import { useCookies } from 'react-cookie';
import decode from '../../../utils/decodeJwt.util';

const LoginScreen = () => {
  const { login } = useAuthFunctions();
  const navigate = useNavigate();
  const { getRandom } = usePhraseFunctions();
  const [loginInput, setLoginInput] = useState({
    username: { value: '' },
    password: { value: '' },
  });
  const [phrase, setPhrase] = useState('');
  const [author, setAuthor] = useState('');
  const [cookie, setCookie] = useCookies();

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

      setCookie('user', user.token);

      const decoded = decode(user.token);

      if (decoded.usuarioNovo) {
        navigate('/configuracoes-perfil');
      } else {
        navigate('/comunidade');
      }
    } catch (error) {
      if (error instanceof AxiosError) {
        toast.error(error.response?.data.message);
      }
    }
  };

  useEffect(() => {
    const fetchPhrase = async () => {
      const data = await getRandom();
      setPhrase(data.frase);
      setAuthor(data.autor);
    };
    fetchPhrase();
  }, []);

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
        <Title
          type="h2"
          color="white"
          weight="normal"
          className="login-right-side-phrase"
        >
          {phrase}
        </Title>
        <Text color="white">{`- ${author}`}</Text>
      </div>
    </div>
  );
};

export default LoginScreen;
