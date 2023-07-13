package br.com.banco.entidades;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transferencia")
@Getter
@Setter
@EqualsAndHashCode
public class Transferencia implements Serializable{
	
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
}
