import javax.swing.JOptionPane;

public class Universidade {
	public Universidade() {
		try {
			Turma t = new Turma("BCC");

			Aluno a1 = new Aluno("Manuel");
			a1.addNotas(10);
			a1.addNotas(8);
			a1.addNotas(7);

			Aluno a2 = new Aluno("Jõao");
			a2.addNotas(7);
			a2.addNotas(3);
			a2.addNotas(4);

			Aluno a3 = new Aluno("Carla");
			a3.addNotas(9);
			a3.addNotas(9);
			a3.addNotas(10);

			t.addAluno(a1);
			t.addAluno(a2);
			t.addAluno(a3);

			JOptionPane.showMessageDialog(null, t.listarAlunos());

			JOptionPane.showMessageDialog(null, "Média geral: " + t.mediaGeral() + "\nMaior média: " + t.maiorMedia().getNome()
					+ "\nAlunos com media >= 7: " + t.qntAcimaMedia());
			Aluno busca = t.buscarAluno("Francisco");
			if(busca == null) {
				JOptionPane.showMessageDialog(null, "Aluno não encontrado");
			} else {
				JOptionPane.showMessageDialog(null, "Encontrado: " + busca.imprimirDados());
			}
			
			boolean alterou = t.alterarInformacoes("Manuel", "Lorenzo", new float[] {10, 10, 10});
			JOptionPane.showMessageDialog(null, "Alterou? " + alterou);
			
			boolean excluiu = t.excluirAluno("Jõao");
			JOptionPane.showMessageDialog(null, "Excluiu? " + excluiu);
			
			JOptionPane.showMessageDialog(null, t.listarAlunos());
			
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		new Universidade();
	}
}
