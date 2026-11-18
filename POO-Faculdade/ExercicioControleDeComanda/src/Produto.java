import javax.swing.JOptionPane;

public class Produto {
	private double valorUnitario;
	private String nome;

	public double getValorUnitario() {
		return valorUnitario;
	}

	public String getNome() {
		return nome;
	}

	public void setValorUnitario(double valorUnitario) {
		if (valorUnitario > 0) {
			this.valorUnitario = valorUnitario;
		} else {
			JOptionPane.showMessageDialog(null, "O valor unitario deve ser superior a R$0.");
		}
	}

	public void setNome(String nome) {
		if (nome != null && !nome.isBlank()) {
			this.nome = nome;
		} else {
			JOptionPane.showMessageDialog(null, "O nome deve ser preenchido");
		}
	}
}

