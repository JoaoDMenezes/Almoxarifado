
package almoxarifado.dao;

import almoxarifado.modelo.Requisitante;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CadastroRequisitante_Dao implements Serializable {
    
 PreparedStatement pst;
 String sql;   
    
 
    public void Salvar(Requisitante requisitante) throws SQLException {
        int Codigo = 0;
        sql = "INSERT INTO requisitante(nome, funcao, departamento, status, observacao) VALUES(?,?,?,?,?)";
        pst = conexao.getInstance().prepareStatement(sql);
        pst.setString(1, requisitante.getNome());
        pst.setString(2, requisitante.getFuncao());
        pst.setString(3, requisitante.getDepartamento());
        pst.setString(4, "ativo");
        pst.setString(5, requisitante.getObservacao());
        pst.execute();
        pst.close();
    }
    public void Alterar(Requisitante requisitante) throws SQLException {

        sql = "Update requisitante set nome =?, funcao=?, departamento=?,"
                + "status=?, observacao=? where codigo=?";
        pst = conexao.getInstance().prepareStatement(sql);
        pst.setString(1, requisitante.getNome());
        pst.setString(2, requisitante.getFuncao());
        pst.setString(3, requisitante.getDepartamento());
        pst.setString(4, requisitante.getStatus());
        pst.setString(5, requisitante.getObservacao());
        pst.setInt(6, requisitante.getCodigo());
        pst.execute();
        pst.close();
    }
    public Requisitante getRequisitantePorNome(String nome) throws SQLException {
        Requisitante requisitante = null;
        sql = "Select * from requisitante where Nome=?";
        Statement st;
        pst = conexao.getInstance().prepareStatement(sql);
        pst.setString(1, nome);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while (rs.next()) {

            requisitante = new Requisitante(rs.getInt("codigo"),rs.getString("nome"), rs.getString("departamento"),rs.getString("observacao"), 
           rs.getString("funcao"),rs.getString("status"));
        }

        pst.close();

        return requisitante;
    }
    
    public List<Requisitante> TodosRequisitantes() throws SQLException {
        Requisitante requisitante;
        List<Requisitante> requisitantes = new ArrayList<>();
        sql = "Select * from requisitante order by nome";
        Statement st;
        st = conexao.getInstance().createStatement();
        st.executeQuery(sql);
        ResultSet rs = st.getResultSet();
        while (rs.next()) {

            requisitante = new Requisitante(rs.getInt("codigo"),rs.getString("nome"), rs.getString("departamento"),rs.getString("observacao"), 
           rs.getString("funcao"),rs.getString("status"));

            requisitantes.add(requisitante);
        }

        st.close();

        return requisitantes;
    }
       public List<Requisitante> TodosRequisitantesAtivos() throws SQLException {
        Requisitante requisitante;
        List<Requisitante> requisitantes = new ArrayList<>();
        sql = "Select * from requisitante order by nome";
        //sql = "Select * from requisitante order by nome";
        Statement st;
        pst = conexao.getInstance().prepareStatement(sql);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while (rs.next()) {

            requisitante = new Requisitante(rs.getInt("codigo"),rs.getString("nome"), rs.getString("departamento"),rs.getString("observacao"), 
           rs.getString("funcao"),rs.getString("status"));

            requisitantes.add(requisitante);

        }

        pst.close();

        return requisitantes;
    }
        public List<Requisitante> TodosRequisitantesInativos() throws SQLException {
        Requisitante requisitante;
        List<Requisitante> requisitantes = new ArrayList<>();
        sql = "Select * from requisitante where status = ? order by nome";
        Statement st;
        pst = conexao.getInstance().prepareStatement(sql);
        pst.setString(1, "Removido");
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while (rs.next()) {

            requisitante = new Requisitante(rs.getInt("codigo"),rs.getString("nome"), rs.getString("departamento"),rs.getString("observacao"), 
           rs.getString("funcao"),rs.getString("status"));

            requisitantes.add(requisitante);
        }
        pst.close();

        return requisitantes;
    }
    
    public Requisitante getRequisitanteByCodigo(int Codigo) throws SQLException {
        Requisitante requisitante = null;
        sql = "Select * from requisitante where codigo=?";
        Statement st;
        pst = conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, Codigo);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while (rs.next()) {

            //requisitante = new Requisitante(rs.getInt("codigo"),rs.getString("nome"),rs.getString("funcao"), rs.getString("departamento"), 
           //rs.getString("status"),rs.getString("observacao"));
           requisitante = new Requisitante(rs.getInt("codigo"),rs.getString("nome"), rs.getString("departamento"),rs.getString("observacao"), 
           rs.getString("funcao"),rs.getString("status"));
        }
        pst.close();

        return requisitante;
    }
    
  
    
}
