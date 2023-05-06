package projectView;

import projectDAO.MaterialDAO;
import projectObject.MaterialObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TelaCadastroMateriais {
    public JPanel panelCadastroMateriais;
    private JLabel nomeLabel, descricaoLabel, imagemLabel;
    private JTextField materialNome, materialDescricao, materialImagem;
    private JButton botaoCadastrar, botaoSim, botaoNao;
    private MaterialObject material = new MaterialObject();

public TelaCadastroMateriais() {

    materialNome.addFocusListener(new FocusAdapter() {
        @Override
        public void focusLost(FocusEvent e) {
            super.focusLost(e);
            material.setMaterialNome(materialNome.getText());
        }
    });
    materialDescricao.addFocusListener(new FocusAdapter() {
        @Override
        public void focusLost(FocusEvent e) {
            super.focusLost(e);
            material.setMaterialDescricao(materialDescricao.getText());
        }
    });
    materialImagem.addFocusListener(new FocusAdapter() {
        @Override
        public void focusLost(FocusEvent e) {
            super.focusLost(e);
            material.setMaterialImagem(materialImagem.getText());
        }
    });
    botaoSim.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            material.setMaterialAtivo(1);
        }
    });
    botaoNao.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            material.setMaterialAtivo(0);
        }
    });
    botaoCadastrar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            MaterialDAO materialBanco = new MaterialDAO();
            LocalDateTime now = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(now);
            material.setMaterialData(String.valueOf(timestamp));
            materialBanco.save(material);
            JOptionPane.showMessageDialog(null, "Material cadastrado com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }
    });

    }
}
