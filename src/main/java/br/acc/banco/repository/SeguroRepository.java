package br.acc.banco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.acc.banco.models.Seguro;

@Repository
public interface SeguroRepository extends JpaRepository<Seguro, Long>{

	List<Seguro> findByContaId(Long id);

}
