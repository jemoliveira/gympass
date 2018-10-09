package br.com.gympass.bean;

public class ClassificacaoBean {
	
	private int posicaoChegada;
	private String codigoPiloto;
	private String nomePiloto;
	private int qtdeVoltas;
	private String tempoTotal;
	
	public int getPosicaoChegada() {
		return posicaoChegada;
	}
	public void setPosicaoChegada(int posicaoChegada) {
		this.posicaoChegada = posicaoChegada;
	}
	public String getCodigoPiloto() {
		return codigoPiloto;
	}
	public void setCodigoPiloto(String codigoPiloto) {
		this.codigoPiloto = codigoPiloto;
	}
	public String getNomePiloto() {
		return nomePiloto;
	}
	public void setNomePiloto(String nomePiloto) {
		this.nomePiloto = nomePiloto;
	}
	
	public int getQtdeVoltas() {
		return qtdeVoltas;
	}
	public void setQtdeVoltas(int qtdeVoltas) {
		this.qtdeVoltas = qtdeVoltas;
	}
	public String getTempoTotal() {
		return tempoTotal;
	}
	public void setTempoTotal(String tempoTotal) {
		this.tempoTotal = tempoTotal;
	}
}