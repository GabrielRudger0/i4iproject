package projectView;

import projectObject.LimitadorCaracteres;

import javax.swing.*;
import java.awt.*;

public class TelaCadastroComentario {
    public JPanel panelCadastroComentario;
    private JLabel nomeMaterialNoCadastro;
    private JTextArea textArea1;

    private void createUIComponents() {

        JPanel painel = new JPanel();
        painel.setPreferredSize(new Dimension(300, 200));

        panelCadastroComentario = painel;

        JTextArea campoTexto = new JTextArea();
        campoTexto.setLineWrap(true);
        campoTexto.setWrapStyleWord(true);
        campoTexto.setRows(5);
        campoTexto.setDocument(new LimitadorCaracteres(180));
        campoTexto.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1), // borda preta de 1px
                BorderFactory.createEmptyBorder(2, 5, 2, 2) // borda vazia
        ));
        campoTexto.setMargin(new Insets(1, 1, 1, 1));

        textArea1 = campoTexto;
    }
}
