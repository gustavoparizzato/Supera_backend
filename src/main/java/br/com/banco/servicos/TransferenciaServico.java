package br.com.banco.servicos;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;

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
	
	//bsucar todas transferencias
	@Transactional(readOnly = true)
	public Page<TransferenciaDTO> buscarTodasTransferencias(Pageable pageable){
		Page<Transferencia> resultado = transferenciaRepositorio.buscarTodasTransferencia(pageable);
		return resultado.map(TransferenciaDTO::new);
	}
	
	//buscar transferencias por data
	@Transactional(readOnly = true)
	public Page<TransferenciaDTO> buscarTransferenciaPorData (String minData, String maxData, Pageable pageable){
		
	    LocalDate hoje = LocalDate.now();
	    Instant instantMin = minData.isEmpty() ? hoje.minusDays(365).atStartOfDay().toInstant(ZoneOffset.UTC) : LocalDate.parse(minData).atStartOfDay().toInstant(ZoneOffset.UTC);
	    Instant instantMax = maxData.isEmpty() ? hoje.atTime(LocalTime.MAX).atZone(ZoneOffset.UTC).toInstant() : LocalDate.parse(maxData).atTime(LocalTime.MAX).atZone(ZoneOffset.UTC).toInstant();

	    Page<Transferencia> resultado = transferenciaRepositorio.buscarTransferenciaPorData(instantMin, instantMax, pageable);
	    return resultado.map(TransferenciaDTO::new);
	}
	
	//buscar transferencias por conta
    public Page<TransferenciaDTO> buscarTransferenciaPorConta(String nome, Pageable pageable) {
        Page<Transferencia> transferencias = transferenciaRepositorio.buscarTransferenciaPorConta(nome, pageable);
        return transferencias.map(TransferenciaDTO::new);
    }
}
