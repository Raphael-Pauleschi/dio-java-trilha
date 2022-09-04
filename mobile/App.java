package mobile;

public abstract class App {
	public boolean rodando = false;
	
	public abstract void rodando();
	public boolean getRodando() {
		return rodando;
	}
	public void fechar() {
		rodando = false;
	}
}
