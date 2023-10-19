import java.util.ArrayList;
import java.util.Scanner;
public class CarrinhoDeCompras {
    private ArrayList<ItemCarrinho> carrinho;

    public CarrinhoDeCompras() {
        carrinho = new ArrayList<>();
    }

    public void adicionarItem(Produto produto, int quantidade) {
        ItemCarrinho item = new ItemCarrinho(produto, quantidade);
        carrinho.add(item);
    }

    public ArrayList<ItemCarrinho> getItens() {
        return carrinho;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemCarrinho item : carrinho) {
            total += item.produto.preco * item.quantidade;
        }
        return total;
    }
}
