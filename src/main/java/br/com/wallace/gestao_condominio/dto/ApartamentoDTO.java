package br.com.wallace.gestao_condominio.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApartamentoDTO {
    private Long id;

    @NotBlank(message = "O número do apartamento é obrigatório")
    private String numero;

    @NotBlank(message = "O bloco é obrigatório")
    private String bloco;
}
