package projectController;

import projectDAO.MaterialDAO;
import projectDAO.UsuarioDAO;
import projectObject.MaterialObject;
import projectObject.UsuarioObject;

import java.util.List;

public class ControllerTelaComentario {

    public String retornaNomeDoUsuario(Integer usuarioId) {
        UsuarioDAO usuariosNoBanco = new UsuarioDAO();
        List<UsuarioObject> listaDeUsuarios = usuariosNoBanco.getUsuarios();
        String nome = null;

        for (UsuarioObject usuario: listaDeUsuarios) {
            if (usuario.getUsuarioId() == usuarioId) {
                nome = usuario.getUsuarioNome();
                break;
            }
        }

        return nome;
    }
    public String retornaNomeMaterial(Integer materialId) {
        MaterialDAO materiaisNoBanco = new MaterialDAO();
        List<MaterialObject> listaDeMateriais = materiaisNoBanco.getMateriais();
        String nome = null;

        for (MaterialObject materiais : listaDeMateriais) {
            if (materiais.getMaterialId() == materialId) {
                nome = materiais.getMaterialNome();
                break;
            }
        }

        return nome;
    }

}
