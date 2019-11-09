
package almoxarifado.dao;


import almoxarifado.modelo.Pedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Dao_Pedido extends ConexaoMySql{
    ArrayList<Pedido> pedidos;
    Pedido pedido = new Pedido();
    PreparedStatement pst;
    String sql;
    Dao_CadastroMaterial material = new Dao_CadastroMaterial();

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
    
    public ArrayList<Pedido> listaDePedidos(int codigo) throws SQLException{
        pedidos = new ArrayList<Pedido>();
        sql="Select*from pedido where cod_requisicao= ? order by codigo";
        Statement st;
        pst = conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, codigo);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while (rs.next()) {
            pedido = new Pedido();
            pedido.setId(rs.getInt("codigo"));
            pedido.setMaterial(material.getMaterialByCodigo(rs.getInt("cod_material")));
            pedido.setRequisicao(rs.getInt("cod_requisicao"));
            pedido.setQuantidade(rs.getInt("quantidade"));
            pedidos.add(pedido);
            
        }
        pst.close();
        return pedidos;
    } 

    
}
