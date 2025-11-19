package DTO;

public class RegistrasiKelas {
    private String id_kelas, nama_kelas, namaDosen, id_matkul;
    private int kapasitas, murid;

    
    public RegistrasiKelas(String id_kelas, String nama_kelas, String namaDosen, String id_matkul,int murid, int kapasitas) {
        this.id_kelas = id_kelas;
        this.nama_kelas = nama_kelas;
        this.namaDosen = namaDosen;
        this.id_matkul = id_matkul;
        this.murid = murid;
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
    
    public String getNamaDosen() {
        return namaDosen;
    }
    
    public void setNamaDosen(String namaDosen) {
        this.namaDosen = namaDosen;
    }
    
    public String getId_matkul() {
        return id_matkul;
    }
    
    public void setId_matkul(String id_matkul) {
        this.id_matkul = id_matkul;
    }
    
    public int getMurid() {
        return murid;
    }

    public void setMurid(int murid) {
        this.murid = murid;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }
}
