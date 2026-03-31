package br.com.wallace.gestao_condominio.repository;

import br.com.wallace.gestao_condominio.Entity.Apartamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartamentoRepository extends JpaRepository<Apartamento, Long> {
}
