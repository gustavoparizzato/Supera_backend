package br.com.banco.repositorios;

import java.time.Instant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.banco.entidades.Transferencia;

public interface TransferenciaRepositorio extends JpaRepository<Transferencia, Long>{
	
    @Query(value = "SELECT c FROM Transferencia c WHERE c.data_trasnferencia BETWEEN :min AND :max ORDER BY c.data_transferencia DESC")
    Page<Transferencia> buscarTransferenciaPorData(Instant min, Instant max, Pageable pageable);
    
    @Query("SELECT t FROM Transferencia t WHERE t.conta.id_conta IN (SELECT c.id_conta FROM Conta c WHERE c.nome_responsavel = :nome)")
    Page<Transferencia> buscarTransferenciaPorConta(@Param("nome") String nome, Pageable pageable);
}
