
package almoxarifado.modelo;

public class Material {
    
    private int codigo;
    private String descricao;
    private Categoria categoria;
    private boolean consumivel;
    private String observacao;
    private int estoqueMinimo;
    private int estoqueMaximo;
    private float custoMedio;

    public Material() {
    }

    public Material(int codigo, String descricao, Categoria categoria, boolean consumivel, String observacao, int estoqueMinimo, int estoqueMaximo, float custoMedio) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.consumivel = consumivel;
        this.observacao = observacao;
        this.estoqueMinimo = estoqueMinimo;
        this.estoqueMaximo = estoqueMaximo;
        this.custoMedio = custoMedio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isConsumivel() {
        return consumivel;
    }

    public void setConsumivel(boolean consumivel) {
        this.consumivel = consumivel;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public int getEstoqueMaximo() {
        return estoqueMaximo;
    }

    public void setEstoqueMaximo(int estoqueMaximo) {
        this.estoqueMaximo = estoqueMaximo;
    }

    public float getCustoMedio() {
        return custoMedio;
    }

    public void setCustoMedio(float custoMedio) {
        this.custoMedio = custoMedio;
    }
    
}
