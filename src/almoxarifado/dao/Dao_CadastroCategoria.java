
package almoxarifado.dao;

import almoxarifado.modelo.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Dao_CadastroCategoria {
    PreparedStatement pst;
    String sql;
    public void salvar(Categoria c) throws SQLException{
        sql = "INSERT INTO categoria values(?, ?)";
        pst =conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, 0);
        pst.setString(2,c.getNome());
        pst.execute();
        pst.close();        
    }
    public List<Categoria> todosUsuarios() throws SQLException {
        Categoria c ;
        List<Categoria> categorias = new ArrayList<>();
        sql = "Select * from categoria order by codigo";
        Statement st;
        st = conexao.getInstance().createStatement();
        st.executeQuery(sql);
        ResultSet rs = st.getResultSet();
        while (rs.next()) {
         c = new Categoria(rs.getInt("codigo"),rs.getString("nome"));
            categorias.add(c);
        }
        st.close();
        return categorias;
    }
    public List<Categoria> BuscaCategoriaNome(String s) throws SQLException {
        Categoria c ;
        List<Categoria> categorias = new ArrayList<>();
        sql = "Select * from categoria where nome like ?";
        Statement st;
        pst = conexao.getInstance().prepareStatement(sql);
        pst.setString(1,s+"%");
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while (rs.next()) {
         c = new Categoria(rs.getInt("codigo"),rs.getString("nome"));
            categorias.add(c);
        }
        pst.close();
        return categorias;
    }
   public Categoria getCategoriaByCodigo(int codigo)throws SQLException{
       
        Categoria c = null;
        sql = "SELECT * FROM categoria WHERE codigo=?";
        Statement st;
        pst = (PreparedStatement) conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, codigo);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while(rs.next()){
         c = new Categoria(rs.getInt("codigo"),rs.getString("nome"));
        }
        pst.close();
        return c;
    }
    public void getAlterar(Categoria c) throws SQLException {
        sql = "UPDATE categoria SET nome = ? WHERE codigo=?";
        pst = conexao.getInstance().prepareStatement(sql);
        pst.setString(1,c.getNome());
        pst.setInt(2,c.getCodigo() );
        pst.execute();
        pst.close();
    }
    public Categoria busca(int codigo) throws SQLException{
        Categoria c = null;
        sql = "SELECT * FROM categoria WHERE codigo=?";
        Statement st;
        pst = (PreparedStatement) conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, codigo);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while(rs.next()){
             c = new Categoria(rs.getInt("codigo"),rs.getString("nome"));
        }
        pst.close();
        return c;
    }
}
