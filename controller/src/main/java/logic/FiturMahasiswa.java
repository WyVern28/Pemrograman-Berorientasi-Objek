package logic;

import java.util.Collections;
import java.util.List;

import dbCon.Jadwal_kelas;
import dbCon.Mahasiswa;
import repo.JadwalKelasRepository;
import repo.NilaiRepository;

public class FiturMahasiswa {
    /**
     * 
     * @param mhs
     * @return kalo listNilai kosong return list kosong
     * @return returnnya list yang tipe datanya array Object
     * [0] -> index 0 untuk id_kelas
     * [1] -> index 1 untuk nama_kelas
     * [2] -> index 2 untuk nilai_akhir
     */
    public List<Object[]> getTranskripNilaiByMahasiswa(Mahasiswa mhs){
        NilaiRepository nilaiRepo = new NilaiRepository();
        List<Object[]> listNilai = nilaiRepo.getNilaiByNIM(mhs.getNim());
        if(listNilai.isEmpty()){
            return Collections.emptyList();
        }
        return listNilai;
    }

    /**
     * 
     * @param mhs
     * @return kalo mahasiswa ga punya jadwal kelas return list kosong
     * @return list dengan data type Jadwal_Kelas
     */
    public List<Jadwal_kelas> getJadwalKelasByMahasiswa(Mahasiswa mhs){
        JadwalKelasRepository jadwalRepo = new JadwalKelasRepository();
        List<Jadwal_kelas> listJadwal = jadwalRepo.getJadwalKelasByNIM(mhs.getNim());
        if(listJadwal.isEmpty()){
            return Collections.emptyList();
        }
        return listJadwal;
    }
}
