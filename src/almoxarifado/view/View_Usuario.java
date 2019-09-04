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
        ButtonAlterar.setEnabled(alterar); 
    }   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        ButtonSalvarAlterar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ButtonNovo = new javax.swing.JButton();
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
        ButtonSair = new javax.swing.JButton();
        ButtonSalvar = new javax.swing.JButton();
        ButtonLimpar1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        TextCodMat = new javax.swing.JTextField();
        TextDescri = new javax.swing.JTextField();
        botaoPesquisarCodigo = new javax.swing.JButton();
        BotaoBusca = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTabCadastro = new javax.swing.JTable();
        ButtonAlterar = new javax.swing.JButton();
        botaoTodos = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        ButtonSalvarAlterar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonSalvarAlterar.setText(" Alterar");
        ButtonSalvarAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSalvarAlterarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Cadastro de Usuario");

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
        jLabel3.setText("Nome");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(250, 30, 50, 20);

        TextNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TextNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextNomeActionPerformed(evt);
            }
        });
        jPanel1.add(TextNome);
        TextNome.setBounds(300, 30, 340, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Senha");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 70, 38, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Confirme sua Senha");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(330, 70, 130, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Tipo de Usuario");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 110, 100, 17);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Status");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(410, 110, 60, 17);

        TextCod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(TextCod);
        TextCod.setBounds(110, 30, 90, 30);
        jPanel1.add(PasswordFieldConfirSenha);
        PasswordFieldConfirSenha.setBounds(460, 70, 180, 30);

        PasswordFieldSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFieldSenhaActionPerformed(evt);
            }
        });
        jPanel1.add(PasswordFieldSenha);
        PasswordFieldSenha.setBounds(110, 70, 190, 30);

        ComboBoxStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Ativo", "Inativo" }));
        ComboBoxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxStatusActionPerformed(evt);
            }
        });
        jPanel1.add(ComboBoxStatus);
        ComboBoxStatus.setBounds(460, 110, 180, 30);

        ComboBoxTipoUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ComboBoxTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "administrador", "operador" }));
        jPanel1.add(ComboBoxTipoUsuario);
        ComboBoxTipoUsuario.setBounds(110, 110, 190, 30);

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

        ButtonLimpar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
                        .addComponent(ButtonNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonSalvarAlterar)
                        .addGap(212, 212, 212)
                        .addComponent(ButtonLimpar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonLimpar1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonSalvarAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cadastro", jPanel2);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setText("Consulta de Usuarios");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(10, 20, 180, 20);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Código");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(16, 55, 43, 17);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Busca");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(20, 110, 36, 17);

        TextCodMat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel3.add(TextCodMat);
        TextCodMat.setBounds(70, 50, 87, 30);

        TextDescri.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel3.add(TextDescri);
        TextDescri.setBounds(70, 100, 301, 30);

        botaoPesquisarCodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoPesquisarCodigo.setText("Pesquisar");
        botaoPesquisarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarCodigoActionPerformed(evt);
            }
        });
        jPanel3.add(botaoPesquisarCodigo);
        botaoPesquisarCodigo.setBounds(160, 50, 110, 30);

        BotaoBusca.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BotaoBusca.setText("Pesquisar");
        BotaoBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoBuscaActionPerformed(evt);
            }
        });
        jPanel3.add(BotaoBusca);
        BotaoBusca.setBounds(380, 100, 110, 30);

        JTabCadastro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTabCadastro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "TipoUsuario", "Status"
            }
        ));
        JTabCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTabCadastroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTabCadastro);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(20, 210, 640, 130);

        ButtonAlterar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonAlterar.setText("Alterar");
        ButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAlterarActionPerformed(evt);
            }
        });
        jPanel3.add(ButtonAlterar);
        ButtonAlterar.setBounds(520, 100, 110, 30);

        botaoTodos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botaoTodos.setText("Todos");
        botaoTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoTodosActionPerformed(evt);
            }
        });
        jPanel3.add(botaoTodos);
        botaoTodos.setBounds(20, 180, 80, 23);

        jButton1.setText("relatorio");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(420, 150, 73, 23);

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

        setSize(new java.awt.Dimension(695, 387));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
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
            String tituloColuna[] = {"codigo", "nome", "tipoUsuario", "status"};
            modelo.setDataVector(dados, tituloColuna);
            JTabCadastro.setModel(modelo);
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
                i++;
            String tituloColuna[] = {"codigo", "nome", "tipoUsuario", "status"};
            modelo.setDataVector(dados, tituloColuna);
            JTabCadastro.setModel(modelo);
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
            String tituloColuna[] = {"codigo", "nome", "tipoUsuario", "status"};
            modelo.setDataVector(dados, tituloColuna);
            JTabCadastro.setModel(modelo);
            JTabCadastro.updateUI();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private void ButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSairActionPerformed
         if(JOptionPane.showConfirmDialog(null, "Deseja realmente sair?") == 0)
     {
         this.dispose();
     }    
    }//GEN-LAST:event_ButtonSairActionPerformed

    private void PasswordFieldSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFieldSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordFieldSenhaActionPerformed

    private void TextNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextNomeActionPerformed

    private void ButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalvarActionPerformed
     boolean CV = camposVazios();
     if(CV){
         if(PasswordFieldSenha.getText().equals(PasswordFieldConfirSenha.getText())){
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
         }else{
              JOptionPane.showMessageDialog(null, "A senha nao confere");
         }
     }else{
                JOptionPane.showMessageDialog(null, "A campos a serem preenchidos");
     }
     
    }//GEN-LAST:event_ButtonSalvarActionPerformed
    private boolean camposVazios(){
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
    private void ButtonLimpar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLimpar1ActionPerformed
    limpar();
    }//GEN-LAST:event_ButtonLimpar1ActionPerformed

    private void ComboBoxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxStatusActionPerformed

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
            ButtonAlterar.setEnabled(true);
        }
    }//GEN-LAST:event_botaoPesquisarCodigoActionPerformed

    private void BotaoBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscaActionPerformed
        if(TextDescri.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Digite o que esta procurando");
        }else{
        BuscaTabela();
        }
    }//GEN-LAST:event_BotaoBuscaActionPerformed

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
            ButtonAlterar.setEnabled(true);
        }
    }//GEN-LAST:event_JTabCadastroMouseClicked

    private void ButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAlterarActionPerformed

        if(TextCodMat.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Escolha um para Alterar");
        }
        else{
            
            this.jTabbedPane1.setSelectedIndex(0);
            campo(false, true, true, true, true, true);
            botao(false, false, true, true, true, true, true, false);
            TextCodMat.setText("");
        }
    }//GEN-LAST:event_ButtonAlterarActionPerformed

    private void botaoTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoTodosActionPerformed
       atualizarTabela();
       TextCodMat.setText("");
       ButtonAlterar.setEnabled(false);
    }//GEN-LAST:event_botaoTodosActionPerformed

    private void ButtonSalvarAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalvarAlterarActionPerformed
    int o = JOptionPane.showConfirmDialog(null, "Você alterar os dados Cadastrados");
        if (o == 0) {
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
    }//GEN-LAST:event_ButtonSalvarAlterarActionPerformed

    private void ButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonNovoActionPerformed
        limpar();
        campo(false,true,true,true,true,true);
        botao(false, true, true, true, false, true, true, false);
    }//GEN-LAST:event_ButtonNovoActionPerformed

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
    private javax.swing.JButton ButtonAlterar;
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
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}