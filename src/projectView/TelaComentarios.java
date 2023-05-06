package projectView;

import projectController.ControllerTelaComentario;
import projectDAO.ComentarioDAO;
import projectObject.ComentarioObject;

import javax.swing.*;

public class TelaComentarios {
    public JPanel panelTelaComentarios;
    private ControllerTelaComentario controller = new ControllerTelaComentario();
    private JLabel usuario1, usuario2, usuario3, usuario4;
    private JLabel comentario1, comentario2, comentario3, comentario4;
    private JLabel data1, data2, data3, data4;
    private JLabel nomeMaterialNoComentario;
    private JLabel[] labels1 = {usuario1, comentario1, data1};
    private JLabel[] labels2 = {usuario2, comentario2, data2};
    private JLabel[] labels3 = {usuario3, comentario3, data3};
    private JLabel[] labels4 = {usuario4, comentario4, data4};

public TelaComentarios() {

            setarInformacoesDosComentarios(labels1, 0);
            setarInformacoesDosComentarios(labels2, 1);
            setarInformacoesDosComentarios(labels3, 2);
            setarInformacoesDosComentarios(labels4, 3);

    }
    private void setarInformacoesDosComentarios(JLabel[] labels, Integer indexComentarioNaLista) {
        ComentarioDAO comentariosNoBanco = new ComentarioDAO();

        if (indexComentarioNaLista <= comentariosNoBanco.getComentarios().size() - 1) {
            ComentarioObject comentario = comentariosNoBanco.getComentarios().get(indexComentarioNaLista);
            String nomeUsuario = controller.retornaNomeDoUsuario(comentario.getFKUsuarioId());
            String nomeMaterial = controller.retornaNomeMaterial(comentario.getFKMaterialId());
            nomeMaterialNoComentario.setText(nomeMaterial);

            labels[0].setText(nomeUsuario);
            labels[1].setText(comentario.getComentarioDescricao());
            labels[2].setText(comentario.getComentarioData());

        } else {
            labels[0].setVisible(false);
            labels[1].setVisible(false);
            labels[2].setVisible(false);
        }
    }
//    private void desabilitaVisibilidadeComentario(JLabel[] label) {
//        label[0].setVisible(false);
//        label[1].setVisible(false);
//        label[2].setVisible(false);
//    }
}
