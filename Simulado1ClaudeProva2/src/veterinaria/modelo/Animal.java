package veterinaria.modelo;

import veterinaria.excecao.CampoVazioException;
import veterinaria.excecao.MenorIgual0Exception;

public abstract class Animal {
	private int nrRegistro;
	private String nome;
	private int idade;
	private double valorBase = 120;

	// valorBase não é recebido no construtor porque é igual para todos os animais
	// (enunciado: "valor base de R$ 120,00, igual para qualquer animal").
	// Ele tem só getter, sem setter: ninguém consegue alterar o valor.
	public Animal(int nrRegistro, String nome, int idade) {
		setNrRegistro(nrRegistro);
		setNome(nome);
		setIdade(idade);
	}

	public int getNrRegistro() {
		return nrRegistro;
	}

	public void setNrRegistro(int nrRegistro) throws MenorIgual0Exception {
		if (nrRegistro <= 0) {
			throw new MenorIgual0Exception("Número de registro");
		}
		this.nrRegistro = nrRegistro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws CampoVazioException {
		if (nome == null || nome.isBlank()) {
			throw new CampoVazioException("Nome");
		}
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public double getValorBase() {
		return valorBase;
	}

	// Idade 0 é válida: filhotes com menos de 1 ano também são atendidos.
	public void setIdade(int idade) throws IllegalArgumentException {
		if (idade < 0) {
			throw new IllegalArgumentException("Idade não pode ser negativa");
		}
		this.idade = idade;
	}

	// Regra que muda de espécie para espécie: cada subclasse implementa.
	public abstract double calcularValorEspecie();

	// Regra comum a todas as espécies, escrita uma vez só:
	// valor da espécie + adicional de R$ 40,00 para animais com mais de 10 anos.
	public double valorFinal() {
		double valor = calcularValorEspecie();
		if (getIdade() > 10) {
			valor += 40;
		}
		return valor;
	}

	public String imprimirDados() {
		return "Número de registro: " + getNrRegistro() + " - Nome: " + getNome() + " - Idade: " + getIdade();
	}
}
