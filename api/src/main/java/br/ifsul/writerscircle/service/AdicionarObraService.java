package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.controller.request.ObraRequest;
import br.ifsul.writerscircle.controller.response.ObraResponse;
import br.ifsul.writerscircle.domain.Genero;
import br.ifsul.writerscircle.domain.Obra;
import br.ifsul.writerscircle.mapper.GeneroMapper;
import br.ifsul.writerscircle.mapper.ObraMapper;
import br.ifsul.writerscircle.repository.ObraRepository;
import br.ifsul.writerscircle.security.domain.Usuario;
import br.ifsul.writerscircle.security.service.GetUsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static br.ifsul.writerscircle.mapper.ObraMapper.toResponse;
import static java.util.stream.Collectors.toList;

@Service
public class AdicionarObraService {
    @Autowired
    private ObraRepository obraRepository;
    @Autowired
    private GetUsuarioAutenticadoService getUsuarioAutenticadoService;
    @Autowired
    private BuscarGeneroService buscarGeneroService;

    @Transactional
    public ObraResponse adicionar(ObraRequest request){
        Usuario usuario = getUsuarioAutenticadoService.get();
        Obra obra = ObraMapper.toEntity(request);

        usuario.adicionarObra(obra);

        List<Genero> generos = request.getGeneros().stream()
                .map(genero -> buscarGeneroService.porId(genero.getId()))
                .collect(toList());

        obra.setGeneros(generos);

        obraRepository.save(obra);

        ObraResponse response = toResponse(obra);

        response.setGeneros(generos.stream()
                .map(GeneroMapper::toResponse)
                .collect(toList()));

        return response;
    }
}
