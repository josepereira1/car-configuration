package data;

import business.comercial.Componente;
import business.comercial.ComponenteNaoExisteException;
import java.sql.*;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class ComponenteDAO implements Map<String,Componente>{
    
    private Connection conn;

    public ComponenteDAO() {
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
 

    public Componente get(Object key) {
        
        /** Variáveis de instância do objeto Configuracao */
        String id;
        String designacao;
        float preco;
        int tipo;
        Set<String> incompativeis = new TreeSet<>();
        Set<String> necessarios = new TreeSet<>();
        int stock;
        
        Componente comp = null;

        try {

            Statement stm = conn.createStatement();

            /** Tabela Configuracao */
            String sql = "SELECT * FROM Componente WHERE id="+key;
            ResultSet rs = stm.executeQuery(sql);

            if (rs.next()) {
                id = rs.getString("id");
                designacao = rs.getString("designacao");
                preco = rs.getFloat("preco");
                tipo = rs.getInt("tipo");
                stock = rs.getInt("stock");

                comp= new Componente();
                comp.setId(id);
                comp.setDesignacao(designacao);
                comp.setPreco(preco);
                comp.setTipo(tipo);
                comp.setStock(stock);

                /** Multi-valorado: Necessarios */
                sql = "SELECT idComponenteNecessario FROM componentesNecessarios WHERE Componente_id="+key;
                ResultSet rs2 = stm.executeQuery(sql);
                while(rs2.next()) {
                    necessarios.add(rs2.getString("idComponenteNecessario"));
                }
                comp.setNecessarios(necessarios);

                /** Multi-valorado: Incompativeis */
                sql = "SELECT idComponenteIncompativel FROM componentesIncompativeis WHERE Componente_id="+key;
                rs2 = stm.executeQuery(sql);
                while(rs2.next()) {
                    incompativeis.add(rs2.getString("idComponenteIncompativel"));
                }
                comp.setIncompativeis(incompativeis);

                
            }

            return comp;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }
    
       
    public int getStock(Object key){
        int r = -1;
      
        try{
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Componente WHERE id="+key;
            ResultSet rs = stm.executeQuery(sql);
            rs.next();
            r = rs.getInt("stock");
            
        }
        catch(Exception e){
            throw new NullPointerException(e.getMessage());
        }
        return r;
    }

    @Override
    public int size() { throw new NullPointerException("Not implemented!"); }

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
    public Componente put(String key, Componente value) {
        throw new NullPointerException("Not implemented!");
    }

    @Override
    public Componente remove(Object key) {
        throw new NullPointerException("Not implemented!");
    }

    @Override
    public void putAll(Map<? extends String, ? extends Componente> m) {
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
    public Collection<Componente> values() {
        throw new NullPointerException("Not implemented!");
    }

    @Override
    public Set<Entry<String, Componente>> entrySet() {
        throw new NullPointerException("Not implemented!");
    }

    /**
     * Coloca o valor do stock no componente.
     * @param idComponente id do componente.
     * @param quantidade quantidade do stock.
     * @throws ComponenteNaoExisteException componente não existe
     */
    public void adicionaStock(String idComponente, int quantidade) throws ComponenteNaoExisteException{
        if(!this.containsKey(idComponente)) throw new ComponenteNaoExisteException(idComponente);
        else{
            try {
                Statement stm = conn.createStatement();
                String sql = "SET SQL_SAFE_UPDATES = 0";
                stm.executeUpdate(sql);

                sql = "UPDATE Componente "
                        + "SET Componente.stock="+quantidade+
                        " WHERE id="+idComponente+";";

                stm.executeUpdate(sql);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}
