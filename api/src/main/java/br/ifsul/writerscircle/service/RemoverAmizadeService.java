package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.domain.Amizade;
import br.ifsul.writerscircle.repository.AmizadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RemoverAmizadeService {
    @Autowired
    private BuscarAmizadeService buscarAmizadeService;

    @Autowired
    private AmizadeRepository amizadeRepository;

    @Transactional
    public void remover(Long idAmizade){
        Amizade amizade = buscarAmizadeService.porId(idAmizade);

        amizadeRepository.delete(amizade);
    }
}
