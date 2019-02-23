package data;

import business.recursoshumanos.*;

import java.sql.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UtilizadorDAO implements Map<String,Utilizador> {

    public Connection conn;

    public UtilizadorDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn =  DriverManager.getConnection("jdbc:mysql://localhost/ConfiguraFacil?user=root&password=password");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int size() {
        try {
            int i = 0;
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT id FROM Utilizador");
            for (;rs.next();i++);
            return i;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    @Override
    public boolean isEmpty() {
        throw new NullPointerException("Not implemented!");
    }

    @Override
    public boolean containsKey(Object key) {
        try {
            int i = 0;
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT id FROM Utilizador WHERE id='"+(String)key+"'");
            while(rs.next()){
              i++;
            }
            if(i != 0) return true;
            return false;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    @Override
    public boolean containsValue(Object value) {
        throw new NullPointerException("Not implemented!");
    }

    @Override
    public Utilizador get(Object key) {
        try {
            Utilizador utilizador = null;
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Utilizador WHERE id='"+String.valueOf(key)+"'";
            ResultSet rs = stm.executeQuery(sql);

            if (rs.next()){
                int tipo = rs.getInt(4);
                if(tipo == 0)
                    utilizador = new Administrador(rs.getString(1), rs.getString(2), rs.getString(3));
                if(tipo == 1)
                    utilizador = new FuncionarioStand(rs.getString(1), rs.getString(2), rs.getString(3));
                if(tipo == 2)
                    utilizador = new FuncionarioFabrica(rs.getString(1), rs.getString(2), rs.getString(3));
            }
            return utilizador;
        }
        catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public Utilizador put(String key, Utilizador value) {
        try {
            if(value != null){
                Statement stm = conn.createStatement();
                String sql = "SET SQL_SAFE_UPDATES = 0";
                stm.executeUpdate(sql);

                stm.executeUpdate("DELETE FROM Utilizador WHERE id='"+key+"'");
                sql = "INSERT INTO Utilizador VALUES ('"+key+"','"+value.getNome()+"','"+value.getPassword()+"','"+value.getTipo()+"')";
                System.out.println(sql);
                stm.executeUpdate(sql);

                int tipo = value.getTipo();
                if(tipo == 0)
                    return new Administrador(value.getId(), value.getNome(), value.getPassword());
                if(tipo == 1)
                    return new FuncionarioStand(value.getId(), value.getNome(), value.getPassword());
                if(tipo == 2)
                    return new FuncionarioFabrica(value.getId(), value.getNome(), value.getPassword());
                return new Utilizador(value.getId(), value.getNome(), value.getPassword(), value.getTipo()).clone();
            }else{
                return null;
            }
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
 
    }

    @Override
    public Utilizador remove(Object key) {
        try {
            if(this.containsKey(key)){
                Statement stm = conn.createStatement();
                String sql = "DELETE FROM Utilizador WHERE id="+key;
                stm.executeUpdate(sql);
            return this.get(key);
            }
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
        return null;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Utilizador> m) {
        throw new NullPointerException("Not implemented!");
    }

    @Override
    public void clear() {
        throw new NullPointerException("Not implemented!");
    }

    @Override
    public Set<String> keySet() {
        throw new NullPointerException("Not implemented!");
    }

    @Override
    public Collection<Utilizador> values() {
        try {
            Collection<Utilizador> col = new HashSet<Utilizador>();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Utilizador");
            for (;rs.next();) {
                int tipo = rs.getInt(4);
                if(tipo == 0)
                    col.add(new Administrador(rs.getString(1),rs.getString(2),rs.getString(3)));
                if(tipo == 1)
                    col.add(new FuncionarioStand(rs.getString(1),rs.getString(2),rs.getString(3)));
                if(tipo == 2)
                    col.add(new FuncionarioFabrica(rs.getString(1),rs.getString(2),rs.getString(3)));
            }
            return col;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    @Override
    public Set<Entry<String, Utilizador>> entrySet() {
        throw new NullPointerException("Not implemented!");
    }
    
    public int geraIdProximoUtilizador() {
        int res = -1;
        try {
            Statement stm = conn.createStatement();
            String sql = "SELECT MAX(id) AS currentId FROM Utilizador";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                res = rs.getInt("currentId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res + 1;
    }
}
