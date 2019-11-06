
package almoxarifado.controle;

import almoxarifado.dao.Dao_CadastroCategoria;
import almoxarifado.dao.Dao_Pedido;
import almoxarifado.modelo.Pedido;
import java.util.ArrayList;


public class ControllerPedido {
    Dao_Pedido daoPedido = new Dao_Pedido(); 
    public boolean salvarPedidosEmLista(ArrayList<Pedido> listapedido) {
       return this.daoPedido.salvarListaDePedidos(listapedido);
    }
    
}
