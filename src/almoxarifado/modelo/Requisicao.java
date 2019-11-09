
package almoxarifado.modelo;

import java.util.ArrayList;
import java.util.Date;

public class Requisicao {
    private int id;
    private Requisitante requisitante;
    private Date data;
    private double valorTotal;
    private ArrayList<Requisicao> listaRequisicao;
    private String Aprovacao;

    public String getAprovacao() {
        return Aprovacao;
    }

    public void setAprovacao(String Aprovacao) {
        this.Aprovacao = Aprovacao;
    }
    
    
    public Requisicao() {
    }

    public Date getData() {
        return data; 
    }

    public void setData(Date data) {
        this.data = data;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Requisitante getRequisitante() {
        return requisitante;
    }

    public void setRequisitante(Requisitante requisitante) {
        this.requisitante = requisitante;
    }

    public ArrayList<Requisicao> getListaRequisicao() {
        return listaRequisicao;
    }

    public void setListaRequisicao(ArrayList<Requisicao> listaRequisicao) {
        this.listaRequisicao = listaRequisicao;
    }

    /**
     * @return the valorTotal
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
}
