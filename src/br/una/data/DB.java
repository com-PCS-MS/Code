package br.una.data;

import br.una.askgame.Personagem;
import br.una.askgame.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

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
    
    public static String criarUsuario(Usuario user){
        if(verificarUsuario(user)){
            return "Usuário já cadastrado.";    
        } else if(verificarEmail(user)){
            return "E-mail já cadastrado.";
        } else{
            String query = "INSERT INTO usuario(usuario, apelido, email, telefone, senha)"
                + " VALUES (?, ?, ?, ?, MD5(?))";
            PreparedStatement stmt;
            try {
                stmt = DB.conectar().prepareStatement(query);

                stmt.setString (1, user.getUsuario());
                stmt.setString (2, user.getApelido());
                stmt.setString (3, user.getEmail());
                stmt.setString (4, user.getTelefone());
                stmt.setString (5, user.getSenha());

                stmt.execute();
                DB.fecharConexao();

                return "Usuário criado com sucesso!";
            } catch (SQLException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
        return "Houve um erro no seu cadastro, por favor tente novamente.";
    }
    
    public static String criarPersonagem(Personagem personagem){
        String query = "INSERT INTO personagem(id_usuario, ativo, nome, vida)"
                + " VALUES (?, 1, ?, 100)";
        PreparedStatement stmt;
        try {
            stmt = DB.conectar().prepareStatement(query);

            stmt.setInt(1, personagem.getIdUsuario());
            stmt.setString(2, personagem.getNome());

            stmt.execute();
            DB.fecharConexao();

            return "Personagem criado com sucesso!";
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return "Houve um erro no seu cadastro, por favor tente novamente.";
    }
    
    private static boolean verificarUsuario(Usuario user){
        String query = "SELECT usuario FROM usuario WHERE usuario=?";
       
        String teste = user.getUsuario();
        PreparedStatement stmt;
        try {
            stmt = DB.conectar().prepareStatement(query);
            stmt.setString (1, user.getUsuario());          
            ResultSet rs = stmt.executeQuery();
            boolean status = rs.next();            
            
            DB.fecharConexao();
            
            return status;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private static boolean verificarEmail(Usuario user){
        String query = "SELECT email FROM usuario WHERE email=?";
       
        PreparedStatement stmt;
        try {
            stmt = DB.conectar().prepareStatement(query);
            stmt.setString (1, user.getEmail());          
            ResultSet rs = stmt.executeQuery();
            boolean status = rs.next();            
            
            DB.fecharConexao();
            
            return status;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean login(Usuario user){
        String query = "SELECT usuario, senha FROM usuario WHERE usuario=? AND senha=MD5(?)";
       
        PreparedStatement stmt;
        try {
            stmt = DB.conectar().prepareStatement(query);
            stmt.setString (1, user.getUsuario());       
            stmt.setString (2, user.getSenha());
            ResultSet rs = stmt.executeQuery();
            boolean status = rs.next();            
            
            DB.fecharConexao();
            
            return status;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static int getUserId(Usuario user){
        String query = "SELECT id FROM usuario WHERE usuario=? AND senha=MD5(?)";
       
        PreparedStatement stmt;
        int id=0;
        try {
            stmt = DB.conectar().prepareStatement(query);
            stmt.setString (1, user.getUsuario());       
            stmt.setString (2, user.getSenha());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                id = rs.getInt("id");
            }            
            
            DB.fecharConexao();
            
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public static int getPersonagemId(Personagem personagem, Usuario user){
        String query = "SELECT P.id FROM personagem AS P, usuario AS U WHERE P.nome=? AND U.usuario=? AND U.id=P.id_usuario";
       
        PreparedStatement stmt;
        int id=0;
        try {
            stmt = DB.conectar().prepareStatement(query);
            stmt.setString (1, personagem.getNome());       
            stmt.setString (2, user.getUsuario());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                id = rs.getInt("id");
            }            
            
            DB.fecharConexao();
            
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public static DefaultListModel listaPersonagens(Usuario user){
        
        DefaultListModel model = new DefaultListModel();        
        
        String query = "SELECT P.nome, P.vida FROM usuario AS U, personagem AS P WHERE P.ativo=1 AND P.id_usuario=U.id AND U.usuario=?";
               
        PreparedStatement stmt;
        try {
            stmt = DB.conectar().prepareStatement(query);
            stmt.setString (1, user.getUsuario());          
            ResultSet rs = stmt.executeQuery();
            int i=0;
            while(rs.next()){
                model.add(i, rs.getString("nome"));
                i++;
            }            
            
            if(model.isEmpty()){
                model.add(0, "Você ainda não possui nenhum personagem.");
            }
            
            DB.fecharConexao();
            
            return model;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        model.add(1, "Você ainda não possui nenhum personagem.");
        return model;
    }
    
    public static int iniciarPartida(Usuario user1, Usuario user2, Personagem personagem1, Personagem personagem2){
        // Retorna o id da partida
        String query = "INSERT INTO partida(id_jogador1, id_jogador2, id_personagem1, id_personagem2, ativo, criada_em)"
                + " VALUES (?, ?, ?, ?, 1, NOW())";
        PreparedStatement stmt, stmt2;
        int id = 0;
        try {
            stmt = DB.conectar().prepareStatement(query);

            stmt.setInt(1, user1.getId());
            stmt.setInt(2, user2.getId());
            stmt.setInt(3, personagem1.getId());
            stmt.setInt(4, personagem2.getId());

            if(stmt.execute()){
                String query2 = "SELECT id FROM partida ORDER BY id DESC LIMIT 1";
                stmt2 = DB.conectar().prepareStatement(query2);
                ResultSet rs = stmt2.executeQuery();
                while(rs.next()){
                    id = rs.getInt("id");
                }                
            }
            
            DB.fecharConexao();

            return id;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }         
        return id;
    }
}