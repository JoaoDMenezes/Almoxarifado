
package almoxarifado.dao;

import almoxarifado.modelo.Pedido;
import java.util.ArrayList;

public class Dao_Pedido extends ConexaoMySql{
    Pedido pedido = new Pedido();

    public boolean salvarListaDePedidos(ArrayList<Pedido> listapedido) {
     try {
            this.conectar();
            int cont = listapedido.size();
            for (int i = 0; i < cont; i++) {
            this.insertSQL("INSERT INTO pedido ("
                    + "cod_requisicao,"
                    + "cod_material,"
                    + "quantidade"
                    + ") VALUES ("
                    + "'" + listapedido.get(i).getRequisicao() + "',"
                    + "'" + listapedido.get(i).getMaterial().getCodigo() + "',"
                    + "'" + listapedido.get(i).getQuantidade() + "'"
                    + ");"
            );
         }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
    
    
}
