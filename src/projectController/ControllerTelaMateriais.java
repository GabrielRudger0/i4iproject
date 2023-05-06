package projectController;

import Main.ExecutaTelas;
import projectDAO.MaterialDAO;
import projectObject.MaterialObject;

import java.util.List;

public class ControllerTelaMateriais {
    public void excluirMaterial(Integer indexNaListaDeMateriais) {
        ExecutaTelas executaTelas = new ExecutaTelas();

        MaterialDAO materiaisNoBanco = new MaterialDAO();
        List<MaterialObject> listaDeMateriais = materiaisNoBanco.getMateriais();

        Integer idNoBanco = listaDeMateriais.get(indexNaListaDeMateriais).getMaterialId();
        materiaisNoBanco.delete(idNoBanco);

        ExecutaTelas.frameTelaMateriais.dispose();
        executaTelas.iniciarTelaMateriais();
    }
}
