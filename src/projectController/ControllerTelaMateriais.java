package projectController;

import projectDAO.MaterialDAO;
import projectObject.MaterialObject;
import projectView.TelaMateriais;

public class ControllerTelaMateriais {
    private TelaMateriais informacoesTela = new TelaMateriais();

    public void verificarAtivo(Integer indexNaListaDeMateriais) {
        MaterialDAO materiaisNoBanco = new MaterialDAO();
        MaterialObject material = materiaisNoBanco.getMateriais().get(indexNaListaDeMateriais);



    }
}
