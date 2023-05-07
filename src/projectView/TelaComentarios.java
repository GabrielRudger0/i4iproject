package projectView;

import projectController.ControllerTelaComentario;

import javax.swing.*;
import java.util.List;

public class TelaComentarios {
    public JPanel panelTelaComentarios;
    private JLabel usuario1, usuario2, usuario3, usuario4;
    private JLabel comentario1, comentario2, comentario3, comentario4;
    private JLabel data1, data2, data3, data4;
    private JLabel nomeMaterialNoComentario;
    private JLabel[] labels1 = {usuario1, comentario1, data1};
    private JLabel[] labels2 = {usuario2, comentario2, data2};
    private JLabel[] labels3 = {usuario3, comentario3, data3};
    private JLabel[] labels4 = {usuario4, comentario4, data4};
    private List<Integer> listaIdsComentarios = ControllerTelaComentario.listaIdsComentarioDoBanco();

public TelaComentarios() {

            ControllerTelaComentario.setarInformacoesDosComentarios(labels1, listaIdsComentarios.get(0), nomeMaterialNoComentario);
            ControllerTelaComentario.setarInformacoesDosComentarios(labels2, listaIdsComentarios.get(1), nomeMaterialNoComentario);
            ControllerTelaComentario.setarInformacoesDosComentarios(labels3, listaIdsComentarios.get(2), nomeMaterialNoComentario);
            ControllerTelaComentario.setarInformacoesDosComentarios(labels4, listaIdsComentarios.get(3), nomeMaterialNoComentario);

    }

}
