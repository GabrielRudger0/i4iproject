package projectDAO;

import com.mysql.jdbc.PreparedStatement;
import i4iproject.factory.ConnectionFactory;
import projectObject.MaterialObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;

public class MaterialDAO {

    public void save(projectObject.MaterialObject materiais){

        String sql = "INSERT INTO materiais(MaterialNome,MaterialDescricao,MaterialAtivo, MaterialData, MaterialImagem) VALUES(?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //cria conexao com banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, materiais.getMaterialNome());
            pstm.setString(2, materiais.getMaterialDescricao());
            pstm.setInt(3, materiais.getMaterialAtivo());
            pstm.setString (4, materiais.getMaterialData());
            pstm.setString (5, materiais.getMaterialImagem());

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
    public HashMap<Integer, MaterialObject> getMateriais() {

        String sql = "SELECT * FROM materiais";

        HashMap<Integer, MaterialObject> materiais = new HashMap<>();

        Connection conn = null;
        PreparedStatement pstn = null;
        //pesquisa SELECT
        ResultSet rset = null;

        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            pstn = (PreparedStatement) conn.prepareStatement(sql);

            rset = pstn.executeQuery();


            while (rset.next()) {
                projectObject.MaterialObject pegaMateriais = new projectObject.MaterialObject();

                //pegar dados
                pegaMateriais.setMaterialId(rset.getInt("MaterialId"));
                pegaMateriais.setMaterialNome(rset.getString("MaterialNome"));
                pegaMateriais.setMaterialDescricao(rset.getString("MaterialDescricao"));
                pegaMateriais.setMaterialAtivo(rset.getInt("MaterialAtivo"));
                pegaMateriais.setMaterialData(rset.getString("MaterialData"));
                pegaMateriais.setMaterialImagem(rset.getString("MaterialImagem"));

                materiais.put(pegaMateriais.getMaterialId(), pegaMateriais);
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

        return materiais;

    }
    public void delete(int id) {
        String sql = "DELETE FROM materiais WHERE MaterialId = ?";

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
