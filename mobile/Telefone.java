package mobile;

import java.util.Scanner;
import java.util.Random;

public class Telefone extends App {
	Scanner input = new Scanner(System.in);
	Contatos contatos = new Contatos();
	boolean ligacao = false;
	
	@Override
	public void rodando() {
		int comando;
		do {
			if (!ligacao) {
			System.out.println("Ligar pra quem?");
			System.out.println("1 - " + contatos.c1.getNome());
			System.out.println("2 - " + contatos.c2.getNome());
			System.out.println("3 - " + contatos.c3.getNome());
			System.out.println("4 - Sair");
			comando = input.nextInt();
			switch (comando) {
			case 1:
				ligar(contatos.c1);
				break;
			case 2:
				ligar(contatos.c2);
				break;
			case 3:
				ligar(contatos.c3);
				break;
			case 4:
				fechar();
				break;
			default:
				System.out.println("Comando invalido\n");
				break;
			}
			}
		} while (rodando);
	}

	private void ligar(Contato chamada) {
		Random recepcao = new Random();
		if (recepcao.nextBoolean()) {
			ligacao = true;
			iniciarCorreioVoz(chamada);
		}else {
			System.out.println("Ligacao recusada!");
			ligacao = false;
			
		}
	}

	public void atender(Contato chamada) {
		boolean aceitar;
		System.out.println("Chamada de" + chamada.toString());
		System.out.println("\nAtender?");
		aceitar = input.nextBoolean();
		if (aceitar)
			iniciarCorreioVoz(chamada);
		else
			fechar();
	}

	private void iniciarCorreioVoz(Contato chamada) {
		do {
			System.out.println("Conversando com " + chamada.toString());
			System.out.println("Desligar?");
			ligacao = input.nextBoolean();
		}while(ligacao);	
	}

}
