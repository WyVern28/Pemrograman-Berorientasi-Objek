package DTO;

public class TranskripNilai {
    private String idKelas;
    private String namaKelas;
    private double nilaiAkhir;
    
    public TranskripNilai(String idKelas, String namaKelas, double nilaiAkhir) {
        this.idKelas = idKelas;
        this.namaKelas = namaKelas;
        this.nilaiAkhir = nilaiAkhir;
    }
    
    public String getIdKelas() {
        return this.idKelas;
    }
    
    public void setIdKelas(String idKelas) {
        this.idKelas = idKelas;
    }
    public String getNamaKelas() {
        return this.namaKelas;
    }
    
    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }
    public double getNilaiAkhir() {
        return this.nilaiAkhir;
    }

    public void setNilaiAkhir(double nilaiAkhir) {
        this.nilaiAkhir = nilaiAkhir;
    }
}
