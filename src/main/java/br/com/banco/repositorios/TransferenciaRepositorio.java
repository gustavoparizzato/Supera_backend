package br.com.banco.repositorios;

import java.time.Instant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.banco.entidades.Transferencia;

public interface TransferenciaRepositorio extends JpaRepository<Transferencia, Long> {

	@Query(value = "SELECT t FROM Transferencia t")
	Page<Transferencia> buscarTodasTransferencia(Pageable pageable);

	@Query(value = "SELECT t FROM Transferencia t WHERE t.data_transferencia BETWEEN :min AND :max ORDER BY t.data_transferencia DESC")
	Page<Transferencia> buscarTransferenciaPorData(Instant min, Instant max, Pageable pageable);

	@Query(value = "SELECT t FROM Transferencia t WHERE t.nome_operador_transacao = :nome")
	Page<Transferencia> buscarTransferenciaPorOperador(String nome, Pageable pageable);

	@Query(value = "SELECT t from Transferencia t WHERE t.conta.id_conta = :numeroConta")
	Page<Transferencia> buscarTransferenciaPorConta(Long numeroConta, Pageable pageable);

	@Query(value = "SELECT t FROM Transferencia t WHERE t.conta.id_conta = :numeroConta AND t.data_transferencia BETWEEN :min AND :max ORDER BY t.data_transferencia DESC")
	Page<Transferencia> buscarTransferenciaPorDateEConta(Long numeroConta, Instant min, Instant max, Pageable pageable);
}
