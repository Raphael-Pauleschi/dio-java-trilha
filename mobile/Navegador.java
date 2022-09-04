package mobile;

import java.util.Scanner;

public class Navegador extends App {
	Scanner input = new Scanner(System.in);
	boolean abaAberta;

	@Override
	public void rodando() {
		rodando = true;
		abaAberta = false;
		int conteudo;

		do {
			System.out.println("1 - Abrir nova aba");
			System.out.println("2 - Exibir nova aba");
			System.out.println("3 - Atualizar aba");
			System.out.println("4 - Sair");
			conteudo = input.nextInt();
			switch (conteudo) {
			case 1:
				adicionarAba();
				break;
			case 2:
				exibirNovaAba();
				break;
			case 3:
				atualizarPagina();
				break;
			case 4:
				fechar();
				break;
			default:
				System.out.println("Comando invalido");
				break;
			}

		} while (rodando);
	}

	public void exibirNovaAba() {
		if (abaAberta)
			System.out.println("\nNova Aba");
		else
			System.out.println("\nNenhuma aba foi aberta");

	}

	public void adicionarAba() {
		System.out.println("\nAba adicionada!");
		abaAberta = true;
	}

	public void atualizarPagina() {
		if (abaAberta)
			System.out.println("\nPagina atualizada!");
		else
			System.out.println("\nNenhuma aba foi aberta");

	}
}
