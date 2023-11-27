import { useCookies } from 'react-cookie';
import { axiosInstance } from './axiosInstance';

export interface GenreResponse {
  id: number;
  nome: string;
}

const useGenreFunctions = () => {
  const [cookie] = useCookies(['user']);

  const list = async (): Promise<GenreResponse[]> => {
    const response = await axiosInstance.get(`/generos`, {
      headers: {
        Authorization: `Bearer ${cookie.user}`,
      },
    });

    return response.data;
  };
  return { list };
};

export default useGenreFunctions;
