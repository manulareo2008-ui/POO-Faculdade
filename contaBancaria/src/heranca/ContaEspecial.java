package heranca;

// 'extends ContaBancaria' => ContaEspecial E UMA ContaBancaria.
// Herda numero, saldo, titular, todos os getters/setters, depositar, transferir.
// Aqui so declaramos o que e NOVO (limiteCredito) ou DIFERENTE (sacar).
public class ContaEspecial extends ContaBancaria {
	private double limiteCredito; // atributo exclusivo da conta especial

	public ContaEspecial(String numero, Cliente titular, double limiteCredito) {
		// super(...) chama o construtor da ContaBancaria pra montar a parte herdada
		// (numero e titular). OBRIGATORIO ser a 1a linha do construtor da subclasse.
		super(numero, titular);
		setLimiteCredito(limiteCredito); // depois inicializa o que e so da filha
	}

	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) throws IllegalArgumentException {
		if (limiteCredito < 0) {
			throw new IllegalArgumentException("O limite de credito nao pode ser negativo");
		}

		this.limiteCredito = limiteCredito;
	}

	// >>> SOBRESCRITA (@Override) <<<
	// Mesma assinatura do sacar() da mae, mas com regra nova: pode sacar alem do
	// saldo, desde que nao passe do limite. @Override nao e obrigatorio pra rodar,
	// mas SEMPRE use: o compilador acusa se voce errar a assinatura (seguranca).
	@Override
	public void sacar(double valor) throws IllegalArgumentException {
		if (valor <= 0) {
			throw new IllegalArgumentException("O valor do saque deve ser positivo");
		}

		// Saldo nao pode cair abaixo de -limite. Ex.: limite 100 => saldo ate -100.
		if ((getSaldo() - valor) < -getLimiteCredito()) {
			// Caso 3 do plano de testes exige RuntimeException quando estoura tudo.
			throw new RuntimeException("Saldo e limite de credito insuficientes");
		}

		// Reaproveita o setSaldo() PROTECTED herdado - so possivel por ser subclasse.
		setSaldo(getSaldo() - valor);
	}
}