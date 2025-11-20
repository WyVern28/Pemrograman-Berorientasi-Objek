package DTO;

import java.time.LocalTime;

import dbCon.Hari;

public class JadwalDTO {
    private String id_jadwal,namaKelas,id_ruangan;
    private Hari hari;
    private LocalTime jam_mulai, jam_selesai;

    public JadwalDTO(String id_jadwal, String namaKelas, String id_ruangan, Hari hari, LocalTime jam_mulai, LocalTime jam_selesai) {
        this.id_jadwal = id_jadwal;
        this.namaKelas = namaKelas;
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

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
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
