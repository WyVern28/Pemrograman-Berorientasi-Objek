package dbCon;

public class Ruangan {
    private String id_ruangan, nama_ruangan, lokasi_gedung;
    private int kapasitas_ruangan;

    public Ruangan(String id_ruangan, String nama_ruangan, String lokasi_gedung, int kapasitas_ruangan) {
        this.id_ruangan = id_ruangan;
        this.nama_ruangan = nama_ruangan;
        this.lokasi_gedung = lokasi_gedung;
        this.kapasitas_ruangan = kapasitas_ruangan;
    }

    public String getId_ruangan() {
        return id_ruangan;
    }

    public void setId_ruangan(String id_ruangan) {
        this.id_ruangan = id_ruangan;
    }

    public String getNama_ruangan() {
        return nama_ruangan;
    }

    public void setNama_ruangan(String nama_ruangan) {
        this.nama_ruangan = nama_ruangan;
    }

    public String getLokasi_gedung() {
        return lokasi_gedung;
    }

    public void setLokasi_gedung(String lokasi_gedung) {
        this.lokasi_gedung = lokasi_gedung;
    }

    public int getKapasitas_ruangan() {
        return kapasitas_ruangan;
    }

    public void setKapasitas_ruangan(int kapasitas_ruangan) {
        this.kapasitas_ruangan = kapasitas_ruangan;
    }
}
