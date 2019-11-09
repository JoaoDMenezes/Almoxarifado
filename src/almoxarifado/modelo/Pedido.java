
package almoxarifado.modelo;

public class Pedido {

    public Pedido(int id, Material material, int requisicao, int quantidade) {
        this.id = id;
        this.material = material;
        this.requisicao = requisicao;
        this.quantidade = quantidade;
    }
    
    public Pedido() {
    }
    private int id;
    private Material material;
    private int requisicao;
    private int quantidade;
    //private double valorUni;

    public int getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(int requisicao) {
        this.requisicao = requisicao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

//    public double getValorUni() {
//        return valorUni;
//    }
//
//    public void setValorUni(double valorUni) {
//        this.valorUni = valorUni;
//    }
}
