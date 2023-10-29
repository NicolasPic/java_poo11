package entidades;

public class Fatura {

	private Double pagamentoBasico;
	private Double tax;
	
	public Double pagamentoTotal() {
		return getPagamentoBasico() + getTax();
	}

	public Double getPagamentoBasico() {
		return pagamentoBasico;
	}

	public void setPagamentoBasico(Double pagamentoBasico) {
		this.pagamentoBasico = pagamentoBasico;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Fatura(Double pagamentoBasico, Double tax) {
		this.pagamentoBasico = pagamentoBasico;
		this.tax = tax;
	}
	
	
}
