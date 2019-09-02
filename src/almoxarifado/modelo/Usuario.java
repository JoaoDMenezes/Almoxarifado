/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almoxarifado.modelo;

public class Usuario {
    //: código, nome, senha, repetir senha, tipo do usuário (administrado/operador), ativo ou inativos. 
private int codigo;
private String nome;
private String senha;
private String confSenha;
private String tipoUsuario;
private boolean status;

    public Usuario() {
    }

    public Usuario(int codigo, String nome, String senha, String confSenha, String tipoUsuario, boolean status) {
        this.codigo = codigo;
        this.nome = nome;
        this.senha = senha;
        this.confSenha = confSenha;
        this.tipoUsuario = tipoUsuario;
        this.status = status;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfSenha() {
        return confSenha;
    }

    public void setConfSenha(String confSenha) {
        this.confSenha = confSenha;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
