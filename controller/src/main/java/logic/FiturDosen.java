package logic;

import java.util.Collections;
import java.util.List;

import DTO.LihatMahasiswa;
import dbCon.Dosen;
import dbCon.Kelas;
import repo.KelasRepository;
import repo.NilaiRepository;


public class FiturDosen {
    /**
     * 
     * @param dosen -> object dosen
     * @return -> kalo listKelas ga ada isinya return list kosong
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
     * @return -> kalo listMahasiswa ga ada isinya return list kosong
     * @return -> list pake tipe data LihatMahasiswa dari DTO
     */
    public List<LihatMahasiswa> lihatMahasiswa(Kelas kelas){
        NilaiRepository nilaiRepo = new NilaiRepository();
        List<LihatMahasiswa> listMahasiswa = nilaiRepo.getMahasiswaByIdKelas(kelas.getId_kelas());
        if(listMahasiswa.isEmpty()){
            return Collections.emptyList();
        }
        return listMahasiswa;
    }

    /**
     * 
     * @param idKelas -> String kasihnya idKelasnya aja
     * @param nim -> String kasihnya nimnya aja
     * @param nilai -> double kasih nilai yang di input dosen
     */
    public void kasihNilai(String idKelas,String nim,double nilai){
        NilaiRepository nilaiRepo = new NilaiRepository();
        if(nilai < 0 & nilai > 100){
            throw new RuntimeException("Nilai tidak boleh Kurang dari 0 dan lebih dari 100");
        }
        if(!nilaiRepo.updateNilai(idKelas, nim, nilai)){
            throw new RuntimeException("Gagal Kasih Nilai");
        }
    }
}
