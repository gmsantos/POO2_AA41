/**
 * Programação Orientada a Objetos 2 - AA4-1
 * Professor: Delano Medeiros Beder
 * Tutor: Fernando Chagas
 * 
 * GABRIEL MACHADO SANTOS 581062
 * JOAO PAULO FRANCELINO MONTEIRO 545767
 * DANIEL JOSE CONSTANTINO 580996 
 * 
 * 12/nov/2016
 */
package br.ufscar.si.catalogo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

//Então, o banco de dados que o grupo optou foi o Java DB.
//É necessário iniciar o serviço antes de rodar o programa
//Essa rotina é responsável em criar o banco de dados e conectar

public class DBDerby {
    
    private Connection con;
    public DBDerby(){
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            //Conecta com base de dados catalogoMidia se não existir cria na pasta home do derby
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/catalogoMidias;create=true","poo","poo");
            System.out.println("Conectou!!");
            //JOptionPane.showMessageDialog(null, "Conectou");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());            
        } catch(SQLException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());            
        }
    }
    //Método que cria as tabelas do BD
    public void CriaTabelas() throws SQLException{
       
        Statement stm = con.createStatement();
        try{
            stm.executeUpdate("create table CD\n" +
                        "(\n" +
                        "	CODIGO INTEGER default 0,\n" +
                        "	FAIXA VARCHAR(50),\n" +
                        "	DURACAO INTEGER default 0\n" +
                        ")");
        }catch(SQLException e){
             //JOptionPane.showMessageDialog(null, e.getMessage());            
            return;
        }
        
        try{
            stm.executeUpdate("create table DVD\n" +
                        "(\n" +
                        "	CODIGO INTEGER default 0,\n" +
                        "	ATORES VARCHAR(50),\n" +
                        "	PAPEL VARCHAR(30)\n" +
                        ")");
        }catch(SQLException e){
             //JOptionPane.showMessageDialog(null, e.getMessage());            
            return;
        }
        
        try{
            stm.executeUpdate("create table MIDIAS\n" +
                        "(\n" +
                        "	CODIGO INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) primary key,\n" +
                        "	TITULO VARCHAR(50),\n" +
                        "	ANO INTEGER default 0,\n" +
                        "	ARTISTA_DIRETOR_GERENERO VARCHAR(50),\n" +
                        "	TIPO INTEGER default 0\n" +
                        ")");
        }catch(SQLException e){
             //JOptionPane.showMessageDialog(null, e.getMessage());            
            return;
        }
    }
    
    //Método para preencher as tabelas com dados padrões
    public void AlimentaTabelas(){

        //Incializa valores de mídias no catálogo
        CD cd1, cd2;
        DVD dvd1, dvd2;
        Jogo jogo1, jogo2;
        
        cd1 = new CD("X & Y", 2005, "Cold Play");
        cd1.adicionaFaixa("Square One", 287); // 4:47
        cd1.adicionaFaixa("What If", 297); // 4:57
        cd1.adicionaFaixa("White Shadows", 328); // 5:28
        cd1.adicionaFaixa("Fix You", 294); // 4:54
        cd1.adicionaFaixa("Talk", 311); // 5:11
        cd1.adicionaFaixa("X&Y", 274); // 4:34

        dvd1 = new DVD("O Senhor dos Anéis - A Sociedade dos Anel", 2001,
                "Peter Jacson");
        dvd1.adicionaArtista("Elijah Wood", "Frodo Baggins");
        dvd1.adicionaArtista("Viggo Mortensen", "Aragorn");
        dvd1.adicionaArtista("Orlando Bloom", "Legolas Greenleaf");
        dvd1.adicionaArtista("Christopher Lee", "Saruman");
        dvd1.adicionaArtista("Ian McKellen", "Gandalf");

        jogo1 = new Jogo("Need For Speed - Underground II", 2005, "Corrida");

        cd2 = new CD("Bachianas Brasileiras No.2", 2004,
                "Orquestra de Câmara da Universidade de São Paulo");
        cd2.adicionaFaixa("(Prelúdio) O Canto do Capadócio", 512); // 4:32
        cd2.adicionaFaixa("(Ária) O Canto da Nossa Terra", 389); // 6:29
        cd2.adicionaFaixa("(Dança) Lembranca do Sertão", 324); // 5:24
        cd2.adicionaFaixa("(Tocata) O Trenzinho do Caipira", 284); // 4:44

        dvd2 = new DVD("Matrix", 1999, "Andy & Larry Wachoski");
        dvd2.adicionaArtista("Keanu Reeves", "Neo");
        dvd2.adicionaArtista("Laurence Fishburne", "Morpheus");
        dvd2.adicionaArtista("Carrie-Anne Moss", "Trinity");
        dvd2.adicionaArtista("Hugo Weaving", "Agente Smith");
        dvd2.adicionaArtista("Gloria Foster", "Óraculo");

        jogo2 = new Jogo("Fifa 2008", 2008, "Esporte");
        
        try {
            InserirCD(cd1);
        } catch (SQLException ex) {
            Logger.getLogger(DBDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            InserirCD(cd2);
        } catch (SQLException ex) {
            Logger.getLogger(DBDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            InserirDVD(dvd1);
        } catch (SQLException ex) {
            Logger.getLogger(DBDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            InserirDVD(dvd2);
        } catch (SQLException ex) {
            Logger.getLogger(DBDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            InserirJogo(jogo1);
        } catch (SQLException ex) {
            Logger.getLogger(DBDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            InserirJogo(jogo2);
        } catch (SQLException ex) {
            Logger.getLogger(DBDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void InserirCD(CD cd) throws SQLException{
        Statement stm = con.createStatement();
        int id = 0;
        
        try{
            String insert = "INSERT INTO POO.MIDIAS (TITULO, ANO, ARTISTA_DIRETOR_GERENERO, TIPO) VALUES (?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, cd.getTítulo()); // or setLong() depending on data type
            stmt.setInt(2, cd.getAno()); // I assume params is a String[]
            stmt.setString(3,  cd.artista);
            stmt.setInt(4, 1);
            
            stmt.execute();            
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            id = rs.getInt(1);

        }catch(SQLException e){
            //JOptionPane.showMessageDialog(null, e.getMessage());            
            System.out.println(e.getMessage());
        }
        try{
            for(int i = 0; i < cd.listadeFaixas.length; i++){
                if(cd.listadeFaixas[i] != null) {
                    String insert = "INSERT INTO POO.CD (CODIGO, FAIXA, DURACAO) VALUES (?,?,?)";
                    PreparedStatement stmt = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
                    
                    stmt.setInt(1, id);
                    stmt.setString(2, cd.listadeFaixas[i]); 
                    stmt.setInt(3, cd.duracao[i]);
                    stmt.execute();                    
                }
            }
        }catch(SQLException e){
            //JOptionPane.showMessageDialog(null, e.getMessage());            
            System.out.println(e.getMessage());
        }
    }
    
    public void InserirDVD(DVD dvd) throws SQLException{
        Statement stm = con.createStatement();
        int id = 0;
        
        try{
            String insert = "INSERT INTO POO.MIDIAS (TITULO, ANO, ARTISTA_DIRETOR_GERENERO, TIPO) VALUES (?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, dvd.getTítulo()); // or setLong() depending on data type
            stmt.setInt(2, dvd.getAno()); // I assume params is a String[]
            stmt.setString(3,  dvd.diretor);
            stmt.setInt(4, 2);
            
            stmt.execute();            
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            id = rs.getInt(1);

        }catch(SQLException e){
            //JOptionPane.showMessageDialog(null, e.getMessage());            
            System.out.println(e.getMessage());
        }
        try{
            for(int i = 0; i < dvd.atores.length; i++){
                if(dvd.atores[i] != null) {
                    String insert = "INSERT INTO POO.DVD (CODIGO, ATORES, PAPEL) VALUES (?,?,?)";
                    PreparedStatement stmt = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
                    
                    stmt.setInt(1, id);
                    stmt.setString(2, dvd.atores[i]); 
                    stmt.setString(3, dvd.papel[i]);
                    stmt.execute();                    
                }
            }
        }catch(SQLException e){
            //JOptionPane.showMessageDialog(null, e.getMessage());            
            System.out.println(e.getMessage());
        }
    }
    
    public void InserirJogo(Jogo jogo) throws SQLException{
        Statement stm = con.createStatement();

        
        try{
            String insert = "INSERT INTO POO.MIDIAS (TITULO, ANO, ARTISTA_DIRETOR_GERENERO, TIPO) VALUES (?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, jogo.getTítulo()); // or setLong() depending on data type
            stmt.setInt(2, jogo.getAno()); // I assume params is a String[]
            stmt.setString(3,  jogo.genero);
            stmt.setInt(4, 3);
            
            stmt.execute(); 
            
        }catch(SQLException e){
            //JOptionPane.showMessageDialog(null, e.getMessage());            
            System.out.println(e.getMessage());
        }        
    }
    
    public void ExcluiCD(int id) throws SQLException{
        Statement stm = con.createStatement();
        
        
        try{
            String delete = "DELETE FROM POO.MIDIAS WHERE CODIGO = ?";
            PreparedStatement stmt = con.prepareStatement(delete, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, id); 
            
            stmt.execute(); 
        }catch(SQLException e){
            //JOptionPane.showMessageDialog(null, e.getMessage());            
            System.out.println(e.getMessage());
        }
        try{
            String delete = "DELETE FROM POO.CD WHERE CODIGO = ?";
            PreparedStatement stmt = con.prepareStatement(delete, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, id); 
            
            stmt.execute(); 
        }catch(SQLException e){
            //JOptionPane.showMessageDialog(null, e.getMessage());            
            System.out.println(e.getMessage());
        }
    }
    
    public void ExcluiDVD(int id) throws SQLException{
        Statement stm = con.createStatement();
        
        
        try{
            String delete = "DELETE FROM POO.MIDIAS WHERE CODIGO = ?";
            PreparedStatement stmt = con.prepareStatement(delete, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, id); 
            
            stmt.execute(); 
        }catch(SQLException e){
            //JOptionPane.showMessageDialog(null, e.getMessage());            
            System.out.println(e.getMessage());
        }
        try{
            String delete = "DELETE FROM POO.DVD WHERE CODIGO = ?";
            PreparedStatement stmt = con.prepareStatement(delete, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, id); 
            
            stmt.execute(); 
        }catch(SQLException e){
            //JOptionPane.showMessageDialog(null, e.getMessage());            
            System.out.println(e.getMessage());
        }
    }
    
    public void ExcluiJogo(int id) throws SQLException{
        Statement stm = con.createStatement();
        
        
        try{
            String delete = "DELETE FROM POO.MIDIAS WHERE CODIGO = ?";
            PreparedStatement stmt = con.prepareStatement(delete, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, id); 
            
            stmt.execute(); 
        }catch(SQLException e){
            //JOptionPane.showMessageDialog(null, e.getMessage());            
            System.out.println(e.getMessage());
        }
    }
    
    public ResultSet retornaTodasMidias(){
        DBDerby DB = new DBDerby();
        ResultSet rs;
        try {
            Statement stm = DB.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql;
            sql = "SELECT * FROM MIDIAS order by Ano";
            rs = stm.executeQuery(sql);  
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DBDerby.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return null;
    }
    
    public ResultSet retornaMidiasTipo(int tipo){
        DBDerby DB = new DBDerby();
        ResultSet rs;
        try {
            Statement stm = DB.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql;
            sql = "SELECT * FROM MIDIAS where TIPO = " + String.valueOf(tipo) + " order by Ano";
            rs = stm.executeQuery(sql);  
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DBDerby.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return null;
    }
    
    public ResultSet retornaFaixasCD(int id){
        DBDerby DB = new DBDerby();
        ResultSet rs;
        try {
            Statement stm = DB.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql;
            sql = "SELECT * FROM CD where codigo = " + String.valueOf(id);
            rs = stm.executeQuery(sql);  
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DBDerby.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return null;
    }
    
    public ResultSet retornaAtoresDVD(int id){
        DBDerby DB = new DBDerby();
        ResultSet rs;
        try {
            Statement stm = DB.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql;
            sql = "SELECT * FROM DVD where codigo = " + String.valueOf(id);
            rs = stm.executeQuery(sql);  
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DBDerby.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return null;
    }
    public ResultSet buscarMidiaTitulo(String titulo){
        DBDerby DB = new DBDerby();
        ResultSet rs;
        try {
            Statement stm = DB.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql;
            sql = "SELECT * FROM MIDIAS where TITULO like '%" + titulo + "%' order by ano";
            rs = stm.executeQuery(sql);  
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DBDerby.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return null;
    }
    public void editaCD(int id, CD cd){
        try {
            Statement stm = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DBDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
        try{
            String update = "UPDATE POO.MIDIAS SET TITULO = ?, ANO = ?, ARTISTA_DIRETOR_GERENERO = ?, TIPO = ? where CODIGO = " + String.valueOf(id);
            PreparedStatement stmt = con.prepareStatement(update, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, cd.getTítulo()); 
            stmt.setInt(2, cd.getAno()); 
            stmt.setString(3,  cd.artista);
            stmt.setInt(4, 1);
            
            stmt.execute();
        }catch(SQLException e){
            //JOptionPane.showMessageDialog(null, e.getMessage());            
            System.out.println(e.getMessage());
        }
        try{
            String delete = "DELETE FROM POO.CD WHERE CODIGO = " +  String.valueOf(id);
            PreparedStatement stmt = con.prepareStatement(delete, Statement.RETURN_GENERATED_KEYS);
            stmt.execute();                    
            for(int i = 0; i < cd.listadeFaixas.length; i++){
                if(cd.listadeFaixas[i] != null) {
                    String insert = "INSERT INTO POO.CD (CODIGO, FAIXA, DURACAO) VALUES (?,?,?)";
                    stmt = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
                    
                    stmt.setInt(1, id);
                    stmt.setString(2, cd.listadeFaixas[i]); 
                    stmt.setInt(3, cd.duracao[i]);
                    stmt.execute();                    
                }
            }
        }catch(SQLException e){
            //JOptionPane.showMessageDialog(null, e.getMessage());            
            System.out.println(e.getMessage());
        }
        
    }
    
    public void editaDVD(int id, DVD dvd){
        try {
            Statement stm = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DBDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
        try{
            String update = "UPDATE POO.MIDIAS SET TITULO = ?, ANO = ?, ARTISTA_DIRETOR_GERENERO = ?, TIPO = ? where CODIGO = " + String.valueOf(id);
            PreparedStatement stmt = con.prepareStatement(update, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, dvd.getTítulo()); 
            stmt.setInt(2, dvd.getAno()); 
            stmt.setString(3,  dvd.diretor);
            stmt.setInt(4, 2);
            
            stmt.execute();
        }catch(SQLException e){
            //JOptionPane.showMessageDialog(null, e.getMessage());            
            System.out.println(e.getMessage());
        }
        try{
            String delete = "DELETE FROM POO.DVD WHERE CODIGO = " +  String.valueOf(id);
            PreparedStatement stmt = con.prepareStatement(delete, Statement.RETURN_GENERATED_KEYS);
            stmt.execute();                    
            for(int i = 0; i < dvd.atores.length; i++){
                if(dvd.atores[i] != null) {
                    String insert = "INSERT INTO POO.DVD (CODIGO, ATORES, PAPEL) VALUES (?,?,?)";
                    stmt = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
                    
                    stmt.setInt(1, id);
                    stmt.setString(2, dvd.atores[i]); 
                    stmt.setString(3, dvd.papel[i]);
                    stmt.execute();                    
                }
            }
        }catch(SQLException e){
            //JOptionPane.showMessageDialog(null, e.getMessage());            
            System.out.println(e.getMessage());
        }
        
    }
    
    public void editaJogo(int id, Jogo jogo){
        try {
            Statement stm = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DBDerby.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
        try{
            String update = "UPDATE POO.MIDIAS SET TITULO = ?, ANO = ?, ARTISTA_DIRETOR_GERENERO = ?, TIPO = ? where CODIGO = " + String.valueOf(id);
            PreparedStatement stmt = con.prepareStatement(update, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, jogo.getTítulo()); 
            stmt.setInt(2, jogo.getAno()); 
            stmt.setString(3,  jogo.genero);
            stmt.setInt(4, 3);
            
            stmt.execute();
        }catch(SQLException e){
            //JOptionPane.showMessageDialog(null, e.getMessage());            
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) throws SQLException {
        DBDerby DB = new DBDerby();
        DB.CriaTabelas();
        DB.AlimentaTabelas();
    }
    
}
