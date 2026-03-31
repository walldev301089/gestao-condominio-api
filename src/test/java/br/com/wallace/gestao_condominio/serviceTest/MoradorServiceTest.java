package br.com.wallace.gestao_condominio.serviceTest;

import br.com.wallace.gestao_condominio.Entity.Apartamento;
import br.com.wallace.gestao_condominio.Entity.Morador;
import br.com.wallace.gestao_condominio.dto.ApartamentoDTO;
import br.com.wallace.gestao_condominio.dto.MoradorDTO;
import br.com.wallace.gestao_condominio.mapper.MoradorMapper;
import br.com.wallace.gestao_condominio.repository.ApartamentoRepository;
import br.com.wallace.gestao_condominio.repository.MoradorRepository;
import br.com.wallace.gestao_condominio.service.MoradorService;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.instancio.Select.field;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MoradorServiceTest {
    @Mock
    private MoradorRepository moradorRepository;
    @Mock
    private ApartamentoRepository apartamentoRepository;
    @Mock
    private MoradorMapper moradorMapper;
    @InjectMocks
    private MoradorService moradorService;

    @Test
    void deve_salvar_morador_com_sucesso_quando_apartamento_existir() {

        Apartamento apartamento = Instancio.of(Apartamento.class)
                .set(field(Apartamento::getId), 1L)
                .create();

        MoradorDTO moradorDTO = Instancio.of(MoradorDTO.class)
                .set(field(MoradorDTO::getApartamento),
                        Instancio.of(ApartamentoDTO.class)
                                .set(field(ApartamentoDTO::getId), apartamento.getId())
                                .create()).create();

        when(apartamentoRepository.findById(apartamento.getId()))
                .thenReturn(Optional.of(apartamento));

        MoradorDTO resultado = moradorService.salvar(moradorDTO);

        verify(moradorRepository, times(1)).save(any(Morador.class));
    }

    @Test
    void deve_lancar_excecao_quando_salvar_morador_em_apartamento_inexistente() {
        MoradorDTO moradorDTO = Instancio.create(MoradorDTO.class);
        Long idApartamento = moradorDTO.getApartamento().getId();

        when(apartamentoRepository.findById(idApartamento)).thenReturn(Optional.empty());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                moradorService.salvar(moradorDTO));

        assertEquals("Apartamento não encontrado", exception.getMessage());
        verify(moradorRepository, never()).save(any(Morador.class));
    }
}