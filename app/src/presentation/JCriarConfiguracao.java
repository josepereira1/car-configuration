package presentation;

import business.comercial.Configuracao;
import business.comercial.Componente;
import business.comercial.ComponenteNaoExisteException;
import business.comercial.ConfiguracaoNaoExisteException;
import business.comercial.Modelo;
import business.comercial.ModeloNaoExisteException;
import business.comercial.Pacote;
import business.comercial.PacoteNaoExisteException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;
import javax.swing.JOptionPane;

public class JCriarConfiguracao extends javax.swing.JFrame {
    
    public JLogin jFacade;    //  facade do pacote presentation
    public String chaveConfiguracao;
    public int estado;
    private JMenuFuncionarioStand parent;

    /**
     * Creates new form CriarConfiguração
     */
    public JCriarConfiguracao(JLogin facade, JMenuFuncionarioStand parent) {
        initComponents();
            
        this.setResizable(false);
        this.jFacade = facade;
        this.parent = parent;
       
        this.chaveConfiguracao = jFacade.getSingleton().criarConfiguracao(this.parent.getId()); // inicia/ cria a configuração
        this.estado = 0;
        this.updateConfiguracao();
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListComponentes = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButtonMotor = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelpreco = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonReset = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ConfiguracaoAtual = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jButton1.setText("Modelo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jListComponentes.setFont(new java.awt.Font("AppleGothic", 1, 14)); // NOI18N
        jListComponentes.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jListComponentes);

        jButton2.setText("Exterior");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Pacotes");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButtonMotor.setText("Motorização");
        jButtonMotor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMotorActionPerformed(evt);
            }
        });

        jButton5.setText("Interior");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("<html><center/>Submeter<br>configuração<center/><html>");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Cancelar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel1.setText("Preço atual:");

        jLabelpreco.setText("0 €");

        jButton8.setText("<html><center/>Adicionar<br />à configuração<center/></html>");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel3.setText("Configuração atual:");

        jLabel4.setText("Lista de Componentes a adicionar disponíveis:");

        jButtonReset.setText("reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        ConfiguracaoAtual.setColumns(20);
        ConfiguracaoAtual.setRows(5);
        jScrollPane3.setViewportView(ConfiguracaoAtual);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonMotor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonReset)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(jLabelpreco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jLabel1))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jButton7)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap())
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(jLabelpreco)
                        .addGap(57, 57, 57)
                        .addComponent(jButtonReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonMotor, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane3))
                        .addContainerGap(25, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>                        

    // MOTORIZACAO
    private void jButtonMotorActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if (this.estado == 1) {
            try {
                DefaultListModel model = new DefaultListModel(); // abstracao visual dos dados
                for(Componente c: jFacade.getSingleton().getMotorizacoes(chaveConfiguracao))
                    model.addElement(c.getId() + " - " + c.prettyPrint());
                this.jListComponentes.setModel(model);
            } catch (ConfiguracaoNaoExisteException e) {
                JOptionPane.showMessageDialog(this, "Erro interno, configuração não existe no sistema!","ERRO", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } catch (ModeloNaoExisteException e) {
                JOptionPane.showMessageDialog(this, "Erro interno, modelo não existe no sistema!","AVISO", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } catch (ComponenteNaoExisteException e) {
                JOptionPane.showMessageDialog(this, "Erro interno, componente não existe no sistema!","AVISO", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else if (this.estado == 0) {
            JOptionPane.showMessageDialog(this, "Por favor seleciona o modelo primeiro!","AVISO", JOptionPane.WARNING_MESSAGE);  
        } else {
            JOptionPane.showMessageDialog(this, "O motor já foi selecionado!","AVISO", JOptionPane.WARNING_MESSAGE);  
        }
    }                                            

    //INTERIOR
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if (this.estado >= 2) {
            this.estado = 3;
            try {
                DefaultListModel model = new DefaultListModel(); // abstracao visual dos dados
                for(Componente c: jFacade.getSingleton().getInteriores(chaveConfiguracao)){
                    if(c != null)model.addElement(c.getId() + " - " + c.prettyPrint());
                }
                this.jListComponentes.setModel(model);
            } catch (ConfiguracaoNaoExisteException e) {
                JOptionPane.showMessageDialog(this, "Erro interno, configuração não existe no sistema!","ERRO", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } catch (ModeloNaoExisteException e) {
                JOptionPane.showMessageDialog(this, "Erro interno, modelo não existe no sistema!","AVISO", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } catch (ComponenteNaoExisteException e) {
                JOptionPane.showMessageDialog(this, "Erro interno, componente não existe no sistema!","AVISO", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else if (this.estado == 0) {
            JOptionPane.showMessageDialog(this, "Por favor seleciona o modelo primeiro!","AVISO", JOptionPane.WARNING_MESSAGE);  
        } else if (this.estado == 1) {
            JOptionPane.showMessageDialog(this, "Por favor seleciona o motor primeiro!","AVISO", JOptionPane.WARNING_MESSAGE);  
        }
    }                                        

    //EXTERIOR
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        if (this.estado >= 2) {
            this.estado = 2;
            try {
                DefaultListModel model = new DefaultListModel(); // abstracao visual dos dados
                for(Componente p: jFacade.getSingleton().getExterior(this.chaveConfiguracao)) {
                    model.addElement(p.getId() + " - " + p.prettyPrint());
                }
                this.jListComponentes.setModel(model);
            } catch (ConfiguracaoNaoExisteException e) {
                JOptionPane.showMessageDialog(this, "Erro interno, configuração não existe no sistema!","ERRO", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } catch (ModeloNaoExisteException e) {
                JOptionPane.showMessageDialog(this, "Erro interno, modelo não existe no sistema!","AVISO", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } catch (ComponenteNaoExisteException e) {
                JOptionPane.showMessageDialog(this, "Erro interno, componente não existe no sistema!","AVISO", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else if (this.estado == 0) {
            JOptionPane.showMessageDialog(this, "Por favor seleciona o modelo primeiro!","AVISO", JOptionPane.WARNING_MESSAGE);  
        } else if (this.estado == 1) {
            JOptionPane.showMessageDialog(this, "Por favor seleciona o motor primeiro!","AVISO", JOptionPane.WARNING_MESSAGE);  
        }
    }

    // SUBMETER FABRCIA
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if (this.estado >= 2) {
            try {
                this.jFacade.getSingleton().submeterFabrica(this.chaveConfiguracao);
                this.updateConfiguracao(); 
                
                // Deteta e adiciona os pacotes
                Collection<Pacote> pacotes = this.jFacade.getSingleton().containsPacote(this.chaveConfiguracao);
                String msg;
                if (pacotes.isEmpty()) msg = "";
                else {
                    msg = "\nForam detados os seguintes pacotes:\n";
                    for(Pacote p: pacotes)
                        msg += p.getId() + " - " + p.getNome() + "\n";
                    msg += "O respetivo desconto foi aplicado!";
                }
                
                JOptionPane.showMessageDialog(this, "A configuração foi submetida com sucesso!\n" + msg,"SUCESSO", JOptionPane.INFORMATION_MESSAGE);  
                this.setVisible(false);
                this.parent.setVisible(true);
            } catch (ConfiguracaoNaoExisteException e) {
                JOptionPane.showMessageDialog(this, "Erro interno, configuração não existe no sistema!","ERRO", JOptionPane.ERROR_MESSAGE); 
                e.printStackTrace();
            } catch (PacoteNaoExisteException e) {
                JOptionPane.showMessageDialog(this, "Erro interno, pacote não existe no sistema!","ERRO", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else if (this.estado == 0) {
            JOptionPane.showMessageDialog(this, "Por favor seleciona o modelo primeiro!","AVISO", JOptionPane.WARNING_MESSAGE);  
        } else if (this.estado == 1) {
            JOptionPane.showMessageDialog(this, "Por favor seleciona o motor primeiro!","AVISO", JOptionPane.WARNING_MESSAGE);  
        }
    }                                        

    // MODELO
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if (this.estado == 0) {
            DefaultListModel model = new DefaultListModel(); // abstracao visual dos dados
            for(Modelo m: jFacade.getSingleton().getCatalogo())
                model.addElement(m.getId() + " - " + m.prettyPrint());
            this.jListComponentes.setModel(model);   
        } else {
            JOptionPane.showMessageDialog(this, "O modelo já foi selecionado!","AVISO", JOptionPane.WARNING_MESSAGE);  
        }
    }                                        

    // Pacotes
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if (this.estado >= 2) {
            this.estado = 4;
            try {
                DefaultListModel model = new DefaultListModel(); // abstracao visual dos dados
                for(Pacote p: jFacade.getSingleton().getPacotes(this.chaveConfiguracao))
                    model.addElement(p.getId() + " - " + p);
                this.jListComponentes.setModel(model);  
            } catch (ConfiguracaoNaoExisteException e) {
                JOptionPane.showMessageDialog(this, "Erro interno, configuração não existe no sistema!","ERRO", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } catch (ModeloNaoExisteException e) {
                JOptionPane.showMessageDialog(this, "Por favor seleciona o modelo primeiro!","AVISO", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } catch (PacoteNaoExisteException e) {
                JOptionPane.showMessageDialog(this, "Por favor seleciona o modelo primeiro!","AVISO", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } 
        } else if (this.estado == 0) {
            JOptionPane.showMessageDialog(this, "Por favor seleciona o modelo primeiro!","AVISO", JOptionPane.WARNING_MESSAGE);  
        } else if (this.estado == 1) {
            JOptionPane.showMessageDialog(this, "Por favor seleciona o motor primeiro!","AVISO", JOptionPane.WARNING_MESSAGE);  
        } 
    }                                        

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                         
      
    }                                        

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {                                      

        int index = -1; // não selecionou nada
        String id = "";
        
        // vai buscar o index (posição no JList) do sercidor selecionado
        if ( (index = this.jListComponentes.locationToIndex(evt.getPoint())) >= 0 ) {
            id = this.jListComponentes.getSelectedValue().split(" ")[0];  
        }
       
        if (estado == 0) { // SELECIONAR O MODELO
            
            try {
                if (id.equals("") == false) { // selecionou algo 

                    jFacade.getSingleton().setModelo(id, this.chaveConfiguracao);
                    DefaultListModel model = new DefaultListModel();
                    model.addElement("Modelo selecionado!");
                    this.jListComponentes.setModel(model);
                    this.estado = 1;
                    
                    // Atualiza JList da configuracao atual
                    this.updateConfiguracao();
                }
            } catch (ConfiguracaoNaoExisteException e) {
                JOptionPane.showMessageDialog(this, "Erro interno, configuração não existe no sistema!","ERRO", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } catch (ModeloNaoExisteException e) {
                JOptionPane.showMessageDialog(this, "Erro interno, modelo não existe no sistema","ERRO", JOptionPane.ERROR_MESSAGE);    
                e.printStackTrace();
            }
            
        } else if (estado == 1) { // SELECIONAR MOTOR
            if (id.equals("") == false) { 
                try {

                    jFacade.getSingleton().setMotorizacao(id, chaveConfiguracao);
                    DefaultListModel model = new DefaultListModel();
                    model.addElement("Motor selecionado!");
                    this.jListComponentes.setModel(model);
                    this.estado = 2;
                    
                    // Atualiza JList da configuracao atual
                    this.updateConfiguracao();
                    
                } catch (ConfiguracaoNaoExisteException e) {
                    JOptionPane.showMessageDialog(this, "Erro interno, configuração não existe no sistema!","ERRO", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                } catch (ComponenteNaoExisteException e) {
                    JOptionPane.showMessageDialog(this, "Erro interno, componente não existe no sistema","ERRO", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
            
       
        } else if (estado == 2 || estado == 3) { // SELECIONAR EXTERIOR OU INTERIOR
            try {
                
                Collection<Collection<String>> resultado = jFacade.getSingleton().validaConfiguracaoAtual(id, chaveConfiguracao);
                
                Iterator<Collection<String>> it = resultado.iterator();
                Collection<String> incompativeis = it.next();
                Collection<String> necessarios = it.next();
         
                
                if(incompativeis.isEmpty() && necessarios.isEmpty()) {
                    jFacade.getSingleton().addComponente(id, chaveConfiguracao);
                    this.updateConfiguracao();
                }
                else new JAlternativas(jFacade.getSingleton(), incompativeis, necessarios, id, this.jFacade, this).setVisible(true); //  abrir a janela das alternativas
                
            } catch (ConfiguracaoNaoExisteException e) {
                JOptionPane.showMessageDialog(this, "Erro interno, configuracao não existe no sistema","ERRO", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } catch (ComponenteNaoExisteException e) {
                JOptionPane.showMessageDialog(this, "Erro interno, componente não existe no sistema","ERRO", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
            
        
        } else if (estado == 4) { // Pacotes
            try {
                if (jFacade.getSingleton().getDAOFacade().getPacotes().containsKey(id) == false) throw new PacoteNaoExisteException(id);
                
                Pacote p = jFacade.getSingleton().getDAOFacade().getPacotes().get(id);
                
                Collection<String> incompativeis = new TreeSet<>();
                Collection<String> necessarios = new TreeSet<>();
                        
                for(String idComponente: p.getComponentes()) {

                    Collection<Collection<String>> resultado = jFacade.getSingleton().validaConfiguracaoAtual(idComponente, chaveConfiguracao);
                
                    Iterator<Collection<String>> it = resultado.iterator();
                    incompativeis.addAll(it.next());
                    necessarios.addAll(it.next());   
                    necessarios.add(idComponente);
                }
                
                new JAlternativas(jFacade.getSingleton(), incompativeis, necessarios, "-1", this.jFacade, this).setVisible(true); //  abrir a janela das alternativas
   
            
            } catch (ConfiguracaoNaoExisteException e) {
                JOptionPane.showMessageDialog(this, "Erro interno, configuração não existe no sistema!","ERRO", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } catch (ComponenteNaoExisteException e) {
                JOptionPane.showMessageDialog(this, "Erro interno, componente não existe no sistema","ERRO", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } catch (PacoteNaoExisteException e) {
                JOptionPane.showMessageDialog(this, "Erro interno, pacote não existe no sistema","ERRO", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }                                     

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {                                             
        try {
            jFacade.getSingleton().removeConfiguracao(this.chaveConfiguracao); // Remove configuracao atual
            this.chaveConfiguracao = jFacade.getSingleton().criarConfiguracao(this.parent.getId()); // cria uma nova
            this.jListComponentes.setModel(new DefaultListModel());   // empty o jList dos componentes
            this.updateConfiguracao(); // atualiza o jList da configuracao Atual
            this.estado = 0;
            JOptionPane.showMessageDialog(this, "A configuração atual foi apagada!","AVISO", JOptionPane.WARNING_MESSAGE);  
        } catch (ConfiguracaoNaoExisteException e) {
            JOptionPane.showMessageDialog(this, "Erro interno, configuração não existe no sistema!","ERRO", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }                                            

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            jFacade.getSingleton().removeConfiguracao(this.chaveConfiguracao); // Remove configuracao atual
            JOptionPane.showMessageDialog(this, "A configuração atual foi apagada!","AVISO", JOptionPane.WARNING_MESSAGE);
        } catch (ConfiguracaoNaoExisteException e) {
            JOptionPane.showMessageDialog(this, "Erro interno, configuração não existe no sistema!","ERRO", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            this.setVisible(false);
            this.parent.setVisible(true);
        }
    }                                        

    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
        try {
            jFacade.getSingleton().removeConfiguracao(this.chaveConfiguracao); // Remove configuracao atual
            JOptionPane.showMessageDialog(this, "A configuração atual foi apagada!","AVISO", JOptionPane.WARNING_MESSAGE);
        } catch (ConfiguracaoNaoExisteException e) {
            JOptionPane.showMessageDialog(this, "Erro interno, configuração não existe no sistema!","ERRO", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            this.setVisible(false);
            this.parent.setVisible(true);
        }
    }                                  

    public void updateConfiguracao() {
        try {
            
        if (jFacade.getSingleton().getDAOFacade().getConfiguracoes().containsKey(this.chaveConfiguracao) == false){
         throw new ConfiguracaoNaoExisteException(this.chaveConfiguracao);  
        }
                                    
        Configuracao c = jFacade.getSingleton().getDAOFacade().getConfiguracoes().get(this.chaveConfiguracao);
        
        
        
        Modelo m = jFacade.getSingleton().getDAOFacade().getModelos().get(c.getModelo());
        
       
        
        Componente motor = jFacade.getSingleton().getDAOFacade().getComponentes().get(c.getMotor());
        
        Collection<Componente> exteriores = jFacade.getSingleton().getExteriorConfiguracao(this.chaveConfiguracao);
        Collection<Componente> interiores = jFacade.getSingleton().getInteriorConfiguracao(this.chaveConfiguracao);
        Collection<Pacote> pacotes = jFacade.getSingleton().getPacotesConfiguracao(this.chaveConfiguracao);
        
        String s = "";
        
        if (c.getModelo().equals("-1")) {
            s = s + "Modelo = Não selecionado" + "\n\n"; 
        }
        else {
            s = s + "Modelo = " + m.getDesignacao()  + "\n\n";
        }
        
          
        
        if (c.getMotor().equals("-1")) {
            s = s + "Motorozicao = Não selecionado" + "\n\n";   
        }
        else {
            s = s + "Motorizacao = " + motor.getDesignacao() + "\n\n";
        }
        
        if(c.getExteriores().isEmpty()) {
                 s = s + "Exteriores = Não selecionado" + "\n\n"; 
        }
        else{
            s = s + "Exterior = \n";
           
            Iterator<Componente> cps = exteriores.iterator();
		while (cps.hasNext()){
			Componente p = cps.next();
		 s = s + p.getDesignacao() + "\n";	
		}
                
        }
            
        
   
        if(c.getInteriores().isEmpty()) {
                 s = s + "\nInteriores = Não selecionado" + "\n\n"; 
        }
        else{
            s = s + "\nInterior = \n";
           
            Iterator<Componente> cps = interiores.iterator();
		while (cps.hasNext()){
			Componente p = cps.next();
		 s = s + p.getDesignacao() + "\n";	
		}
                
        }
       
        /*
        if(c.getPacotes().isEmpty()) {
                 s = s + "\nPacotes = Não selecionado" + "\n\n"; 
        }
        else{
            s = s + "\nPacote = \n";
           
            Iterator<Pacote> p = pacotes.iterator();
		while (p.hasNext()){
			Pacote pa = p.next();
		 s = s + pa.getNome() + "\n";	
		}
                
        }
        */
        
        this.ConfiguracaoAtual.setText(s); 
        //Impede edição
        this.ConfiguracaoAtual.setEditable(false);
        
        // Atualiza o preco atual apresentado
        this.jLabelpreco.setText(Float.toString(c.getPreco()) + " €");
        } catch (ConfiguracaoNaoExisteException e) {
            JOptionPane.showMessageDialog(this, "Erro interno, configuração não existe no sistema!","ERRO", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();

        }
                
        
   
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextArea ConfiguracaoAtual;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButtonMotor;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelpreco;
    private javax.swing.JList<String> jListComponentes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration                   
}
