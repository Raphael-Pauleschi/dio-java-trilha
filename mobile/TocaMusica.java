package mobile;

import java.util.Scanner;

public class TocaMusica extends App {
	Album album = new Album();
	Musica music = album.music1;
	boolean tocando;

	@Override	
	public void rodando() {
		rodando = true;
		this.tocando = true;
		int comando;
		Scanner input = new Scanner(System.in);
		do {
			if (tocando) {
				System.out.println("Atualmente tocando: " + music.toString());
				System.out.println("<< I> >>");
			} else {
				System.out.println("Está pausado: " + music.toString());
				System.out.println("<< II >>");
			}

			System.out.println("1 - Back ");
			System.out.println("2 - Next ");
			System.out.println("3 - Play ");
			System.out.println("3 - Pause ");
			System.out.println("4 - Avaliar ");
			System.out.println("5 - Sair");
			comando = input.nextInt();

			switch (comando) {
			case 1:
				back();
				break;
			case 2:
				next();
				break;
			case 3:
				if (this.tocando)
					pause();
				else
					play();
				break;
			case 4:
				System.out.println("Entre com a avaliacao");
				avaliar(input.nextInt());
				break;
			case 5:
				rodando = false;
				break;
			default:
				System.out.println("Comando Invalido");
				break;
			}
		} while (rodando);
	}

	public void play() {
		tocando = true;
	}

	public void pause() {
		tocando = false;
	}

	public void next() {
		music = music.getProxima();
	}

	public void back() {
		music = music.getAnterior();
	}

	public void avaliar(int avaliacao) {
		music.setAvaliacao(avaliacao);
	}
}
