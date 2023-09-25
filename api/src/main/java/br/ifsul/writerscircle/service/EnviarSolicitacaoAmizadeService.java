package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.controller.request.SolicitacaoAmizadeRequest;
import br.ifsul.writerscircle.controller.response.SolicitacaoAmizadeResponse;
import br.ifsul.writerscircle.domain.SolicitacaoAmizade;
import br.ifsul.writerscircle.mapper.SolicitacaoAmizadeMapper;
import br.ifsul.writerscircle.repository.SolicitacaoAmizadeRepository;
import br.ifsul.writerscircle.security.domain.Usuario;
import br.ifsul.writerscircle.security.service.BuscarUsuarioService;
import br.ifsul.writerscircle.security.service.GetUsuarioAutenticadoService;
import br.ifsul.writerscircle.validator.ValidarSolicitacaoJaEnviadaValidator;
import br.ifsul.writerscircle.validator.ValidarUsuariosSolicitacaoNaoSaoIguaisValidator;
import br.ifsul.writerscircle.validator.ValidarUsuariosSolicitacaoNaoSaoAmigosValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.ifsul.writerscircle.mapper.SolicitacaoAmizadeMapper.toResponse;

@Service
public class EnviarSolicitacaoAmizadeService {
    @Autowired
    private SolicitacaoAmizadeRepository solicitacaoAmizadeRepository;
    @Autowired
    private BuscarUsuarioService buscarUsuarioService;
    @Autowired
    private GetUsuarioAutenticadoService getUsuarioAutenticadoService;
    @Autowired
    private ValidarUsuariosSolicitacaoNaoSaoAmigosValidator validarUsuariosSolicitacaoNaoSaoAmigosValidator;
    @Autowired
    private ValidarUsuariosSolicitacaoNaoSaoIguaisValidator validarUsuariosSolicitacaoNaoSaoIguaisValidator;
    @Autowired
    private ValidarSolicitacaoJaEnviadaValidator validarSolicitacaoJaEnviadaValidator;

    public SolicitacaoAmizadeResponse enviar(SolicitacaoAmizadeRequest request){
        Usuario remetente = getUsuarioAutenticadoService.get();
        Usuario destinatario = buscarUsuarioService.porId(request.getIdDestinatario());
        SolicitacaoAmizade solicitacao = new SolicitacaoAmizade();

        validarUsuariosSolicitacaoNaoSaoAmigosValidator.validar(remetente, destinatario);
        validarUsuariosSolicitacaoNaoSaoIguaisValidator.validar(remetente, destinatario);
        validarSolicitacaoJaEnviadaValidator.validar(remetente, destinatario);

        solicitacao.setRemetente(remetente);
        solicitacao.setDestinatario(destinatario);

        solicitacaoAmizadeRepository.save(solicitacao);
        destinatario.adicionarSolicitacao(solicitacao);

        return toResponse(solicitacao);
    }
}
