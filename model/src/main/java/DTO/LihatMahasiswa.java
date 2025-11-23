package DTO;

public class LihatMahasiswa {
    private String nama;
    private String nim;
    public LihatMahasiswa(String nim, String nama) {
        this.nama = nama;
        this.nim = nim;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getNim() {
        return nim;
    }
    public void setNim(String nim) {
        this.nim = nim;
    }
    
}
