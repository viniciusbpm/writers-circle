package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.controller.response.GeneroResponse;
import br.ifsul.writerscircle.domain.Genero;
import br.ifsul.writerscircle.mapper.GeneroMapper;
import br.ifsul.writerscircle.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ListarGenerosService {
    @Autowired
    private GeneroRepository generoRepository;

    public List<GeneroResponse> listar(){
        List<Genero> generos = generoRepository.findAll();
        return generos.stream()
                .map(GeneroMapper::toResponse)
                .collect(toList());
    }
}
