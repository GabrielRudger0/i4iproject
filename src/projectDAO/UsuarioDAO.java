package projectDAO;

import com.mysql.jdbc.PreparedStatement;
import i4iproject.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public void save(projectObject.UsuarioObject usuarios){

        String sql = "INSERT INTO usuarios(UsuarioNome,UsuarioEmail,UsuarioSenha) VALUES(?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //cria conexao com banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, usuarios.getUsuarioNome());
            pstm.setString(2, usuarios.getUsuarioEmail());
            pstm.setString(3, usuarios.getUsuarioSenha());

            //executa a query

            pstm.execute();

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            //fechar a conexao

            try {
                if (pstm!=null){
                    pstm.close();
                }
                if (conn!=null){
                    conn.close();
                }
        }catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public List<projectObject.UsuarioObject> getUsuarios() {

        String sql = "SELECT * FROM usuarios";

        List<projectObject.UsuarioObject> usuarios = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstn = null;
        //pesquisa SELECT
        ResultSet rset = null;

        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            pstn = (PreparedStatement) conn.prepareStatement(sql);

            rset = pstn.executeQuery();


            while (rset.next()) {
                projectObject.UsuarioObject pegaUsuarios = new projectObject.UsuarioObject();

                //pegar dados
                pegaUsuarios.setUsuarioId(rset.getInt("UsuarioId"));
                pegaUsuarios.setUsuarioNome(rset.getString("UsuarioNome"));
                pegaUsuarios.setUsuarioEmail(rset.getString("UsuarioEmail"));
                pegaUsuarios.setUsuarioSenha(rset.getString("UsuarioSenha"));

                usuarios.add(pegaUsuarios);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {


                if (rset != null) {
                    rset.close();
                }
                if (pstn != null) {
                    pstn.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return usuarios;

    }
}
