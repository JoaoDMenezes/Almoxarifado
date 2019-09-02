/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almoxarifado.controle;

import almoxarifado.dao.Dao_CadastroUsuario;
import almoxarifado.modelo.Usuario;
import almoxarifado.view.Principal;
import almoxarifado.view.View_Login;
import almoxarifado.view.View_Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Almoxarifado01 {
   // ArrayList<Usuario> usuarios = new ArrayList<>();
   
    public static void main(String[] args) throws SQLException {
       ArrayList<Usuario> usuarios = new ArrayList<>();
       Dao_CadastroUsuario daoUsuario = new Dao_CadastroUsuario();
       usuarios = (ArrayList<Usuario>) daoUsuario.todosUsuarios();
       if(usuarios==null){
           JOptionPane.showMessageDialog(null, "NÃO A USUARIOS CADASTRADOS");
           new View_Usuario().setVisible(true);
       }else{
           new View_Login().setVisible(true);
       }      
    }
    
}
