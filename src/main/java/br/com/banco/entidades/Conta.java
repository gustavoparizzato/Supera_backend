package br.com.banco.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "conta")
@Getter
@Setter
@EqualsAndHashCode
public class Conta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id_conta;	
	private String nome_responsavel;
	
	@JsonIgnore
	@OneToMany(mappedBy = "conta")
	private List<Transferencia> transferencias = new ArrayList<>();
	
	public Conta() {
	}

	public Conta(Long id_conta, String nome_responsavel) {
		this.id_conta = id_conta;
		this.nome_responsavel = nome_responsavel;
	}
}
