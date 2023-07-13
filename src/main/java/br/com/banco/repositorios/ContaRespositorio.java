package br.com.banco.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banco.entidades.Conta;

public interface ContaRespositorio extends JpaRepository<Conta, Long> {

}
