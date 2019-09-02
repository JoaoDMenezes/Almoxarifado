
package almoxarifado.dao;

import almoxarifado.modelo.Departamento;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CadastroDepartamento_Dao implements Serializable {
    
    
    PreparedStatement pst;
    String sql;   
    
 
    public void Salvar(Departamento departamento) throws SQLException {
        int Codigo = 0;
        sql = "INSERT INTO departamento (nome)VALUES(?)";
        pst = conexao.getInstance().prepareStatement(sql);
        pst.setString(1, departamento.getNome());
        pst.execute();
        pst.close();
    }
    
     public void Alterar(Departamento departamento) throws SQLException {

        sql = "Update departamento set Nome =? where Codigo=?";
        pst = conexao.getInstance().prepareStatement(sql);
        pst.setString(1, departamento.getNome());
         pst.setInt(2, departamento.getCodigo());
        pst.execute();
        pst.close();
    }
    
       public List<Departamento> TodosDepartamentos() throws SQLException {
        Departamento departamento;
        List<Departamento> requisitantes = new ArrayList<>();
        sql = "Select * from departamento order by Nome";
        Statement st;
        st = conexao.getInstance().createStatement();
        st.executeQuery(sql);
        ResultSet rs = st.getResultSet();
        while (rs.next()) {

            departamento = new Departamento(rs.getInt("Codigo"),rs.getString("Nome"));

            requisitantes.add(departamento);
        }

        st.close();

        return requisitantes;
    }
    
     public List<Departamento> TodosDepartamentosAtivos() throws SQLException {
        Departamento departamento;
        List<Departamento> departamentos = new ArrayList<>();
        sql = "Select * from departamento order by Nome";
        Statement st;
        pst = conexao.getInstance().prepareStatement(sql);
       // pst.setString(1, "");
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while (rs.next()) {

            departamento = new Departamento(rs.getInt("Codigo"),rs.getString("Nome"));

            departamentos.add(departamento);

        }

        pst.close();

        return departamentos;
    }  
    
     public List<Departamento> TodosDepartamentosInativos() throws SQLException {
        Departamento departamento;
        List<Departamento> departamentos = new ArrayList<>();
        sql = "Select * from departamento  order by Nome";
        Statement st;
        pst = conexao.getInstance().prepareStatement(sql);
        pst.setString(1, "Removido");
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while (rs.next()) {

            departamento = new Departamento(rs.getInt("Codigo"),rs.getString("Nome"));

            departamentos.add(departamento);
        }
        pst.close();

        return departamentos;
    }
    public Departamento getDepartamentoByCodigo(int Codigo) throws SQLException {
        Departamento departamento = null;
        sql = "Select * from departamento where Codigo=?";
        Statement st;
        pst = conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, Codigo);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while (rs.next()) {

            departamento = new Departamento(rs.getInt("Codigo"),rs.getString("Nome"));
        }
        pst.close();

        return departamento;
    }
    
    public Departamento getDepartamentoPorNome(String nome) throws SQLException {
        Departamento departamento = null;
        sql = "Select * from departamento where Nome=?";
        Statement st;
        pst = conexao.getInstance().prepareStatement(sql);
        pst.setString(1, nome);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while (rs.next()) {

            departamento = new Departamento(rs.getInt("codigo"),rs.getString("nome"));
        }

        pst.close();

        return departamento;
    }
    
    
    
    }