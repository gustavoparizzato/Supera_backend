package br.com.banco.dto;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.banco.entidades.Conta;
import br.com.banco.entidades.Transferencia;

public class TransferenciaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Instant data_transferencia;
	private Double valor;
	private String tipo;
	private String nome_operador_transacao;

	@JsonProperty("conta_id")
	@JsonIgnoreProperties({ "nome_responsavel" })
	private Conta conta;

	public TransferenciaDTO() {
	}

	public TransferenciaDTO(Transferencia entidade) {
		BeanUtils.copyProperties(entidade, this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getData_transferencia() {
		return data_transferencia;
	}

	public void setData_transferencia(Instant data_transferencia) {
		this.data_transferencia = data_transferencia;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome_operador_transacao() {
		return nome_operador_transacao;
	}

	public void setNome_operador_transacao(String nome_operador_transacao) {
		this.nome_operador_transacao = nome_operador_transacao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
