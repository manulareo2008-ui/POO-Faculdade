
public class Aluno {
	private String nome;
	private double nota1;
	private double nota2;
	private double nota3;
	
	public Aluno(String nome, double nota1, double nota2, double nota3) {
		setNome(nome);
		setNota1(nota1);
		setNota2(nota2);
		setNota3(nota3);
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getNota1() {
		return nota1;
	}
	public double getNota2() {
		return nota2;
	}
	
	public double getNota3() {
		return nota3;
	}
	
	public void setNome(String nome) {
		if(nome == null || nome.isBlank()) {
			System.out.println("O nome deve ser informado");
		} else if(nome.length() < 3) {
			System.out.println("O nome deve ter mais de 2 caracteres");
		} else {
			this.nome = nome;
		}
	}
	
	public void setNota1(double nota1) {
		if(nota1 < 0 || nota1 > 10) {
			System.out.println("A nota deve ser maior do que 0");
		} else {
			this.nota1 = nota1;
		}
	}
	
	public void setNota2(double nota2) {
		if(nota2 < 0 || nota2 > 10) {
			System.out.println("A nota deve ser maior do que 0");
		} else {
			this.nota2 = nota2;
		}
	}
	
	public void setNota3(double nota3) {
		if(nota3 < 0 || nota3 > 10) {
			System.out.println("A nota deve ser maior do que 0");
		} else {
			this.nota3 = nota3;
		}
	}
	
	public double calcularMedia() {
		return (getNota1() + getNota2() + getNota3()) / 3;
	}
	
	public String listarInformacoes() {
		return getNome() + " - " + getNota1() + " - " + getNota2() + " - " + getNota3() + " - " + calcularMedia();
	}
}

