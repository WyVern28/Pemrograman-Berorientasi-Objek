package dbCon;

public class SuperAdmin {
    private String id_sa,nama,jabatan,kontak;

    public SuperAdmin(String id_sa, String nama, String jabatan, String kontak) {
        this.id_sa = id_sa;
        this.nama = nama;
        this.jabatan = jabatan;
        this.kontak = kontak;
    }

    public String getId_sa() {
        return id_sa;
    }

    public void setId_sa(String id_sa) {
        this.id_sa = id_sa;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }
}
