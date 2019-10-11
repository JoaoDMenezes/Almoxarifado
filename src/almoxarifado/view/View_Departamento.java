/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almoxarifado.view;

import almoxarifado.dao.CadastroDepartamento_Dao;
import almoxarifado.modelo.Departamento;
import almoxarifado.util.LimitaDigitos;
import almoxarifado.util.LimitaDigitosNum;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;



public class View_Departamento extends javax.swing.JFrame {
    Departamento departamento;
    CadastroDepartamento_Dao cDao;
    List<Departamento> departamentos;
    DefaultTableModel modelo = new DefaultTableModel();

    public View_Departamento() {
        departamento = new Departamento();
        cDao = new CadastroDepartamento_Dao();
        initComponents();
        TextCodigo.setDocument(new LimitaDigitosNum(11));
        TextNome.setDocument(new LimitaDigitos(30));
        TextNomeDep.setDocument(new LimitaDigitos(30));
        JTabCadastro.setRowSorter(new TableRowSorter(modelo));
        departamentos = new ArrayList<>();
        AtualizarTabela();
        inicio();
    }
    private void limpar(){
        inicio();
        TextCodigo.setText("");
        TextCod.setText("");
        TextNome.setText("");
    }
    private void inicio(){
        campo(false,false);
        botao(true, false, false, true, false, true,true);
    }
    private void alterar(){
        campo(false,true);
        botao(false, false, true, true, true, true, true);
    }    
    public void campo(boolean codigo ,boolean nome){
        this.TextNome.setEnabled(nome);
        this.TextCod.setEnabled(codigo);
    }
    private void botao(boolean novo, boolean salvar, boolean limpar, boolean sair,
        boolean alterar,boolean pesCodigo,boolean pesNome){
        ButtonNovo.setEnabled(novo);
        ButtonSalvar.setEnabled(salvar);
        ButtonLimpar.setEnabled(limpar);
        ButtonSair.setEnabled(sair);
        ButtonAlterar.setEnabled(alterar); 
        ButtonPesquiCod.setEnabled(pesCodigo);
        ButtonPesquiNome.setEnabled(pesNome);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TextNome = new javax.swing.JTextField();
        TextCod = new javax.swing.JTextField();
        ButtonNovo = new javax.swing.JButton();
        ButtonSair = new javax.swing.JButton();
        ButtonSalvar = new javax.swing.JButton();
        ButtonLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTabCadastro = new javax.swing.JTable();
        ButtonAlterar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        TextCodigo = new javax.swing.JTextField();
        ButtonPesquiCod = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        TextNomeDep = new javax.swing.JTextField();
        ButtonPesquiNome = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(232, 222, 200));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro de Departamento");

        jPanel1.setBackground(new java.awt.Color(230, 214, 165));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados de Cadastro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Código");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Nome");

        TextNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        TextCod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextCod, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextNome, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TextCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(TextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        ButtonNovo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/script_add.png"))); // NOI18N
        ButtonNovo.setText("Novo");
        ButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonNovoActionPerformed(evt);
            }
        });

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

        ButtonLimpar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonLimpar.setText("Limpar");
        ButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLimparActionPerformed(evt);
            }
        });

        JTabCadastro.setBackground(new java.awt.Color(230, 214, 165));
        JTabCadastro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTabCadastro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
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
        if (JTabCadastro.getColumnModel().getColumnCount() > 0) {
            JTabCadastro.getColumnModel().getColumn(0).setMinWidth(50);
            JTabCadastro.getColumnModel().getColumn(0).setPreferredWidth(100);
            JTabCadastro.getColumnModel().getColumn(0).setMaxWidth(100);
            JTabCadastro.getColumnModel().getColumn(1).setMinWidth(500);
            JTabCadastro.getColumnModel().getColumn(1).setPreferredWidth(500);
            JTabCadastro.getColumnModel().getColumn(1).setMaxWidth(700);
        }

        ButtonAlterar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonAlterar.setText("Alterar");
        ButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAlterarActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(230, 214, 165));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta de Departamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Código");

        ButtonPesquiCod.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonPesquiCod.setText("Buscar");
        ButtonPesquiCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPesquiCodActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Nome");

        ButtonPesquiNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonPesquiNome.setText("Buscar");
        ButtonPesquiNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPesquiNomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TextNomeDep, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonPesquiNome))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonPesquiCod)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonPesquiCod))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TextNomeDep, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonPesquiNome))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(ButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(37, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonLimpar)
                    .addComponent(ButtonAlterar)
                    .addComponent(ButtonSalvar)
                    .addComponent(ButtonNovo)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonSair)
                .addGap(0, 14, Short.MAX_VALUE))
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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSairActionPerformed
      int i = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja realmente Sair?");
        if (i == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_ButtonSairActionPerformed

    private void ButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonNovoActionPerformed
    int i = JOptionPane.showConfirmDialog(null, "Tem certeza que Deseja Realizar Registro?");
        if (i == 0) {
            limpar();
            campo(false,true);
            botao(false, true, true, true, false, true, true);
        } 
    }//GEN-LAST:event_ButtonNovoActionPerformed

    private void ButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalvarActionPerformed
     try {
            if (TextNome.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos os Campos precisa ser preenchido");
            } else {
                int s = JOptionPane.showConfirmDialog(null,"------- Salvar Como ------\nNome: "+TextNome.getText());
                   if(s==0){
                    departamento = new Departamento();
                    departamento.setNome(TextNome.getText());
                   

                    cDao.Salvar(departamento);
                     AtualizarTabela();
                     limpar();
                    JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso");
                } 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO!");
            e.printStackTrace();
        }
    }//GEN-LAST:event_ButtonSalvarActionPerformed

    private void JTabCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTabCadastroMouseClicked
         JOptionPane.showConfirmDialog(null, "Deseja selecionar a linha?");
        JTabCadastro.getModel();
        try {
            departamento = cDao.getDepartamentoByCodigo(Integer.parseInt(modelo.getValueAt(JTabCadastro.getSelectedRow(), 0).toString()));
            if (departamento == null) {
                JOptionPane.showMessageDialog(null, "Departamento não encontrado");
            } else {
                TextCod.setText(String.valueOf(departamento.getCodigo()));
                TextNome.setText(departamento.getNome());
                alterar();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_JTabCadastroMouseClicked

    private void ButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLimparActionPerformed
        limpar();
        inicio();
    }//GEN-LAST:event_ButtonLimparActionPerformed

    private void ButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAlterarActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Você deseja realmente atualizar os dados?");
        if (i == 0) {           
                    if (!TextNome.getText().isEmpty()) {
          int s = JOptionPane.showConfirmDialog(null,"------- Alterar Como ------\nNome: "+TextNome.getText());
           if(s==0){         
            departamento = new Departamento();
            departamento.setCodigo(Integer.parseInt(TextCod.getText()));
            departamento.setNome(TextNome.getText());
            try {
                cDao.Alterar(departamento);
            } catch (SQLException ex) {
                Logger.getLogger(View_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            AtualizarTabela();
            limpar();
           }
        }
        }
        
    }//GEN-LAST:event_ButtonAlterarActionPerformed

    private void ButtonPesquiCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPesquiCodActionPerformed
       try {
            if (TextCodigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Digite o Codigo para ser pesquisado");
            } else {
                departamento = cDao.getDepartamentoByCodigo(Integer.parseInt(TextCodigo.getText()));
            }

            if (departamento == null) {
                JOptionPane.showMessageDialog(null, "Departamento não encontrado");
            } else {
                TextCod.setText(String.valueOf(departamento.getCodigo()));
                TextNome.setText(departamento.getNome());
                               
//                dep = departamento.getNome();
                campo(false,false);
                botao(false, false, true,true, true, false,true);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }            TextNome.setText(departamento.getNome());
     
    }//GEN-LAST:event_ButtonPesquiCodActionPerformed

    private void ButtonPesquiNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPesquiNomeActionPerformed
        try {
            if (TextNomeDep.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Digite o Nome para ser pesquisado");
            } else {
                departamento = cDao.getDepartamentoPorNome(TextNomeDep.getText());
                
            }

            if (departamento == null) {
                JOptionPane.showMessageDialog(null, "Departamento não encontrado");
            } else {
               TextCod.setText(String.valueOf(departamento.getCodigo())); 
               TextNome.setText(departamento.getNome());
                                
//              dep = departamento.getNome();
                campo(false,false);
                botao(false, false, true,true,true,false,true);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }            TextNome.setText(departamento.getNome());
    }//GEN-LAST:event_ButtonPesquiNomeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            campo(false, true);
            botao(false, false, true, true, true, true, true);
    }//GEN-LAST:event_jButton1ActionPerformed
            //---------------------Fomataçao das tabelas--------------------------
    String tituloColuna[] = {"codigo", "nome",};
    public void modeloDATabela(String[][] a){
            modelo.setDataVector(a, tituloColuna);
            JTabCadastro.setModel(new DefaultTableModel(a,tituloColuna){
            boolean[] canEdit = new boolean[]{
                false,false
            };
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return canEdit[columnIndex];
            }
            });
            JTabCadastro.getColumnModel().getColumn(0).setPreferredWidth(100);
            JTabCadastro.getColumnModel().getColumn(1).setPreferredWidth(500);
            
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);            
            JTabCadastro.getColumnModel().getColumn(0).setCellRenderer(centralizado);            
            JTabCadastro.setRowHeight(25);    
            JTabCadastro.updateUI();
    }
    //---------------------------------------------------------------------
    public void AtualizarTabela() {
        //departamento = new Departamento();
        try {
            departamentos = cDao.TodosDepartamentosAtivos();
            String dados[][] = new String[departamentos.size()][3];
            int i = 0;
            for (Departamento u : departamentos) {
                dados[i][0] = String.valueOf(u.getCodigo());
                dados[i][1] = u.getNome();
                i++;
            }
            modeloDATabela(dados);
//            String tituloColuna[] = {"Código", "Nome"};
//            modelo.setDataVector(dados, tituloColuna);
//            JTabCadastro.setModel(modelo);
//            JTabCadastro.updateUI();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
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
            java.util.logging.Logger.getLogger(View_Departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_Departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_Departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_Departamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_Departamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAlterar;
    private javax.swing.JButton ButtonLimpar;
    private javax.swing.JButton ButtonNovo;
    private javax.swing.JButton ButtonPesquiCod;
    private javax.swing.JButton ButtonPesquiNome;
    private javax.swing.JButton ButtonSair;
    private javax.swing.JButton ButtonSalvar;
    private javax.swing.JTable JTabCadastro;
    private javax.swing.JTextField TextCod;
    private javax.swing.JTextField TextCodigo;
    private javax.swing.JTextField TextNome;
    private javax.swing.JTextField TextNomeDep;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
