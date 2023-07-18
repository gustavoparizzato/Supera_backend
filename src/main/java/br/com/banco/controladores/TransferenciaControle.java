package br.com.banco.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.dto.TransferenciaDTO;
import br.com.banco.dto.TransferenciaSaldoDTO;
import br.com.banco.servicos.TransferenciaServico;

@RestController
@RequestMapping(value = "transferencias")
public class TransferenciaControle {

	@Autowired
	private TransferenciaServico transferenciaServico;

	@GetMapping
	public ResponseEntity<TransferenciaSaldoDTO> buscarTransferencias(
			@RequestParam(value = "minData", defaultValue = "") String minData,
			@RequestParam(value = "maxData", defaultValue = "") String maxData,
			@RequestParam(value = "nomeOperador", defaultValue = "") String nomeOperador, 
			@RequestParam(value = "numeroConta", defaultValue = "") Long numeroConta,
			Pageable pageable) {

		Page<TransferenciaDTO> resultado = transferenciaServico.buscarTodasTransferencias(pageable);

		if (!minData.isEmpty() && !maxData.isEmpty()) {
			resultado = transferenciaServico.buscarTransferenciaPorData(minData, maxData, pageable);
		}
		if (!nomeOperador.isEmpty()) {
			resultado = transferenciaServico.buscarTransferenciaPorOperador(nomeOperador, pageable);
		}
		if (numeroConta != null) {
			resultado = transferenciaServico.buscarTransferenciaPorConta(numeroConta, pageable);
		}
		
	    Double saldoTotal = transferenciaServico.calcularSaldoTotal(numeroConta, pageable);
	    Double saldoTotalNoPeriodo = transferenciaServico.calcularSaldoTotalNoPeriodo(numeroConta, minData, maxData, pageable);

	    TransferenciaSaldoDTO dto = new TransferenciaSaldoDTO(saldoTotal, saldoTotalNoPeriodo, resultado.getContent());
        
		return ResponseEntity.ok().body(dto);
	}
}
