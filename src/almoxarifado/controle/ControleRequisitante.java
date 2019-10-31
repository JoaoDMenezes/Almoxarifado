
package almoxarifado.controle;

import almoxarifado.dao.CadastroRequisitante_Dao;
import almoxarifado.modelo.Requisitante;
import java.sql.SQLException;


public class ControleRequisitante {
    private CadastroRequisitante_Dao dao_requisitante= new CadastroRequisitante_Dao();
    
    public Requisitante retornaRequiCodigo(int codigo) throws SQLException{
        return this.dao_requisitante.getRequisitanteByCodigo(codigo);
    }
    public Requisitante retornaRequiNome(String nome) throws SQLException{
        return this.dao_requisitante.getRequisitantePorNome(nome);
    }   
    
}
