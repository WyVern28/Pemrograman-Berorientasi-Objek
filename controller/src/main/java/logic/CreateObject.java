package logic;

import dbCon.Dosen;
import dbCon.Mahasiswa;
import dbCon.SuperAdmin;
import repo.DosenRepository;
import repo.MahasiswaRepository;
import repo.SuperAdminRepository;

// Jadi kalo rolenya mahasiswa nanti CreateObject.createMahasiswa
//gitu seterusnya
public class CreateObject {
    /**
     * 
     * @param id -> id yang sebelumnya di input
     * @return Object Mahasiswa
     */
    public Mahasiswa createMahasiswa(String id){
        MahasiswaRepository mhsRepo = new MahasiswaRepository();
        Mahasiswa mahasiswa = mhsRepo.getMahasiswaById(id);
        if(mahasiswa == null){
            throw new RuntimeException("Mahasiswa tidak ditemukan");
        }
        return mahasiswa;
    }

    /**
     * 
     * @param id -> id yang sebelumnya di input
     * @return Object Dosen
     */
    public Dosen createDosen(String id){
        DosenRepository dosenRepo = new DosenRepository();
        Dosen dosen = dosenRepo.getDosenById(id);
        if(dosen == null){
            throw new RuntimeException("Dosen Tidak ditemukan");
        }
        return dosen;
    }

    /**
     * 
     * @param id -> id yang sebelumnya di input
     * @return Object SuperAdmin
     */
    public SuperAdmin createSuperAdmin(String id){
        SuperAdminRepository adminRepo = new SuperAdminRepository();
        SuperAdmin admin = adminRepo.getSuperAdminById(id);
        if(admin == null){
            throw new RuntimeException("SuperAdmin tidak ditemukan");
        }
        return admin;
    }
}
