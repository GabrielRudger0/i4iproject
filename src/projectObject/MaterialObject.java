package projectObject;

public class MaterialObject {

    private Integer materialId;
    private String materialNome;
    private String materialDescricao;
    private Integer materialAtivo;
    private String materialData;

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public String getMaterialNome() {
        return materialNome;
    }

    public void setMaterialNome(String materialNome) {
        this.materialNome = materialNome;
    }

    public String getMaterialDescricao() {
        return materialDescricao;
    }

    public void setMaterialDescricao(String materialDescricao) {
        this.materialDescricao = materialDescricao;
    }

    public int getMaterialAtivo() {
        return materialAtivo;
    }

    public void setMaterialAtivo(Integer materialAtivo) {
        this.materialAtivo = materialAtivo;
    }

    public String getMaterialData() {
        return materialData;
    }

    public void setMaterialData(String materialData) {
        this.materialData = materialData;
    }
}
