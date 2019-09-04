
package almoxarifado.dao;

import almoxarifado.modelo.Usuario;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;


public class Dao_CadastroUsuario {
    PreparedStatement pst;
    String sql;
    public void salvar(Usuario u) throws SQLException{
        sql = "INSERT INTO usuario values(?, ?, ?, ?, ?)";
        pst =conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, 0);
        pst.setString(2,u.getNome());
        pst.setString(3,u.getSenha());
        pst.setString(4,u.getTipoUsuario());
        pst.setBoolean(5, u.isStatus());
        pst.execute();
        pst.close();        
    }
    public List<Usuario> todosUsuarios() throws SQLException {
        Usuario u ;
        List<Usuario> usuarios = new ArrayList<>();
        sql = "Select * from usuario order by codigo";
        Statement st;
        st = conexao.getInstance().createStatement();
        st.executeQuery(sql);
        ResultSet rs = st.getResultSet();
        while (rs.next()) {
         u = new Usuario(rs.getInt("codigo"),rs.getString("nome"),rs.getString("senha"),
                    rs.getString("senha"),rs.getString("tipoUsuario"),rs.getBoolean("status"));
            usuarios.add(u);
        }
        st.close();
        return usuarios;
    }
    public List<Usuario> BuscaUsuarios(String s) throws SQLException {
        Usuario u ;
        List<Usuario> usuarios = new ArrayList<>();
        sql = "Select * from usuario where nome like ? OR tipoUsuario like ?";
        Statement st;
        pst = conexao.getInstance().prepareStatement(sql);
        pst.setString(1,s+"%");
        pst.setString(2,s+"%");
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while (rs.next()) {
         u = new Usuario(rs.getInt("codigo"),rs.getString("nome"),rs.getString("senha"),
                    rs.getString("senha"),rs.getString("tipoUsuario"),rs.getBoolean("status"));
            usuarios.add(u);
        }
        pst.close();
        return usuarios;
    }
   public Usuario getUsuarioByCodigo(int codigo)throws SQLException{
       
        Usuario u = null;
        sql = "SELECT * FROM Usuario WHERE codigo=?";
        Statement st;
        pst = (PreparedStatement) conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, codigo);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while(rs.next()){
         u = new Usuario(rs.getInt("codigo"),rs.getString("nome"),rs.getString("senha"),
              rs.getString("senha"),rs.getString("tipoUsuario"),rs.getBoolean("status"));
        }
        pst.close();
        return u;
    }
//    
//   public void getExcluirFuncionario(int codigo)throws SQLException{
//        sql = "DELETE FROM Funcionario WHERE codigo=?";
//        pst = conexao.getInstance().prepareStatement(sql);
//        pst.setInt(1, codigo);
//        pst.execute(); 
//        pst.close();
//    }
   public void getAlterar(Usuario u) throws SQLException {
        sql = "UPDATE Usuario SET nome =?, senha =?, tipoUsuario =?, status=? WHERE codigo=?";
        pst = conexao.getInstance().prepareStatement(sql);
        pst.setString(1,u.getNome());
        pst.setString(2, u.getSenha());
        pst.setString(3,u.getTipoUsuario());
        pst.setBoolean(4,u.isStatus());
        pst.setInt(5, u.getCodigo());
        pst.execute();
        pst.close();
    }
 
    public boolean gerarRelatorioCliente() throws SQLException, JRException, IOException {
        sql = "SELECT "
                + "     usuario.codigo  AS usuario_codigo, "
                + "     usuario.nome  AS usuario_nome, "
                + "     usuario.senha  AS usuario_senha, "
                + "     usuario.tipoUsuario  AS usuario_tipoUsuario, "
                + "     usuario.status  AS usuario_status "
                + "FROM "
                + "      usuario";
        pst = conexao.getInstance().prepareStatement(sql);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        JRResultSetDataSource jrRS = new JRResultSetDataSource(pst.getResultSet());
        
        InputStream caminho = this.getClass().getClassLoader().getResourceAsStream("relatorio/teste2.jasper");
        JasperPrint jasper = JasperFillManager.fillReport(caminho, new HashMap(),jrRS);
        JasperExportManager.exportReportToPdfFile(jasper,"C:/Users/User/Downloads/jcalendar-1.1.4.jar/teste.pdf");
        File file =new File("C:/Users/User/Downloads/jcalendar-1.1.4.jar/teste.pdf");
        Desktop.getDesktop().open(file);
        file.deleteOnExit();
        
        pst.close();
        return true;
    }

}
