package projectObject;

public class ComentarioObject {

    private String comentarioId;
    private String comentarioDescricao;
    private int FKMaterialId;
    private int FKUsuarioId;
    private String comentarioData;

    public String getComentarioId() {
        return comentarioId;
    }

    public void setComentarioId(String comentarioId) {
        this.comentarioId = comentarioId;
    }

    public String getComentarioDescricao() {
        return comentarioDescricao;
    }

    public void setComentarioDescricao(String comentarioDescricao) {
        this.comentarioDescricao = comentarioDescricao;
    }

    public int getFKMaterialId() {
        return FKMaterialId;
    }

    public void setFKMaterialId(int FKMaterialId) {
        this.FKMaterialId = FKMaterialId;
    }

    public int getFKUsuarioId() {
        return FKUsuarioId;
    }

    public void setFKUsuarioId(int FKUsuarioId) {
        this.FKUsuarioId = FKUsuarioId;
    }

    public String getComentarioData() {
        return comentarioData;
    }

    public void setComentarioData(String comentarioData) {
        this.comentarioData = comentarioData;
    }
}
