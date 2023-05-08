package projectController;

import Main.ExecutaTelas;
import projectDAO.UsuarioDAO;
import projectObject.UsuarioObject;

import javax.swing.*;
import java.util.HashMap;

public class ControllerTelaLogin {
    public static Integer usuarioAtual;
    private final UsuarioDAO usuarioBanco = new UsuarioDAO();
    private final HashMap<Integer, UsuarioObject> listaDeUsuarios = usuarioBanco.getUsuarios();

    public boolean validarAcessoPorEmail(String emailDigitado) {
        boolean acessoPermitido = false;

        for (Integer usuarioIdNoBanco : listaDeUsuarios.keySet()) {
            String emailNoBanco = listaDeUsuarios.get(usuarioIdNoBanco).getUsuarioEmail();

            if (emailDigitado.equals(emailNoBanco)) {
                acessoPermitido = true;
                usuarioAtual = usuarioIdNoBanco;
                break;
            }
        }

        return acessoPermitido;
    }
    public boolean validarAcessoPorSenha(char[] senhaProtegida) {
        boolean acessoPermitido = false;
        String senhaNoBanco = listaDeUsuarios.get(usuarioAtual).getUsuarioSenha();
        String senhaDigitada = new String(senhaProtegida);

        if (senhaDigitada.equals(senhaNoBanco)) {
            acessoPermitido = true;
        }

        return acessoPermitido;
    }

    public void permiteAcesso(boolean emailAceito, boolean senhaAceita) {
        if (emailAceito && senhaAceita) {
            ExecutaTelas executaTelas = new ExecutaTelas();
            ExecutaTelas.frameTelaLogin.dispose();
            executaTelas.iniciarTelaMateriais();
        } else {
            JOptionPane.showMessageDialog(null, "Erro: Email ou senha inválido", "Login", JOptionPane.ERROR_MESSAGE, null);
        }

    }

}
