
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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
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
        //ButtonSalvarAlterar.setEnabled(salvarAterar);
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
        //---------------------Fomataçao das tabelas--------------------------
    String tituloColuna[] = {"Codigo", "Descricao","Categoria", "Consumivel","Observação"," Minimo","Maximo"," Custo Medio"};
    public void modeloDATabela(String[][] a){
            modelo.setDataVector(a, tituloColuna);
            JTabCadastro.setModel(new DefaultTableModel(a,tituloColuna){
            boolean[] canEdit = new boolean[]{
                false,false,false,false,false,false,false
            };
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return canEdit[columnIndex];
            }
            });
            JTabCadastro.getColumnModel().getColumn(0).setPreferredWidth(20);
            JTabCadastro.getColumnModel().getColumn(1).setPreferredWidth(150);
            JTabCadastro.getColumnModel().getColumn(2).setPreferredWidth(70);
            JTabCadastro.getColumnModel().getColumn(3).setPreferredWidth(30);
            JTabCadastro.getColumnModel().getColumn(4).setPreferredWidth(200);
            JTabCadastro.getColumnModel().getColumn(5).setPreferredWidth(20);
            JTabCadastro.getColumnModel().getColumn(6).setPreferredWidth(20);
            JTabCadastro.getColumnModel().getColumn(7).setPreferredWidth(50);
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);            
            JTabCadastro.getColumnModel().getColumn(0).setCellRenderer(centralizado);            
            JTabCadastro.setRowHeight(25);               
    }
    //---------------------------------------------------------------------
    
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
            modeloDATabela(dados);
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
            modeloDATabela(dados);
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
        ButtonLimpar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTabCadastro = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        ButtonAlterar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        TextCodMat = new javax.swing.JTextField();
        botaoPesquisarCodigo = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        TextDescri = new javax.swing.JTextField();
        botaoTodos = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(232, 222, 200));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro de Material");

        ButtonNovo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/script_add.png"))); // NOI18N
        ButtonNovo.setText("Novo");
        ButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonNovoActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(230, 214, 165));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados de Cadastro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Código");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 30, 37, 15);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Descrição");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(230, 30, 60, 20);

        TextDesc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TextDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextDescActionPerformed(evt);
            }
        });
        jPanel1.add(TextDesc);
        TextDesc.setBounds(300, 30, 340, 25);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Categoria");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 70, 51, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Consumível");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(300, 70, 70, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Observação");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 110, 63, 15);
        jPanel1.add(TextObs);
        TextObs.setBounds(110, 110, 530, 25);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Estoque Mínimo");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 150, 90, 17);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Estoque Máximo");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(190, 150, 89, 20);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Custo Médio");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(420, 150, 70, 20);

        TextEstMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextEstMinActionPerformed(evt);
            }
        });
        jPanel1.add(TextEstMin);
        TextEstMin.setBounds(110, 150, 70, 25);

        TextEstMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextEstMaxActionPerformed(evt);
            }
        });
        jPanel1.add(TextEstMax);
        TextEstMax.setBounds(290, 150, 120, 25);

        TextCustMed.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(TextCustMed);
        TextCustMed.setBounds(500, 150, 140, 25);

        ComboBoxCateg.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        ComboBoxCateg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione Categoria" }));
        jPanel1.add(ComboBoxCateg);
        ComboBoxCateg.setBounds(110, 70, 160, 25);

        TextCod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TextCod.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(TextCod);
        TextCod.setBounds(110, 30, 110, 25);

        RadioButtonConsumivel.setBackground(new java.awt.Color(230, 214, 165));
        RadioButtonConsumivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonConsumivelActionPerformed(evt);
            }
        });
        jPanel1.add(RadioButtonConsumivel);
        RadioButtonConsumivel.setBounds(380, 60, 30, 40);

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

        ButtonLimpar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonLimpar1.setText("Limpar");
        ButtonLimpar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLimpar1ActionPerformed(evt);
            }
        });

        JTabCadastro.setBackground(new java.awt.Color(230, 214, 165));
        JTabCadastro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTabCadastro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Descrição", "Categoria", "Consumível", "Estoque Mínimo", "Estoque Máximo", "Custo Médio"
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

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Todos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ButtonAlterar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonAlterar.setText("Editar");
        ButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAlterarActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(230, 214, 165));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta de Materiais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Código");

        TextCodMat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        botaoPesquisarCodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoPesquisarCodigo.setText("Buscar");
        botaoPesquisarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarCodigoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Descrição");

        TextDescri.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        botaoTodos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoTodos.setText("Buscar");
        botaoTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(TextDescri, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(botaoTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(TextCodMat, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoPesquisarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(TextCodMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisarCodigo))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(botaoTodos)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextDescri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btAlterar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton1)
                                .addComponent(jScrollPane1)
                                .addComponent(ButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(ButtonNovo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                                    .addComponent(ButtonSalvar)
                                    .addGap(18, 18, 18)
                                    .addComponent(btAlterar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(ButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(25, 25, 25)
                                    .addComponent(ButtonLimpar1))
                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(103, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonSalvar)
                    .addComponent(ButtonAlterar)
                    .addComponent(ButtonLimpar1)
                    .addComponent(ButtonNovo)
                    .addComponent(btAlterar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jButton1)
                .addGap(11, 11, 11)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(824, 641));
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
            
            //this.jTabbedPane1.setSelectedIndex(0);
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

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
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
    }//GEN-LAST:event_btAlterarActionPerformed
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
             
            modeloDATabela(dados);
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
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
