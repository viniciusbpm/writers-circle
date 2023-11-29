import { useCookies } from 'react-cookie';
import { axiosInstance } from './axiosInstance';

export interface SuggestionsResponse {
  content: [
    {
      id: number;
      username: string;
      imagem: string;
    }
  ];
  last: boolean;
}

const useUserFunctions = () => {
  const [cookie] = useCookies(['user']);
  const suggestions = async (page: number): Promise<SuggestionsResponse> => {
    const response = await axiosInstance.get(
      `/usuarios/sugerir?page=${page}&size=5`,
      {
        headers: {
          Authorization: cookie.user,
        },
      }
    );
    return response.data;
  };

  return { suggestions };
};

export default useUserFunctions;
