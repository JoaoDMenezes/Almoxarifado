package almoxarifado.dao;

import almoxarifado.modelo.Material;
import almoxarifado.modelo.Requisicao;
import almoxarifado.modelo.Requisitante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dao_Requisicao extends ConexaoMySql {

    PreparedStatement pst;
    String sql;
    CadastroRequisitante_Dao requsitante = new CadastroRequisitante_Dao();

    public void Salvar(Requisicao requisicao) throws SQLException {
        int codigo = 0;
        sql = "INSERT INTO requisicao VALUES(?,?,now(),?)";
        pst = conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, codigo);
        pst.setInt(2, requisicao.getRequisitante().getCodigo());
        pst.setDouble(3, requisicao.getValorTotal());
        pst.execute();
        pst.close();
    }

    //-------------------teste salvar-------------------
    public int salvarRequisicaoDAO(Requisicao Requi) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO requisicao ("
                    + "dataReq,"
                    + "codigo_req,"
                    + "valorReq"
                    + ") VALUES (now(),"
                    + "'" + Requi.getRequisitante().getCodigo() + "',"
                    + "'" + Requi.getValorTotal() + "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    public ArrayList<Requisicao> ListaDeRequisicoes() throws SQLException {
        ArrayList<Requisicao> requisicao = new ArrayList();
        Requisitante R = new Requisitante();
        Requisicao req = new Requisicao();
        sql = "Select * from requisicao Order By codigo";
        Statement st;
        st = conexao.getInstance().createStatement();
        st.executeQuery(sql);
        ResultSet rs = st.getResultSet();
        while (rs.next()) {
            req = new Requisicao();
            req.setId(rs.getInt("codigo"));
            req.setRequisitante(requsitante.getRequisitanteByCodigo(rs.getInt("codigo_req")));
            req.setData(rs.getDate("dataReq"));
            req.setValorTotal(rs.getDouble("valorReq"));
            req.setAprovacao(rs.getString("Aprovacao"));
            requisicao.add(req);
        }
        st.close();
        return requisicao;
    }
    public void excluirPedidos(int codigo) throws SQLException{
        sql ="Delete from pedido where cod_requisicao = ? ";
        pst= conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, codigo);
        pst.execute();
        pst.close();
    }
    public void excluir(int codigo) throws SQLException {

        sql = "Delete from requisicao where codigo = ?";
        pst = conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, codigo);
        pst.execute();
        pst.close();
    }

    public Requisicao buscaCodigoById(int id) throws SQLException {
        Requisicao requi = null;
        sql = "Select * from requisicao where codigo=?";
        pst = conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, id);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while (rs.next()) {
            requi = new Requisicao();
            requi.setId(rs.getInt("codigo"));
            requi.setRequisitante(requsitante.getRequisitanteByCodigo(rs.getInt("codigo_req")));
            requi.setData(rs.getDate("dataReq"));
            requi.setValorTotal(rs.getDouble("valorReq"));
        }
        pst.close();
        return requi;
    }
    
    public void aprovacaoPositiva(int codigo) throws SQLException{
        sql="update requisicao  set aprovacao='Aprovado' where codigo=?";
        pst = conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, codigo);
        pst.execute();
        pst.close();
    }
        public void aprovacaoNegativa(int codigo) throws SQLException{
        sql="update requisicao  set aprovacao='Negado' where codigo=?";
        pst = conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, codigo);
        pst.execute();
        pst.close();
    }

}
