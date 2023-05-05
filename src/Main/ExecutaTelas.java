package Main;

import projectView.TelaLogin;
import projectView.TelaMateriais;

import javax.swing.*;
import java.awt.*;

public class ExecutaTelas {

    public static JFrame frameTelaLogin = new JFrame("Login");
    public static JFrame frameTelaMateriais = new JFrame("Materiais");
    private static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public void iniciarTelaLogin() {

        frameTelaLogin.setContentPane(new TelaLogin().painelTelaLogin);
        frameTelaLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameTelaLogin.pack();
        frameTelaLogin.setVisible(true);
        frameTelaLogin.setLocation(dim.width/2-frameTelaLogin.getSize().width/2, dim.height/2-frameTelaLogin.getSize().height/2);
    }

    public void iniciarTelaMateriais() {

        frameTelaMateriais.setContentPane(new TelaMateriais().panelTelaMateriais);
        frameTelaMateriais.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameTelaMateriais.pack();
        frameTelaMateriais.setVisible(true);
        frameTelaMateriais.setLocation(dim.width/2-frameTelaMateriais.getSize().width/2, dim.height/2-frameTelaMateriais.getSize().height/2);
    }

}
