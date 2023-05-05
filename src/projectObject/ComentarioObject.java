package projectObject;

public class ComentarioObject {

    private int comentarioId;
    private String comentarioDescricao;
    private Integer FKMaterialId;
    private Integer FKUsuarioId;
    private String comentarioData;

    public int getComentarioId() {
        return comentarioId;
    }

    public void setComentarioId(Integer comentarioId) {
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

    public void setFKMaterialId(Integer FKMaterialId) {
        this.FKMaterialId = FKMaterialId;
    }

    public int getFKUsuarioId() {
        return FKUsuarioId;
    }

    public void setFKUsuarioId(Integer FKUsuarioId) {
        this.FKUsuarioId = FKUsuarioId;
    }

    public String getComentarioData() {
        return comentarioData;
    }

    public void setComentarioData(String comentarioData) {
        this.comentarioData = comentarioData;
    }
}
