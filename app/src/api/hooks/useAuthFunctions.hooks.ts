import { axiosInstance } from './axiosInstance';

const useAuthFunctions = () => {
  const login = async (username: string, password: string) => {
    const response = await axiosInstance.post('/auth/login', {
      username: username,
      password: password,
    });

    return response.data;
  };

  const register = async (
    username: string,
    email: string,
    password: string,
    birthDate: Date
  ) => {
    const response = await axiosInstance.post('/auth/register', {
      username: username,
      email: email,
      senha: password,
      dataNascimento: birthDate,
    });

    return response.data;
  };

  return { login, register };
};

export default useAuthFunctions;
