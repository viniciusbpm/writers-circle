import { useCookies } from 'react-cookie';
import { axiosInstance } from './axiosInstance';
import { GenreResponse } from './useGenreFunctions.hooks';

const useProfileConfigFunctions = () => {
  const [cookie] = useCookies(['user']);

  const sendConfig = async (
    genres: GenreResponse[],
    author?: string,
    imageUrl?: string,
    bio?: string,
    book?: string
  ) => {
    const response = await axiosInstance.put(
      '/usuarios/detalhes',
      {
        imagemPerfil: imageUrl,
        bio: bio,
        generos: genres,
        escritorFavorito: author,
        livroFavorito: book,
      },
      {
        headers: {
          Authorization: `Bearer ${cookie.user}`,
        },
      }
    );

    return response.data;
  };
  return { sendConfig };
};

export default useProfileConfigFunctions;
