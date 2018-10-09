package br.com.gympass.bean;

public class CorridaBean {
	
	private String hora;
	private String codigoPiloto;
	private String piloto;   
	private String nVolta;
	private String tempoVolta;      
	private String velocidadeMedia;
	
	public String getCodigoPiloto() {
		return codigoPiloto;
	}
	public void setCodigoPiloto(String codigoPiloto) {
		this.codigoPiloto = codigoPiloto;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getPiloto() {
		return piloto;
	}
	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}
	public String getnVolta() {
		return nVolta;
	}
	public void setnVolta(String nVolta) {
		this.nVolta = nVolta;
	}
	public String getTempoVolta() {
		return tempoVolta;
	}
	public void setTempoVolta(String tempoVolta) {
		this.tempoVolta = tempoVolta;
	}
	public String getVelocidadeMedia() {
		return velocidadeMedia;
	}
	public void setVelocidadeMedia(String velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}	
}