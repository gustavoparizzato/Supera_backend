package br.com.banco.dto;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import br.com.banco.entidades.Conta;

public class ContaDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id_conta;
	private String nome_responsavel;
	
	public ContaDTO() {
	}
	
	public ContaDTO(Conta entidade) {
		BeanUtils.copyProperties(entidade, this);
	}

	public Long getId_conta() {
		return id_conta;
	}

	public void setId_conta(Long id_conta) {
		this.id_conta = id_conta;
	}

	public String getNome_responsavel() {
		return nome_responsavel;
	}

	public void setNome_responsavel(String nome_responsavel) {
		this.nome_responsavel = nome_responsavel;
	}
}
