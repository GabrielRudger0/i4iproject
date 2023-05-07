package projectView;

import Main.ExecutaTelas;
import projectController.ControllerTelaComentario;
import projectController.ControllerTelaMateriais;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaMateriais {
    public JPanel panelTelaMateriais;
    private JLabel processadorImagem, monitorImagem, mouseImagem, tecladoImagem, imagem5;
    private JLabel materialNome1, materialDescricao1, materialData1, materialNome2, materialDescricao2, materialData2,
            materialNome3, materialDescricao3, materialData3, materialNome4, materialDescricao4, materialData4,
            materialNome5, materialDescricao5, materialData5;
    private JButton botaoComentarios1, botaoComentarios2, botaoComentarios3, botaoComentarios4, botaoComentarios5;
    private JButton botaoExcluirMaterial1, botaoExcluirMaterial2, botaoExcluirMaterial3, botaoExcluirMaterial4,
            botaoExcluirMaterial5;
    private JLabel[] labels1 = {materialNome1, materialDescricao1, materialData1};
    private JLabel[] labels2 = {materialNome2, materialDescricao2, materialData2};
    private JLabel[] labels3 = {materialNome3, materialDescricao3, materialData3};
    private JLabel[] labels4 = {materialNome4, materialDescricao4, materialData4};
    private JLabel[] labels5 = {materialNome5, materialDescricao5, materialData5};
    private JButton[] botoes1 = {botaoComentarios1, botaoExcluirMaterial1};
    private JButton[] botoes2 = {botaoComentarios2, botaoExcluirMaterial2};
    private JButton[] botoes3 = {botaoComentarios3, botaoExcluirMaterial3};
    private JButton[] botoes4 = {botaoComentarios4, botaoExcluirMaterial4};
    private JButton[] botoes5 = {botaoComentarios5, botaoExcluirMaterial5};
    private List<Integer> listaIdsMaterial = ControllerTelaMateriais.listaIdsMaterialDoBanco();

    public TelaMateriais() {

        ControllerTelaMateriais.setarInformacoesDosMateriais(labels1, processadorImagem, botoes1, listaIdsMaterial.get(0));
        ControllerTelaMateriais.setarInformacoesDosMateriais(labels2, monitorImagem, botoes2, listaIdsMaterial.get(1));
        ControllerTelaMateriais.setarInformacoesDosMateriais(labels3, mouseImagem, botoes3, listaIdsMaterial.get(2));
        ControllerTelaMateriais.setarInformacoesDosMateriais(labels4, tecladoImagem, botoes4, listaIdsMaterial.get(3));
        ControllerTelaMateriais.setarInformacoesDosMateriais(labels5, imagem5, botoes5, listaIdsMaterial.get(4));

        botaoComentarios1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerTelaComentario.materialIdParaTelaComentario = listaIdsMaterial.get(0);
                executaTelaComentario();
            }
        });
        botaoComentarios2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerTelaComentario.materialIdParaTelaComentario = listaIdsMaterial.get(1);
                executaTelaComentario();
            }
        });
        botaoComentarios3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerTelaComentario.materialIdParaTelaComentario = listaIdsMaterial.get(2);
                executaTelaComentario();
            }
        });
        botaoComentarios4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerTelaComentario.materialIdParaTelaComentario = listaIdsMaterial.get(3);
                executaTelaComentario();
            }
        });
        botaoExcluirMaterial1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerTelaMateriais.excluirMaterial(listaIdsMaterial.get(0));
            }
        });
        botaoExcluirMaterial2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerTelaMateriais.excluirMaterial(listaIdsMaterial.get(1));
            }
        });
        botaoExcluirMaterial3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerTelaMateriais.excluirMaterial(listaIdsMaterial.get(2));
            }
        });
        botaoExcluirMaterial4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerTelaMateriais.excluirMaterial(listaIdsMaterial.get(3));
            }
        });
        botaoExcluirMaterial5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerTelaMateriais.excluirMaterial(listaIdsMaterial.get(4));
            }
        });
    }

    private void createUIComponents() {
        List<JLabel> listaImagens = ControllerTelaMateriais.retornaListarImagens();

        processadorImagem = listaImagens.get(0);
        monitorImagem = listaImagens.get(1);
        mouseImagem = listaImagens.get(2);
        tecladoImagem = listaImagens.get(3);
        imagem5 = listaImagens.get(4);
    }

    private void executaTelaComentario() {
        ExecutaTelas executaTelas = new ExecutaTelas();
        executaTelas.iniciarTelaComentarios();
        ExecutaTelas.frameTelaMateriais.dispose();
    }
}
