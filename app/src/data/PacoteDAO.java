package data;

import business.comercial.Pacote;
import java.sql.Connection;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class PacoteDAO implements Map<String,Pacote> {
    
    private Connection conn;
    
    public PacoteDAO () {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn =  DriverManager.getConnection("jdbc:mysql://localhost/configuraFacil?user=root&password=password");
            System.out.println("Connected to DB as root!");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void clear () {
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE FROM Pacote");
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());}
    }


    
    public boolean containsKey(Object key) throws NullPointerException {
        if(this.get(key) == null) return false;
        else return true;
    }


    
    public boolean containsValue(Object value) {
        throw new NullPointerException("public boolean containsValue(Object value) not implemented!");
    }
    

    public Set<Map.Entry<String,Pacote>> entrySet() {
        throw new NullPointerException("public Set<Map.Entry<String,Aluno>> entrySet() not implemented!");
    }
    

    public boolean equals(Object o) {
        throw new NullPointerException("public boolean equals(Object o) not implemented!");
    }

    
    public Pacote get(Object key) {
        try {
            Statement stm = conn.createStatement();
            Pacote p = null;
            String sql = "SELECT * FROM Pacote WHERE id="+key;
            ResultSet rs = stm.executeQuery(sql);

            if (rs.next()) {
                p = new Pacote(rs.getString("id"), rs.getString("nome"), rs.getFloat("preco"), rs.getFloat("desconto"), new TreeSet<String>());

                sql = "SELECT idComponente FROM ComponentesPacote WHERE Pacote_id="+key;
                ResultSet rs2 = stm.executeQuery(sql);

                Set<String> aux = new TreeSet<String>();

                /** vais buscar os valores á tabela dos ComponentesPacote */
                while (rs2.next()) {
                    aux.add(rs2.getString("idComponente"));
                }

                p.setComponentes(aux);
            }

            return p;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());}
    }
    
    public int hashCode() {
        return this.conn.hashCode();
    }
    
    public boolean isEmpty() {
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT id FROM Pacote");
            return !rs.next();
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }
    
    public Set<String> keySet() {
        throw new NullPointerException("Not implemented!");
    }
    
    public Pacote put(String key, Pacote value) {
      throw new NullPointerException("Not implemented!");
    }

    public void putAll(Map<? extends String,? extends Pacote> t) {
        throw new NullPointerException("Not implemented!");
    }
    
    public Pacote remove(Object key) {
        try {
            Statement stm = conn.createStatement();
            Pacote p = this.get(key);

            /** Garante que pode atualizar/ adiconar/ remover */
            String sql = "SET SQL_SAFE_UPDATES = 0";
            stm.executeUpdate(sql);

            /** Apaga todos os dados das 2 tabelas */
            sql = "DELETE FROM ComponentesPacote WHERE Pacote_id="+key;
            stm.executeUpdate(sql);
            sql = "DELETE FROM Pacote WHERE id="+key;
            stm.executeUpdate(sql);

            return p;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());}
    }
    
    public int size() {
        try {
            int i = 0;
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT id FROM Pacote");
            for (;rs.next();i++);
            return i;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }
    
    public Collection<Pacote> values() {
        try {
            Collection<Pacote> col = new HashSet<Pacote>();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT id FROM Pacote");

            for (;rs.next();) {

                /** get de cada pacote pelo id*/
                Pacote p = get(rs.getString("id"));

                col.add(p);
            }
         
            return col;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());}
    }
    
}

