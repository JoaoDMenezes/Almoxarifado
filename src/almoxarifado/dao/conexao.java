/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almoxarifado.dao;


import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class conexao {
    private static conexao conexao = null;
    private static Connection connection;

   
    private String usuario;
    private String senha;
    private String url;
    
    public conexao(){
        usuario ="root";
        senha ="";
        url="jdbc:mysql://localhost:3306/almoxarifado";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto", "root", "");  
            connection =DriverManager.getConnection(url, usuario, senha);       
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
    }
    public static Connection getInstance(){
        if(connection == null){
            synchronized (conexao.class){
                conexao = new conexao();
            }
        }
        return connection;
    }
    public static void closeInstance()throws SQLException{
        if(connection !=null){
            connection.close();
        }
    } 
}
