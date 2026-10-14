package heranca;

public class ContaBancaria {
	private String numero;
	private double saldo;     // ATRIBUTO private (fechado) - exigencia do enunciado da Q1
	private Cliente titular;

	public ContaBancaria(String numero, Cliente titular) {
		setNumero(numero);
		setTitular(titular);
		// saldo comeca em 0.0 por padrao (valor default do double). Nao precisa setar.
	}

	public String getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public Cliente getTitular() {
		return titular;
	}

	public void setNumero(String numero) throws IllegalArgumentException {
		if (numero == null || numero.isBlank()) {
			throw new IllegalArgumentException("O numero deve ser preenchido");
		}

		this.numero = numero;
	}

	public void setTitular(Cliente titular) throws IllegalArgumentException {
		if (titular == null) { // Cliente e referencia => pode ser null => tem que validar
			throw new IllegalArgumentException("O titular deve ser informado");
		}

		this.titular = titular;
	}

	// >>> HERANCA - PONTO-CHAVE DA QUESTAO 1 <<<
	// Atributo 'saldo' e private, mas o METODO setSaldo e 'protected' (o '#' do UML).
	// protected = so a propria classe + SUBCLASSES (+ mesmo pacote) enxergam.
	// Assim ninguem de fora altera o saldo direto, mas ContaEspecial reaproveita.
	// (So se percebe o efeito com os pacotes separados: 'sistema' NAO acessa isto.)
	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void depositar(double valor) throws IllegalArgumentException {
		if (valor <= 0) {
			throw new IllegalArgumentException("O valor do deposito deve ser positivo");
		}

		setSaldo(getSaldo() + valor); // usa o setSaldo protegido internamente
	}

	// sacar da SUPERCLASSE: NAO conhece limite de credito. So saca o que ha de saldo.
	// A regra do limite e tratada na subclasse, SOBRESCREVENDO este metodo.
	public void sacar(double valor) throws IllegalArgumentException {
		if (valor <= 0) {
			throw new IllegalArgumentException("O valor do saque deve ser positivo");
		}
		if (valor > getSaldo()) {
			throw new IllegalArgumentException("Saldo insuficiente");
		}

		setSaldo(getSaldo() - valor);
	}

	public void transferir(ContaBancaria contaDestino, double valor) throws IllegalArgumentException {
		if (contaDestino == null) {
			throw new IllegalArgumentException("A conta de destino deve ser informada");
		}

		// Reaproveita sacar e depositar (regras ja validadas). Como 'sacar' pode
		// estar sobrescrito na subclasse, a origem usa a versao certa => POLIMORFISMO.
		sacar(valor);
		contaDestino.depositar(valor);
	}
}