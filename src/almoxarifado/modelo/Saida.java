
package almoxarifado.modelo;


public class Saida {
    
    private String material,data,quantidade,quantidadeAnterior,requisitante; 

    public Saida() {
    }

    public Saida(String material, String data, String quantidade, String quantidadeAnterior, String requisitante) {
        this.material = material;
        this.data = data;
        this.quantidade = quantidade;
        this.quantidadeAnterior = quantidadeAnterior;
        this.requisitante = requisitante;
    }
    

    public String getQuantidadeAnterior() {
        return quantidadeAnterior;
    }

    public void setQuantidadeAnterior(String quantidadeAnterior) {
        this.quantidadeAnterior = quantidadeAnterior;
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

    public String getRequisitante() {
        return requisitante;
    }

    public void setRequisitante(String requisitante) {
        this.requisitante = requisitante;
    }
    

}
