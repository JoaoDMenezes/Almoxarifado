/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almoxarifado.dao;

import almoxarifado.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author joao
 */
public class Dao_login {
    PreparedStatement pst;
    String sql;
    
    public boolean getLogin(String n ,String s) throws SQLException{
        System.out.println(n+s);
        Usuario usuario = null;
        sql ="SELECT * FROM usuario where nome = ? AND senha = ?";
        Statement st;
        pst = conexao.getInstance().prepareStatement(sql);
        pst.setString(1,n);
        pst.setString(2,s);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        
        while(rs.next()){
            usuario = new Usuario(rs.getInt("codigo"),rs.getString("nome"),rs.getString("senha"),
                    rs.getString("senha"),rs.getString("tipoUsuario"),rs.getBoolean("status"));
        }
        pst.close();
        boolean r  = false;
        try{
            if(usuario.getNome().equals(n) && usuario.getSenha().equals(s)){
                r= true;
            }
            else{
                r = false;
            }
        }catch(NullPointerException x){
            JOptionPane.showMessageDialog(null,"O usuario ou a senha \n  esta incorreto ");
        }
        return r; 
    }
    public Usuario getLogin2(String n ,String s) throws SQLException{
        System.out.println(n+s);
        Usuario usuario = null;
        sql ="SELECT * FROM usuario where nome = ? AND senha = ?";
        Statement st;
        pst = conexao.getInstance().prepareStatement(sql);
        pst.setString(1,n);
        pst.setString(2,s);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        
        while(rs.next()){
            usuario = new Usuario(rs.getInt("codigo"),rs.getString("nome"),rs.getString("senha"),
                    rs.getString("senha"),rs.getString("tipoUsuario"),rs.getBoolean("status"));
        }
        pst.close();
//        boolean r  = false;
//        try{
//            if(usuario.getNome().equals(n) && usuario.getSenha().equals(s)){
//                r= true;
//            }
//            else{
//                r = false;
//            }
//        }catch(NullPointerException x){
//            JOptionPane.showMessageDialog(null,"O usuario ou a senha \n  esta incorreto ");
//        }
        return usuario; 
    }
}
