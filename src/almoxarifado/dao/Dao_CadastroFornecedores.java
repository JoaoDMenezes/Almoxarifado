
package almoxarifado.dao;

import almoxarifado.modelo.Fornecedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Dao_CadastroFornecedores {
    PreparedStatement pst;
    String sql;
    
     public void salvar(Fornecedor f) throws SQLException{
        sql = "INSERT INTO Fornecedores values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now())";
        pst =conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, 0);
        pst.setString(2,f.getRazao());
        pst.setString(3,f.getNomeFantasia());
        pst.setString(4,f.getCnpj_cpf());
        pst.setString(5,f.getInscricaoEstadual_RG());
        pst.setString(6,f.getRua());
        pst.setString(7,f.getNumero());
        pst.setString(8,f.getComplemento());
        pst.setString(9,f.getBairro());
        pst.setString(10,f.getCidade());
        pst.setString(11,f.getEstado());
        pst.setString(12,f.getCep());
        pst.setString(13,f.getBanco());
        pst.setString(14,f.getAgencia());
        pst.setString(15,f.getConta());
        pst.setString(16,f.getTelefone1());
        pst.setString(17,f.getTelefone2());
        pst.setString(18,f.getEmail());
        pst.execute();
        pst.close();        
    }
    public List<Fornecedor> todosUsuarios() throws SQLException {
        Fornecedor f ;
        List<Fornecedor> fornecedores = new ArrayList<>();
        sql = "Select * from Fornecedores order by codigo";
        Statement st;
        st = conexao.getInstance().createStatement();
        st.executeQuery(sql);
        ResultSet rs = st.getResultSet();
        while (rs.next()) {
         f = new Fornecedor(rs.getInt("codigo"), rs.getString("razao"), rs.getString("nomeFantasia"), rs.getString("CNPJ_CPF")
                 ,rs.getString("Inscricao_RG"),rs.getString("rua"),rs.getString("numero"),rs.getString("complemento"),rs.getString("bairro")
                 ,rs.getString("cidade"),rs.getString("estado"),rs.getString("cep"),rs.getString("banco"),rs.getString("agencia"),
                 rs.getString("conta"),rs.getString("telefone"),rs.getString("telefone2"),rs.getString("email"),rs.getDate("dataCadastro"));
            fornecedores.add(f);
        }
        st.close();
        return fornecedores;
    }
    public List<Fornecedor> BuscaUsuarios(String s) throws SQLException {
        Fornecedor f ;
        List<Fornecedor> fornecedores = new ArrayList<>();
        sql = "Select * from fornecedores where nomeFantasia like ? OR Inscricao_RG like ?";
        Statement st;
        pst = conexao.getInstance().prepareStatement(sql);
        pst.setString(1,s+"%");
        pst.setString(2,s+"%");
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while (rs.next()) {
        f = new Fornecedor(rs.getInt("codigo"), rs.getString("razao"), rs.getString("nomeFantasia"), rs.getString("CNPJ_CPF")
                 ,rs.getString("Inscricao_RG"),rs.getString("rua"),rs.getString("numero"),rs.getString("complemento"),rs.getString("bairro")
                 ,rs.getString("cidade"),rs.getString("estado"),rs.getString("cep"),rs.getString("banco"),rs.getString("agencia"),
                 rs.getString("conta"),rs.getString("telefone"),rs.getString("telefone2"),rs.getString("email"),rs.getDate("dataCadastro"));
            fornecedores.add(f);
        }
        pst.close();
        return fornecedores;
    }
   public Fornecedor getUsuarioByCodigo(int codigo)throws SQLException{
       
        Fornecedor f = null;
        sql = "SELECT * FROM Fornecedores WHERE codigo=?";
        Statement st;
        pst = (PreparedStatement) conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, codigo);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while(rs.next()){
         f = new Fornecedor(rs.getInt("codigo"), rs.getString("razao"), rs.getString("nomeFantasia"), rs.getString("CNPJ_CPF")
                 ,rs.getString("Inscricao_RG"),rs.getString("rua"),rs.getString("numero"),rs.getString("complemento"),rs.getString("bairro")
                 ,rs.getString("cidade"),rs.getString("estado"),rs.getString("cep"),rs.getString("banco"),rs.getString("agencia"),
                 rs.getString("conta"),rs.getString("telefone"),rs.getString("telefone2"),rs.getString("email"),rs.getDate("dataCadastro"));
           
        }
        pst.close();
        return f;
    }
//    
//   public void getExcluirFuncionario(int codigo)throws SQLException{
//        sql = "DELETE FROM Funcionario WHERE codigo=?";
//        pst = conexao.getInstance().prepareStatement(sql);
//        pst.setInt(1, codigo);
//        pst.execute(); 
//        pst.close();
//    }
   public void getAlterar(Fornecedor f) throws SQLException {
        sql = "UPDATE Fornecedor SET  razao =?, nomeFantasia =?, cnpj_cpf= ?,Inscricao_RG =?,rua = ?,numero = ?,"
                + "complemento = ?, bairro = ?,cidade = ?, estado =?,cidade= ?,estado = ?,cep = ?, banco = ?, agencia = ?,conta = ?, telefone = ?,telefone2 = ?,email = ? WHERE codigo=?";
        pst = conexao.getInstance().prepareStatement(sql);
        pst.setString(1,f.getRazao());
        pst.setString(2,f.getNomeFantasia());
        pst.setString(3,f.getCnpj_cpf());
        pst.setString(4,f.getInscricaoEstadual_RG());
        pst.setString(5,f.getRua());
        pst.setString(6,f.getNumero());
        pst.setString(7,f.getComplemento());
        pst.setString(8,f.getBairro());
        pst.setString(9,f.getCidade());
        pst.setString(10,f.getEstado());
        pst.setString(11,f.getCep());
        pst.setString(12,f.getBanco());
        pst.setString(13,f.getAgencia());
        pst.setString(14,f.getConta());
        pst.setString(15,f.getTelefone1());
        pst.setString(16,f.getTelefone2());
        pst.setString(17,f.getEmail());
        pst.setInt(18, f.getCodigo());
        pst.execute();
        pst.close();
    }
}
