package Questao5;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Agenda {
	private Map<Integer, Contato> contatos;
	private File arquivo;
	
	public Agenda() {
		contatos = new HashMap<Integer, Contato>();
		arquivo = new File("contatos.txt");
	}
	
	private void carregar() {
		
	}
	
	private void cadastrar(Contato c) {
		
	}
	
	private String listar() {
		
	}
	
	private Contato procurar(int codigo) {
		
	}
	
	public boolean excluir(int codigo) {
		
	}
	
	public void alterar(int codigo, String novoNome, String novoTelefone) {
		
	}
}




