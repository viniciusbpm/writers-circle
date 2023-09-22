package br.ifsul.writerscircle.service;

import br.ifsul.writerscircle.controller.request.ObraRequest;
import br.ifsul.writerscircle.controller.response.ObraResponse;
import br.ifsul.writerscircle.domain.Genero;
import br.ifsul.writerscircle.domain.Obra;
import br.ifsul.writerscircle.mapper.GeneroMapper;
import br.ifsul.writerscircle.repository.GeneroRepository;
import br.ifsul.writerscircle.repository.ObraRepository;
import br.ifsul.writerscircle.security.domain.Usuario;
import br.ifsul.writerscircle.security.service.GetUsuarioAutenticadoService;
import br.ifsul.writerscircle.validator.ValidarUsuarioEhProprietarioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static br.ifsul.writerscircle.mapper.ObraMapper.toResponse;
import static java.time.LocalDateTime.now;
import static java.util.stream.Collectors.toList;

@Service
public class EditarObraService {
    @Autowired
    private GetUsuarioAutenticadoService getUsuarioAutenticadoService;
    @Autowired
    private ObraRepository obraRepository;
    @Autowired
    private BuscarObraService buscarObraService;
    @Autowired
    private ValidarUsuarioEhProprietarioValidator validarUsuarioEhProprietarioValidator;
    @Autowired
    private BuscarGeneroService buscarGeneroService;

    public ObraResponse editar(ObraRequest request, Long idObra){
        Usuario usuario = getUsuarioAutenticadoService.get();
        Obra obra = buscarObraService.porId(idObra);

        validarUsuarioEhProprietarioValidator.validar(usuario.getId(), obra.getUsuario().getId());

        obra.setTitulo(request.getTitulo());
        obra.setDescricao(request.getDescricao());
        obra.setDataAlteracao(now());

        List<Genero> generos = request.getGeneros().stream()
                .map(genero -> buscarGeneroService.porId(genero.getId()))
                .collect(toList());

        obra.setGeneros(generos);

        ObraResponse response = toResponse(obra);

        response.setGeneros(generos.stream()
                .map(GeneroMapper::toResponse)
                .collect(toList()));

        obraRepository.save(obra);

        return response;
    }
}
