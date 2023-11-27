import { jwtDecode } from 'jwt-decode';

interface DecodedJwt {
  exp: number;
  id: number;
  iss: string;
  sub: string;
  usuarioNovo: boolean;
}

const decode = (token: string) => {
  return jwtDecode<DecodedJwt>(token);
};

export default decode;
