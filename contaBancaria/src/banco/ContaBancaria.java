package banco;

import heranca.Cliente;
import excecao.*;

public class ContaBancaria {
	private String numero;
	private double saldo;     
	private Cliente titular;

	public ContaBancaria(String numero, Cliente titular) {
		setNumero(numero);
		setTitular(titular);
	}
	
	public ContaBancaria(String numero, Cliente titular, double saldo) {
		setNumero(numero);
		setTitular(titular);
		setSaldo(saldo);
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

	public void setNumero(String numero) throws CampoVazioException {
		if (numero == null || numero.isBlank()) {
			throw new CampoVazioException("Numero");
		}

		this.numero = numero;
	}

	public void setTitular(Cliente titular) throws CampoVazioException {
		if (titular == null) {
			throw new CampoVazioException("Titular");
		}

		this.titular = titular;
	}

	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void depositar(double valor) throws IllegalArgumentException {
		if (valor <= 0) {
			throw new IllegalArgumentException("O valor do deposito deve ser positivo");
		}

		this.saldo += valor;
	}

	public void sacar(double valor) throws IllegalArgumentException {
		if (valor <= 0) {
			throw new IllegalArgumentException("O valor do saque deve ser positivo");
		}
		if (valor > getSaldo()) {
			throw new IllegalArgumentException("Valor deve ser menor que o saldo da conta.Saldo atual 100.0R$");
		}

		this.saldo -= valor;
	}

	public void transferir(ContaBancaria contaDestino, double valor) throws IllegalArgumentException {
		if (contaDestino == null) {
			throw new IllegalArgumentException("A conta de destino deve ser informada");
		}

		sacar(valor);
		contaDestino.depositar(valor);
	}
}