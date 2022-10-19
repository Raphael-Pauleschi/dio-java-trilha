package conta;
import lombok.Data;
import main.Cliente;

@Data
public abstract class Conta implements InterfaceConta {
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	protected  final int agencia;
	protected final int number;
	protected double saldo;
	private Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.number = SEQUENCIAL++;
		this.cliente = cliente;

	}

	
	protected void imprimirInfos() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agência: %d", this.agencia));
		System.out.println(String.format("Número: %d", this.number));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
	
	@Override
	public void sacar(double valor) {
		if (saldo >= valor)
		saldo -= valor;
		else 
			System.out.println("Não se pode sacar esse valor");
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		try {
		this.sacar(valor);
		if (this.saldo >= valor)
		contaDestino.depositar(valor);
		else
			System.out.println("Transação incompleta");
		}catch(NullPointerException e){
			System.out.println("Conta não existente");
		}

	}

}
