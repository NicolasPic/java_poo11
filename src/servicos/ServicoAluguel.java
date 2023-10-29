package servicos;

import java.time.Duration;

import entidades.Aluguel;
import entidades.Fatura;

public class ServicoAluguel {
	
	private Double precoPorHora;
	private Double precoPorDia;
	
	private ServicoTaxa servicoTaxa;
	
	public Double getPrecoPorHora() {
		return precoPorHora;
	}
	 
	public ServicoAluguel(Double precoPorHora, Double precoPorDia, ServicoTaxa servicoTaxa) {
		this.precoPorHora = precoPorHora;
		this.precoPorDia = precoPorDia;
		this.servicoTaxa = servicoTaxa;
	}

	public void setPrecoPorHora(Double precoPorHora) {
		this.precoPorHora = precoPorHora;
	}

	public Double getPrecoPorDia() {
		return precoPorDia;
	}

	public void setPrecoPorDia(Double precoPorDia) {
		this.precoPorDia = precoPorDia;
	}

	public ServicoTaxa getServicoTaxa() {
		return servicoTaxa;
	}

	public void setServicoTaxa(ServicoTaxa servicoTaxa) {
		this.servicoTaxa = servicoTaxa;
	}

	public void processarFatura(Aluguel aluguel) {	
		
		double minutos = Duration.between(aluguel.getInicio(), aluguel.getFim()).toMinutes();
		double horas = minutos/60;
		double pagamentoBasico;
		
		if(horas <= 12) {
			pagamentoBasico = getPrecoPorHora() * Math.ceil(horas);
		} else {
			pagamentoBasico = getPrecoPorDia() * Math.ceil(horas/24);
		}
		
		double taxa = servicoTaxa.taxa(pagamentoBasico);
		
		aluguel.setFatura(new Fatura(pagamentoBasico,taxa));
	}
}
