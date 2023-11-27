package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.controller.response.GeneroResponse;
import br.ifsul.writerscircle.mapper.GeneroMapper;
import br.ifsul.writerscircle.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class BuscarGeneroPorNomeService {
    @Autowired
    private GeneroRepository generoRepository;

    public List<GeneroResponse> buscar(String nome){
      return generoRepository.findAllByNomeContainsIgnoreCase(nome).stream()
              .map(GeneroMapper::toResponse)
              .collect(toList());
    }
}
