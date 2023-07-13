package br.com.banco.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banco.entidades.Transferencia;

public interface TransferenciaRepositorio extends JpaRepository<Transferencia, Long>{

}
