import java.util.List;
import java.util.ArrayList;

public class Sorveteria {
	private List<Pedido> pedidos;
	
	public Sorveteria() {
		pedidos = new ArrayList<Pedido>();
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	public void addPedido(Pedido pedido) throws IllegalArgumentException {
		if(pedido == null) {
			throw new IllegalArgumentException("O pedido deve ser preenchido");
		}
		pedidos.add(pedido);
	}
	
	public Pedido localizarPedido(int numero) {
		for(Pedido p: pedidos) {
			if(p.getNumero() == numero) {
				return p;
			} 
		}
		return null;
	}
	
	public int qntPedidosPorCliente(String nome) {
		int qnt = 0;
		for(Pedido p: pedidos) {
			if(p.getNomeCliente().equals(nome)) {
				qnt++;
			}
		}
		
		return qnt;
	}
	
	public Pedido qntSorvetesNoMaiorPedido() {
		if(pedidos.isEmpty()) {
			return null;
		}
		Pedido maior = pedidos.get(0);
		for(Pedido p: pedidos) {
			if(p.getSorvetes().size() > maior.getSorvetes().size()) {
				maior = p;
			}
		}
		
		return maior;
	}
}
