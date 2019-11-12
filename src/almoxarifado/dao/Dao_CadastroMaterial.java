
package almoxarifado.dao;

import almoxarifado.modelo.Categoria;
import almoxarifado.modelo.Material;
import almoxarifado.modelo.entrada;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class Dao_CadastroMaterial {
    PreparedStatement pst;
    String sql;
    Dao_CadastroCategoria categoria = new Dao_CadastroCategoria();
    
     public void salvar(Material m) throws SQLException
    {
        int id = 0;
        sql = "INSERT INTO material values(?, ?, ?, ?, ?, ?, ?, ?)";
        pst =conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, 0);
        pst.setString(2,m.getDescricao());
        pst.setInt(3,m.getCategoria().getCodigo());
        pst.setBoolean(4, m.isConsumivel());
        pst.setString(5, m.getObservacao());
        pst.setInt(6, m.getEstoqueMinimo());
        pst.setInt(7, m.getEstoqueMaximo());
        pst.setDouble(8, m.getCustoMedio());
        pst.execute();
        pst.close();
    }
     public List<Material> todosMateriais() throws SQLException {
        Material m ;
        List<Material> materiais = new ArrayList<>();
        sql = "Select * from material order by codigo";
        Statement st;
        st = conexao.getInstance().createStatement();
        st.executeQuery(sql);
        ResultSet rs = st.getResultSet();
        while (rs.next()) {
         m = new Material(rs.getInt("codigo"),rs.getString("descricao"),categoria.busca(rs.getInt("codigo_cat")),
                    rs.getBoolean("consumivel"),rs.getString("obs"),rs.getInt("estoqueMinimo"),rs.getInt("estoqueMaximo"), rs.getDouble("custoMedio"),rs.getInt("quantidade"));
            materiais.add(m);    
        }
        st.close();
        return materiais;
    }
     public Material getMaterialByCodigo(int codigo)throws SQLException{
       
        Material m = null;
        sql = "SELECT * FROM material WHERE codigo=?";
        Statement st;
        pst = (PreparedStatement) conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, codigo);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while(rs.next()){
         m = new Material(rs.getInt("codigo"),rs.getString("descricao"),categoria.busca(rs.getInt("codigo_cat")),
                    rs.getBoolean("consumivel"),rs.getString("obs"),rs.getInt("estoqueMinimo"),rs.getInt("estoqueMaximo"),
                    rs.getDouble("custoMedio"),rs.getInt("quantidade"));
        }
        pst.close();
        return m;
    }
      public void getAlterar(Material m) throws SQLException {
        sql = "UPDATE material SET descricao =?, codigo_cat =?, consumivel =?, obs=?, estoqueMinimo =?, estoqueMaximo=?, custoMedio=? WHERE codigo=?";
        pst = conexao.getInstance().prepareStatement(sql);
        pst.setString(1,m.getDescricao());
        pst.setInt(2,m.getCategoria().getCodigo());
        pst.setBoolean(3, m.isConsumivel());
        pst.setString(4, m.getObservacao());
        pst.setInt(5, m.getEstoqueMinimo());
        pst.setInt(6, m.getEstoqueMaximo());
        pst.setDouble(7, m.getCustoMedio());
        pst.setInt(8, m.getCodigo());
        pst.execute();
        pst.close();
    }
      public Categoria pegaCategoria(String nome) throws SQLException{
        Categoria c = null;
        sql = "Select * From categoria Where nome = ?";
        Statement st;
        pst = (PreparedStatement) conexao.getInstance().prepareStatement(sql);
        pst.setString(1, nome);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while(rs.next()){
         c = new Categoria(rs.getInt("codigo"),rs.getString("nome"));
        }
        pst.close();
        return c;
    }
    
    public Vector<Categoria> CampoBox() throws SQLException {
     
    Vector<Categoria> dados = new Vector<Categoria>();
    sql="Select*From categoria order by codigo";
    Statement st;
    st = conexao.getInstance().createStatement();
    st.executeQuery(sql);
    ResultSet rs = st.getResultSet();
    while(rs.next()){
       Categoria c = new Categoria(rs.getInt("codigo"),rs.getString("nome"));
       dados.add(c);
    }
    st.close();
    return dados;
    }
     public List<Material> BuscaMateriais(String s) throws SQLException {
        Material m ;
        List<Material> materiais = new ArrayList<>();
        sql = "Select * from material where descricao like ? OR obs like ?";
        Statement st;
        pst = conexao.getInstance().prepareStatement(sql);
        pst.setString(1,s+"%");
        pst.setString(2,s+"%");
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while (rs.next()) {
        m = new Material(rs.getInt("codigo"),rs.getString("descricao"),categoria.busca(rs.getInt("codigo_cat")),
                    rs.getBoolean("consumivel"),rs.getString("obs"),rs.getInt("estoqueMinimo"),rs.getInt("estoqueMaximo"),
                    rs.getDouble("custoMedio"),rs.getInt("quantidade"));
            materiais.add(m);
        }
        pst.close();
        return materiais;
    }
    public Material pegaChave(int codigo) throws SQLException{
        Material m = null;
        sql = "SELECT * FROM material WHERE codigo=?";
        Statement st;
        pst = (PreparedStatement) conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, codigo);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while(rs.next()){
         m = new Material(rs.getInt("codigo"),rs.getString("descricao"),categoria.busca(rs.getInt("codigo_cat")),
                    rs.getBoolean("consumivel"),rs.getString("obs"),rs.getInt("estoqueMinimo"),rs.getInt("estoqueMaximo"),
                    rs.getDouble("custoMedio"),rs.getInt("quantidade"));
        }
        pst.close();
        return m;
    }

    public Material getMateriaPorNome(String nome) throws SQLException {
         Material m = null;
        sql = "SELECT * FROM material WHERE descricao=?";
        Statement st;
        pst = (PreparedStatement) conexao.getInstance().prepareStatement(sql);
        pst.setString(1, nome);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while(rs.next()){
         m = new Material(rs.getInt("codigo"),rs.getString("descricao"),categoria.busca(rs.getInt("codigo_cat")),
                    rs.getBoolean("consumivel"),rs.getString("obs"),rs.getInt("estoqueMinimo"),rs.getInt("estoqueMaximo"),
                    rs.getDouble("custoMedio"),rs.getInt("quantidade"));
        }
        pst.close();
        return m;
    }
    
        public void adicionar(int quant,int codigo) throws SQLException{
        sql="update material  set quantidade=? where codigo=?";
        pst = conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, quant);
        pst.setInt(2, codigo);
        pst.execute();
        pst.close();
    }
        public void salvarEntrada(String material,String fornecedor,String quant) throws SQLException
    {
        int id = 0;
        sql = "INSERT INTO entrada values(?,?, now(), ?, ?)";
        pst =conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, 0);
        pst.setString(2, material);
        pst.setString(3,quant);
        pst.setString(4,fornecedor);
        pst.execute();
        pst.close();
    }
        public List<entrada> todosentradas() throws SQLException {
        entrada m ;
        List<entrada> entradas = new ArrayList<>();
        sql = "Select * from entrada order by id";
        Statement st;
        st = conexao.getInstance().createStatement();
        st.executeQuery(sql);
        ResultSet rs = st.getResultSet();
        while (rs.next()) {
         m = new entrada(rs.getString("material"),rs.getString("dt_entrada"),rs.getString("quant"),
                    rs.getString("fornecedor"));
           entradas.add(m);    
        }
        st.close();
        return entradas;
    }
}
