package data;

import business.comercial.Modelo;
import java.sql.*;
import java.util.*;

public class ModeloDAO implements Map<String, Modelo> {

    public Connection conn;

    public ModeloDAO() {
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

    /**
     * Retorna o tamanho.
     * @return retorna o tamanho.
     */
    @Override
    public int size() {
        try {
            int i = 0;
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT designacao FROM Modelo");
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
        if (this.get(key) == null) return false;
        else return true;
    }

    @Override
    public boolean containsValue(Object value) {
        throw new NullPointerException("Not implemented!");
    }

    @Override
    public Modelo get(Object key) {
        try {
            Modelo modelo = null;
            Statement stm1 = conn.createStatement();
            Statement stm2 = conn.createStatement();
            Statement stm3 = conn.createStatement();
            Statement stm4 = conn.createStatement();
            Statement stm5 = conn.createStatement();
            ResultSet rs1 = stm1.executeQuery("SELECT * FROM Modelo WHERE id='"+String.valueOf(key)+"'");
            ResultSet rs2 = stm2.executeQuery("SELECT idComponente FROM MotorizacaoModelo WHERE MotorizacaoModelo.Modelo_id='"+String.valueOf(key)+"'");
            ResultSet rs3 = stm3.executeQuery("SELECT idComponente FROM InterioresModelo WHERE Modelo_id='"+String.valueOf(key)+"'");
            ResultSet rs4 = stm4.executeQuery("SELECT idComponente FROM ExterioresModelo WHERE Modelo_id='"+String.valueOf(key)+"'");
            ResultSet rs5 = stm5.executeQuery("SELECT idPacote FROM PacotesModelo WHERE Modelo_id='"+String.valueOf(key)+"'");

            if (rs1.next())
                modelo = new Modelo(String.valueOf(rs1.getInt(1)),rs1.getString(2),rs1.getFloat(3),rs1.getString(4), rs1.getString(5),new TreeSet<String>(), new TreeSet<String>(), new TreeSet<String>(), new TreeSet<String>());


            if(modelo!=null) {

                Set<String> tmp = new TreeSet<String>();

                while (rs2.next()) {
                    tmp.add(String.valueOf(rs2.getInt(1)));
                }
                modelo.setMotorizacoesCompativeis(tmp);
                tmp.clear();

                while (rs3.next()){
                    tmp.add(String.valueOf(rs3.getInt(1)));
                }
                modelo.setInterioresCompativeis(tmp);
                tmp.clear();

                while (rs4.next()){
                    tmp.add(String.valueOf(rs4.getInt(1)));
                }
                modelo.setExteriorCompativeis(tmp);
                tmp.clear();

                while (rs5.next()){
                    tmp.add(String.valueOf(rs5.getInt(1)));
                }
                modelo.setPacotesCompativeis(tmp);
                tmp.clear();
            }
            return modelo;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    @Override
    public Modelo put(String key, Modelo value) {
        throw new NullPointerException("Not implemented!");
    }

    @Override
    public Modelo remove(Object key) {
        throw new NullPointerException("Not implemented!");
    }

    @Override
    public void putAll(Map<? extends String, ? extends Modelo> m) {
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
    public Collection<Modelo> values() {
        Collection<Modelo> res = new ArrayList<>();
        try {
            Statement stm = conn.createStatement();

            String sql = "SELECT id FROM Modelo";
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("id");
                Modelo m = this.get(id);
                res.add(m);
            }
            return res;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    @Override
    public Set<Entry<String, Modelo>> entrySet() {
        throw new NullPointerException("Not implemented!");
    }
}
