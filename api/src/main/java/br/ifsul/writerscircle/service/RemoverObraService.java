package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.domain.Obra;
import br.ifsul.writerscircle.repository.ObraRepository;
import br.ifsul.writerscircle.security.domain.Usuario;
import br.ifsul.writerscircle.security.service.GetUsuarioAutenticadoService;
import br.ifsul.writerscircle.validator.ValidarUsuarioEhProprietarioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoverObraService {
    @Autowired
    private ObraRepository obraRepository;
    @Autowired
    private BuscarObraService buscarObraService;
    @Autowired
    private GetUsuarioAutenticadoService getUsuarioAutenticadoService;
    @Autowired
    private ValidarUsuarioEhProprietarioValidator validarUsuarioEhProprietarioValidator;

    public void remover(Long idObra){
        Usuario usuario = getUsuarioAutenticadoService.get();
        Obra obra = buscarObraService.porId(idObra);

        validarUsuarioEhProprietarioValidator.validar(usuario.getId(), obra.getUsuario().getId());

        obraRepository.delete(obra);

        usuario.removerObra(obra);
    }
}
