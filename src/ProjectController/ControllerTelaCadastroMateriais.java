package ProjectController;

import ProjectDAO.MaterialDAO;
import ProjectObject.MaterialObject;
import ProjectView.TelaCadastroMateriais;

import javax.swing.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ControllerTelaCadastroMateriais {

    public static void inserirMaterialNoBanco(MaterialObject material) {
        if (validaCamposMaterial(material) == false) {
            JOptionPane.showMessageDialog(null, "Cadastro inválido! Verifique os campos", "Cadastro", JOptionPane.ERROR_MESSAGE);
        } else {
            MaterialDAO materialBanco = new MaterialDAO();
            LocalDateTime now = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(now);
            material.setMaterialData(String.valueOf(timestamp));

            materialBanco.save(material);
            JOptionPane.showMessageDialog(null, "Material cadastrado com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }

    }
    public static Boolean validaCamposMaterial(MaterialObject material) {
        Boolean cadastroValido = true;
        String materialNome = material.getMaterialNome();
        String materialDescricao = material.getMaterialDescricao();
        String materialImagem = material.getMaterialImagem();
        Boolean materialAtivo = TelaCadastroMateriais.materialAtivoVazio;

        if (materialNome == null) {
            cadastroValido = false;
        }
        if (materialDescricao == null) {
            cadastroValido = false;
        }
        if (materialImagem == null) {
            cadastroValido = false;
        }
        if (materialImagem == null) {
            cadastroValido = false;
        }
        if (materialAtivo == true) {
            cadastroValido = false;
        }

        return  cadastroValido;
    }
}
