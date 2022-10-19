package main;

import java.util.Scanner;

import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean autenticado = false;
		boolean executando = true;
		Banco banco = new Banco();
		Conta conta = null;
		int aux;

		System.out.println("Bem vindo ao Banco " + banco.getNome());
		while (executando) {
			while (!autenticado) {
				System.out.println("1 - Login");
				System.out.println("2 - Cadastro");
				System.out.println("3 - Sair");
				try {
					aux = input.nextInt();
					switch (aux) {
					case 1:
						conta = banco.login();
						if (conta == null)
							System.out.println("Nome ou senha incorretos");
						else {
							autenticado = true;
							System.out.println("Olá, " + conta.getCliente().getNome());
						}
						break;
					case 2:
						banco.cadastrarCliente();
						;
						break;
					case 3:
						autenticado = true;
						executando = false;
						break;
					default:
						System.out.println("Valor invalido! Por favor, coloque umas das opções!\n");
					}
				} catch (NumberFormatException e) {
					System.out.println("Valor invalido! Por favor, coloque umas das opções!\n");
				}
			}
			if (!executando) {
				
				System.out.println("1 - Sacar");
				System.out.println("2 - Depositar");
				System.out.println("3-  Tranferir");
				System.out.println("4 - Imprimir Extrato");
				System.out.println("4 - Sair da conta");
				System.out.println("5 - Fechar programa");
				aux = input.nextInt();

				switch (aux) {
				case 1:
					conta.sacar(input.nextDouble());
					break;
				case 2:
					conta.depositar(input.nextDouble());
					break;
				case 3:
					conta.transferir(input.nextDouble(), banco.buscaConta(input.nextInt()));
					break;
				case 4:
					conta.imprimirExtrato();
					break;
				case 5:
					autenticado = false;
					break;
				case 6:
					executando = false;
					break;
				default:
					System.out.println("Valor invalido! Por favor, coloque umas das opções!\n");

				}
			}
		}

	}

}
