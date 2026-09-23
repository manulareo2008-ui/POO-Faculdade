
public class Animal {
	private String nome;
	private String dataNascimento;
	private String raca;
	private Dono dono;
	
	public Animal(String nome, String dataNascimento, String raca, Dono dono) {
		setNome(nome);
		setDataNascimento(dataNascimento);
		setRaca(raca);
		setDono(dono);
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public String getRaca() {
		return raca;
	}
	
	public Dono getDono() {
		return dono;
	}
	
	public void setNome(String nome) throws IllegalArgumentException {
		if(nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("O nome deve ser preenchido");
		}
		if(nome.length() < 3) {
			throw new IllegalArgumentException("O nome deve possuir pelo menos 3 caracteres");
		}
		
		this.nome = nome;
	}
	
	public void setDataNascimento(String dataNascimento) throws IllegalArgumentException {
		if(dataNascimento == null || dataNascimento.isBlank()) {
			throw new IllegalArgumentException("A data de nascimento deve ser preenchido");
		}
		if(dataNascimento.length() < 8) {
			throw new IllegalArgumentException("A data de nascimento deve possuir pelo menos 8 caracteres");
		}
		
		this.dataNascimento = dataNascimento;
	}
	
	
	public void setRaca(String raca) throws IllegalArgumentException {
		if(raca == null || raca.isBlank()) {
			throw new IllegalArgumentException("A raça deve ser preenchida");
		}
		if(raca.length() < 3) {
			throw new IllegalArgumentException("A raça deve possuir pelo menos 3 caracteres");
		}
		
		this.raca = raca;
	}
	
	public void setDono(Dono dono) throws IllegalArgumentException {
		if(dono == null) {
			throw new IllegalArgumentException("O dono deve ser informado");
		}
		
		this.dono = dono;
	}
	
	public String imprimirDados() {
		return getNome() + " - " + getDataNascimento() + " - " + getRaca() + " - Dono: " + getDono().getNome();
	}
}
