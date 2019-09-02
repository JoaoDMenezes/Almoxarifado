
package almoxarifado.view;

import almoxarifado.dao.Dao_CadastroMaterial;
import almoxarifado.modelo.Categoria;
import almoxarifado.modelo.Material;
import almoxarifado.util.LimitaDigitos;
import almoxarifado.util.LimitaDigitosNum;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class View_Material extends javax.swing.JFrame {
    DefaultTableModel modelo = new DefaultTableModel();
    Dao_CadastroMaterial Dao_Material;
    Material m;
    ArrayList<Material> materiais;
    Vector<Categoria>categorias;
    Categoria categoria;
    public View_Material() throws SQLException {
        categoria = new Categoria();
        m= new Material();
        Dao_Material = new Dao_CadastroMaterial();
        materiais= new ArrayList<>();
        initComponents();
        TextCod.setDocument(new LimitaDigitosNum(11));
        TextCodMat.setDocument(new LimitaDigitosNum(11));
        TextDesc.setDocument(new LimitaDigitos(30));
        TextDescri.setDocument(new LimitaDigitos(30));
        TextObs.setDocument(new LimitaDigitos(50));
        TextEstMax.setDocument(new LimitaDigitosNum(11));
        TextEstMin.setDocument(new LimitaDigitosNum(11));
        categorias = new Dao_CadastroMaterial().CampoBox();
        ComboBoxCateg.setModel(new DefaultComboBoxModel(categorias));
        atualizarTabela();
        inicio();
        
    }
    private void inicio(){
        campo(false,false,false,false,false,false,false,false);
        botao(true, false, false, true, false, true, true,false);
    }
    private void campo(boolean codigo, boolean descricao, boolean categoria, boolean consumivel,
            boolean obs, boolean minimo, boolean maximo, boolean medio){
          this.TextCod.setEnabled(codigo);
          this.TextDesc.setEnabled(descricao);
          this.ComboBoxCateg.setEnabled(categoria);
          this.RadioButtonConsumivel.setEnabled(consumivel);
          this.TextObs.setEnabled(obs);
          this.TextEstMin.setEnabled(minimo);
          this.TextEstMax.setEnabled(maximo);
          this.TextCustMed.setEnabled(medio);
    }
        private void botao(boolean novo, boolean salvar, boolean limpar, boolean sair, 
            boolean salvarAterar, boolean pesCodigo, boolean pesNome, boolean alterar){
        ButtonNovo.setEnabled(novo);
        ButtonSalvar.setEnabled(salvar);
        ButtonLimpar1.setEnabled(limpar);
        ButtonSair.setEnabled(sair);
        ButtonSalvarAlterar.setEnabled(salvarAterar);
        botaoPesquisarCodigo.setEnabled(pesCodigo);
        botaoTodos.setEnabled(pesNome);
        ButtonAlterar.setEnabled(alterar); 
    } 
    
    public boolean verificarCampo() {
        if (TextDesc.getText().isEmpty()
            || TextObs.getText().isEmpty()
            || ComboBoxCateg.getSelectedItem().equals(" ")
            || TextEstMin.getText().isEmpty()
            || TextEstMax.getText().isEmpty()
            || TextCustMed.getText().isEmpty()
            ) {
            return false;
        } else {
            return true;
        }
    }
        public void atualizarTabela(){
            m = new Material();
        try {
            materiais = (ArrayList<Material>) Dao_Material.todosMateriais();
            String dados[][] = new String[materiais.size()][8];
            int i = 0;
            for (Material u : materiais) {
                dados[i][0] = String.valueOf(u.getCodigo());
                dados[i][1] = u.getDescricao();
                dados[i][2] = String.valueOf(u.getCategoria().getNome());
                if(u.isConsumivel()){
                    dados[i][3] =String.valueOf("Sim");
                }else{
                    dados[i][3] =String.valueOf("Não");
                }
                dados[i][4] = u.getObservacao();
                dados[i][5] = String.valueOf(u .getEstoqueMinimo());
                dados[i][6] = String.valueOf(u .getEstoqueMaximo());
                dados[i][7] = String.valueOf(u .getCustoMedio());
                i++;
            }
            String tituloColuna[] = {"Codigo", "Descricao","Categoria", "Consumivel","Observação"," Minimo","Maximo"," Custo Medio"};
            modelo.setDataVector(dados, tituloColuna);
            JTabCadastro.setModel(modelo);
            JTabCadastro.updateUI();
        } catch (SQLException ex) { 
            Logger.getLogger(View_Material.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
         private void BuscaTabela(){
         m = new Material();
        try {
            materiais = (ArrayList<Material>) Dao_Material.BuscaMateriais(TextDescri.getText());
            String dados[][] = new String[materiais.size()][8];
            int i = 0;
            for (Material u : materiais) {
                dados[i][0] = String.valueOf(u.getCodigo());
                dados[i][1] = u.getDescricao();
                dados[i][2] = String.valueOf(u.getCategoria().getNome());
                if(u.isConsumivel()){
                    dados[i][3] =String.valueOf("Sim");
                }else{
                    dados[i][3] =String.valueOf("Não");
                }
                dados[i][4] = u.getObservacao();
                dados[i][5] = String.valueOf(u .getEstoqueMinimo());
                dados[i][6] = String.valueOf(u .getEstoqueMaximo());
                dados[i][7] = String.valueOf(u .getCustoMedio());
                i++;
            }
            String tituloColuna[] = {"Codigo", "Descricao","Categoria", "Consumivel","Observação"," Minimo","Maximo"," Custo Medio"};
            modelo.setDataVector(dados, tituloColuna);
            JTabCadastro.setModel(modelo);
            JTabCadastro.updateUI();
        } catch (SQLException ex) { 
            Logger.getLogger(View_Material.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ButtonNovo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TextDesc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TextObs = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TextEstMin = new javax.swing.JTextField();
        TextEstMax = new javax.swing.JTextField();
        TextCustMed = new javax.swing.JTextField();
        ComboBoxCateg = new javax.swing.JComboBox<>();
        TextCod = new javax.swing.JTextField();
        RadioButtonConsumivel = new javax.swing.JRadioButton();
        ButtonSair = new javax.swing.JButton();
        ButtonSalvar = new javax.swing.JButton();
        ButtonSalvarAlterar = new javax.swing.JButton();
        ButtonLimpar1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        TextCodMat = new javax.swing.JTextField();
        TextDescri = new javax.swing.JTextField();
        botaoPesquisarCodigo = new javax.swing.JButton();
        botaoTodos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTabCadastro = new javax.swing.JTable();
        ButtonAlterar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Cadastro de Material");

        ButtonNovo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/script_add.png"))); // NOI18N
        ButtonNovo.setText("Novo");
        ButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonNovoActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados de Cadastro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); // NOI18N
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Código");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 30, 43, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Descrição");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(220, 30, 70, 20);

        TextDesc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TextDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextDescActionPerformed(evt);
            }
        });
        jPanel1.add(TextDesc);
        TextDesc.setBounds(300, 30, 310, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Categoria");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 70, 58, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Consumivel");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(300, 80, 70, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Observação");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 110, 73, 17);
        jPanel1.add(TextObs);
        TextObs.setBounds(110, 110, 500, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Estoque Minimo");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 160, 100, 17);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Estoque Máximo");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(190, 160, 101, 20);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Custo Médio");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(410, 160, 80, 20);

        TextEstMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextEstMinActionPerformed(evt);
            }
        });
        jPanel1.add(TextEstMin);
        TextEstMin.setBounds(110, 160, 70, 30);

        TextEstMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextEstMaxActionPerformed(evt);
            }
        });
        jPanel1.add(TextEstMax);
        TextEstMax.setBounds(300, 160, 100, 30);

        TextCustMed.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(TextCustMed);
        TextCustMed.setBounds(500, 160, 110, 30);

        ComboBoxCateg.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        ComboBoxCateg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione Categoria" }));
        jPanel1.add(ComboBoxCateg);
        ComboBoxCateg.setBounds(110, 70, 160, 30);

        TextCod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TextCod.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(TextCod);
        TextCod.setBounds(110, 30, 61, 30);

        RadioButtonConsumivel.setBackground(new java.awt.Color(204, 204, 255));
        RadioButtonConsumivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonConsumivelActionPerformed(evt);
            }
        });
        jPanel1.add(RadioButtonConsumivel);
        RadioButtonConsumivel.setBounds(380, 70, 30, 40);

        ButtonSair.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/door_in.png"))); // NOI18N
        ButtonSair.setText("Sair");
        ButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSairActionPerformed(evt);
            }
        });

        ButtonSalvar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/disk.png"))); // NOI18N
        ButtonSalvar.setText("Salvar");
        ButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSalvarActionPerformed(evt);
            }
        });

        ButtonSalvarAlterar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonSalvarAlterar.setText("Alterar");
        ButtonSalvarAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSalvarAlterarActionPerformed(evt);
            }
        });

        ButtonLimpar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonLimpar1.setText("Limpar");
        ButtonLimpar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLimpar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonSalvarAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129)
                        .addComponent(ButtonLimpar1)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ButtonNovo, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                        .addComponent(ButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ButtonSalvarAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonLimpar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(26, 26, 26))
        );

        jTabbedPane1.addTab("Cadastro", jPanel2);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setText("Consulta de Material");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(207, 11, 169, 20);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Código");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(16, 55, 43, 17);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Descrição");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(16, 102, 59, 17);

        TextCodMat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel3.add(TextCodMat);
        TextCodMat.setBounds(63, 49, 87, 30);

        TextDescri.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel3.add(TextDescri);
        TextDescri.setBounds(79, 102, 301, 30);

        botaoPesquisarCodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoPesquisarCodigo.setText("Pesquisar");
        botaoPesquisarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarCodigoActionPerformed(evt);
            }
        });
        jPanel3.add(botaoPesquisarCodigo);
        botaoPesquisarCodigo.setBounds(170, 50, 99, 30);

        botaoTodos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoTodos.setText("Pesquisar");
        botaoTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoTodosActionPerformed(evt);
            }
        });
        jPanel3.add(botaoTodos);
        botaoTodos.setBounds(390, 100, 100, 30);

        JTabCadastro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTabCadastro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Descrição", "Categoria", "Consumivel", "Estoque Minimo", "Estoque Maximo", "Custo Medio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        JTabCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTabCadastroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTabCadastro);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(10, 200, 676, 100);

        ButtonAlterar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonAlterar.setText("Alterar");
        ButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAlterarActionPerformed(evt);
            }
        });
        jPanel3.add(ButtonAlterar);
        ButtonAlterar.setBounds(10, 160, 100, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Todos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(577, 170, 100, 23);

        jTabbedPane1.addTab("Consulta", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        setSize(new java.awt.Dimension(705, 371));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSairActionPerformed
           if(JOptionPane.showConfirmDialog(null, "Deseja realmente sair?") == 0)
     {
         this.dispose();
     } 
    }//GEN-LAST:event_ButtonSairActionPerformed

    private void TextDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextDescActionPerformed

    private void TextEstMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextEstMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextEstMinActionPerformed

    private void RadioButtonConsumivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonConsumivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioButtonConsumivelActionPerformed

    private void TextEstMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextEstMaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextEstMaxActionPerformed

    private void ButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalvarActionPerformed

            boolean v = verificarCampo();
            if (v) {
                    m = new Material();
                    m.setDescricao(TextDesc.getText());
                    Categoria c;
                try {
                    c = Dao_Material.pegaCategoria((String) String.valueOf(ComboBoxCateg.getSelectedItem()));
                
                    m.setCategoria(c);
                    if(RadioButtonConsumivel.isSelected()){
                       m.setConsumivel(true);
                    }else{
                       m.setConsumivel(false);
                    }
                    m.setObservacao(TextObs.getText());
                    m.setEstoqueMinimo(Integer.valueOf(TextEstMin.getText()));
                    m.setEstoqueMaximo(Integer.valueOf(TextEstMax.getText()));
                    m.setCustoMedio(Float.valueOf(TextCustMed.getText()));
                   
                    Dao_Material.salvar(m);
                } catch (SQLException ex) {
                    Logger.getLogger(View_Material.class.getName()).log(Level.SEVERE, null, ex);
                }
                    limpar();
                   atualizarTabela();
                    JOptionPane.showMessageDialog(null, "Salvo!");
                
            } else {
                JOptionPane.showMessageDialog(null, "A campos a serem preenchidos");
            }
    }//GEN-LAST:event_ButtonSalvarActionPerformed

    private void JTabCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTabCadastroMouseClicked
        if (JTabCadastro.getSelectedRow() != -1) {
        //int a = Integer.valueOf(JTabCadastro.getValueAt(JTabCadastro.getSelectedRow(), 0).toString())+1;
        TextCodMat.setText(JTabCadastro.getValueAt(JTabCadastro.getSelectedRow(), 0).toString());
        try{   
          try {
            
           
           m = Dao_Material.getMaterialByCodigo(Integer.valueOf(TextCodMat.getText()));
           int a = Integer.valueOf(m.getCategoria().getCodigo());
            //  System.out.println(a);
           TextCod.setText(String.valueOf(m.getCodigo()));
           TextDesc.setText(m.getDescricao());
           ComboBoxCateg.setSelectedIndex(a - 1);
           RadioButtonConsumivel.setSelected(m.isConsumivel());
           TextObs.setText(m.getObservacao());
           TextEstMin.setText(String.valueOf(m.getEstoqueMinimo()));
           TextEstMax.setText(String.valueOf(m.getEstoqueMaximo()));
           TextCustMed.setText(String.valueOf(m.getCustoMedio()));
//               botao(true,false,true,true,true,true,false,true);
//               campo(true,false,false,false,false,false,false,false);     
        } catch (SQLException ex) {
                Logger.getLogger(View_Material.class.getName()).log(Level.SEVERE, null, ex);
        }
        }catch(Exception ex){
            ex.printStackTrace();
        }
            ButtonAlterar.setEnabled(true);
        }
    }//GEN-LAST:event_JTabCadastroMouseClicked
    private void limpar(){
        TextCod.setText("");
        TextDesc.setText("");
        ComboBoxCateg.setSelectedIndex(0);
        TextObs.setText("");
        TextEstMin.setText("");
        TextEstMax.setText("");
        TextCustMed.setText("");
       inicio();        
    }
    private void ButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonNovoActionPerformed
        limpar();
        campo(false,true,true,true,true,true,true,true);
        botao(false, true, true, true, false, true, true, false);
    }//GEN-LAST:event_ButtonNovoActionPerformed

    private void ButtonLimpar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLimpar1ActionPerformed
        limpar();
    }//GEN-LAST:event_ButtonLimpar1ActionPerformed

    private void ButtonSalvarAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalvarAlterarActionPerformed
       int o = JOptionPane.showConfirmDialog(null, "Você alterar os dados Cadastrados");
        if (o == 0) {
            boolean v = verificarCampo();
            if (v) {
                        m = new Material();
                        m.setCodigo(Integer.parseInt(TextCod.getText()));
                        m.setDescricao(TextDesc.getText());
                   Categoria c;
               
                try {
                    c = Dao_Material.pegaCategoria((String) String.valueOf(ComboBoxCateg.getSelectedItem()));
                
                
                    m.setCategoria(c);
                    if(RadioButtonConsumivel.isSelected()){
                       m.setConsumivel(true);
                    }else{
                       m.setConsumivel(false);
                    }
                    m.setObservacao(TextObs.getText());
                    m.setEstoqueMinimo(Integer.valueOf(TextEstMin.getText()));
                    m.setEstoqueMaximo(Integer.valueOf(TextEstMax.getText()));
                    m.setCustoMedio(Float.valueOf(TextCustMed.getText()));
                    } catch (SQLException ex) {
                    Logger.getLogger(View_Material.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    Dao_Material.getAlterar(m);
                } catch (SQLException ex) {
                    Logger.getLogger(View_Material.class.getName()).log(Level.SEVERE, null, ex);
                }
                }   
                atualizarTabela();
                limpar();
            }
    }//GEN-LAST:event_ButtonSalvarAlterarActionPerformed

    private void botaoPesquisarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarCodigoActionPerformed
        if(TextCodMat.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Escolha um codigo");
        }
        else{
            try{
            m = Dao_Material.getMaterialByCodigo(Integer.parseInt(TextCodMat.getText()));
            if(m == null){
                JOptionPane.showMessageDialog(null, "Material não encontrado");
            }
            else{
                
                Material t = Dao_Material.getMaterialByCodigo(Integer.valueOf(TextCodMat.getText()));
                int a = Integer.valueOf(t.getCategoria().getCodigo());
                TextCod.setText(String.valueOf(m.getCodigo()));
               
                TextDesc.setText(m.getDescricao());
                ComboBoxCateg.setSelectedIndex(a - 1);
                RadioButtonConsumivel.setSelected(m.isConsumivel());
                TextObs.setText(m.getObservacao());
                TextEstMin.setText(String.valueOf(m.getEstoqueMinimo()));
                TextEstMax.setText(String.valueOf(m.getEstoqueMaximo()));
                TextCustMed.setText(String.valueOf(m.getCustoMedio()));
               
               BuscaCodigo();

//               botao(true,false,true,true,true,true,false,true);
//               campo(true,false,false,false,false,false,false,false);     
            }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            ButtonAlterar.setEnabled(true);
        }
    }//GEN-LAST:event_botaoPesquisarCodigoActionPerformed

    private void ButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAlterarActionPerformed
      if(TextCodMat.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Escolha um para Alterar");
        }
        else{
            
            this.jTabbedPane1.setSelectedIndex(0);
            campo(false, true, true, true, true, true, true, true);
            botao(false, false, true, true, true, true, true, false);
            TextCodMat.setText("");
        }
    }//GEN-LAST:event_ButtonAlterarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       atualizarTabela();
       TextCodMat.setText("");
       ButtonAlterar.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botaoTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoTodosActionPerformed
         if(TextDescri.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Digite o que esta procurando");
        }else{
        BuscaTabela();
        }
    }//GEN-LAST:event_botaoTodosActionPerformed
    private void BuscaCodigo(){
        m = new Material();
        try {
            m =Dao_Material.getMaterialByCodigo(Integer.valueOf(TextCodMat.getText()));
            String dados[][] = new String[1][8];
            int i = 0;
           
                dados[i][0] = String.valueOf(m.getCodigo());
                dados[i][1] = m.getDescricao();
                dados[i][2] = String.valueOf(m.getCategoria().getNome());
                if(m.isConsumivel()){
                    dados[i][3] =String.valueOf("Sim");
                }else{
                    dados[i][3] =String.valueOf("Não");
                }
                dados[i][4] = m.getObservacao();
                dados[i][5] = String.valueOf(m .getEstoqueMinimo());
                dados[i][6] = String.valueOf(m .getEstoqueMaximo());
                dados[i][7] = String.valueOf(m .getCustoMedio());
                i++;
            String tituloColuna[] = {"Codigo", "Descricao","Categoria", "Consumivel","Observação"," Minimo","Maximo"," Custo Medio"};
            modelo.setDataVector(dados, tituloColuna);
            JTabCadastro.setModel(modelo);
            JTabCadastro.updateUI();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View_Material.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_Material.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_Material.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_Material.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new View_Material().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(View_Material.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAlterar;
    private javax.swing.JButton ButtonLimpar1;
    private javax.swing.JButton ButtonNovo;
    private javax.swing.JButton ButtonSair;
    private javax.swing.JButton ButtonSalvar;
    private javax.swing.JButton ButtonSalvarAlterar;
    private javax.swing.JComboBox<String> ComboBoxCateg;
    private javax.swing.JTable JTabCadastro;
    private javax.swing.JRadioButton RadioButtonConsumivel;
    private javax.swing.JTextField TextCod;
    private javax.swing.JTextField TextCodMat;
    private javax.swing.JTextField TextCustMed;
    private javax.swing.JTextField TextDesc;
    private javax.swing.JTextField TextDescri;
    private javax.swing.JTextField TextEstMax;
    private javax.swing.JTextField TextEstMin;
    private javax.swing.JTextField TextObs;
    private javax.swing.JButton botaoPesquisarCodigo;
    private javax.swing.JButton botaoTodos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
