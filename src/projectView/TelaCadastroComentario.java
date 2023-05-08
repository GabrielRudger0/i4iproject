package projectView;

import Main.ExecutaTelas;
import projectController.ControllerTelaComentario;
import projectController.ControllerTelaLogin;
import projectDAO.ComentarioDAO;
import projectObject.ComentarioObject;
import projectObject.LimitadorCaracteres;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TelaCadastroComentario {
    public JPanel panelCadastroComentario;
    private JLabel nomeMaterialNoCadastro;
    private JTextArea textoComentario;
    private JButton botaoVoltar, botaoComentar;

    public TelaCadastroComentario() {
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExecutaTelas executaTelas = new ExecutaTelas();
                ExecutaTelas.frameTelaCadastroComentarios.dispose();
                executaTelas.iniciarTelaComentarios();
            }
        });
        botaoComentar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarComentario();
            }
        });

    }

    private void createUIComponents() {

        JPanel painel = new JPanel();
        painel.setPreferredSize(new Dimension(300, 250));

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

        textoComentario = campoTexto;
    }
    private void cadastrarComentario() {
        ComentarioObject comentario = new ComentarioObject();
        ComentarioDAO comentariosNoBanco = new ComentarioDAO();

        String comentarioDigitado = textoComentario.getText();
        comentario.setComentarioDescricao(comentarioDigitado);

        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        comentario.setComentarioData(String.valueOf(timestamp));

        comentario.setFKUsuarioId(ControllerTelaLogin.usuarioAtual);
        comentario.setFKMaterialId(ControllerTelaComentario.materialIdParaTelaComentario);

        comentariosNoBanco.save(comentario);
    }
}
