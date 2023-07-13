package br.com.banco.dto;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import br.com.banco.entidades.Conta;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id_conta;
	private String nome_responsavel;
	
	public ContaDTO() {
	}
	
	public ContaDTO(Conta entidade) {
		BeanUtils.copyProperties(entidade, this);
	}
}
