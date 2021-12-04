package br.una.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {
    
    public static String status = "Nenhuma operação realizada.";
    
    public static java.sql.Connection conectar() {
        Connection connection = null;
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
            
            String urlLocal = "jdbc:mysql://localhost/askgame";
            String usernameLocal = "root";        
            String passwordLocal = ""; 
            
            String url = "jdbc:mysql://213.190.6.106/u109624496_askgame";
            String username = "u109624496_admin_ask_game";        
            String password = "Askgame@123";      

            //connection = DriverManager.getConnection(url, username, password);
            connection = DriverManager.getConnection(urlLocal, usernameLocal, passwordLocal);

            if (connection != null) {
                status = ("Conectado com sucesso!");
            } else {
                status = ("Não foi possivel realizar conexão");
            }
            
            return connection;            
        } catch (ClassNotFoundException e) {
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao banco de dados.");
            return null;
        }
    }
    
    public static String statusConexao() {
        return status;
    }
    
    public static boolean fecharConexao() {
        try {
            DB.conectar().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public static String criarUsuario(String user, String nickname, String email, String telefone, String senha){
        if(verificarUsuario(user)){
            return "Usuário já cadastrado.";    
        } else if(verificarEmail(email)){
            return "E-mail já cadastrado.";
        } else{
            String query = "INSERT INTO usuario(usuario, apelido, email, telefone, senha)"
                + " VALUES (?, ?, ?, ?, MD5(?))";
            PreparedStatement stmt;
            try {
                stmt = DB.conectar().prepareStatement(query);

                stmt.setString (1, user);
                stmt.setString (2, nickname);
                stmt.setString (3, email);
                stmt.setString (4, telefone);
                stmt.setString (5, senha);

                stmt.execute();
                DB.fecharConexao();

                return "Usuário criado com sucesso!";
            } catch (SQLException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
        return "Houve um erro no seu cadastro, por favor tente novamente.";
    }
    
    private static boolean verificarUsuario(String user){
        String query = "SELECT usuario FROM usuario WHERE usuario=?";
       
        PreparedStatement stmt;
        try {
            stmt = DB.conectar().prepareStatement(query);
            stmt.setString (1, user);          
            ResultSet rs = stmt.executeQuery();
            boolean status = rs.next();            
            
            DB.fecharConexao();
            
            return status;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private static boolean verificarEmail(String email){
        String query = "SELECT email FROM usuario WHERE email=?";
       
        PreparedStatement stmt;
        try {
            stmt = DB.conectar().prepareStatement(query);
            stmt.setString (1, email);          
            ResultSet rs = stmt.executeQuery();
            boolean status = rs.next();            
            
            DB.fecharConexao();
            
            return status;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean login(String user, String pass){
        String query = "SELECT usuario, senha FROM usuario WHERE usuario=? AND senha=MD5(?)";
       
        PreparedStatement stmt;
        try {
            stmt = DB.conectar().prepareStatement(query);
            stmt.setString (1, user);       
            stmt.setString (2, pass);
            ResultSet rs = stmt.executeQuery();
            boolean status = rs.next();            
            
            DB.fecharConexao();
            
            return status;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}