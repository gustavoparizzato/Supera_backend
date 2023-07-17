package br.com.banco.dto;

import java.io.Serializable;
import java.util.List;

public class TransferenciaSaldoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Double saldoTotal;
	private Double saldoNoPeriodo;
	private List<TransferenciaDTO> transferencias;
	
	public TransferenciaSaldoDTO() {
	}

	public TransferenciaSaldoDTO(Double saldoTotal, Double saldoNoPeriodo, List<TransferenciaDTO> transferencias) {
		this.saldoTotal = saldoTotal;
		this.saldoNoPeriodo = saldoNoPeriodo;
		this.transferencias = transferencias;
	}

	public String getSaldoTotal() {
		return String.format("%.2f", saldoTotal);
	}

	public void setSaldoTotal(Double saldoTotal) {
		this.saldoTotal = saldoTotal;
	}

	public String getSaldoNoPeriodo() {
		return String.format("%.2f", saldoNoPeriodo);
	}

	public void setSaldoNoPeriodo(Double saldoNoPeriodo) {
		this.saldoNoPeriodo = saldoNoPeriodo;
	}

	public List<TransferenciaDTO> getTransferencias() {
		return transferencias;
	}

	public void setTransferencias(List<TransferenciaDTO> transferencias) {
		this.transferencias = transferencias;
	}	
}
