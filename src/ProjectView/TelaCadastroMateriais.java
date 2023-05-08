package ProjectView;

import ProjectController.ControllerTelaCadastroMateriais;
import ProjectDAO.MaterialDAO;
import ProjectObject.MaterialObject;

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
    public static Boolean materialAtivoVazio = true;

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
            materialAtivoVazio = false;
            material.setMaterialAtivo(1);
        }
    });
    botaoNao.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            materialAtivoVazio = false;
            material.setMaterialAtivo(0);
        }
    });
    botaoCadastrar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ControllerTelaCadastroMateriais.inserirMaterialNoBanco(material);
        }
    });

    }
}
