
public class Aluno {
	private String nome;
	private float[] notas;
	private int notaAtual;
	
	public Aluno(String nome) throws IllegalArgumentException{
		setNome(nome);
		notas = new float[3];
	}
	
	public String getNome() {
		return nome;
	}
	
	public float[] getNotas() {
		return notas;
	}
	
	public void setNome(String nome) {
		if(nome == null || nome.isEmpty()) {
			throw new IllegalArgumentException("Nome deve ser preenchido");
		} 
		this.nome = nome;
	}
	
	public void setNotas(float[] notas) {
	    if (notas == null || notas.length != 3) {
	        throw new IllegalArgumentException("Devem ser informadas exatamente 3 notas");
	    }
	    for (float n : notas) {
	        if (n < 0 || n > 10) {
	            throw new IllegalArgumentException("A nota deve ser entre 0 e 10");
	        }
	    }
	    for (int i = 0; i < 3; i++) {
	        this.notas[i] = notas[i];
	    }
	    this.notaAtual = 3;
	}
	
	public void addNotas(float nota) {
		if(notaAtual < 3) {
			if(nota >= 0 && nota <= 10) {
				notas[notaAtual] = nota;
				notaAtual++;
			} else {
				throw new IllegalArgumentException("A nota deve ser entre 0 e 10");
			}
		} else {
			throw new IllegalArgumentException("As 3 notas já foram preenchidas");
		}
	}
	
	public float calcularMedia() {
		if(notaAtual == 3) {
			return( notas[0] + notas[1] + notas[2]) / 3;
		} else {
			throw new IllegalArgumentException("As 3 notas devem ser preenchidas para fazer a media");
		}
	}
	
	public String imprimirDados() {
		return getNome() + " - " + notas[0] + ", " + notas[1] + ", " + notas[2] + " - " + calcularMedia(); 
	}
}
