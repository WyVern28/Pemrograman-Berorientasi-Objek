package dbCon;

public class Kelas {
    private String id_kelas, nama_kelas, nid, id_matkul;
    private int kapasitas;

    public Kelas(String id_kelas, String nama_kelas, String nid, String id_matkul, int kapasitas) {
        this.id_kelas = id_kelas;
        this.nama_kelas = nama_kelas;
        this.nid = nid;
        this.id_matkul = id_matkul;
        this.kapasitas = kapasitas;
    }

    public String getId_kelas() {
        return id_kelas;
    }

    public void setId_kelas(String id_kelas) {
        this.id_kelas = id_kelas;
    }

    public String getNama_kelas() {
        return nama_kelas;
    }

    public void setNama_kelas(String nama_kelas) {
        this.nama_kelas = nama_kelas;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getId_matkul() {
        return id_matkul;
    }

    public void setId_matkul(String id_matkul) {
        this.id_matkul = id_matkul;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }
}
