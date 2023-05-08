package ProjectDAO;

import com.mysql.jdbc.PreparedStatement;
import i4iproject.factory.ConnectionFactory;
import ProjectObject.ComentarioObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;

public class ComentarioDAO {

    public void save(ProjectObject.ComentarioObject comentarios){

        String sql = "INSERT INTO comentarios(ComentarioDescricao, FKMaterialId, FKUsuarioId, ComentarioData) VALUES(?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //cria conexao com banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, comentarios.getComentarioDescricao());
            pstm.setInt(2, comentarios.getFKMaterialId());
            pstm.setInt(3, comentarios.getFKUsuarioId());
            pstm.setString (4, comentarios.getComentarioData());

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

    public HashMap<Integer, ComentarioObject> getComentarios() {

        String sql = "SELECT * FROM comentarios";

        HashMap<Integer, ComentarioObject> comentarios = new HashMap<>();

        Connection conn = null;
        PreparedStatement pstn = null;
        //pesquisa SELECT
        ResultSet rset = null;

        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            pstn = (PreparedStatement) conn.prepareStatement(sql);

            rset = pstn.executeQuery();


            while (rset.next()) {
                ProjectObject.ComentarioObject pegaComentarios = new ProjectObject.ComentarioObject();

                //pegar dados
                pegaComentarios.setComentarioId(rset.getInt("ComentarioId"));
                pegaComentarios.setComentarioDescricao(rset.getString("ComentarioDescricao"));
                pegaComentarios.setFKMaterialId(rset.getInt("FKMaterialId"));
                pegaComentarios.setFKUsuarioId(rset.getInt("FKUsuarioId"));
                pegaComentarios.setComentarioData(rset.getString("ComentarioData"));

                comentarios.put(pegaComentarios.getComentarioId(), pegaComentarios);
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

        return comentarios;

    }
    public void deletePorMaterial(int id) {
        String sql = "DELETE FROM comentarios WHERE FKMaterialId = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // cria conexao com banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setInt(1, id);

            // executa a query
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // fechar a conexao
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
