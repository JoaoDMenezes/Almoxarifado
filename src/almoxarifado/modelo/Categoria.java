
package almoxarifado.modelo;

public class Categoria {
    private int codigo;
    private String nome;

    @Override
    public String toString() {
        return  nome ;
    }

    public Categoria() {
    }

    public Categoria(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
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
}
