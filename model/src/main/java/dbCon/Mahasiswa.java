package dbCon;

public class Mahasiswa {
    private String nim, nama, id_prodi;
    private float ipk;
    private int totalSks;

    public Mahasiswa(String nim, String nama, String id_prodi, float ipk, int totalSks) {
        this.nim = nim;
        this.nama = nama;
        this.id_prodi = id_prodi;
        this.ipk = ipk;
        this.totalSks = totalSks;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
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

    public float getIpk() {
        return ipk;
    }

    public void setIpk(float ipk) {
        this.ipk = ipk;
    }

    public int getTotalSks() {
        return totalSks;
    }

    public void setTotalSks(int totalSks) {
        this.totalSks = totalSks;
    }
}
