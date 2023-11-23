import { axiosInstance } from './axiosInstance';

const usePhraseFunctions = () => {
  const getRandom = async () => {
    const response = await axiosInstance.get('/frases/aleatoria');

    return response.data;
  };
  return { getRandom };
};

export default usePhraseFunctions;
