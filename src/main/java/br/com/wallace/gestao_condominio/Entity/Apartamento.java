package br.com.wallace.gestao_condominio.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Builder
@Table(name = "apartamento")
public class Apartamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O número do apartamento é obrigatório")
    private String numero;

    @NotBlank(message = "O bloco é obrigatório")
    private String bloco;

    @OneToMany(mappedBy = "apartamento", cascade = CascadeType.ALL)
    private List<Morador> moradores;

}