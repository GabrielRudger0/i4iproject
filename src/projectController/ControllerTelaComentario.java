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
            labels[0].setText("null");
            labels[1].setText("null");
            labels[2].setText("null");
            desabilitaVisibilidade(labels);

        } else {
            String nomeUsuario = retornaNomeDoUsuario(comentario.getFKUsuarioId());
            String nomeMaterial = retornaNomeMaterial(comentario.getFKMaterialId());
            nomeMaterialNoTitulo.setText(nomeMaterial);

            labels[0].setText(nomeUsuario);
            labels[1].setText(comentario.getComentarioDescricao());
            labels[2].setText(comentario.getComentarioData());
        }
//        ComentarioDAO comentariosNoBanco = new ComentarioDAO();
//
//        List<Integer> listaIdsComentarios = listaIdsComentarioDoBanco();
//
//        HashMap<Integer, ComentarioObject> comentarios = comentariosNoBanco.getComentarios();
//        List<ComentarioObject> listaComentarios = new ArrayList<>();
//        Integer materialId = materialIdParaTelaComentario;
//        Integer comentarioId;
//
//        comentarioId = listaComentarios.get(posicaoNaTela).getComentarioId();
//
//        preencheCamposNulos(listaIdsComentarios, comentariosNoBanco);
//
//        if (comentarios.get(comentarioId).getFKMaterialId() == materialId) {
//
//            ComentarioObject comentario = comentarios.get(comentarioId);
//            String nomeUsuario = retornaNomeDoUsuario(comentario.getFKUsuarioId());
//            String nomeMaterial = retornaNomeMaterial(comentario.getFKMaterialId());
//            nomeMaterialNoTitulo.setText(nomeMaterial);
//
//            labels[0].setText(nomeUsuario);
//            labels[1].setText(comentario.getComentarioDescricao());
//            labels[2].setText(comentario.getComentarioData());
//        } else {
//            labels[0].setText("null");
//            labels[1].setText("null");
//            labels[2].setText("null");
//            desabilitaVisibilidade(labels);
//        }

    }

    //public static void

    public static List<Integer> listaIdsComentarioDoBanco() {
        ComentarioDAO comentariosNoBanco = new ComentarioDAO();
        HashMap<Integer, ComentarioObject> comentarios = comentariosNoBanco.getComentarios();
        List<Integer> listaIdsComentarios = new ArrayList<>();

        for (Integer comentarioId : comentarios.keySet()) {
            listaIdsComentarios.add(comentarios.get(comentarioId).getComentarioId());

        }
        for (int i = listaIdsComentarios.size() - 1; i < 4; i++) {
            Random rand = new Random();
            Integer numero = rand.nextInt(2147483647 - 1670818091 + 1) + 1670818091;

            listaIdsComentarios.add(numero);
        }

        return listaIdsComentarios;
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
    public static void preencheCamposNulos(List<Integer> listaIdsComentarios, ComentarioDAO comentariosNoBanco) {
        for (int i = listaIdsComentarios.size() - 1; i < 4; i++) {
            Random rand = new Random();
            Integer numero1 = rand.nextInt(2147483647 - 1670818091 + 1) + 1670818091;
            Integer numero2 = rand.nextInt(2147483647 - 1670818091 + 1) + 1670818091;

            ComentarioObject comentarioNulo = comentariosNoBanco.getComentarios().get(i);
            comentarioNulo.setFKMaterialId(numero1);
            comentarioNulo.setFKUsuarioId(numero2);
            comentarioNulo.setComentarioDescricao("null");
            comentarioNulo.setComentarioData("null");
        }
    }
    private static void desabilitaVisibilidade(JLabel[] labels) {
        labels[0].setVisible(false);
        labels[1].setVisible(false);
        labels[2].setVisible(false);
    }

}
