package br.com.wallace.gestao_condominio.mapper;

import br.com.wallace.gestao_condominio.Entity.Morador;
import br.com.wallace.gestao_condominio.dto.MoradorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MoradorMapper {
    Morador toEntity(MoradorDTO dto);

    MoradorDTO toDTO(Morador entity);
}
