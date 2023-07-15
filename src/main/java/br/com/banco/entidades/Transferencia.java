package br.com.banco.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transferencia")
public class Transferencia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private Instant data_transferencia;
	private Double valor;
	private String tipo;
	private String nome_operador_transacao;

	@ManyToOne
	@JoinColumn(name = "conta_id")
	private Conta conta;

	public Transferencia() {
	}

	public Transferencia(Long id, Instant data_transferencia, Double valor, String tipo, String nome_operador_transacao,
			Conta conta) {
		this.id = id;
		this.data_transferencia = data_transferencia;
		this.valor = valor;
		this.tipo = tipo;
		this.nome_operador_transacao = nome_operador_transacao;
		this.conta = conta;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public void atualizarTipoTransferencia() {
		if (tipo.equalsIgnoreCase("TRANSFERENCIA") && valor < 0) {
			tipo = "TRANSFERENCIA SAIDA";
		} else if (tipo.equalsIgnoreCase("TRANSFERENCIA")) {
			tipo = "TRANSFERENCIA ENTRADA";
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transferencia other = (Transferencia) obj;
		return Objects.equals(id, other.id);
	}
}
