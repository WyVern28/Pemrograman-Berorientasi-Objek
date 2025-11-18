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

    /**
     * 
     * @param idKelas -> String kasihnya idKelasnya aja
     * @param nim -> String kasihnya nimnya aja
     * @param nilai -> double kasih nilai yang di input dosen
     */
    public void kasihNilai(String idKelas,String nim,double nilai){
        NilaiRepository nilaiRepo = new NilaiRepository();
        if(!nilaiRepo.updateNilai(idKelas, nim, nilai)){
            throw new RuntimeException("Gagal Kasih Nilai");
        }
    }
}
