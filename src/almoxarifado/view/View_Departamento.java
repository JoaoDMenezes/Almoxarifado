/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almoxarifado.view;

import almoxarifado.dao.CadastroDepartamento_Dao;
import almoxarifado.modelo.Departamento;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;



public class View_Departamento extends javax.swing.JFrame {
    DefaultTableModel modelo = new DefaultTableModel();
     CadastroDepartamento_Dao cDao;
    Departamento departamento;
    String dep = "";
    String dep2;
    List<Departamento> departamentos;
    public View_Departamento() {
        departamento = new Departamento();
        cDao = new CadastroDepartamento_Dao();
        initComponents();
        Tabela.setRowSorter(new TableRowSorter(modelo));
        departamentos = new ArrayList<>();
        this.setVisible(true);
        
        inicio();
        AtualizarTabela();
    }
    private void limpar(){
        inicio();
        TextCodigo.setText("");
        TextCod.setText("");
        TextNome.setText("");
    }
    private void inicio(){
        campo(false,false);
        botao(true, false, false, true, false, true, true,false);
    }
    public void campo(boolean codigo ,boolean nome){
        this.TextNome.setEnabled(nome);
        this.TextCod.setEnabled(codigo);
    }
    private void botao(boolean novo, boolean salvar, boolean limpar, boolean sair, 
            boolean salvarAterar, boolean pesCodigo, boolean pesNome, boolean alterar){
        ButtonNovo.setEnabled(novo);
        ButtonSalvar.setEnabled(salvar);
        ButtonLimpar.setEnabled(limpar);
        ButtonSair.setEnabled(sair);
        ButtonAlt.setEnabled(salvarAterar);
        ButtonPesquiCod.setEnabled(pesCodigo);
        ButtonPesquiNome.setEnabled(pesNome);
        ButtonAlterar.setEnabled(alterar); 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
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
        ButtonAlt = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TextCodigo = new javax.swing.JTextField();
        TextNomeDep = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        ButtonPesquiNome = new javax.swing.JButton();
        ButtonPesquiCod = new javax.swing.JButton();
        ButtonSairCons = new javax.swing.JButton();
        ButtonAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jTabbedPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Cadastro de Departamento");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados de Cadastro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Código");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
                .addComponent(TextCod, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextNome, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                .addContainerGap(60, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 20, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(ButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ButtonSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ButtonAlt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ButtonLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(113, 113, 113)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(66, 66, 66)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonAlt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cadastro", jPanel2);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Consulta de Departamento");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Código");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Nome");

        Tabela.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código", "Nome"
            }
        ));
        Tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabela);

        ButtonPesquiNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonPesquiNome.setText("Pesquisar");
        ButtonPesquiNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPesquiNomeActionPerformed(evt);
            }
        });

        ButtonPesquiCod.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonPesquiCod.setText("Pesquisar");
        ButtonPesquiCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPesquiCodActionPerformed(evt);
            }
        });

        ButtonSairCons.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonSairCons.setText("Sair");
        ButtonSairCons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSairConsActionPerformed(evt);
            }
        });

        ButtonAlterar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonAlterar.setText("Alterar");
        ButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextNomeDep, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ButtonPesquiNome)
                .addGap(43, 182, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ButtonPesquiCod))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addComponent(jLabel4)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(ButtonAlterar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonSairCons, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ButtonPesquiCod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5)))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextNomeDep, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(ButtonPesquiNome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(ButtonAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addComponent(ButtonSairCons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consulta", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void ButtonSairConsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSairConsActionPerformed
      int i = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja realmente Sair?");
        if (i == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_ButtonSairConsActionPerformed

    private void ButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonNovoActionPerformed
    int i = JOptionPane.showConfirmDialog(null, "Tem certeza que Deseja Realizar Cadastro?");
        if (i == 0) {
            limpar();
            campo(false,true);
            botao(false, true, true, true, false, true, true, false);
        } 
    }//GEN-LAST:event_ButtonNovoActionPerformed

    private void ButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalvarActionPerformed
     try {
            if (TextNome.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos os Campos precisa ser preenchido");
            } else {
                    departamento = new Departamento();
                    departamento.setNome(TextNome.getText());
                   

                    cDao.Salvar(departamento);
                     AtualizarTabela();
                     limpar();
                    JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso");
                    
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO!");
            e.printStackTrace();
        }
    }//GEN-LAST:event_ButtonSalvarActionPerformed

    private void TabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaMouseClicked
 JOptionPane.showConfirmDialog(null, "Deseja selecionar a linha?");
        Tabela.getModel();
        try {
            departamento = cDao.getDepartamentoByCodigo(Integer.parseInt(modelo.getValueAt(Tabela.getSelectedRow(), 0).toString()));
            if (departamento == null) {
                JOptionPane.showMessageDialog(null, "Departamento não encontrado");
            } else {
                TextCod.setText(String.valueOf(departamento.getCodigo()));
                TextNome.setText(departamento.getNome());
                dep = departamento.getNome();
                campo(false, false);
                botao(false,false,true,true,true,true,true,true);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_TabelaMouseClicked

    private void ButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLimparActionPerformed
        limpar();
        inicio();
    }//GEN-LAST:event_ButtonLimparActionPerformed

    private void ButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAlterarActionPerformed
         int i = JOptionPane.showConfirmDialog(null, "Você deseja realmente atualizar os dados?");
        if (i == 0) {
             this.jTabbedPane1.setSelectedIndex(0);
            campo(false, true);
            botao(false, false, true, true, true, true, true, true);
        }
        
    }//GEN-LAST:event_ButtonAlterarActionPerformed

    private void ButtonPesquiCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPesquiCodActionPerformed
       try {
            if (TextCodigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Digite o Codigo para ser pesquisado");
            } else {
                departamento = cDao.getDepartamentoByCodigo(Integer.parseInt(TextCodigo.getText()));
                this.jTabbedPane1.setSelectedIndex(0);
            }

            if (departamento == null) {
                JOptionPane.showMessageDialog(null, "Departamento não encontrado");
            } else {
                TextCod.setText(String.valueOf(departamento.getCodigo()));
                TextNome.setText(departamento.getNome());
                               
                dep = departamento.getNome();
                campo(false,false);
                botao(false, false, true,true,true, true, false,true);

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
                                
                dep = departamento.getNome();
                campo(false,false);
                botao(false, false, true,true,true,true,false,true);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }            TextNome.setText(departamento.getNome());
    }//GEN-LAST:event_ButtonPesquiNomeActionPerformed

    private void ButtonAltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAltActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "voce deseja realmente alterar o Cadastro?");
        try {
            if (TextNome.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos campos devem ser preenchidos");
            } else {
                        departamento.setCodigo(Integer.valueOf(TextCod.getText()));
                        departamento.setNome(TextNome.getText());
                        cDao.Alterar(departamento);
                        AtualizarTabela();
                        limpar();
                        JOptionPane.showMessageDialog(null, "Cadastro Alterado com Sucesso");
                       
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_ButtonAltActionPerformed
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
            String tituloColuna[] = {"Código", "Nome"};
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
    private javax.swing.JButton ButtonAlt;
    private javax.swing.JButton ButtonAlterar;
    private javax.swing.JButton ButtonLimpar;
    private javax.swing.JButton ButtonNovo;
    private javax.swing.JButton ButtonPesquiCod;
    private javax.swing.JButton ButtonPesquiNome;
    private javax.swing.JButton ButtonSair;
    private javax.swing.JButton ButtonSairCons;
    private javax.swing.JButton ButtonSalvar;
    private javax.swing.JTable Tabela;
    private javax.swing.JTextField TextCod;
    private javax.swing.JTextField TextCodigo;
    private javax.swing.JTextField TextNome;
    private javax.swing.JTextField TextNomeDep;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
