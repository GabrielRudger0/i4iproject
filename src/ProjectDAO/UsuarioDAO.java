package ProjectDAO;

import com.mysql.jdbc.PreparedStatement;
import i4iproject.factory.ConnectionFactory;
import ProjectObject.UsuarioObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;

public class UsuarioDAO {

    public void save(ProjectObject.UsuarioObject usuarios){

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

    public HashMap<Integer, UsuarioObject> getUsuarios() {
        String sql = "SELECT * FROM usuarios";

        HashMap<Integer, UsuarioObject> usuarios = new HashMap<>();

        Connection conn = null;
        PreparedStatement pstn = null;
        //pesquisa SELECT
        ResultSet rset = null;

        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            pstn = (PreparedStatement) conn.prepareStatement(sql);

            rset = pstn.executeQuery();


            while (rset.next()) {
                ProjectObject.UsuarioObject pegaUsuarios = new ProjectObject.UsuarioObject();

                //pegar dados
                pegaUsuarios.setUsuarioId(rset.getInt("UsuarioId"));
                pegaUsuarios.setUsuarioNome(rset.getString("UsuarioNome"));
                pegaUsuarios.setUsuarioEmail(rset.getString("UsuarioEmail"));
                pegaUsuarios.setUsuarioSenha(rset.getString("UsuarioSenha"));

                usuarios.put(pegaUsuarios.getUsuarioId(), pegaUsuarios);
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
