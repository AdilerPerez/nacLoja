package br.com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.model.LojaModel;

public interface LojaRepository extends JpaRepository<LojaModel, Long> {

}
