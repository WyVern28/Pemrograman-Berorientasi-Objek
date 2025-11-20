package logic;

import java.util.Collections;
import java.util.List;

import DTO.JadwalDTO;
import DTO.RegistrasiKelas;
import DTO.TranskripNilai;
import dbCon.Jadwal_kelas;
import dbCon.Mahasiswa;
import dbCon.Matkul;
import repo.JadwalKelasRepository;
import repo.KelasRepository;
import repo.MatkulRepository;
import repo.NilaiRepository;

public class FiturMahasiswa {
    /**
     * 
     * @param mhs
     * @return kalo listNilai kosong return list kosong
     * @return return list tipe data TranskripNiali dari model/DTO
     */
    public List<TranskripNilai> getTranskripNilaiByMahasiswa(Mahasiswa mhs){
        NilaiRepository nilaiRepo = new NilaiRepository();
        List<TranskripNilai> listNilai = nilaiRepo.getTranskripNilaiByNIM(mhs.getNim());
        if(listNilai.isEmpty()){
            return Collections.emptyList();
        }
        return listNilai;
    }

    /**
     * 
     * @param mhs
     * @return kalo mahasiswa ga punya jadwal kelas return list kosong
     * @return list dengan data type JadwalDTO
     */
    public List<JadwalDTO> getJadwalKelasByMahasiswa(Mahasiswa mhs){
        JadwalKelasRepository jadwalRepo = new JadwalKelasRepository();
        List<JadwalDTO> listJadwal = jadwalRepo.getJadwalKelasByNIM(mhs.getNim());
        if(listJadwal.isEmpty()){
            return Collections.emptyList();
        }
        return listJadwal;
    }

    /**
     * 
     * @param mhs -> object mahasiswa
     * @return list dengan dataType matkul yang ada di model
     */
    public List<Matkul> getMatkul(Mahasiswa mhs){
        MatkulRepository matkulRepo = new MatkulRepository();
        List<Matkul> listMatkul = matkulRepo.getMatkulByIdProdi(mhs.getId_prodi());
        if(listMatkul.isEmpty()){
            return Collections.emptyList();
        }
        return listMatkul;
    }

    /**
     * 
     * @param nim -> nim tipe data String
     * @param idMatkul -> idMatkul tipe data String
     * @return boolean -> kalo true ga ada matkul yang sama
     * @return boolean -> kalo false ada matkul yang sama
     */
    public boolean bisaAmbilMatkul(String nim,String idMatkul){
        NilaiRepository nilaiRepo = new NilaiRepository();

        return nilaiRepo.cekMatkulBisaAmbil(nim, idMatkul);
    }

    /**
     * 
     * @param matkul -> object matkul
     * @return List data typenya KelasDTO di model
     */
    public List<RegistrasiKelas> getKelas (Matkul matkul){
        KelasRepository kelasRepo = new KelasRepository();
        List<RegistrasiKelas> listKelas = kelasRepo.getKelasByIdMatkul(matkul.getId_matkul());
        if(listKelas.isEmpty()){
            return Collections.emptyList();
        }
        return listKelas;
    }

    /**
     * 
     * @param idKelas -> kirim idKelasnya aja
     * @return kalo jumlah muridnya lebih sedikit dari kapasitas true -> boleh masuk kelas
     * @return kalo jumlah muridnya lebih banyak dari kapasitas false -> ga boleh masuk kelas
     */
    public boolean cekAdaKelas(String idKelas){
        KelasRepository kelasRepo = new KelasRepository();
        NilaiRepository nilaiRepo = new NilaiRepository();
        int kapasitas = kelasRepo.getKapasitasKelas(idKelas);
        int jumlahMurid = nilaiRepo.cekBanyakMahasiswa(idKelas);

        return jumlahMurid < kapasitas;
    }

    /**
     * 
     * @param nim
     * @param idKelas
     * @return kalo listKelasnya kosong (tidak ada kelas tedaftar) -> ga ada kelas yang tabrakan -> false
     * @return boolean -> true -> tabrakan
     * @return boolean -> false -> tidak ada tabrakan
     */

    public boolean cekTabrakanJadwal(String nim, String idKelas){
        NilaiRepository nilaiRepo = new NilaiRepository();
        JadwalKelasRepository jadwalRepo = new JadwalKelasRepository();
        List<String> listIdKelas = nilaiRepo.getIdKelasByNIM(nim);

        if(listIdKelas.isEmpty()){
            return false;
        }
        Jadwal_kelas regisKelas = jadwalRepo.getJadwalByIdKelas(idKelas);
        for(String kelas : listIdKelas){
            Jadwal_kelas jadwal = jadwalRepo.getJadwalByIdKelas(kelas);

            if(regisKelas.getHari().equals(jadwal.getHari())){
                boolean bentrok = 
                regisKelas.getJam_selesai().isAfter(jadwal.getJam_mulai()) &&
                regisKelas.getJam_mulai().isBefore(jadwal.getJam_selesai());
    
                if (bentrok) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 
     * @param nim -> kirim nim tipe data String
     * @param idKelas -> kirim idKelas tipe datanya String
     */
    public void regisKelas(String nim,String idKelas){
        NilaiRepository nilaiRepo = new NilaiRepository();
        if(!nilaiRepo.InputNilai(nim, idKelas)){
            throw new RuntimeException("Gagal Regis");
        }
    }
}
