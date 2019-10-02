/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almoxarifado.view;

import almoxarifado.dao.CadastroRequisitante_Dao;
import almoxarifado.modelo.Departamento;
import almoxarifado.modelo.Requisitante;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author bruna
 */
public class View_Requisitante extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    CadastroRequisitante_Dao cDao;
    Requisitante requisitante;
    String req = "";
    String req2;
    List<Requisitante> requisitantes;
    
    public View_Requisitante() {
        requisitante = new Requisitante();
        cDao = new CadastroRequisitante_Dao();
        
        initComponents();
        
        Tabela.setRowSorter(new TableRowSorter(modelo));
        
        requisitantes = new ArrayList<>();
       
        this.setVisible(true);
        
        
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
        TextDepartamento.setEnabled(Tdep);
        TextObs.setEnabled(TO);
        TextStatus.setEnabled(TS);

    }
     
    public int validarAltReq() {
        int vc = 0;
        if (req2.equals(TextNome.getText())) {
            JOptionPane.showMessageDialog(null, "Já existe um requisitante com este nome");
        } else {
            vc = 1;
        }
        return vc;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        TextDepartamento = new javax.swing.JComboBox<>();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(232, 222, 200));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Código");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Nome");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Departamento");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Observação");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Função");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Status");

        TextCod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        TextNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        TextObs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        TextStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TextStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Ativo", "Inativo" }));

        TextDepartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Garagem", "Oficina" }));

        TextFuncao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TextObs))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(TextDepartamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TextCod, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(TextNome, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 54, Short.MAX_VALUE)))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TextStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TextCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(TextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TextDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(TextStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(23, 23, 23))
        );

        ButtonSair.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/door_in.png"))); // NOI18N
        ButtonSair.setText("Sair");
        ButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSairActionPerformed(evt);
            }
        });

        ButtonSalvar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/disk.png"))); // NOI18N
        ButtonSalvar.setText("Salvar");
        ButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSalvarActionPerformed(evt);
            }
        });

        ButtonLimpar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonLimpar.setText("Limpar Dados");
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
                "Código", "Nome", "Departamento", "Observacao", "Funcao", "Status"
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(TextNomeReq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonPesqNome))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(ButtonSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonAlt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonLimpar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(ButtonSair))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(19, 19, 19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ButtonNovo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonSalvar)
                    .addComponent(ButtonAlt)
                    .addComponent(ButtonLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(ButtonSair)
                .addContainerGap())
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                requisitante = cDao.getRequisitantePorNome(TextNomeReq.getText());
                
            }

            if (requisitante == null) {
                JOptionPane.showMessageDialog(null, "Requisitante não encontrado");
            } else {
                // this.jTabbedPane4.setSelectedIndex(0);
                TextCod.setText(String.valueOf(requisitante.getCodigo()));
               TextFuncao.setText(requisitante.getFuncao());
                TextDepartamento.setSelectedItem(requisitante.getDepartamento());
                TextStatus.setSelectedItem(requisitante.getStatus());
                TextObs.setText(requisitante.getObservacao());
                                
                req = requisitante.getNome();
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
            if (TextNome.getText().isEmpty() || TextFuncao.getText().isEmpty() || TextDepartamento.getSelectedItem().equals("")|| TextStatus.getSelectedItem().equals("")|| TextObs.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos os Campos precisa ser preenchido");
            } else {
                    requisitante = new Requisitante();
                    requisitante.setNome(TextNome.getText());
                    requisitante.setFuncao(TextFuncao.getText());
                    requisitante.setDepartamento(TextDepartamento.getItemAt(TextDepartamento.getSelectedIndex()));
                    requisitante.setStatus(TextStatus.getItemAt(TextStatus.getSelectedIndex()));
                    requisitante.setObservacao(TextObs.getText());

                    cDao.Salvar(requisitante);
                    AtualizarTabela();
                    limpar();
//
                    JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso");
//                    Campos(false,false, false, false, false,false);
//                 botao(true, false, true,false,true,false,false,true);
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
                requisitante = cDao.getRequisitanteByCodigo(Integer.parseInt(TextCodigo.getText()));
                
            }

            if (requisitante == null) {
                JOptionPane.showMessageDialog(null, "Requisitante não encontrado");
            } else {
               // this.jTabbedPane4.setSelectedIndex(0);
                TextCod.setText(String.valueOf(requisitante.getCodigo()));
                TextFuncao.setText(requisitante.getFuncao());
                TextDepartamento.setSelectedItem(requisitante.getDepartamento());
                TextStatus.setSelectedItem(requisitante.getStatus());
                TextObs.setText(requisitante.getObservacao());
                                
                req = requisitante.getNome();
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
            requisitante = cDao.getRequisitanteByCodigo(Integer.parseInt(modelo.getValueAt(Tabela.getSelectedRow(), 0).toString()));
            if (requisitante == null) {
                JOptionPane.showMessageDialog(null, "Requisitante não encontrado");
            } else {
              //   this.jTabbedPane4.setSelectedIndex(0);
                TextCod.setText(String.valueOf(requisitante.getCodigo()));
                TextNome.setText(requisitante.getNome());
                TextFuncao.setText(requisitante.getFuncao());
                TextDepartamento.setSelectedItem(requisitante.getDepartamento());
                TextStatus.setSelectedItem(requisitante.getStatus());
                TextObs.setText(requisitante.getObservacao());


                req = requisitante.getNome();
                Campos(false,true, true, true, true,true);
                botao(false, false, true, true, true, true, true);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_TabelaMouseClicked

    private void ButtonAltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAltActionPerformed
      int i = JOptionPane.showConfirmDialog(null, "voce deseja realmente alterar o Cadastro?");
      
            if (TextNome.getText().isEmpty() || TextFuncao.getText().isEmpty() || TextDepartamento.getSelectedItem().equals("") 
                    || TextStatus.getSelectedItem().equals("") || TextObs.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos campos devem ser preenchidos");
            } else {
                        Requisitante r = new Requisitante();
                        r.setCodigo(Integer.parseInt(TextCod.getText()));
                        r.setNome(TextNome.getText());
                        r.setFuncao(TextFuncao.getText());
                        r.setDepartamento((String) TextDepartamento.getSelectedItem());
                        r.setStatus((String) TextStatus.getSelectedItem());
                        r.setObservacao(TextObs.getText());
          try {
              cDao.Alterar(r);
          } catch (SQLException ex) {
              Logger.getLogger(View_Requisitante.class.getName()).log(Level.SEVERE, null, ex);
          }
                        AtualizarTabela();
                        limpar();
                        JOptionPane.showMessageDialog(null, "Cadastro Alterado com Sucesso");
//                        Campos(false, true, true, true, true, true);
//            botao(false, false, true, true, true, true, true, false);
            }
    }//GEN-LAST:event_ButtonAltActionPerformed

    private void ButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLimparActionPerformed
        limpar();
    }//GEN-LAST:event_ButtonLimparActionPerformed
    private void limpar(){
       TextCod.setText("");
       TextNome.setText("");
       TextDepartamento.setSelectedIndex(0);
       TextObs.setText("");
       TextFuncao.setText("");
       TextStatus.setSelectedIndex(0);
       inicio();
    }
    public void AtualizarTabela() {
//        requisitante = new Requisitante();
        try {
            requisitantes = cDao.TodosRequisitantesAtivos();
            String dados[][] = new String[requisitantes.size()][6];
            int i = 0;
            for (Requisitante u : requisitantes) {
                dados[i][0] = String.valueOf(u.getCodigo());
                dados[i][1] = u.getNome();
                dados[i][2] = u.getDepartamento();
                dados[i][3] = u.getObservacao();
                dados[i][4] = u.getFuncao();
                dados[i][5] = u.getStatus();
                
                i++;
            }
            String tituloColuna[] = {"Codigo", "Nome", "Departamento", "Observação","Função", "Status"};
            modelo.setDataVector(dados, tituloColuna);
            
            Tabela.setModel(modelo);
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
                new View_Requisitante().setVisible(true);
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
    private javax.swing.JComboBox<String> TextDepartamento;
    private javax.swing.JTextField TextFuncao;
    private javax.swing.JTextField TextNome;
    private javax.swing.JTextField TextNomeReq;
    private javax.swing.JTextField TextObs;
    private javax.swing.JComboBox<String> TextStatus;
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
    // End of variables declaration//GEN-END:variables
}
