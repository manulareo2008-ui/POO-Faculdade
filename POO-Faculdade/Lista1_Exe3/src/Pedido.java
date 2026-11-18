import java.util.List;
import java.util.ArrayList;

public class Pedido {
    private int numero;
    private String data;
    private Situacao situacao;
    private List<Produto> listaProdutos = new ArrayList<>();

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public Situacao getSituacao() {
        return situacao;
    }
    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }
    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public double valorTotal() {
        double soma = 0;
        for (Produto p : listaProdutos) {
            soma = soma + p.getPreco();
        }
        return soma;
    }
}