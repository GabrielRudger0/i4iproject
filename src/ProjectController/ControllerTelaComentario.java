package ProjectController;

import Main.ExecutaTelas;
import ProjectDAO.ComentarioDAO;
import ProjectDAO.MaterialDAO;
import ProjectDAO.UsuarioDAO;
import ProjectObject.ComentarioObject;
import ProjectObject.FuncoesUtil;
import ProjectObject.MaterialObject;
import ProjectObject.UsuarioObject;

import javax.swing.*;
import java.util.*;

public class ControllerTelaComentario {
    public static Integer materialIdParaTelaComentario;
    public static void setarInformacoesDosComentarios(JLabel[] labels, JSeparator separador,
                                                      ComentarioObject comentario) {

        if (comentario == null) {
            desabilitaVisibilidade(labels, separador);

        } else {
            String nomeUsuario = retornaNomeDoUsuario(comentario.getFKUsuarioId());

            String data = FuncoesUtil.formatarData(comentario.getComentarioData());
            labels[0].setText(nomeUsuario);
            labels[1].setText(comentario.getComentarioDescricao());
            labels[2].setText(data);
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
    public static void iniciaCadastroDeComentario() {
        ComentarioDAO comentarios = new ComentarioDAO();
        HashMap<Integer, ComentarioObject> listaComentariosNoBanco = comentarios.getComentarios();
        Integer materialId = materialIdParaTelaComentario;
        Integer numeroComentarios = 0;

        /*
            For verifica quantos comentários no material existem;
            Logo após isso é verificado se o número de comentários está no limite (MAX: 4);
            Se não, inicia a tela de cadastro de comentário normalmente;
         */
        for (Integer keyComentarioId: listaComentariosNoBanco.keySet()) {
            Integer materialIdNoComentario = listaComentariosNoBanco.get(keyComentarioId).getFKMaterialId();

            if (materialIdNoComentario == materialId) {
                ++numeroComentarios;
            }
        }
        if (numeroComentarios == 4) {
            JOptionPane.showMessageDialog(null, "Lista de comentários cheia!",
                    "Cadastro de Comentário",JOptionPane.ERROR_MESSAGE);
        } else {
            ExecutaTelas executaTelas = new ExecutaTelas();
            ExecutaTelas.frameTelaComentarios.dispose();
            executaTelas.iniciarTelaCadastroComentarios();
        }
    }
    private static void desabilitaVisibilidade(JLabel[] labels, JSeparator separador) {

        //Desabilita a visibilidade dos campos na tela
        labels[0].setVisible(false);
        labels[1].setVisible(false);
        labels[2].setVisible(false);
        separador.setVisible(false);
    }

}
