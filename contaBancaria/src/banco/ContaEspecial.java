package banco;

import heranca.Cliente;

public class ContaEspecial extends ContaBancaria {
	private double limiteCredito;

	public ContaEspecial(String numero, Cliente titular, double saldo, double limiteCredito) {
		super(numero, titular, saldo);
		setLimiteCredito(limiteCredito);
	}

	public ContaEspecial(String numero, Cliente titular, double limiteCredito) {
		super(numero, titular);
		setLimiteCredito(limiteCredito);
	}

	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) {
		if (limiteCredito < 0) {
			throw new IllegalArgumentException("O limite de credito deve ser superior a 0.");
		}
		this.limiteCredito = limiteCredito;
	}

	@Override
	public void sacar(double valor) throws IllegalArgumentException {
		if (valor <= 0) {
			throw new IllegalArgumentException("O valor deve ser maior do que 0.");
		}
		if (valor > (getSaldo() + limiteCredito)) {
			throw new RuntimeException("Saldo e limite de crédito insuficientes");
		}

		setSaldo(getSaldo() - valor);
	}
}