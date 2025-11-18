package logic;

import java.util.Collections;
import java.util.List;

import dbCon.Dosen;
import dbCon.Kelas;
import dbCon.Mahasiswa;
import repo.KelasRepository;
import repo.NilaiRepository;


public class FiturDosen {
    /**
     * 
     * @param dosen -> object dosen
     * @return -> list pake tipe data Kelas dari model
     */
    public List<Kelas> lihatKelas(Dosen dosen){
        KelasRepository kelasRepo = new KelasRepository();
        List<Kelas> listKelas = kelasRepo.getKelasByIdDosen(dosen.getNid());
        if(listKelas.isEmpty()){
            return Collections.emptyList();
        }
        return listKelas;
    }

    /**
     * 
     * @param kelas -> object kelas
     * @return -> list pake tipe data mahasiswa dari object
     */
    public List<Mahasiswa> lihatMahasiswa(Kelas kelas){
        NilaiRepository nilaiRepo = new NilaiRepository();
        List<Mahasiswa> listMahasiswa = nilaiRepo.getMahasiswaByIdKelas(kelas.getId_kelas());
        if(listMahasiswa.isEmpty()){
            return Collections.emptyList();
        }
        return listMahasiswa;
    }
}
