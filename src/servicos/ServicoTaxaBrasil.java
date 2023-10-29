package servicos;

public class ServicoTaxaBrasil implements ServicoTaxa {

	public double taxa(Double valor) {
		
		if (valor <= 100) {
			return valor * 0.20;
		} else {
			return valor * 0.15;
		}
		
	}
}
