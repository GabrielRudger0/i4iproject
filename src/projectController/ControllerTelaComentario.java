package projectController;

import projectDAO.MaterialDAO;
import projectDAO.UsuarioDAO;
import projectObject.MaterialObject;
import projectObject.UsuarioObject;

import java.util.HashMap;

public class ControllerTelaComentario {

    public String retornaNomeDoUsuario(Integer usuarioId) {
        UsuarioDAO usuariosNoBanco = new UsuarioDAO();
        HashMap<Integer, UsuarioObject> listaDeUsuarios = usuariosNoBanco.getUsuarios();
        String nome = null;

        for (Integer usuarioIdNoBanco : listaDeUsuarios.keySet()) {
            if (usuarioIdNoBanco == usuarioId) {
                nome = listaDeUsuarios.get(usuarioIdNoBanco).getUsuarioNome();
                break;
            }
        }

        return nome;
    }
    public static String retornaNomeMaterial(Integer materialId) {
        MaterialDAO materiaisNoBanco = new MaterialDAO();
        HashMap<Integer, MaterialObject> listaDeMateriais = materiaisNoBanco.getMateriais();
        String nome = null;

        for (Integer materiaisId : listaDeMateriais.keySet()) {
            if (materiaisId == materialId) {
                nome = listaDeMateriais.get(materiaisId).getMaterialNome();
                break;
            }
        }

        return nome;
    }

}
