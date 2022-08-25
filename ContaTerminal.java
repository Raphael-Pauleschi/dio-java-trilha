package Conta;
import java.util.Scanner;

public class ContaTerminal {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int numero;
		String agencia;
		String nomeCliente;
		double saldo;
		
		System.out.println("Por favor, digite o numero da agencia");
		numero = input.nextInt();
		System.out.println("Digite o nome da agencia");
		agencia = input.next();
		System.out.println("Digite o seu nome");
		nomeCliente = input.next();
		System.out.println("Digite o saldo dessa conta");
		saldo = input.nextDouble();
		
		System.out.println("Ola "+nomeCliente+", obrigado por criar uma conta em nosso banco, sua agencia e "+agencia+", conta "+numero+" e seu saldo "+saldo+" ja esta disponivel para saque");
	}
}
