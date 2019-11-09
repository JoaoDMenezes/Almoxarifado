/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almoxarifado.controle;

import almoxarifado.dao.Dao_Requisicao;
import almoxarifado.modelo.Requisicao;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerRequisicao {
    Dao_Requisicao requisicao = new Dao_Requisicao();
    public ArrayList<Requisicao> lista() throws SQLException{
        return this.requisicao.ListaDeRequisicoes();
    }
    public void excluir(int codigo) throws SQLException{
        this.requisicao.excluir(codigo);
    }
    public int salvar(Requisicao requi){
        return this.requisicao.salvarRequisicaoDAO(requi);
    }
    
    public void apro(int codigo) throws SQLException{
        this.requisicao.aprovacaoNegativa(codigo);
    }
}
