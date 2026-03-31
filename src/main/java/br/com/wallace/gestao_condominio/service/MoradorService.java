package br.com.wallace.gestao_condominio.service;

import br.com.wallace.gestao_condominio.Entity.Apartamento;
import br.com.wallace.gestao_condominio.Entity.Morador;
import br.com.wallace.gestao_condominio.dto.MoradorDTO;
import br.com.wallace.gestao_condominio.mapper.MoradorMapper;
import br.com.wallace.gestao_condominio.repository.ApartamentoRepository;
import br.com.wallace.gestao_condominio.repository.MoradorRepository;
import org.springframework.stereotype.Service;

@Service
public class MoradorService {
    private final MoradorRepository moradorRepository;
    private final ApartamentoRepository apartamentoRepository;
    private MoradorMapper moradorMapper;

    public MoradorService(MoradorRepository moradorRepository, ApartamentoRepository apartamentoRepository, MoradorMapper moradorMapper) {
        this.moradorRepository = moradorRepository;
        this.apartamentoRepository = apartamentoRepository;
        this.moradorMapper = moradorMapper;
    }

    public MoradorDTO salvar(MoradorDTO moradorDTO) {
        Long apartamentoId = moradorDTO.getApartamento().getId();
        Apartamento apartamento = apartamentoRepository.findById(apartamentoId)
                .orElseThrow(() -> new IllegalArgumentException("Apartamento não encontrado"));
        Morador morador = Morador.builder()
                .nome(moradorDTO.getNome())
                .sobrenome(moradorDTO.getSobrenome())
                .apartamento(apartamento)
                .build();

        Morador moradorSalvo = moradorRepository.save(morador);

        return moradorMapper.toDTO(moradorSalvo);
    }
}