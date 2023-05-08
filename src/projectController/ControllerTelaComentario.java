package projectController;

import projectDAO.ComentarioDAO;
import projectDAO.MaterialDAO;
import projectDAO.UsuarioDAO;
import projectObject.ComentarioObject;
import projectObject.MaterialObject;
import projectObject.UsuarioObject;

import javax.swing.*;
import java.util.*;

public class ControllerTelaComentario {
    public static Integer materialIdParaTelaComentario;
    public static void setarInformacoesDosComentarios(JLabel[] labels, ComentarioObject comentario, JLabel nomeMaterialNoTitulo) {


        if (comentario == null) {
            desabilitaVisibilidade(labels);

        } else {
            String nomeUsuario = retornaNomeDoUsuario(comentario.getFKUsuarioId());
            String nomeMaterial = retornaNomeMaterial(comentario.getFKMaterialId());
            nomeMaterialNoTitulo.setText(nomeMaterial);

            labels[0].setText(nomeUsuario);
            labels[1].setText(comentario.getComentarioDescricao());
            labels[2].setText(comentario.getComentarioData());
        }

    }

    private static String retornaNomeDoUsuario(Integer usuarioId) {
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
    private static String retornaNomeMaterial(Integer materialId) {
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
    public static List<ComentarioObject> retornaListaComentariosDoMaterial() {
        ComentarioDAO comentarios = new ComentarioDAO();
        HashMap<Integer, ComentarioObject> listaComentariosNoBanco = comentarios.getComentarios();
        List<ComentarioObject> listaComentariosDeMaterial = new ArrayList<>();

        Integer materialId = materialIdParaTelaComentario;


        for (Integer keyComentarioId: listaComentariosNoBanco.keySet()) {
            Integer materialIdNoComentario = listaComentariosNoBanco.get(keyComentarioId).getFKMaterialId();

            if (materialIdNoComentario == materialId) {
                listaComentariosDeMaterial.add(listaComentariosNoBanco.get(keyComentarioId));
            }
        }
        /*
            For inicia na última posição preenchida com dados e,
            caso as posições posteriores estiverem sem comentários,
            preenche as posições com vazio;
         */
        for (int i = listaComentariosDeMaterial.size() - 1; i < 4; i++) {
            ComentarioObject comentarioVazio = null;
            listaComentariosDeMaterial.add(comentarioVazio);
        }
        return listaComentariosDeMaterial;
    }
    private static void desabilitaVisibilidade(JLabel[] labels) {

        //Desabilita a visibilidade dos campos na tela
        labels[0].setVisible(false);
        labels[1].setVisible(false);
        labels[2].setVisible(false);
    }

}
