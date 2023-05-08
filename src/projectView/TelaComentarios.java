package projectView;

import Main.ExecutaTelas;
import projectController.ControllerTelaComentario;
import projectObject.ComentarioObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaComentarios {
    public JPanel panelTelaComentarios;
    private JLabel usuario1, usuario2, usuario3, usuario4;
    private JLabel comentario1, comentario2, comentario3, comentario4;
    private JLabel data1, data2, data3, data4;
    private JLabel nomeMaterialNoComentario;
    private JButton botaoCadastrarComentario, botaoVoltar;
    private JLabel[] labels1 = {usuario1, comentario1, data1};
    private JLabel[] labels2 = {usuario2, comentario2, data2};
    private JLabel[] labels3 = {usuario3, comentario3, data3};
    private JLabel[] labels4 = {usuario4, comentario4, data4};

public TelaComentarios() {

    List<ComentarioObject> listaComentarios = ControllerTelaComentario.retornaListaComentariosDoMaterial();

    ControllerTelaComentario.setarInformacoesDosComentarios(labels1, listaComentarios.get(0), nomeMaterialNoComentario);
    ControllerTelaComentario.setarInformacoesDosComentarios(labels2, listaComentarios.get(1), nomeMaterialNoComentario);
    ControllerTelaComentario.setarInformacoesDosComentarios(labels3, listaComentarios.get(2), nomeMaterialNoComentario);
    ControllerTelaComentario.setarInformacoesDosComentarios(labels4, listaComentarios.get(3), nomeMaterialNoComentario);

    botaoCadastrarComentario.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ExecutaTelas executaTelas = new ExecutaTelas();
            ExecutaTelas.frameTelaComentarios.dispose();
            executaTelas.iniciarTelaCadastroComentarios();
        }
    });
    botaoVoltar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ExecutaTelas executaTelas = new ExecutaTelas();
            ExecutaTelas.frameTelaComentarios.dispose();
            executaTelas.iniciarTelaMateriais();
        }
    });
}

}
