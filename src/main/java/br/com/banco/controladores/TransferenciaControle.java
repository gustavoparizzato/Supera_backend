package br.com.banco.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.dto.TransferenciaDTO;
import br.com.banco.servicos.TransferenciaServico;

@RestController
@RequestMapping(value = "transferencias")
public class TransferenciaControle {

	@Autowired
	private TransferenciaServico transferenciaServico;
	
	@GetMapping
	public ResponseEntity<Page<TransferenciaDTO>> buscarTransferenciaPorData(
			@RequestParam(value = "minData", defaultValue = "") String minData,
			@RequestParam(value = "maxData", defaultValue = "") String maxData,
			Pageable pageable){
		Page<TransferenciaDTO> resultado = transferenciaServico.buscarTransferenciaPorData(minData, maxData, pageable);
		return ResponseEntity.ok().body(resultado);
	}
	
	@GetMapping
	public ResponseEntity<Page<TransferenciaDTO>> buscarTransferenciarPorConta(@PathVariable String nome, Pageable pageable){
		Page<TransferenciaDTO> resultado = transferenciaServico.buscarTransferenciaPorConta(nome, pageable);
		return ResponseEntity.ok().body(resultado);
 	}
}
