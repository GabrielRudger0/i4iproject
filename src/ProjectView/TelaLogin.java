package ProjectView;

import ProjectController.ControllerTelaLogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TelaLogin {
    public JPanel painelTelaLogin;
    private ControllerTelaLogin controllerTelaLogin = new ControllerTelaLogin();
    private boolean emailAceito, senhaAceita;
    private JTextField campoEmail;
    private JPasswordField campoSenha;
    private JLabel labelEmail, labelSenha;
    private JButton botaoLogin;
public TelaLogin() {
    campoEmail.addFocusListener(new FocusAdapter() {
        @Override
        public void focusLost(FocusEvent e) {
            super.focusLost(e);
            emailAceito = controllerTelaLogin.validarAcessoPorEmail(campoEmail.getText());
        }
    });
    campoSenha.addFocusListener(new FocusAdapter() {
        @Override
        public void focusLost(FocusEvent e) {
            super.focusLost(e);
            senhaAceita = controllerTelaLogin.validarAcessoPorSenha(campoSenha.getPassword());
        }
    });
    botaoLogin.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            controllerTelaLogin.permiteAcesso(emailAceito, senhaAceita);
        }
    });
}
}
