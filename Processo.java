package processo.seletivo;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Processo {

	public static void main(String[] args) {
		String candidatos[] = selecaoCandidatos();
		
		for (String candidato: candidatos) {
			entrarEmContato(candidato);
		}
		
		
	}
	
	static void entrarEmContato(String candidato) {
		int tentativa = 0;
		boolean continuar = true;
		boolean atendeu = false;
		do {
			atendeu = atender();
			continuar = ! atendeu;
			if(continuar)
				tentativa++;
			else
				System.out.println("\nContato realizado com sucesso");
		}while(continuar && tentativa<3);
		
		if (atendeu)
			System.out.println("Conseguimos contato com o "+candidato+" na tentativa "+(tentativa+1));
		else
			System.out.println("\nNão conseguimos contato com o "+candidato+", tentativas esgotadas");
	}
	
	static boolean atender() {
		return new Random().nextInt(3) == 1;
	}
	
	static String[] selecaoCandidatos() {
		String candidatos[] = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto","Monica","Fabricio","Manuel","Mirela","Daniela"};
		String selecionados[] = new String[5];
		int candidatosSelecionados = 0;
		int candidatosAtual = 0;
		
		while(candidatosSelecionados < 5) {
			try {	
				String candidato = candidatos[candidatosAtual];
				System.out.println("O candidato "+candidato+" solicitou esse valor de salario "+valorPretendido());
				if(analisarCandidato(valorPretendido())) {
					System.out.println("Candidato selecionado\n");
					selecionados[candidatosSelecionados] = candidatos[candidatosAtual];
					candidatosSelecionados++;
				}
				candidatosAtual++;
			}	
			catch(java.lang.ArrayIndexOutOfBoundsException e) {
				break;	
			}
		}
		
		//Cria uma array de String no tamanho ideal
		int aux=0;
		for(String candidato: selecionados) {
			if (candidato == null) break;
			aux++;
		}
		
		String selecionadosRetorno[] = new String[aux];
		aux = 0;
		for(String retorno:  selecionadosRetorno) {
			selecionadosRetorno[aux] = selecionados[aux];
			aux++;
		}
		
		imprimirCandidatos(selecionadosRetorno);
		
		
		
		return selecionadosRetorno;
	}
	
	static void imprimirCandidatos(String selecionados[]) {
		System.out.println("Imprimindo a lista de candidatos:");
		int candidatoAtual = 0;
		while((candidatoAtual < 5)){
			try{	
			System.out.println("O candidato "+(candidatoAtual+1)+": "+selecionados[candidatoAtual]);
				candidatoAtual++;
			if(selecionados[candidatoAtual] == null)
				break;	
			}catch(java.lang.ArrayIndexOutOfBoundsException e) {
				break;	
			}
		}
		System.out.println("\nResumidamente: ");
		for(String candidato: selecionados) {
			System.out.print(candidato+"/");
		}
	}
	
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800,2200);
	}
	
	
	static boolean analisarCandidato(double salarioPretendido) {
		double salarioBase = 2000.0;
		if(salarioPretendido > salarioBase) {
			System.out.println("Ligar para o candidato\n");
			return false;
		}else if(salarioPretendido == salarioBase) {
			System.out.println("Ligar para o candidato com contra proposta\n");	
		}else {
			System.out.println("Aguardando resultado demais candidatos\n");
		}
		return true;
		
	}

}
