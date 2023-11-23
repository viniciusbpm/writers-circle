package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.controller.response.FraseResponse;
import br.ifsul.writerscircle.domain.Frase;
import br.ifsul.writerscircle.mapper.FraseMapper;
import br.ifsul.writerscircle.repository.FraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

import static br.ifsul.writerscircle.mapper.FraseMapper.toResponse;

@Service
public class BuscarFraseAleatoria {
    @Autowired
    private FraseRepository fraseRepository;

    public FraseResponse buscar(){
        List<Frase> frases = fraseRepository.findAll();

        Random random = new Random();

        int aleatorio = random.nextInt(frases.size());

        Frase frase = frases.get(aleatorio);

        return toResponse(frase);
    }
}
