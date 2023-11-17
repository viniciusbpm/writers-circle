import './index.css';
import { useState } from 'react';
import { AxiosError } from 'axios';
import FormInput from '../../components/form-input/FormInput.component';
import Button from '../../components/button/Button.component';
import Title from '../../components/title/Title.component';
import Link from '../../components/link/Link.component';
import useAuthFunctions from '../../../api/hooks/useAuthFunctions.hooks';
import toast from 'react-hot-toast';
import { useNavigate } from 'react-router-dom';

const RegisterScreen = () => {
  const { register } = useAuthFunctions();
  const navigate = useNavigate();
  const [registerInput, setRegisterInput] = useState({
    username: { value: '' },
    email: { value: '' },
    password: { value: '' },
    confirmPassword: { value: '' },
    birthDate: { value: new Date() },
  });

  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = event.currentTarget;
    setRegisterInput((oldFormInput) => ({
      ...oldFormInput,
      [name]: { value: value },
    }));
  };

  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    if (registerInput.password.value === registerInput.confirmPassword.value) {
      try {
        const user = await register(
          registerInput.username.value,
          registerInput.email.value,
          registerInput.password.value,
          registerInput.birthDate.value
        );
        toast.success('Usuário criado com sucesso');
        navigate('/');
      } catch (error) {
        if (error instanceof AxiosError) {
          toast.error(error.response?.data.message);
        }
      }
    } else toast.error('As senhas devem ser iguais');
  };

  return (
    <div className="login-box">
      <div className="login-left-side">
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
            label="Email:"
            type="email"
            name="email"
            id="email"
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
          <FormInput
            label="Confirmar senha:"
            type="password"
            name="confirmPassword"
            id="confirm-password"
            onChange={handleChange}
            required
          />
          <FormInput
            label="Data de nascimento:"
            type="date"
            name="birthDate"
            id="birth-date"
            onChange={handleChange}
            required
          />
          <Button type="primary">Registrar</Button>
        </form>
        <p>
          Já possui uma conta?{' '}
          <Link path="/" underline>
            Fazer login
          </Link>
        </p>
      </div>
      <div className="login-right-side">
        <Title type="h2" size="large" color="white" weight="normal">
          Crie uma conta para começar a utilizar o Writers Circle.
        </Title>
      </div>
    </div>
  );
};

export default RegisterScreen;
