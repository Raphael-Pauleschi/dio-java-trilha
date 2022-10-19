package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import conta.*;
import lombok.Data;

@Data
public class Banco {
	private final String nome = "Café";
	private List<Conta> contas = new ArrayList<>();
	private List<Cliente> clientes = new ArrayList<>();

	Scanner input = new Scanner(System.in);

	// O cliente deve ter uma conta vinculada
	public void cadastrarCliente() {
		System.out.println("Entre com o nome: ");
		String nome = input.next();
		System.out.println("Entre com a senha: ");
		String senha = input.next();

		Cliente cliente = new Cliente(nome, senha);
		criarConta(cliente);
		clientes.add(cliente);
	}

	public void criarConta(Cliente cliente) {
		boolean valido = false;
		int tipoConta;

		System.out.println("Entre com o Tipo de conta" + "\n1 - Poupança \t 2 - Corrente");
		do {
			try {
				tipoConta = input.nextInt();
				switch (tipoConta) {
				case 1:
					Conta contaP = new ContaPoupanca(cliente);
					valido = true;
					contas.add(contaP);
					break;
				case 2:
					Conta contaC = new ContaCorrente(cliente);
					valido = true;
					contas.add(contaC);
					break;
				default:
					System.out.println("Valor invalido! Por favor, coloque umas das opções!\n");
				}
			} catch (NumberFormatException e) {
				System.out.println("Valor invalido! Por favor, coloque umas das opções!\n");
			}
		} while (!valido);

	}

	public Conta login() {
		System.out.println("Entre com o nome: ");
		String nome = input.next();
		System.out.println("Entre com a senha: ");
		String senha = input.next();
		Cliente clienteTeste = new Cliente(nome, senha);
		try {
			for (Conta conta : contas) {
				if (conta.getCliente().equals(clienteTeste)) {
					return conta;
				}
			}
		} catch (NullPointerException e) {
			System.out.println("Não há cliente cadastrado!");
		}
		return null;
	}
	
	public Conta buscaConta(int numero) {
		try {
			for (Conta conta : contas) {
				if (conta.getNumber() == numero) {
					return conta;
				}
			}
		} catch (NullPointerException e) {
			System.out.println("Não há cliente cadastrado!");
		}
		return null;
	}
}
