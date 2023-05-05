package projectController;

import projectDAO.UsuarioDAO;
import projectObject.UsuarioObject;

import javax.swing.*;
import java.util.List;

public class controllerTelaLogin {
    private UsuarioObject usuarioAtual = new UsuarioObject();
    private final UsuarioDAO usuarioBanco = new UsuarioDAO();
    private final List<UsuarioObject> listaDeUsuarios = usuarioBanco.getUsuarios();

    public boolean validarAcessoPorEmail(String emailDigitado) {
        boolean acessoPermitido = false;

        for (UsuarioObject usuario : listaDeUsuarios) {
            String emailNoBanco = usuario.getUsuarioEmail();

            if (emailDigitado.equals(emailNoBanco)) {
                acessoPermitido = true;
                usuarioAtual = usuario;
                break;
            }
        }

        return acessoPermitido;
    }
    public boolean validarAcessoPorSenha(char[] senhaProtegida) {
        boolean acessoPermitido = false;
        String senhaNoBanco = usuarioAtual.getUsuarioSenha();
        String senhaDigitada = new String(senhaProtegida);

        if (senhaDigitada.equals(senhaNoBanco)) {
            acessoPermitido = true;
        }

        return acessoPermitido;
    }

    public void permiteAcesso(boolean emailAceito, boolean senhaAceita) {

        if (emailAceito && senhaAceita) {
            JOptionPane.showMessageDialog(null, "Deu bom");
        } else {
            JOptionPane.showMessageDialog(null, "Erro: Email ou senha inválido", "Login", JOptionPane.ERROR_MESSAGE, null);
        }

    }

}
