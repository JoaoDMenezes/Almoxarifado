/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almoxarifado.modelo;

/**
 *
 * @author User
 */
public class entrada {
    
   private String material,data,quantidade,fornecedor;

    public entrada(String material, String data, String quantidade, String fornecedor) {
        this.material = material;
        this.data = data;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
    }

    public entrada() {
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
    
}
