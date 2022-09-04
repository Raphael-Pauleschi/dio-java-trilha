package mobile;

import java.util.Random;
import java.util.Scanner;

public class DemoMobile {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random generator = new Random();
		TocaMusica itunes = new TocaMusica();
		Telefone tel = new Telefone();
		Navegador safari = new Navegador();
		int conteudo;
		int ligacao, contato;

		boolean ligado = true;
		boolean inApp = false;
		do {
			do {
				ligacao = generator.nextInt(10);
				if (ligacao == 9) {
					contato = generator.nextInt(3);
					switch(contato) {
					case 1:
						tel.atender(tel.contatos.c1);
						break;
					case 2:
							tel.atender(tel.contatos.c1);
							break;
					case 3:
						tel.atender(tel.contatos.c1);
						break;
					}
				} else {
					System.out.println("Selecione seu aplicativo");
					System.out.println("1 - Toca musica");
					System.out.println("2 - Telefone");
					System.out.println("3-  Navegador");
					System.out.println("4 - Sair");
					conteudo = input.nextInt();
					switch (conteudo) {
					case 1:
						itunes.rodando();
						inApp = rodando(itunes);
						break;
					case 2:
						tel.rodando();
						inApp = rodando(tel);
						break;
					case 3:
						safari.rodando();
						inApp = rodando(safari);
						break;
					case 4:
						ligado = false;
						inApp = true;
						break;
					default:
						System.out.println("Comando invalido");
						break;
					}
				}

			} while (!inApp);
		} while (ligado);

	}

	static public boolean rodando(App app) {
		return app.getRodando();
	}

}
