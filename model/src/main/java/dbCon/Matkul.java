package dbCon;

public class Matkul {
    private String id_matkul,nama_matkul,id_prodi;
    private int sks;

    public Matkul(String id_matkul, String nama_matkul, String id_prodi, int sks) {
        this.id_matkul = id_matkul;
        this.nama_matkul = nama_matkul;
        this.id_prodi = id_prodi;
        this.sks = sks;
    }

    public String getId_matkul() {
        return id_matkul;
    }

    public void setId_matkul(String id_matkul) {
        this.id_matkul = id_matkul;
    }

    public String getNama_matkul() {
        return nama_matkul;
    }

    public void setNama_matkul(String nama_matkul) {
        this.nama_matkul = nama_matkul;
    }

    public String getId_prodi() {
        return id_prodi;
    }

    public void setId_prodi(String id_prodi) {
        this.id_prodi = id_prodi;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }
}
