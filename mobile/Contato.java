package mobile;

public class Contato {
	private String nome;
	private int numero;
	
	public Contato(String nome, int numero) {
		this.nome = nome;
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	@Override
	public String toString() {
		return nome+"\n+"+numero;
	}
	
	
}
