package dbCon;

public class Nilai {
    private String id_nilai, nim, id_kelas;
    private float nilai_akhir;
    private boolean status;
    private String status_bayar;

    public Nilai(String id_nilai, String nim, String id_kelas, float nilai_akhir, boolean status, String status_bayar) {
        this.id_nilai = id_nilai;
        this.nim = nim;
        this.id_kelas = id_kelas;
        this.nilai_akhir = nilai_akhir;
        this.status = status;
    }

    public String getStatus_bayar() {
        return status_bayar;
    }

    public void setStatus_bayar(String status_bayar) {
        this.status_bayar = status_bayar;
    }

    public String getId_nilai() {
        return id_nilai;
    }

    public void setId_nilai(String id_nilai) {
        this.id_nilai = id_nilai;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getId_kelas() {
        return id_kelas;
    }

    public void setId_kelas(String id_kelas) {
        this.id_kelas = id_kelas;
    }

    public float getNilai_akhir() {
        return nilai_akhir;
    }

    public void setNilai_akhir(float nilai_akhir) {
        this.nilai_akhir = nilai_akhir;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
