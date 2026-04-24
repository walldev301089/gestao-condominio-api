package br.com.wallace.gestao_condominio.contoller;

import br.com.wallace.gestao_condominio.dto.ApartamentoDTO;
import br.com.wallace.gestao_condominio.service.ApartamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apartamentos")
public class ApartamentoController {
    @Autowired
    ApartamentoService apartamentoService;

    @PostMapping
    public ResponseEntity<ApartamentoDTO> salvar(@RequestBody @Valid ApartamentoDTO apartamentoDTO) {
        ApartamentoDTO apartamentoSalvo = apartamentoService.salvar(apartamentoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(apartamentoSalvo);
    }
}