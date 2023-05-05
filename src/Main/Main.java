package Main;

import projectDAO.UsuarioDAO;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO usuariosBanco = new UsuarioDAO();


        //Teste de conexão com o banco
        String id = usuariosBanco.getUsuarios().get(0).getUsuarioId();
        String nome = usuariosBanco.getUsuarios().get(0).getUsuarioNome();
        String email = usuariosBanco.getUsuarios().get(0).getUsuarioEmail();
        String senha = usuariosBanco.getUsuarios().get(0).getUsuarioSenha();

        JOptionPane.showMessageDialog(null, id + "\n" + nome + "\n" + email + "\n" + senha);
        //
    }
}