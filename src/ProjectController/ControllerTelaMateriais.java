package ProjectController;

import Main.ExecutaTelas;
import ProjectDAO.MaterialDAO;
import ProjectObject.MaterialObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ControllerTelaMateriais {

    public static void setarInformacoesDosMateriais(JLabel[] label, JLabel imagem, JButton[] botoes,
                                                    Integer materialId) {

        MaterialDAO materiaisNoBanco = new MaterialDAO();
        List<Integer> listaIdsMateriais = listaIdsMaterialDoBanco();

        if (materiaisNoBanco.getMateriais().size() - 1 <= listaIdsMateriais.size() - 1) {
            MaterialObject material = materiaisNoBanco.getMateriais().get(materialId);

            if (material == null) {
                label[0].setText("null");
                label[1].setText("null");
                label[2].setText("null");
                desabilitaVisibilidadeMaterial(label, imagem, botoes);

            } else {
                if (material.getMaterialAtivo() != 0) {
                    label[0].setText(material.getMaterialNome());
                    label[1].setText("<html><p style=\"width:900px\">"+material.getMaterialDescricao()+"</html>");
                    label[2].setText(material.getMaterialData());
                } else {
                    desabilitaVisibilidadeMaterial(label, imagem, botoes);
                }
            }

        } else {
            desabilitaVisibilidadeMaterial(label, imagem, botoes);
        }
    }
    public static void excluirMaterial(Integer materialId) {
        ExecutaTelas executaTelas = new ExecutaTelas();
        MaterialDAO materiaisNoBanco = new MaterialDAO();

        materiaisNoBanco.delete(materialId);
        ExecutaTelas.frameTelaMateriais.dispose();
        executaTelas.iniciarTelaMateriais();
    }

    public static List<Integer> listaIdsMaterialDoBanco() {
        MaterialDAO materiaisNoBanco = new MaterialDAO();
        HashMap<Integer, MaterialObject> materiais = materiaisNoBanco.getMateriais();
        List<Integer> listaIdsMateriais = new ArrayList<>();

        for (Integer materialId : materiais.keySet()) {
            listaIdsMateriais.add(materiais.get(materialId).getMaterialId());

        }
        for (int i = listaIdsMateriais.size() - 1; i < 5; i++) {
                Random rand = new Random();
                Integer numero = rand.nextInt(2147483647 - 1670818091 + 1) + 1670818091;
                listaIdsMateriais.add(numero);
        }

        return listaIdsMateriais;
    }

    public static List<JLabel> retornaListarImagens() {
        MaterialDAO materiaisNoBanco = new MaterialDAO();
        HashMap<Integer, MaterialObject> listaDeMateriais = materiaisNoBanco.getMateriais();

        List<Integer> listaIdsMateriais = ControllerTelaMateriais.listaIdsMaterialDoBanco();
        List<JLabel> imagens = new ArrayList<>();

        for (Integer index : listaIdsMateriais) {
            MaterialObject material = listaDeMateriais.get(index);
            if (material != null) {
                imagens.add(new JLabel(redimencionaImagem(material.getMaterialImagem())));
            }
        }
        for (int i = imagens.size() - 1; i < 5; i++) {
                imagens.add(new JLabel(redimencionaImagem("null")));
        }

        return imagens;
    }
    private static ImageIcon redimencionaImagem(String nomeDoArquivo) {

        ImageIcon imagemDoMaterial = new ImageIcon(nomeDoArquivo);
        Image img = imagemDoMaterial.getImage();
        Image tamanhoPadraoImagem = img.getScaledInstance(125,125,Image.SCALE_SMOOTH);
        imagemDoMaterial = new ImageIcon(tamanhoPadraoImagem);

        return imagemDoMaterial;
    }

    private static void desabilitaVisibilidadeMaterial(JLabel[] label, JLabel imagem, JButton[] botoes) {
        botoes[0].setVisible(false);
        botoes[1].setVisible(false);
        imagem.setVisible(false);
        label[0].setVisible(false);
        label[1].setVisible(false);
        label[2].setVisible(false);
    }

}
