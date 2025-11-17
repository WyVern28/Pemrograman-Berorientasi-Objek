package dbCon;

public class Fakultas {
    private String id_fakultas, nama_fakultas;

    public Fakultas(String id_fakultas, String nama_fakultas) {
        this.id_fakultas = id_fakultas;
        this.nama_fakultas = nama_fakultas;
    }

    public String getId_fakultas() {
        return id_fakultas;
    }

    public void setId_fakultas(String id_fakultas) {
        this.id_fakultas = id_fakultas;
    }

    public String getNama_fakultas() {
        return nama_fakultas;
    }

    public void setNama_fakultas(String nama_fakultas) {
        this.nama_fakultas = nama_fakultas;
    }
}
