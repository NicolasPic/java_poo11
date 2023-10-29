package programa;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entidades.Aluguel;
import entidades.Veiculo;
import servicos.ServicoAluguel;
import servicos.ServicoTaxaBrasil;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		DateTimeFormatter fmt =  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		String modelo;
		Veiculo veiculo;
		
		System.out.println("Entre com os dados do aluguel");
		System.out.println("Modelo do carro: ");
		modelo=sc.nextLine();
		veiculo = new Veiculo(modelo);
		
		System.out.println("Retirada (dd/MM/yyyy hh:mm): ");
		LocalDateTime inicio = LocalDateTime.parse(sc.nextLine(), fmt);
		System.out.println("Retorno (dd/MM/yyyy hh:mm): ");
		LocalDateTime fim = LocalDateTime.parse(sc.nextLine(), fmt);
		
		Aluguel aluguel = new Aluguel(inicio,fim,veiculo);
		
		System.out.println("Entre com o preco por hora: ");
		double precoHora = sc.nextDouble();
		System.out.println("Entre com o preco por dia: ");
		double precoDia = sc.nextDouble();
		
		ServicoAluguel servicoAluguel = new ServicoAluguel(precoHora,precoDia, new ServicoTaxaBrasil());
		servicoAluguel.processarFatura(aluguel);
		
		System.out.println("Fatura: ");
		System.out.println("Pagamento basico: "+ String.format("%.2f", aluguel.getFatura().getPagamentoBasico()));
		System.out.println("Imposto: "+aluguel.getFatura().getTax());
		double total = aluguel.getFatura().pagamentoTotal();
		System.out.println("Pagamento total: "+total);
		
		sc.close();
	}

}
