package empresa.modelo;

import java.util.ArrayList;
import java.util.List;

import empresa.excecao.CampoVazioException;

public class Programador extends Funcionario {
	private List<String> linguagens;
	
	public Programador(String nome, double salarioBase)  {
		super(nome, salarioBase);
		linguagens = new ArrayList<String>();
	}
	
	public List<String> getLinguagens() {
		return linguagens;
	}
	
	public void incluirLinguagem(String linguagem) throws CampoVazioException{
		if(linguagem == null || linguagem.isBlank()) {
			throw new CampoVazioException("Linguagem");
		}
		for(String l: linguagens) {
			if(l.equalsIgnoreCase(linguagem)) {
				throw new IllegalArgumentException("Linguagem já presente na lista");
			}
		}
		
		linguagens.add(linguagem);
	}
	
	public void removerLinguagem(String linguagem) throws CampoVazioException{
		if(linguagem == null || linguagem.isBlank()) {
			throw new CampoVazioException("Linguagem");
		}
		boolean presente = false;
		String esperada = null;
		for(String l: linguagens) {
			if(l.equalsIgnoreCase(linguagem)) {
				presente = true;
				esperada = l;
			}
		}
		
		if(presente) {
			linguagens.remove(esperada);
		} else {
			throw new IllegalArgumentException("Linguagem não cadastrada");
		}
	}
	
	@Override
	public double calcularSalario() {
		for(String linguagem: linguagens) {
			if(linguagem.equalsIgnoreCase("Java")) {
				return getSalarioBase() * 1.2;
			}
		}
		
		return getSalarioBase();
	}
}
