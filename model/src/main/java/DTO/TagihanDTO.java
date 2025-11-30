package DTO;

public class TagihanDTO {
    private String idNilai;
    private String namaMatkul;
    private int sks;
    private double totalHarga;
    private String statusBayar;
    private boolean isSelected;

    public TagihanDTO(String idNilai, String namaMatkul, int sks, double totalHarga, String statusBayar) {
        this.idNilai = idNilai;
        this.namaMatkul = namaMatkul;
        this.sks = sks;
        this.totalHarga = totalHarga;
        this.statusBayar = statusBayar;
        this.isSelected = false;
    }

    public String getIdNilai() { return idNilai; }

    public void setIdNilai(String idNilai) { this.idNilai = idNilai; }

    public String getNamaMatkul() { return namaMatkul; }

    public void setNamaMatkul(String namaMatkul) { this.namaMatkul = namaMatkul; }

    public int getSks() { return sks; }

    public void setSks(int sks) { this.sks = sks; }

    public double getTotalHarga() { return totalHarga; }

    public void setTotalHarga(double totalHarga) { this.totalHarga = totalHarga; }

    public String getStatusBayar() { return statusBayar; }

    public void setStatusBayar(String statusBayar) { this.statusBayar = statusBayar; }

    public boolean isSelected() { return isSelected; }

    public void setSelected(boolean selected) { isSelected = selected; }
}