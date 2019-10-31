
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

public class Dao_Requisicao {
    PreparedStatement pst;
    String sql;
    CadastroRequisitante_Dao requsitante = new CadastroRequisitante_Dao();
    
    public ArrayList<Requisicao> ListaDeRequisicoes() throws SQLException{
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
         requisicao.add(req);    
        }
        st.close();
        return requisicao;
    }
    
        public void excluir(int codigo) throws SQLException{
     
        sql = "Delete from requisicao where codigo = ?";
        pst = conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, codigo);
        pst.execute();
        
        pst.close();
    }
}

