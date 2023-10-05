package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.domain.Amizade;
import br.ifsul.writerscircle.domain.SolicitacaoAmizade;
import br.ifsul.writerscircle.repository.AmizadeRepository;
import br.ifsul.writerscircle.repository.SolicitacaoAmizadeRepository;
import br.ifsul.writerscircle.security.domain.Usuario;
import br.ifsul.writerscircle.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AceitarSolicitacaoAmizadeService {
    @Autowired
    private BuscarSolicitacaoAmizadeService buscarSolicitacaoAmizadeService;
    @Autowired
    private SolicitacaoAmizadeRepository solicitacaoAmizadeRepository;
    @Autowired
    private AmizadeRepository amizadeRepository;

    @Transactional
    public void aceitar(Long idSolicitacao){
        SolicitacaoAmizade solicitacao = buscarSolicitacaoAmizadeService.porId(idSolicitacao);
        Usuario remetente = solicitacao.getRemetente();
        Usuario destinatario = solicitacao.getDestinatario();

        solicitacaoAmizadeRepository.delete(solicitacao);

        destinatario.removerSolicitacao(solicitacao);

        Amizade amizade = new Amizade();
        amizade.setPrimeiroUsuario(remetente);
        amizade.setSegundoUsuario(destinatario);

        amizadeRepository.save(amizade);
    }
}
