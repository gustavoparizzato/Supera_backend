package br.com.banco.repositorios;

import java.time.Instant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.banco.entidades.Transferencia;

public interface TransferenciaRepositorio extends JpaRepository<Transferencia, Long>{
	
	@Query(value = "SELECT c FROM Transferencia c")
	Page<Transferencia> buscarTodasTransferencia(Pageable pageable);
	
    @Query(value = "SELECT c FROM Transferencia c WHERE c.data_transferencia BETWEEN :min AND :max ORDER BY c.data_transferencia DESC")
    Page<Transferencia> buscarTransferenciaPorData(Instant min, Instant max, Pageable pageable);
    
    @Query(value = "SELECT t FROM Transferencia t WHERE t.nome_operador_transacao = :nome")
    Page<Transferencia> buscarTransferenciaPorOperador(String nome, Pageable pageable);
}
