/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almoxarifado.modelo;

public class Requisitante {
   
    private int codigo;
    private String nome;
    private String departamento;
    private String observacao;
    private String funcao;
    private String status;

    public Requisitante() {
    }

    public Requisitante(int codigo, String nome, String departamento, String observacao, String funcao, String status) {
        this.codigo = codigo;
        this.nome = nome;
        this.departamento = departamento;
        this.observacao = observacao;
        this.funcao = funcao;
        this.status = status;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   
    
}
