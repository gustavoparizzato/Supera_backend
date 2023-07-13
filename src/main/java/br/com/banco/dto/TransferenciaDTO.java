package br.com.banco.dto;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.beans.BeanUtils;

import br.com.banco.entidades.Transferencia;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferenciaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Instant data_transferencia;
	private Double valor;
	private String tipo;
	private String nome_operador_transacao;

	public TransferenciaDTO() {
	}
	
	public TransferenciaDTO(Transferencia entidade) {
		BeanUtils.copyProperties(entidade, this);
	}
}
