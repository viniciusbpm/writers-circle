import { useCookies } from 'react-cookie';
import { axiosInstance } from './axiosInstance';

export interface PageableReviewResponse {
  content: [
    {
      id: number;
      titulo: string;
      obraAvaliada: string;
      conteudo: string;
      nota: number;
      dataPublicacao: Date;
      imagem: string;
    }
  ];
  last: boolean;
}

export interface ReviewResponse {
  id: number;
  titulo: string;
  obraAvaliada: string;
  autor: string;
  conteudo: string;
  nota: number;
  dataPublicacao: Date;
  imagem: string;
}

const useReviewFunctions = () => {
  const [cookie] = useCookies(['user']);
  const list = async (page: number): Promise<PageableReviewResponse> => {
    const response = await axiosInstance.get(
      `/reviews/amigos?page=${page}&size=10`,
      {
        headers: {
          Authorization: cookie.user,
        },
      }
    );
    console.log(response.data);
    return response.data;
  };

  const detail = async (id: number): Promise<ReviewResponse> => {
    const response = await axiosInstance.get(`/reviews/${id}`, {
      headers: {
        Authorization: cookie.user,
      },
    });
    return response.data;
  };

  return { list, detail };
};

export default useReviewFunctions;
