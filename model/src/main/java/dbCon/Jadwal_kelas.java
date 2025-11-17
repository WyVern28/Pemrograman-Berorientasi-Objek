package dbCon;
import java.time.LocalTime;
public class Jadwal_kelas {
    private String id_jadwal,id_kelas,id_ruangan;
    private Hari hari;
    private LocalTime jam_mulai, jam_selesai;

    public Jadwal_kelas(String id_jadwal, String id_kelas, String id_ruangan, Hari hari, LocalTime jam_mulai, LocalTime jam_selesai) {
        this.id_jadwal = id_jadwal;
        this.id_kelas = id_kelas;
        this.id_ruangan = id_ruangan;
        this.hari = hari;
        this.jam_mulai = jam_mulai;
        this.jam_selesai = jam_selesai;
    }

    public String getId_jadwal() {
        return id_jadwal;
    }

    public void setId_jadwal(String id_jadwal) {
        this.id_jadwal = id_jadwal;
    }

    public String getId_kelas() {
        return id_kelas;
    }

    public void setId_kelas(String id_kelas) {
        this.id_kelas = id_kelas;
    }

    public String getId_ruangan() {
        return id_ruangan;
    }

    public void setId_ruangan(String id_ruangan) {
        this.id_ruangan = id_ruangan;
    }

    public Hari getHari() {
        return hari;
    }

    public void setHari(Hari hari) {
        this.hari = hari;
    }

    public LocalTime getJam_mulai() {
        return jam_mulai;
    }

    public void setJam_mulai(LocalTime jam_mulai) {
        this.jam_mulai = jam_mulai;
    }

    public LocalTime getJam_selesai() {
        return jam_selesai;
    }

    public void setJam_selesai(LocalTime jam_selesai) {
        this.jam_selesai = jam_selesai;
    }
}
