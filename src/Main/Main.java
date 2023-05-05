package Main;

import projectDAO.ComentarioDAO;
import projectDAO.MaterialDAO;
import projectDAO.UsuarioDAO;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO usuariosBanco = new UsuarioDAO();
        MaterialDAO materiaisBanco = new MaterialDAO();
        ComentarioDAO comentariosBanco = new ComentarioDAO();

        //Teste de conexão com o banco
        String id = usuariosBanco.getUsuarios().get(0).getUsuarioId();
        String nome = usuariosBanco.getUsuarios().get(0).getUsuarioNome();
        String email = usuariosBanco.getUsuarios().get(0).getUsuarioEmail();
        String senha = usuariosBanco.getUsuarios().get(0).getUsuarioSenha();

        JOptionPane.showMessageDialog(null, id + "\n" + nome + "\n" + email + "\n" + senha);
        //

        //Teste de conexão com o banco
        id = materiaisBanco.getMateriais().get(0).getMaterialId();
        nome = materiaisBanco.getMateriais().get(0).getMaterialNome();
        String descricao = materiaisBanco.getMateriais().get(0).getMaterialDescricao();
        Integer ativo = materiaisBanco.getMateriais().get(0).getMaterialAtivo();
        String data = materiaisBanco.getMateriais().get(0).getMaterialData();

        JOptionPane.showMessageDialog(null, id + "\n" + nome + "\n" + descricao + "\n" + ativo + "\n"+
                data);
        //

        //Teste de conexão com o banco
        id = comentariosBanco.getComentarios().get(0).getComentarioId();
        descricao = comentariosBanco.getComentarios().get(0).getComentarioDescricao();
        Integer materialId = comentariosBanco.getComentarios().get(0).getFKMaterialId();
        Integer usuarioId = comentariosBanco.getComentarios().get(0).getFKUsuarioId();
        data = comentariosBanco.getComentarios().get(0).getComentarioData();

        JOptionPane.showMessageDialog(null, id + "\n" + descricao + "\n" + materialId + "\n" + usuarioId + "\n"+
                data);
        //
    }
}