package com.satc.satcloja.repository;

import com.satc.satcloja.model.Cliente;
import com.satc.satcloja.model.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
}
