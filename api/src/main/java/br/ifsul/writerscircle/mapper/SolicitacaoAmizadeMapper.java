package br.ifsul.writerscircle.mapper;

import br.ifsul.writerscircle.controller.response.SolicitacaoAmizadeResponse;
import br.ifsul.writerscircle.domain.SolicitacaoAmizade;
import br.ifsul.writerscircle.security.mapper.UsuarioResumidoMapper;

public class SolicitacaoAmizadeMapper {
    public static SolicitacaoAmizadeResponse toResponse(SolicitacaoAmizade entity){
        return SolicitacaoAmizadeResponse.builder()
                .id(entity.getId())
                .remetente(UsuarioResumidoMapper.toResponse(entity.getRemetente()))
                .destinatario(UsuarioResumidoMapper.toResponse(entity.getDestinatario()))
                .build();
    }
}
