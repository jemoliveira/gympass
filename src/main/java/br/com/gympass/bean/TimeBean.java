package br.com.gympass.bean;

public class TimeBean {
	
	private int minutos;
	private int segundos;
	private int milisegundos;
	
	public TimeBean(int minutos, int segundos, int milisegundos) {
		this.minutos = minutos;
		this.segundos = segundos;
		this.milisegundos = milisegundos;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}


	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	public int getMilisegundos() {
		return milisegundos;
	}

	public void setMilisegundos(int milisegundos) {
		this.milisegundos = milisegundos;
	}
	
}