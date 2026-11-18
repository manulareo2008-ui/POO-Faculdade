
public class Sistema {

	public static void main(String[] args) {
		Produto p1 = new Produto();
		p1.setNome("Teclado");
		p1.setPreco(150);
		
		Produto p2 = new Produto();
		p2.setNome("Mouse");
		p2.setPreco(80);
		
		Pedido pedido = new Pedido();
		pedido.setNumero(1);
		pedido.setData("14/08/2026");
		
		pedido.getListaProdutos().add(p1);
		pedido.getListaProdutos().add(p2);

		System.out.println("Os produtos " + p1.getNome() + " e " + p2.getNome() + " somam R$" + pedido.valorTotal());
	}
}
