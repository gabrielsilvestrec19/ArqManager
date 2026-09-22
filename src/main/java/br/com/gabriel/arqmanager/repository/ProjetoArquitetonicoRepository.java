package br.com.gabriel.arqmanager.repository;

import br.com.gabriel.arqmanager.entity.ProjetoArquitetonico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjetoArquitetonicoRepository extends JpaRepository <ProjetoArquitetonico,Long>{

    Optional<ProjetoArquitetonico> findByNomeObra(String nomeObra);

}
