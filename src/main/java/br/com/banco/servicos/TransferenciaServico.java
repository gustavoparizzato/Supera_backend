package br.com.banco.servicos;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.banco.dto.TransferenciaDTO;
import br.com.banco.entidades.Transferencia;
import br.com.banco.repositorios.TransferenciaRepositorio;

@Service
public class TransferenciaServico {

	@Autowired
	private TransferenciaRepositorio transferenciaRepositorio;

	@Transactional(readOnly = true)
	public Page<TransferenciaDTO> buscarTodasTransferencias(Pageable pageable) {
		Page<Transferencia> resultado = transferenciaRepositorio.buscarTodasTransferencia(pageable);
		atualizarTipoTransferencia(resultado.getContent());
		return resultado.map(TransferenciaDTO::new);
	}

	@Transactional(readOnly = true)
	public Page<TransferenciaDTO> buscarTransferenciaPorData(String minData, String maxData, Pageable pageable) {

		LocalDate hoje = LocalDate.now();
		Instant instantMin = minData.isEmpty() ? hoje.minusDays(2000).atStartOfDay().toInstant(ZoneOffset.UTC)
				: LocalDate.parse(minData).atStartOfDay().toInstant(ZoneOffset.UTC);
		Instant instantMax = maxData.isEmpty() ? hoje.atTime(LocalTime.MAX).atZone(ZoneOffset.UTC).toInstant()
				: LocalDate.parse(maxData).atTime(LocalTime.MAX).atZone(ZoneOffset.UTC).toInstant();
		Page<Transferencia> resultado = transferenciaRepositorio.buscarTransferenciaPorData(instantMin, instantMax,
				pageable);
		atualizarTipoTransferencia(resultado.getContent());
		return resultado.map(TransferenciaDTO::new);
	}

	@Transactional(readOnly = true)
	public Page<TransferenciaDTO> buscarTransferenciaPorOperador(String nome, Pageable pageable) {
		Page<Transferencia> resultado = transferenciaRepositorio.buscarTransferenciaPorOperador(nome, pageable);
		atualizarTipoTransferencia(resultado.getContent());
		return resultado.map(TransferenciaDTO::new);
	}

	@Transactional(readOnly = true)
	public Page<TransferenciaDTO> buscarTransferenciaPorConta(Long numeroConta, Pageable pageable) {
		Page<Transferencia> resultado = transferenciaRepositorio.buscarTransferenciaPorConta(numeroConta, pageable);
		return resultado.map(TransferenciaDTO::new);
	}

	@Transactional(readOnly = true)
	public Double calcularSaldoTotal(Long numeroConta, Pageable pageable) {
		if (numeroConta != null) {
			Page<Transferencia> transferencias = transferenciaRepositorio.buscarTransferenciaPorConta(numeroConta,
					pageable);
			return transferencias.stream().mapToDouble(Transferencia::getValor).sum();
		} else {
			List<Transferencia> transferencias = transferenciaRepositorio.findAll();
			return transferencias.stream().mapToDouble(Transferencia::getValor).sum();
		}
	}

	@Transactional(readOnly = true)
	public Double calcularSaldoTotalNoPeriodo(Long numeroConta, String minData, String maxData, Pageable pageable) {

		LocalDate hoje = LocalDate.now();
		Instant instantMin = minData.isEmpty() ? hoje.minusDays(2000).atStartOfDay().toInstant(ZoneOffset.UTC)
				: LocalDate.parse(minData).atStartOfDay().toInstant(ZoneOffset.UTC);
		Instant instantMax = maxData.isEmpty() ? hoje.atTime(LocalTime.MAX).atZone(ZoneOffset.UTC).toInstant()
				: LocalDate.parse(maxData).atTime(LocalTime.MAX).atZone(ZoneOffset.UTC).toInstant();

		if (numeroConta != null) {
			Page<Transferencia> transferencias = transferenciaRepositorio.buscarTransferenciaPorDateEConta(numeroConta,
					instantMin, instantMax, pageable);
			return transferencias.stream().mapToDouble(Transferencia::getValor).sum();
		} else {
			Page<Transferencia> transferencias = transferenciaRepositorio.buscarTransferenciaPorData(instantMin,
					instantMax, pageable);
			return transferencias.stream().mapToDouble(Transferencia::getValor).sum();
		}
	}

	private void atualizarTipoTransferencia(List<Transferencia> transferencias) {
		for (Transferencia transferencia : transferencias) {
			transferencia.atualizarTipoTransferencia();
		}
	}
}
