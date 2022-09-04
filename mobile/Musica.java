package mobile;

public class Musica {
	private String artista, nome;
	public int avaliacao;
	private double duracao;
	private Musica proxima, anterior;
	
	public Musica(String artista, String nome, double duracao) {
		this.artista = artista;
		this.nome = nome;
		this.avaliacao = 0;
		this.duracao = duracao;
	}
	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Musica getProxima() {
		return proxima;
	}

	public void setProxima(Musica proxima) {
		this.proxima = proxima;
	}

	public Musica getAnterior() {
		return anterior;
	}

	public void setAnterior(Musica anterior) {
		this.anterior = anterior;
	}

	@Override
	public String toString() {
		return nome+"\n"+artista+"\nAvaliado: "+avaliacao+"\nDuracao: "+duracao+" min.";
	}
	
}
