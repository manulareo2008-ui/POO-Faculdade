
public class Turma {
	private String codigo;
	private String horario;
	private String sala;
	private int qntMaxAlunos;
	private Curso curso;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public int getQntMaxAlunos() {
		return qntMaxAlunos;
	}
	public void setQntMaxAlunos(int qntMaxAlunos) {
		this.qntMaxAlunos = qntMaxAlunos;
	}
}
