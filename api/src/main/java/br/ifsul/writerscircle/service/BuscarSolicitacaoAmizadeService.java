package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.domain.Review;
import br.ifsul.writerscircle.domain.SolicitacaoAmizade;
import br.ifsul.writerscircle.repository.SolicitacaoAmizadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class BuscarSolicitacaoAmizadeService {
    @Autowired
    private SolicitacaoAmizadeRepository solicitacaoAmizadeRepository;
    private static final String MENSAGEM_SOLICITACAO_NAO_EXISTE = "Solicitação não encontrada";
    public SolicitacaoAmizade porId(Long id){
        Optional<SolicitacaoAmizade> solicitacao = solicitacaoAmizadeRepository.findById(id);

        if(solicitacao.isEmpty()){
            throw new ResponseStatusException(BAD_REQUEST, MENSAGEM_SOLICITACAO_NAO_EXISTE);
        }

        return solicitacao.get();
    }
}
