/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almoxarifado.controle;

import almoxarifado.dao.Dao_CadastroMaterial;
import almoxarifado.modelo.Material;
import java.sql.SQLException;

public class ControllerMaterial {
    private Dao_CadastroMaterial daoMateria = new Dao_CadastroMaterial();
    
    public void salvarMaterialContro(Material material) throws SQLException{
        this.daoMateria.salvar(material);
    }
    public Material retornaMateriaCodigo(int codigo) throws SQLException{
        return this.daoMateria.getMaterialByCodigo(codigo);
    }
    public Material retornaRequiNome(String nome) throws SQLException{
        return this.daoMateria.getMateriaPorNome(nome);
    }
}
