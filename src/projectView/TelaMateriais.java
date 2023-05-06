package projectView;

import Main.ExecutaTelas;
import projectController.ControllerTelaMateriais;
import projectDAO.MaterialDAO;
import projectObject.MaterialObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaMateriais {
    public JPanel panelTelaMateriais;
    private ControllerTelaMateriais controller = new ControllerTelaMateriais();
    private JLabel processadorImagem, monitorImagem, mouseImagem, tecladoImagem, imagem5;
    private JLabel materialNome1, materialDescricao1, materialData1, materialNome2, materialDescricao2, materialData2,
            materialNome3, materialDescricao3, materialData3, materialNome4, materialDescricao4, materialData4,
            materialNome5, materialDescricao5, materialData5;
    private JLabel[] labels1 = {materialNome1, materialDescricao1, materialData1};
    private JLabel[] labels2 = {materialNome2, materialDescricao2, materialData2};
    private JLabel[] labels3 = {materialNome3, materialDescricao3, materialData3};
    private JLabel[] labels4 = {materialNome4, materialDescricao4, materialData4};
    private JLabel[] labels5 = {materialNome5, materialDescricao5, materialData5};
    private JButton botaoComentarios1, botaoComentarios2, botaoComentarios3, botaoComentarios4, botaoComentarios5;
    private JButton botaoExcluirMaterial1, botaoExcluirMaterial2, botaoExcluirMaterial3, botaoExcluirMaterial4,
            botaoExcluirMaterial5;
    private JButton[] botoes1 = {botaoComentarios1, botaoExcluirMaterial1};
    private JButton[] botoes2 = {botaoComentarios2, botaoExcluirMaterial2};
    private JButton[] botoes3 = {botaoComentarios3, botaoExcluirMaterial3};
    private JButton[] botoes4 = {botaoComentarios4, botaoExcluirMaterial4};
    private JButton[] botoes5 = {botaoComentarios5, botaoExcluirMaterial5};

    public TelaMateriais() {
        MaterialDAO materiaisNoBanco = new MaterialDAO();
        List<MaterialObject> listaDeMateriais = materiaisNoBanco.getMateriais();

        setarInformacoesDosMateriais(labels1, processadorImagem, botoes1, 0);
        setarInformacoesDosMateriais(labels2, monitorImagem, botoes2, 1);
        setarInformacoesDosMateriais(labels3, mouseImagem, botoes3, 2);
        setarInformacoesDosMateriais(labels4, tecladoImagem, botoes4, 3);
        setarInformacoesDosMateriais(labels5, imagem5, botoes5, listaDeMateriais.size()-1);


        botaoComentarios1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executaTelaComentario();
            }
        });
        botaoComentarios2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executaTelaComentario();
            }
        });
        botaoComentarios3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executaTelaComentario();
            }
        });
        botaoComentarios4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executaTelaComentario();
            }
        });
        botaoExcluirMaterial1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.excluirMaterial(0);
            }
        });
        botaoExcluirMaterial2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.excluirMaterial(1);
            }
        });
        botaoExcluirMaterial3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.excluirMaterial(2);
            }
        });
        botaoExcluirMaterial4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.excluirMaterial(3);
            }
        });
        botaoExcluirMaterial5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.excluirMaterial(listaDeMateriais.size()-1);
            }
        });
    }

    private void setarInformacoesDosMateriais(JLabel[] label, JLabel imagem, JButton[] botoes, Integer indexNaListaDeMateriais) {
        MaterialDAO materiaisNoBanco = new MaterialDAO();
        if (indexNaListaDeMateriais <= materiaisNoBanco.getMateriais().size() - 1) {
            MaterialObject material = materiaisNoBanco.getMateriais().get(indexNaListaDeMateriais);

        if (material.getMaterialAtivo() != 0) {
            label[0].setText(material.getMaterialNome());
            label[1].setText("<html><p style=\"width:900px\">"+material.getMaterialDescricao()+"</html>");
            label[2].setText(material.getMaterialData());
        } else {
            desabilitaVisibilidadeMaterial(label, imagem, botoes);
            }
        } else {
            desabilitaVisibilidadeMaterial(label, imagem, botoes);
        }
    }

    private void createUIComponents() {
        MaterialDAO materiaisNoBanco = new MaterialDAO();
        List<MaterialObject> listaDeMateriais = materiaisNoBanco.getMateriais();

        processadorImagem = new JLabel(redimencionaImagem(listaDeMateriais.get(0).getMaterialImagem()));
        monitorImagem = new JLabel(redimencionaImagem(listaDeMateriais.get(1).getMaterialImagem()));
        mouseImagem = new JLabel(redimencionaImagem(listaDeMateriais.get(2).getMaterialImagem()));
        tecladoImagem = new JLabel(redimencionaImagem(listaDeMateriais.get(3).getMaterialImagem()));
        imagem5 = new JLabel(redimencionaImagem(listaDeMateriais.get(listaDeMateriais.size()-1).getMaterialImagem()));
    }

    private ImageIcon redimencionaImagem(String nomeDoArquivo) {
        ImageIcon imagemDoMaterial = new ImageIcon(nomeDoArquivo);
        Image img = imagemDoMaterial.getImage();
        Image tamanhoPadraoImagem = img.getScaledInstance(125,125,Image.SCALE_SMOOTH);
        imagemDoMaterial = new ImageIcon(tamanhoPadraoImagem);
        return imagemDoMaterial;
    }
    private void desabilitaVisibilidadeMaterial(JLabel[] label, JLabel imagem, JButton[] botoes) {
        botoes[0].setVisible(false);
        botoes[1].setVisible(false);
        imagem.setVisible(false);
        label[0].setVisible(false);
        label[1].setVisible(false);
        label[2].setVisible(false);
    }
    private void executaTelaComentario() {
        ExecutaTelas executaTelas = new ExecutaTelas();
        executaTelas.iniciarTelaComentarios();
        ExecutaTelas.frameTelaMateriais.dispose();
    }
}
