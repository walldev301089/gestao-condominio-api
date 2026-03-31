package br.com.wallace.gestao_condominio.contoller;

import br.com.wallace.gestao_condominio.dto.MoradorDTO;
import br.com.wallace.gestao_condominio.service.MoradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MoradorController {
    @Autowired
    private MoradorService moradorService;

    @PostMapping("/moradores")
    public ResponseEntity<MoradorDTO> salvar(@RequestBody MoradorDTO moradorDTO) {
        MoradorDTO moradorSalvo = moradorService.salvar(moradorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(moradorSalvo);
    }
}
