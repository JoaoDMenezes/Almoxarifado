/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almoxarifado.modelo;


import java.util.Date;

public class Fornecedor {
  /* código, razão, nome fantasia,
    endereço(rua, numero, complemento, bairro, cidade, estado, cep),
    dados de contato (telefone 1, telefone 2, e-mail),
    dados contratuais (cnpj/cpf, inscrição estadual/RG, banco, agencia, conta), 
    data do cadastramento, Ativo/Inativo*/ 
    private int codigo;
    private String razao;
    private String nomeFantasia,cnpj_cpf,inscricaoEstadual_RG;
    private String rua,numero,complemento,bairro,cidade,estado,cep;
    private String banco,agencia,conta;
    private String telefone1,telefone2,email;
    private Date dataDoCadastro;

    public Fornecedor(int codigo, String razao, String nomeFantasia, String cnpj_cpf, String inscricaoEstadual_RG, String rua, String numero, String complemento, String bairro, String cidade, String estado, String cep, String banco, String agencia, String conta, String telefone1, String telefone2, String email, Date dataDoCadastro) {
        this.codigo = codigo;
        this.razao = razao;
        this.nomeFantasia = nomeFantasia;
        this.cnpj_cpf = cnpj_cpf;
        this.inscricaoEstadual_RG = inscricaoEstadual_RG;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.banco = banco;
        this.agencia = agencia;
        this.conta = conta;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.email = email;
        this.dataDoCadastro = dataDoCadastro;
    }

    public Fornecedor() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj_cpf() {
        return cnpj_cpf;
    }

    public void setCnpj_cpf(String cnpj_cpf) {
        this.cnpj_cpf = cnpj_cpf;
    }

    public String getInscricaoEstadual_RG() {
        return inscricaoEstadual_RG;
    }

    public void setInscricaoEstadual_RG(String inscricaoEstadual_RG) {
        this.inscricaoEstadual_RG = inscricaoEstadual_RG;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public Date getDataDoCadastro() {
        return dataDoCadastro;
    }

    public void setDataDoCadastro(Date dataDoCadastro) {
        this.dataDoCadastro = dataDoCadastro;
    }
    
    
    }
