package it.step.sixlesson.model;

public class Type {
    private String id;
    private String nameRus;
    private String nameKz;

    public Type() {
    }

    public Type(String id, String nameRus, String nameKz) {
        this.id = id;
        this.nameRus = nameRus;
        this.nameKz = nameKz;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameRus() {
        return nameRus;
    }

    public void setNameRus(String nameRus) {
        this.nameRus = nameRus;
    }

    public String getNameKz() {
        return nameKz;
    }

    public void setNameKz(String nameKz) {
        this.nameKz = nameKz;
    }
}
