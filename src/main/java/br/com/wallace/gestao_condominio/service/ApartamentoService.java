package br.com.wallace.gestao_condominio.service;

import br.com.wallace.gestao_condominio.Entity.Apartamento;
import br.com.wallace.gestao_condominio.dto.ApartamentoDTO;
import br.com.wallace.gestao_condominio.repository.ApartamentoRepository;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.springframework.stereotype.Service;

@Service
public class ApartamentoService {

    private final ApartamentoRepository apartamentoRepository;

    public ApartamentoService(ApartamentoRepository apartamentoRepository) {
        this.apartamentoRepository = apartamentoRepository;
    }

    public ApartamentoDTO salvar(ApartamentoDTO apartamentoDTO){
        Apartamento apartamento = Apartamento.builder()
                .numero(apartamentoDTO.getNumero())
                .bloco(apartamentoDTO.getBloco())
                .build();
        Apartamento salvo = apartamentoRepository.save(apartamento);
        return new ApartamentoDTO(salvo.getId(), salvo.getNumero(), salvo.getBloco());
    }
}