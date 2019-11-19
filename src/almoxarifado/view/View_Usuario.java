/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almoxarifado.view;

import almoxarifado.dao.Dao_CadastroUsuario;
import almoxarifado.modelo.Usuario;
import almoxarifado.util.LimitaDigitos;
import almoxarifado.util.LimitaDigitosNum;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author User
 */
public class View_Usuario extends javax.swing.JFrame {
    DefaultTableModel modelo = new DefaultTableModel();
    ArrayList<Usuario> usuarios;
    Dao_CadastroUsuario daoUsuario;
    Usuario u;
    /**
     * Creates new form View_Usuario
     */
    public View_Usuario() {
        u = new Usuario();
        daoUsuario = new Dao_CadastroUsuario();
        usuarios = new ArrayList<>();
        initComponents();
        TextCod.setDocument(new LimitaDigitosNum(11));
        TextCodMat.setDocument(new LimitaDigitosNum(10));
        TextNome.setDocument(new LimitaDigitos(30));
        TextDescri.setDocument(new LimitaDigitos(30));
        PasswordFieldSenha.setDocument(new LimitaDigitos(15));
        PasswordFieldConfirSenha.setDocument(new LimitaDigitos(15));
        atualizarTabela();
        inicio();
    }
    private void inicio(){
        campo(false,false,false,false,false,false);
        botao(true, false, false, true, false, true, true,false);
    }
    public void campo(boolean codigo, boolean nome, boolean senha, boolean confSenha,
        boolean tipoUsuario, boolean status){
        
        this.TextCod.setEnabled(codigo);
        this.TextNome.setEnabled(nome);
        this.PasswordFieldSenha.setEnabled(senha);
        this.PasswordFieldConfirSenha.setEnabled(confSenha);
        this.ComboBoxTipoUsuario.setEnabled(tipoUsuario);
        this.ComboBoxStatus.setEnabled(status);
    
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
        ButtonEditar.setEnabled(alterar); 
    }   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TextNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TextCod = new javax.swing.JTextField();
        PasswordFieldConfirSenha = new javax.swing.JPasswordField();
        PasswordFieldSenha = new javax.swing.JPasswordField();
        ComboBoxStatus = new javax.swing.JComboBox<>();
        ComboBoxTipoUsuario = new javax.swing.JComboBox<>();
        ButtonSalvar = new javax.swing.JButton();
        ButtonLimpar1 = new javax.swing.JButton();
        ButtonNovo = new javax.swing.JButton();
        ButtonSalvarAlterar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTabCadastro = new javax.swing.JTable();
        botaoTodos = new javax.swing.JButton();
        ButtonEditar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        BotaoBusca = new javax.swing.JButton();
        TextDescri = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        botaoPesquisarCodigo = new javax.swing.JButton();
        TextCodMat = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        ButtonSair = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel4.setBackground(new java.awt.Color(232, 222, 200));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro de Usuário");

        jPanel1.setBackground(new java.awt.Color(230, 214, 165));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados De Cadastro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Código");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(60, 30, 40, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Nome");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(260, 30, 40, 20);

        TextNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextNomeActionPerformed(evt);
            }
        });
        jPanel1.add(TextNome);
        TextNome.setBounds(300, 30, 320, 25);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Senha");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 60, 34, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Confirme sua senha");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(320, 60, 110, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Tipo de Usuário");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 90, 90, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Status");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(390, 90, 40, 20);
        jPanel1.add(TextCod);
        TextCod.setBounds(110, 30, 60, 23);

        PasswordFieldConfirSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFieldConfirSenhaActionPerformed(evt);
            }
        });
        jPanel1.add(PasswordFieldConfirSenha);
        PasswordFieldConfirSenha.setBounds(440, 60, 180, 25);

        PasswordFieldSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFieldSenhaActionPerformed(evt);
            }
        });
        jPanel1.add(PasswordFieldSenha);
        PasswordFieldSenha.setBounds(110, 60, 190, 23);

        ComboBoxStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Ativo", "Inativo" }));
        ComboBoxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxStatusActionPerformed(evt);
            }
        });
        jPanel1.add(ComboBoxStatus);
        ComboBoxStatus.setBounds(440, 90, 180, 25);

        ComboBoxTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "administrador", "operador" }));
        jPanel1.add(ComboBoxTipoUsuario);
        ComboBoxTipoUsuario.setBounds(110, 90, 190, 25);

        ButtonSalvar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_save_16px_1.png"))); // NOI18N
        ButtonSalvar.setText("Salvar");
        ButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSalvarActionPerformed(evt);
            }
        });

        ButtonLimpar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonLimpar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_broom_16px_4.png"))); // NOI18N
        ButtonLimpar1.setText("Limpar");
        ButtonLimpar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLimpar1ActionPerformed(evt);
            }
        });

        ButtonNovo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_new_16px.png"))); // NOI18N
        ButtonNovo.setText("Novo");
        ButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonNovoActionPerformed(evt);
            }
        });

        ButtonSalvarAlterar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonSalvarAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_save_16px_1.png"))); // NOI18N
        ButtonSalvarAlterar.setText("Alterar");
        ButtonSalvarAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSalvarAlterarActionPerformed(evt);
            }
        });

        JTabCadastro.setBackground(new java.awt.Color(230, 214, 165));
        JTabCadastro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTabCadastro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Tipo Usuário", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTabCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTabCadastroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTabCadastro);

        botaoTodos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoTodos.setText("Todos");
        botaoTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoTodosActionPerformed(evt);
            }
        });

        ButtonEditar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_edit_16px.png"))); // NOI18N
        ButtonEditar.setText("Editar");
        ButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEditarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(230, 214, 165));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta de Usuários", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        BotaoBusca.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BotaoBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_search_16px_1.png"))); // NOI18N
        BotaoBusca.setText("Buscar");
        BotaoBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoBuscaActionPerformed(evt);
            }
        });

        TextDescri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextDescriActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Nome");

        botaoPesquisarCodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoPesquisarCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_search_16px_1.png"))); // NOI18N
        botaoPesquisarCodigo.setText("Buscar");
        botaoPesquisarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarCodigoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Código");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCodMat, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoPesquisarCodigo)
                .addGap(45, 45, 45)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextDescri)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotaoBusca)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BotaoBusca)
                            .addComponent(jLabel12)
                            .addComponent(botaoPesquisarCodigo)
                            .addComponent(TextCodMat, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(TextDescri, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addContainerGap())
        );

        ButtonSair.setBackground(new java.awt.Color(232, 222, 200));
        ButtonSair.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_cancel_48px.png"))); // NOI18N
        ButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSairActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Relatório");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(ButtonNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                        .addComponent(ButtonSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonSalvarAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonLimpar1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonSalvarAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ButtonLimpar1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(botaoTodos)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(712, 484));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            daoUsuario.gerarRelatorioCliente();
        } catch (SQLException ex) {
            Logger.getLogger(View_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(View_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(View_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void botaoTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoTodosActionPerformed
        atualizarTabela();
        TextCodMat.setText("");
        ButtonEditar.setEnabled(false);
    }//GEN-LAST:event_botaoTodosActionPerformed

    private void ButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEditarActionPerformed

        if(TextCodMat.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Escolha um para Alterar");
        }
        else{
            campo(false, true, true, true, true, true);
            botao(false, false, true, true, true, true, true, false);
           
            TextCodMat.setText("");
        }
    }//GEN-LAST:event_ButtonEditarActionPerformed

    private void JTabCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTabCadastroMouseClicked
        if (JTabCadastro.getSelectedRow() != -1) {
            int a = Integer.valueOf(JTabCadastro.getValueAt(JTabCadastro.getSelectedRow(), 0).toString());
            TextCodMat.setText(JTabCadastro.getValueAt(JTabCadastro.getSelectedRow(), 0).toString());
            try{

                u = daoUsuario.getUsuarioByCodigo(a);
                TextCod.setText(String.valueOf(u.getCodigo()));
                TextNome.setText(u.getNome());
                PasswordFieldSenha.setText(u.getSenha());
                PasswordFieldConfirSenha.setText(u.getConfSenha());
                ComboBoxTipoUsuario.setSelectedItem(u.getTipoUsuario());
                int s =0;
                if(u.isStatus()){
                    s=1;
                }else{
                    s=2;
                }
                ComboBoxStatus.setSelectedIndex(s);

                //               botao(true,false,true,true,true,true,false,true);
                //               campo(true,false,false,false,false,false,false,false);
            }catch(Exception ex){
                ex.printStackTrace();
            }
            ButtonEditar.setEnabled(true);
        }
    }//GEN-LAST:event_JTabCadastroMouseClicked

    private void BotaoBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscaActionPerformed
        if(TextDescri.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Digite o que esta procurando");
        }else{
            BuscaTabela();
        }
    }//GEN-LAST:event_BotaoBuscaActionPerformed

    private void botaoPesquisarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarCodigoActionPerformed
        //this.jTabbedPane1.setSelectedIndex(0);
        if(TextCodMat.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Escolha um codigo");
        }
        else{
            try{
                u = daoUsuario.getUsuarioByCodigo(Integer.parseInt(TextCodMat.getText()));
                if(u == null){
                    JOptionPane.showMessageDialog(null, "Usuario não encontrado");
                }
                else{
                    TextCod.setText(String.valueOf(u.getCodigo()));
                    TextNome.setText(u.getNome());
                    PasswordFieldSenha.setText(u.getSenha());
                    PasswordFieldConfirSenha.setText(u.getConfSenha());
                    ComboBoxTipoUsuario.setSelectedItem(u.getTipoUsuario());
                    int s =0;
                    if(u.isStatus()){
                        s=1;
                    }else{
                        s=2;
                    }
                    ComboBoxStatus.setSelectedIndex(s);
                    BuscaCodigo();

                    //               botao(true,false,true,true,true,true,false,true);
                    //               campo(true,false,false,false,false,false,false,false);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            ButtonEditar.setEnabled(true);
        }
    }//GEN-LAST:event_botaoPesquisarCodigoActionPerformed

    private void ButtonLimpar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLimpar1ActionPerformed
        limpar();
    }//GEN-LAST:event_ButtonLimpar1ActionPerformed

    private void ButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalvarActionPerformed
        boolean CV = camposVazios();
        if(CV){
            if(PasswordFieldSenha.getText().equals(PasswordFieldConfirSenha.getText())){
              int s = JOptionPane.showConfirmDialog(null,"------- Salvar Como ------\nNome: "+TextNome.getText()
                                       + "\n Tipo do Usuario: "+ComboBoxTipoUsuario.getSelectedItem().toString());
               if(s==0){ 
                
                u = new Usuario();
                u.setNome(TextNome.getText());
                u.setSenha(PasswordFieldSenha.getText());
                u.setTipoUsuario((String) ComboBoxTipoUsuario.getSelectedItem());
                if(ComboBoxStatus.getSelectedItem().equals("Ativo")){
                    u.setStatus(true);
                }else{
                    u.setStatus(false);
                }
                try {
                    daoUsuario.salvar(u);
                } catch (SQLException ex) {
                    Logger.getLogger(View_Usuario.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "SALVO");
                limpar();
                atualizarTabela();
               }
            }else{
                JOptionPane.showMessageDialog(null, "A senha nao confere");
            }
        }else{
            JOptionPane.showMessageDialog(null, "A campos a serem preenchidos");
        }

    }//GEN-LAST:event_ButtonSalvarActionPerformed

    private void ComboBoxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxStatusActionPerformed

    private void PasswordFieldSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFieldSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordFieldSenhaActionPerformed

    private void TextNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextNomeActionPerformed

    private void ButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonNovoActionPerformed
        limpar();
        campo(false,true,true,true,true,true);
        botao(false, true, true, true, false, true, true, false);
    }//GEN-LAST:event_ButtonNovoActionPerformed

    private void ButtonSalvarAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalvarAlterarActionPerformed
        boolean CV = camposVazios();
        if(CV){
            if(PasswordFieldSenha.getText().equals(PasswordFieldConfirSenha.getText())){        
            int s = JOptionPane.showConfirmDialog(null,"------- Alterar Como ------\nNome: "+TextNome.getText()
                                       + "\n Tipo do Usuario: "+ComboBoxTipoUsuario.getSelectedItem().toString());
               if(s==0){ 
                boolean v = camposVazios();
                if (v) {
                    u = new Usuario();
                    u.setCodigo(Integer.parseInt(TextCod.getText()));
                    u.setNome(TextNome.getText());
                    u.setSenha(PasswordFieldSenha.getText());
                    u.setTipoUsuario((String) ComboBoxTipoUsuario.getSelectedItem());
                    if(ComboBoxStatus.getSelectedItem().equals("Ativo")){
                        u.setStatus(true);
                    }else{
                        u.setStatus(false);
                    }

                    try {
                        daoUsuario.getAlterar(u);
                    } catch (SQLException ex) {
                        Logger.getLogger(View_Usuario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    atualizarTabela();
                    limpar();
                    }
                }
            }
        }   
    }//GEN-LAST:event_ButtonSalvarAlterarActionPerformed

    private void PasswordFieldConfirSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFieldConfirSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordFieldConfirSenhaActionPerformed

    private void TextDescriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextDescriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextDescriActionPerformed

    private void ButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSairActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Deseja realmente sair?") == 0)
        {
            this.dispose();
        }
    }//GEN-LAST:event_ButtonSairActionPerformed
    
        //---------------------Fomataçao das tabelas--------------------------
    String tituloColuna[] = {"Codigo", "Nome", "Tipo Usuario", "Status"};
    public void modeloDATabela(String[][] a){
            modelo.setDataVector(a, tituloColuna);
            JTabCadastro.setModel(new DefaultTableModel(a,tituloColuna){
            boolean[] canEdit = new boolean[]{
                false,false,false,false,false
            };
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return canEdit[columnIndex];
            }
            });
            JTabCadastro.getColumnModel().getColumn(0).setPreferredWidth(30);
            JTabCadastro.getColumnModel().getColumn(1).setPreferredWidth(200);
            JTabCadastro.getColumnModel().getColumn(2).setPreferredWidth(100);
            JTabCadastro.getColumnModel().getColumn(3).setPreferredWidth(50);
            
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);            
            JTabCadastro.getColumnModel().getColumn(0).setCellRenderer(centralizado);            
            JTabCadastro.setRowHeight(25);               
    }
    
    public void atualizarTabela(){
       u = new Usuario();
        try {
            usuarios = (ArrayList<Usuario>) daoUsuario.todosUsuarios();
            String dados[][] = new String[usuarios.size()][8];
            int i = 0;
            for (Usuario u : usuarios) {
                boolean a = u.isStatus();
                dados[i][0] = String.valueOf(u.getCodigo());
                dados[i][1] = u.getNome();
                dados[i][2] = u.getTipoUsuario();
                if(u.isStatus()){
                    dados[i][3] =String.valueOf("Ativo");
                }else{
                    dados[i][3] =String.valueOf("Inativo");
                }
                i++;
            }
            modeloDATabela(dados);
            JTabCadastro.updateUI();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private void BuscaCodigo(){
        u = new Usuario();
        try {
            u = daoUsuario.getUsuarioByCodigo(Integer.valueOf(TextCodMat.getText()));
            String dados[][] = new String[1][4];
            int i = 0;
           
                dados[i][0] = String.valueOf(u.getCodigo());
                dados[i][1] = u.getNome();
                dados[i][2] = u.getTipoUsuario();
               if(u.isStatus()){
                    dados[i][3] =String.valueOf("Ativo");
                }else{
                    dados[i][3] =String.valueOf("Inativo");
                }
            modeloDATabela(dados);
            JTabCadastro.updateUI();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private void BuscaTabela(){
        u = new Usuario();
        try {
            usuarios = (ArrayList<Usuario>) daoUsuario.BuscaUsuarios(TextDescri.getText());
            String dados[][] = new String[usuarios.size()][4];
            int i = 0;
            for (Usuario u : usuarios) {
                boolean a = u.isStatus();
                dados[i][0] = String.valueOf(u.getCodigo());
                dados[i][1] = u.getNome();
                dados[i][2] = u.getTipoUsuario();
                if(u.isStatus()){
                    dados[i][3] =String.valueOf("Ativo");
                }else{
                    dados[i][3] =String.valueOf("Inativo");
                }
                i++;
            }
            modeloDATabela(dados);

            JTabCadastro.updateUI();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }    private boolean camposVazios(){
        if( TextNome.getText().isEmpty()
                || PasswordFieldSenha.getText().isEmpty()
                || PasswordFieldConfirSenha.getText().isEmpty()
                || ComboBoxStatus.getSelectedItem().equals("")
                || ComboBoxTipoUsuario.getSelectedItem().equals("")){
            return false;
        }
        else{
            return true;
        }
    }    
    private void limpar(){
       TextCod.setText("");
       TextNome.setText("");
       PasswordFieldSenha.setText("");
       PasswordFieldConfirSenha.setText("");
       ComboBoxStatus.setSelectedIndex(0);
       ComboBoxTipoUsuario.setSelectedIndex(0);
       inicio();
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
            java.util.logging.Logger.getLogger(View_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_Usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoBusca;
    private javax.swing.JButton ButtonEditar;
    private javax.swing.JButton ButtonLimpar1;
    private javax.swing.JButton ButtonNovo;
    private javax.swing.JButton ButtonSair;
    private javax.swing.JButton ButtonSalvar;
    private javax.swing.JButton ButtonSalvarAlterar;
    private javax.swing.JComboBox<String> ComboBoxStatus;
    private javax.swing.JComboBox<String> ComboBoxTipoUsuario;
    private javax.swing.JTable JTabCadastro;
    private javax.swing.JPasswordField PasswordFieldConfirSenha;
    private javax.swing.JPasswordField PasswordFieldSenha;
    private javax.swing.JTextField TextCod;
    private javax.swing.JTextField TextCodMat;
    private javax.swing.JTextField TextDescri;
    private javax.swing.JTextField TextNome;
    private javax.swing.JButton botaoPesquisarCodigo;
    private javax.swing.JButton botaoTodos;
    private javax.swing.JButton jButton1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}