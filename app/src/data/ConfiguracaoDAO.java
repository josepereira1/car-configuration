package data;

import business.comercial.Configuracao;
import java.util.*;
import java.sql.*;

public class ConfiguracaoDAO implements Map<String, Configuracao> {

    private Connection conn;

    public ConfiguracaoDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn =  DriverManager.getConnection("jdbc:mysql://localhost/ConfiguraFacil?user=root&password=password");
            System.out.println("Connected to DB as root!");
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
        throw new NullPointerException("Not implemented!");
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
    public Configuracao get(Object key) {

        /** Variáveis de instância do objeto Configuracao */
        String id;
        String modelo;
        String motor;
        Set<String> interiores = new TreeSet<>();
        Set<String> exteriores = new TreeSet<>();
        Set<String> pacotes = new TreeSet<>();
        float preco;
        float desconto;
        String idUtilizador;
        boolean valida;

        Configuracao configuracao = null;

        try {

            Statement stm = conn.createStatement();

            /** Tabela Configuracao */
            String sql = "SELECT * FROM Configuracao WHERE id="+key;
            ResultSet rs = stm.executeQuery(sql);

            if (rs.next()) {
                id = Integer.toString(rs.getInt("id"));
                modelo = rs.getString("modelo");
                motor = rs.getString("motor");
                preco = rs.getFloat("preco");
                desconto = rs.getFloat("desconto");
                idUtilizador = rs.getString("idUtilizador");
                valida = rs.getBoolean("valida");

                configuracao = new Configuracao();
                configuracao.setId(id);
                configuracao.setModelo(modelo);
                configuracao.setMotor(motor);
                configuracao.setPreco(preco);
                configuracao.setDesconto(desconto);
                configuracao.setUtilizador(idUtilizador);
                configuracao.setValida(valida);

                /** Multi-valorado: Interiores */
                sql = "SELECT idComponente FROM InterioresConfiguracao WHERE Configuracao_id="+key;
                ResultSet rs2 = stm.executeQuery(sql);
                while(rs2.next()) {
                    interiores.add(rs2.getString("idComponente"));
                }
                configuracao.setInteriores(interiores);

                /** Multi-valorado: Exteriores */
                sql = "SELECT idComponente FROM ExterioresConfiguracao WHERE configuracao_id="+key;
                rs2 = stm.executeQuery(sql);
                while(rs2.next()) {
                    exteriores.add(rs2.getString("idComponente"));
                }
                configuracao.setExteriores(exteriores);

                /** Multi-valorado: Pacotes */
                sql = "SELECT idPacote FROM PacotesConfiguracao WHERE configuracao_id="+key;
                rs2 = stm.executeQuery(sql);
                while(rs2.next()) {
                    pacotes.add(rs2.getString("idPacote"));
                }
                configuracao.setPacotes(pacotes);
            }

            return configuracao;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public Configuracao put(String key, Configuracao value) {
        try {
            Statement stm = conn.createStatement();

            /** Garante que pode atualizar/ adiconar/ remover */
            String sql = "SET SQL_SAFE_UPDATES = 0";
            stm.executeUpdate(sql);

            /** Apaga se já houver algum com aquele ID */
            sql = "DELETE FROM PacotesConfiguracao WHERE Configuracao_id="+key;
            stm.executeUpdate(sql);
            sql = "DELETE FROM InterioresConfiguracao WHERE Configuracao_id="+key;
            stm.executeUpdate(sql);
            sql = "DELETE FROM ExterioresConfiguracao WHERE Configuracao_id="+key;
            stm.executeUpdate(sql);
            sql = "DELETE FROM Configuracao WHERE id="+key;
            stm.executeUpdate(sql);

            /** Insere na tabela Configuracao */
            sql = "INSERT INTO Configuracao VALUES (";
            sql += value.getId()+",";
            sql += value.getModelo()+",";
            sql += value.getUtilizador()+",";
            sql += value.getMotor()+",";
            sql += value.getPreco()+",";
            sql += value.getDesconto()+",";
            sql += value.isValida()+")";
            stm.executeUpdate(sql);

            /** Insere na tabela Interiores */
            int currentId = this.getCurrentIdInteriores();
            for(String idComponente: value.getInteriores()) {
                sql = "INSERT INTO InterioresConfiguracao VALUES (";
                sql += currentId+",";
                sql += value.getId()+","; // id da configuracao
                sql += idComponente+")";
                stm.executeUpdate(sql);
                currentId++;
            }

            /** Insere na tabela Exteriores */
            currentId = this.getCurrentIdExteriores();
            for(String idComponente: value.getExteriores()) {
                sql = "INSERT INTO ExterioresConfiguracao VALUES (";
                sql += currentId+",";
                sql += value.getId()+","; // id da configuracao
                sql += idComponente+")";
                stm.executeUpdate(sql);
                currentId++;
            }

            /** Insere na tabela Pacotes */
            currentId = this.getCurrentIdPacotes();
            for(String idPacote: value.getPacotes()) {
                sql = "INSERT INTO PacotesConfiguracao VALUES (";
                sql += currentId+",";
                sql += value.getId()+","; // id da configuracao
                sql += idPacote +")";
                stm.executeUpdate(sql);
                currentId++;
            }

            return value.clone();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());}
    }

    @Override
    public Configuracao remove(Object key) {
        try {
            Statement stm = conn.createStatement();
            Configuracao configuracao = this.get(key);

            /** Garante que pode atualizar/ adiconar/ remover */
            String sql = "SET SQL_SAFE_UPDATES = 0";
            stm.executeUpdate(sql);

            /** Apaga as tabelas */
            sql = "DELETE FROM PacotesConfiguracao WHERE Configuracao_id="+key;
            stm.executeUpdate(sql);
            sql = "DELETE FROM InterioresConfiguracao WHERE Configuracao_id="+key;
            stm.executeUpdate(sql);
            sql = "DELETE FROM ExterioresConfiguracao WHERE Configuracao_id="+key;
            stm.executeUpdate(sql);
            sql = "DELETE FROM Configuracao WHERE id="+key;
            stm.executeUpdate(sql);

            return configuracao;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public void putAll(Map<? extends String, ? extends Configuracao> m) {
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
    public Collection<Configuracao> values() {

        Collection<Configuracao> res = new ArrayList<>();

        try {
            Statement stm = conn.createStatement();

            String sql = "SELECT id FROM Configuracao";
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("id");
                Configuracao c = this.get(id);
                res.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    @Override
    public Set<Entry<String, Configuracao>> entrySet() {
        throw new NullPointerException("Not implemented!");

    }

    private int getCurrentIdInteriores() {
        int res = -1;
        try {
            Statement stm = conn.createStatement();
            String sql = "SELECT MAX(id) AS currentId FROM InterioresConfiguracao";
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()) {
                res = rs.getInt("currentId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res + 1;
    }

    private int getCurrentIdExteriores() {
        int res = -1;
        try {
            Statement stm = conn.createStatement();
            String sql = "SELECT MAX(id) AS currentId FROM ExterioresConfiguracao";
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()) {
                res = rs.getInt("currentId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res + 1;
    }

    private int getCurrentIdPacotes() {
        int res = -1;
        try {
            Statement stm = conn.createStatement();
            String sql = "SELECT MAX(id) AS currentId FROM PacotesConfiguracao";
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()) {
                res = rs.getInt("currentId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res + 1;
    }

    public int getCurrentIdConfiguracoes() {
        int res = -1;
        try {
            Statement stm = conn.createStatement();
            String sql = "SELECT MAX(id) AS currentId FROM Configuracao";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                res = rs.getInt("currentId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res + 1;
    }

    public static void main(String[] args) {

        ConfiguracaoDAO configuracoes = new ConfiguracaoDAO();

        Set<String> interiores = new TreeSet<>();
        interiores.add("1");
        interiores.add("2");
        interiores.add("3");

        Set<String> exteriores = new TreeSet<>();
        exteriores.add("4");
        exteriores.add("5");
        exteriores.add("6");

        Set<String> pacotes = new TreeSet<>();
        pacotes.add("7");
        pacotes.add("8");
        pacotes.add("9");

        /** Testar o put() */
        Configuracao configuracao = new Configuracao("1", "1", "1", interiores, exteriores, pacotes, 20000f, 1500f, "1", true);
        configuracoes.put(configuracao.getId(), configuracao);

        System.out.println(configuracoes.get(configuracao.getId()));

        configuracoes.remove(configuracao.getId());
        
        configuracoes.getCurrentIdConfiguracoes();
    }
}
