package projectView;

import projectDAO.MaterialDAO;
import projectObject.MaterialObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaMateriais {
    public JPanel panelTelaMateriais;
    private JLabel processadorImagem, monitorImagem, mouseImagem, tecladoImagem;
    private JLabel materialNome1, materialDescricao1, materialData1, materialNome2, materialDescricao2, materialData2,
            materialNome3, materialDescricao3, materialData3, materialNome4, materialDescricao4, materialData4;
    private JLabel[] labels1 = {materialNome1, materialDescricao1, materialData1};
    private JLabel[] labels2 = {materialNome2, materialDescricao2, materialData2};
    private JLabel[] labels3 = {materialNome3, materialDescricao3, materialData3};
    private JLabel[] labels4 = {materialNome4, materialDescricao4, materialData4};
    private JButton botaoComentarios1, botaoComentarios2, botaoComentarios3, botaoComentarios4;
    private JButton botaoExcluirMaterial1, botaoExcluirMaterial2, botaoExcluirMaterial3, botaoExcluirMaterial4;
    private JButton[] botoes1 = {botaoComentarios1, botaoExcluirMaterial1};
    private JButton[] botoes2 = {botaoComentarios2, botaoExcluirMaterial2};
    private JButton[] botoes3 = {botaoComentarios3, botaoExcluirMaterial3};
    private JButton[] botoes4 = {botaoComentarios4, botaoExcluirMaterial4};

    public TelaMateriais() {

        setarInformacoesDosMateriais(labels1, processadorImagem, botoes1, 0);
        setarInformacoesDosMateriais(labels2, monitorImagem, botoes2, 1);
        setarInformacoesDosMateriais(labels3, mouseImagem, botoes3, 2);
        setarInformacoesDosMateriais(labels4, tecladoImagem, botoes4, 3);


        botaoComentarios1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        botaoComentarios2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        botaoComentarios3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        botaoComentarios4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        botaoExcluirMaterial1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        botaoExcluirMaterial2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        botaoExcluirMaterial3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        botaoExcluirMaterial4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void setarInformacoesDosMateriais(JLabel[] label, JLabel imagem, JButton[] botoes, Integer indexNaListaDeMateriais) {
        MaterialDAO materiaisNoBanco = new MaterialDAO();
        MaterialObject material = materiaisNoBanco.getMateriais().get(indexNaListaDeMateriais);

        if (material.getMaterialAtivo() != 0) {
            label[0].setText(material.getMaterialNome());
            label[1].setText("<html><p style=\"width:900px\">"+material.getMaterialDescricao()+"</html>");
            label[2].setText(material.getMaterialData());
        } else {
            botoes[0].setVisible(false);
            botoes[1].setVisible(false);
            imagem.setVisible(false);
            label[0].setVisible(false);
            label[1].setVisible(false);
            label[2].setVisible(false);
        }

    }

    private void createUIComponents() {

        processadorImagem = new JLabel(redimencionaImagem("Intel_Core_i9.png"));
        monitorImagem = new JLabel(redimencionaImagem("Monitor_Dell.png"));
        mouseImagem = new JLabel(redimencionaImagem("Mouse_Razer.png"));
        tecladoImagem = new JLabel(redimencionaImagem("Teclado_Microsoft.png"));
    }

    private ImageIcon redimencionaImagem(String nomeDoArquivo) {
        ImageIcon imagemDoMaterial = new ImageIcon(nomeDoArquivo);
        Image img = imagemDoMaterial.getImage();
        Image tamanhoPadraoImagem = img.getScaledInstance(125,125,Image.SCALE_SMOOTH);
        imagemDoMaterial = new ImageIcon(tamanhoPadraoImagem);
        return imagemDoMaterial;
    }
}
