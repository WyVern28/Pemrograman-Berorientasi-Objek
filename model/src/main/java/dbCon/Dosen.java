package dbCon;

public class Dosen {
    private String nid, nama, id_prodi;

    public Dosen(String nid, String nama, String id_prodi) {
        this.nid = nid;
        this.nama = nama;
        this.id_prodi = id_prodi;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getId_prodi() {
        return id_prodi;
    }

    public void setId_prodi(String id_prodi) {
        this.id_prodi = id_prodi;
    }
}
