/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almoxarifado.view;

import almoxarifado.dao.CadastroRequisitante_Dao;
import almoxarifado.modelo.Departamento;
import almoxarifado.modelo.Requisitante;
import almoxarifado.util.LimitaDigitos;
import almoxarifado.util.LimitaDigitosNum;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author bruna
 */
public class View_Requisitante extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    CadastroRequisitante_Dao dao_re;
    Requisitante requisitante;
    List<Requisitante> requisitantes;
    Departamento departamento;
    Vector<Departamento>departamentos;
    public View_Requisitante() throws SQLException {
        
        departamento = new Departamento();
        requisitante = new Requisitante();
        dao_re = new CadastroRequisitante_Dao();
        requisitantes = new ArrayList<>();
        initComponents();
        
        Tabela.setRowSorter(new TableRowSorter(modelo));
        TextCod.setDocument(new LimitaDigitosNum(11));
        TextCodigo.setDocument(new LimitaDigitosNum(11));
        TextObs.setDocument(new LimitaDigitos(50));
        TextNome.setDocument(new LimitaDigitos(30));
        TextNomeReq.setDocument(new LimitaDigitos(30));
        TextFuncao.setDocument(new LimitaDigitos(30));
        departamentos = new CadastroRequisitante_Dao().CampoBox();
        cbDepartamento.setModel(new DefaultComboBoxModel(departamentos)); 
        inicio();
        AtualizarTabela();
    }
   private void inicio(){
        Campos(false,false,false,false,false,false);
        botao(true, false, false, true, false, true, true);
    }
 private void botao(boolean novo, boolean salvar, boolean limpar, boolean sair, 
            boolean salvarAterar, boolean pesCodigo, boolean pesNome){
        ButtonNovo.setEnabled(novo);
        ButtonSalvar.setEnabled(salvar);
        ButtonLimpar.setEnabled(limpar);
        ButtonSair.setEnabled(sair);
        ButtonAlt.setEnabled(salvarAterar);
        ButtonPesqCodigo.setEnabled(pesCodigo);
        ButtonPesqNome.setEnabled(pesNome);
         
    } 
    
    
    public void Campos(boolean Tc, boolean Tn, boolean Tse,  boolean Tdep, boolean TO, boolean TS) {
        TextCod.setEnabled(Tc);
        TextNome.setEnabled(Tn);
        TextFuncao.setEnabled(Tse);
        cbDepartamento.setEnabled(Tdep);
        TextObs.setEnabled(TO);
        TextStatus.setEnabled(TS);

    }
     
//    public int validarAltReq() {
//        int vc = 0;
//        if (req2.equals(TextNome.getText())) {
//            JOptionPane.showMessageDialog(null, "Já existe um requisitante com este nome");
//        } else {
//            vc = 1;
//        }
//        return vc;
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ButtonNovo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TextCod = new javax.swing.JTextField();
        TextNome = new javax.swing.JTextField();
        TextObs = new javax.swing.JTextField();
        TextStatus = new javax.swing.JComboBox<>();
        cbDepartamento = new javax.swing.JComboBox<>();
        TextFuncao = new javax.swing.JTextField();
        ButtonSair = new javax.swing.JButton();
        ButtonSalvar = new javax.swing.JButton();
        ButtonLimpar = new javax.swing.JButton();
        ButtonAlt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        TextCodigo = new javax.swing.JTextField();
        ButtonPesqCodigo = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        TextNomeReq = new javax.swing.JTextField();
        ButtonPesqNome = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(232, 222, 200));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro de Requisitante");

        ButtonNovo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/script_add.png"))); // NOI18N
        ButtonNovo.setText("Novo");
        ButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonNovoActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(230, 214, 165));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados de Cadastro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel3.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Código");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(50, 30, 37, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Nome");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(220, 30, 32, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Departamento");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(16, 70, 88, 15);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Observação");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(20, 110, 73, 15);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Função");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(270, 70, 39, 15);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Status");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(490, 70, 39, 20);
        jPanel3.add(TextCod);
        TextCod.setBounds(110, 30, 100, 25);
        jPanel3.add(TextNome);
        TextNome.setBounds(260, 30, 390, 25);
        jPanel3.add(TextObs);
        TextObs.setBounds(110, 110, 540, 25);

        TextStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TextStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Ativo", "Inativo" }));
        jPanel3.add(TextStatus);
        TextStatus.setBounds(540, 70, 110, 25);

        jPanel3.add(cbDepartamento);
        cbDepartamento.setBounds(110, 70, 140, 25);

        TextFuncao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFuncaoActionPerformed(evt);
            }
        });
        jPanel3.add(TextFuncao);
        TextFuncao.setBounds(320, 70, 150, 25);

        ButtonSair.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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

        ButtonAlt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonAlt.setText("Alterar");
        ButtonAlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAltActionPerformed(evt);
            }
        });

        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Departamento", "Observação", "Função", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TabelaMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(Tabela);

        jPanel4.setBackground(new java.awt.Color(230, 214, 165));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta de Requisitantes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Código");

        ButtonPesqCodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonPesqCodigo.setText("Pesquisar");
        ButtonPesqCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPesqCodigoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Nome");

        TextNomeReq.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        ButtonPesqNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonPesqNome.setText("Pesquisar");
        ButtonPesqNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPesqNomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(TextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonPesqCodigo))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(TextNomeReq, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonPesqNome)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(TextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ButtonPesqCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(TextNomeReq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonPesqNome))
                .addGap(24, 24, 24))
        );

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Editar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(ButtonSair))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(19, 19, 19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 22, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(ButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ButtonSalvar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ButtonAlt)
                                        .addGap(15, 15, 15)
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ButtonLimpar)
                                        .addGap(10, 10, 10)))
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonSalvar)
                    .addComponent(ButtonAlt)
                    .addComponent(ButtonLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonNovo)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(ButtonSair)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void ButtonPesqNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPesqNomeActionPerformed
      try {
            if (TextNomeReq.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Digite o Nome para ser pesquisado");
            } else {
                requisitante = dao_re.getRequisitantePorNome(TextNomeReq.getText());
                
            }

            if (requisitante == null) {
                JOptionPane.showMessageDialog(null, "Requisitante não encontrado");
            } else {
                TextCod.setText(String.valueOf(requisitante.getCodigo()));
                TextFuncao.setText(requisitante.getFuncao());
                cbDepartamento.setSelectedItem(requisitante.getDepartamento());
                TextStatus.setSelectedItem(requisitante.getStatus());
                TextObs.setText(requisitante.getObservacao());

                Campos(false,true, true, true, true,true);
                botao(false, false, true, true, true, true, true);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }            TextNome.setText(requisitante.getNome());
    }//GEN-LAST:event_ButtonPesqNomeActionPerformed

    private void ButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonNovoActionPerformed
         int i = JOptionPane.showConfirmDialog(null, "Tem certeza que Deseja Realizar Cadastro?");
        if (i == 0) {
           limpar();
        Campos(false,true,true,true,true,true);
        botao(false, true, true, true, false, true, true);
        } 
    }//GEN-LAST:event_ButtonNovoActionPerformed

    private void ButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalvarActionPerformed
     try {
            if (TextNome.getText().isEmpty() || TextFuncao.getText().isEmpty() || cbDepartamento.getSelectedItem().equals("")|| TextStatus.getSelectedItem().equals("")|| TextObs.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos os Campos precisa ser preenchido");
            } else {
             int s = JOptionPane.showConfirmDialog(null,"------- Salvar Como ------\n"
                     + "Nome: "+TextNome.getText()+"\nFunção: "+TextFuncao.getText()
                      + "\nDepartamento "+ cbDepartamento.getSelectedItem().toString()+
                     "\nObs "+TextObs.getText());
                if(s==0){
                    departamento = dao_re.pegaDepartamento(String.valueOf(cbDepartamento.getSelectedItem()));
   
                    requisitante = new Requisitante();
                    requisitante.setNome(TextNome.getText());
                    requisitante.setFuncao(TextFuncao.getText());
                    requisitante.setDepartamento(departamento);
                    requisitante.setStatus(TextStatus.getItemAt(TextStatus.getSelectedIndex()));
                    requisitante.setObservacao(TextObs.getText());

                    dao_re.Salvar(requisitante);
                    AtualizarTabela();
                    limpar();
//
                    JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO!");
            e.printStackTrace();
        }
    }//GEN-LAST:event_ButtonSalvarActionPerformed

    private void ButtonPesqCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPesqCodigoActionPerformed
       try {
            if (TextCodigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Digite o Codigo para ser pesquisado");
            } else {
                requisitante = dao_re.getRequisitanteByCodigo(Integer.parseInt(TextCodigo.getText()));
            }
            if (requisitante == null) {
                JOptionPane.showMessageDialog(null, "Requisitante não encontrado");
            } else {
               // this.jTabbedPane4.setSelectedIndex(0);
                int a = Integer.valueOf(requisitante.getDepartamento().getCodigo());
                TextCod.setText(String.valueOf(requisitante.getCodigo()));
                TextFuncao.setText(requisitante.getFuncao());
                cbDepartamento.setSelectedIndex(a-1);
                TextStatus.setSelectedItem(requisitante.getStatus());
                TextObs.setText(requisitante.getObservacao());
                Campos(false,true, true, true, true,true);
                botao(false, false, true, true, true, true, true);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }            TextNome.setText(requisitante.getNome());
     
    }//GEN-LAST:event_ButtonPesqCodigoActionPerformed

    private void TabelaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_TabelaMouseEntered

    private void TabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaMouseClicked
      JOptionPane.showConfirmDialog(null, "Deseja selecionar a linha?");
        Tabela.getModel();
        try {
            requisitante = dao_re.getRequisitanteByCodigo(Integer.parseInt(modelo.getValueAt(Tabela.getSelectedRow(), 0).toString()));
            if (requisitante == null) {
                JOptionPane.showMessageDialog(null, "Requisitante não encontrado");
            } else {
              //   this.jTabbedPane4.setSelectedIndex(0);
               int a = Integer.valueOf(requisitante.getDepartamento().getCodigo());
                TextCod.setText(String.valueOf(requisitante.getCodigo()));
                TextNome.setText(requisitante.getNome());
                TextFuncao.setText(requisitante.getFuncao());
                cbDepartamento.setSelectedIndex(a - 1);
                TextStatus.setSelectedItem(requisitante.getStatus());
                TextObs.setText(requisitante.getObservacao());

                Campos(false,true, true, true, true,true);
                botao(false, false, true, true, true, true, true);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_TabelaMouseClicked

    private void ButtonAltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAltActionPerformed
      
            if (TextNome.getText().isEmpty() || TextFuncao.getText().isEmpty() || cbDepartamento.getSelectedItem().equals("") 
                    || TextStatus.getSelectedItem().equals("") || TextObs.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos campos devem ser preenchidos");
            } else {
                    try {
                        departamento = dao_re.pegaDepartamento(String.valueOf(cbDepartamento.getSelectedItem()));
                    } catch (SQLException ex) {
                        Logger.getLogger(View_Requisitante.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        Requisitante r = new Requisitante();
                        r.setCodigo(Integer.parseInt(TextCod.getText()));
                        r.setNome(TextNome.getText());
                        r.setFuncao(TextFuncao.getText());
                        r.setDepartamento(departamento);
                        r.setStatus((String) TextStatus.getSelectedItem());
                        r.setObservacao(TextObs.getText());
          try {
              dao_re.Alterar(r);
          } catch (SQLException ex) {
              Logger.getLogger(View_Requisitante.class.getName()).log(Level.SEVERE, null, ex);
          }
            AtualizarTabela();
            limpar();
            JOptionPane.showMessageDialog(null, "Cadastro Alterado com Sucesso");
            }
    }//GEN-LAST:event_ButtonAltActionPerformed

    private void ButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLimparActionPerformed
        limpar();
    }//GEN-LAST:event_ButtonLimparActionPerformed

    private void TextFuncaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFuncaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFuncaoActionPerformed
    private void limpar(){
       TextCod.setText("");
       TextNome.setText("");
       cbDepartamento.setSelectedIndex(0);
       TextObs.setText("");
       TextFuncao.setText("");
       TextStatus.setSelectedIndex(0);
       inicio();
    }
    
    //---------------------Fomataçao das tabelas--------------------------
    String tituloColuna[] = {"Codigo", "Nome", "Departamento", "Observação","Função", "Status"};
    public void modeloDATabela(String[][] a){
            modelo.setDataVector(a, tituloColuna);
            Tabela.setModel(new DefaultTableModel(a,tituloColuna){
            boolean[] canEdit = new boolean[]{
                false,false,false,false,false,false
            };
            public boolean isCellEditable(int rowIndex,int columnIndex){
                return canEdit[columnIndex];
            }
            });
            Tabela.getColumnModel().getColumn(0).setPreferredWidth(30);
            Tabela.getColumnModel().getColumn(1).setPreferredWidth(200);
            Tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
            Tabela.getColumnModel().getColumn(3).setPreferredWidth(200);
            Tabela.getColumnModel().getColumn(4).setPreferredWidth(100);
            Tabela.getColumnModel().getColumn(5).setPreferredWidth(70);
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);            
            Tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);            
            Tabela.setRowHeight(25);               
    }
    //---------------------------------------------------------------------
    public void AtualizarTabela() {
//        requisitante = new Requisitante();
        try {
            requisitantes = dao_re.TodosRequisitantesAtivos();
            String dados[][] = new String[requisitantes.size()][6];
            int i = 0;
            for (Requisitante u : requisitantes) {
                dados[i][0] = String.valueOf(u.getCodigo());
                dados[i][1] = u.getNome();
                dados[i][2] = String.valueOf(u.getDepartamento().getNome());
                dados[i][3] = u.getObservacao();
                dados[i][4] = u.getFuncao();
                dados[i][5] = u.getStatus();
                
                i++;
            }
            modeloDATabela(dados);
            Tabela.updateUI();
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
            java.util.logging.Logger.getLogger(View_Requisitante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_Requisitante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_Requisitante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_Requisitante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new View_Requisitante().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(View_Requisitante.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAlt;
    private javax.swing.JButton ButtonLimpar;
    private javax.swing.JButton ButtonNovo;
    private javax.swing.JButton ButtonPesqCodigo;
    private javax.swing.JButton ButtonPesqNome;
    private javax.swing.JButton ButtonSair;
    private javax.swing.JButton ButtonSalvar;
    private javax.swing.JTable Tabela;
    private javax.swing.JTextField TextCod;
    private javax.swing.JTextField TextCodigo;
    private javax.swing.JTextField TextFuncao;
    private javax.swing.JTextField TextNome;
    private javax.swing.JTextField TextNomeReq;
    private javax.swing.JTextField TextObs;
    private javax.swing.JComboBox<String> TextStatus;
    private javax.swing.JComboBox<String> cbDepartamento;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
