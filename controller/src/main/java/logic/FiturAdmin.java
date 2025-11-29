package logic;

import java.util.Collections;
import java.util.List;

import DTO.RegistrasiKelas;
import dbCon.SuperAdmin;
import dbCon.Dosen;
import dbCon.Mahasiswa;
import dbCon.Kelas;
import dbCon.Matkul;
import repo.SuperAdminRepository;
import repo.DosenRepository;
import repo.MahasiswaRepository;
import repo.KelasRepository;
import repo.MatkulRepository;
import repo.UserRepository;

public class FiturAdmin {

    // ==================== SUPER ADMIN MANAGEMENT ====================

    /**
     * Menambahkan SuperAdmin baru
     * @param admin -> object SuperAdmin
     * @param password -> password untuk login
     * @return boolean -> true jika berhasil, false jika gagal
     */
    public boolean tambahSuperAdmin(SuperAdmin admin, String password) {
        SuperAdminRepository adminRepo = new SuperAdminRepository();

        // Validasi input
        if (admin.getId_sa() == null || admin.getId_sa().trim().isEmpty()) {
            throw new RuntimeException("ID SuperAdmin tidak boleh kosong");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new RuntimeException("Password tidak boleh kosong");
        }
        if (admin.getNama() == null || admin.getNama().trim().isEmpty()) {
            throw new RuntimeException("Nama tidak boleh kosong");
        }

        // Cek apakah ID sudah ada
        if (adminRepo.isIdExist(admin.getId_sa())) {
            throw new RuntimeException("ID SuperAdmin sudah terdaftar");
        }

        if (!adminRepo.createSuperAdmin(admin, password)) {
            throw new RuntimeException("Gagal menambahkan SuperAdmin");
        }
        return true;
    }

    /**
     * Mendapatkan SuperAdmin berdasarkan ID
     * @param id -> ID SuperAdmin
     * @return SuperAdmin object atau null jika tidak ditemukan
     */
    public SuperAdmin getSuperAdminById(String id) {
        SuperAdminRepository adminRepo = new SuperAdminRepository();
        SuperAdmin admin = adminRepo.getSuperAdminById(id);
        if (admin == null) {
            throw new RuntimeException("SuperAdmin dengan ID " + id + " tidak ditemukan");
        }
        return admin;
    }

    /**
     * Mendapatkan semua SuperAdmin
     * @return List SuperAdmin atau empty list
     */
    public List<SuperAdmin> getAllSuperAdmin() {
        SuperAdminRepository adminRepo = new SuperAdminRepository();
        List<SuperAdmin> listAdmin = adminRepo.getAllSuperAdmin();
        if (listAdmin.isEmpty()) {
            return Collections.emptyList();
        }
        return listAdmin;
    }

    /**
     * Update data SuperAdmin
     * @param admin -> object SuperAdmin dengan data baru
     * @return boolean -> true jika berhasil
     */
    public boolean updateSuperAdmin(SuperAdmin admin) {
        SuperAdminRepository adminRepo = new SuperAdminRepository();

        // Validasi input
        if (admin.getNama() == null || admin.getNama().trim().isEmpty()) {
            throw new RuntimeException("Nama tidak boleh kosong");
        }

        // Cek apakah admin exists
        if (!adminRepo.isIdExist(admin.getId_sa())) {
            throw new RuntimeException("SuperAdmin dengan ID " + admin.getId_sa() + " tidak ditemukan");
        }

        if (!adminRepo.updateSuperAdmin(admin)) {
            throw new RuntimeException("Gagal mengupdate SuperAdmin");
        }
        return true;
    }

    /**
     * Update password SuperAdmin
     * @param id -> ID SuperAdmin
     * @param newPassword -> password baru
     * @return boolean -> true jika berhasil
     */
    public boolean updatePasswordSuperAdmin(String id, String newPassword) {
        SuperAdminRepository adminRepo = new SuperAdminRepository();

        if (newPassword == null || newPassword.trim().isEmpty()) {
            throw new RuntimeException("Password tidak boleh kosong");
        }

        if (!adminRepo.updatePassword(id, newPassword)) {
            throw new RuntimeException("Gagal mengupdate password");
        }
        return true;
    }

    /**
     * Hapus SuperAdmin
     * @param id -> ID SuperAdmin yang akan dihapus
     * @return boolean -> true jika berhasil
     */
    public boolean hapusSuperAdmin(String id) {
        SuperAdminRepository adminRepo = new SuperAdminRepository();

        // Cek apakah admin exists
        if (!adminRepo.isIdExist(id)) {
            throw new RuntimeException("SuperAdmin dengan ID " + id + " tidak ditemukan");
        }

        if (!adminRepo.deleteSuperAdmin(id)) {
            throw new RuntimeException("Gagal menghapus SuperAdmin");
        }
        return true;
    }

    // ==================== DOSEN MANAGEMENT ====================

    /**
     * Mendapatkan Dosen berdasarkan ID
     * @param nid -> NID Dosen
     * @return Dosen object atau null jika tidak ditemukan
     */
    public Dosen getDosenById(String nid) {
        DosenRepository dosenRepo = new DosenRepository();
        Dosen dosen = dosenRepo.getDosenById(nid);
        if (dosen == null) {
            throw new RuntimeException("Dosen dengan NID " + nid + " tidak ditemukan");
        }
        return dosen;
    }

    /**
     * Validasi apakah user dengan role dosen exists
     * @param nid -> NID Dosen
     * @return boolean -> true jika exists
     */
    public boolean isDosenExist(String nid) {
        DosenRepository dosenRepo = new DosenRepository();
        return dosenRepo.getDosenById(nid) != null;
    }

    // ==================== MAHASISWA MANAGEMENT ====================

    /**
     * Mendapatkan Mahasiswa berdasarkan NIM
     * @param nim -> NIM Mahasiswa
     * @return Mahasiswa object atau null jika tidak ditemukan
     */
    public Mahasiswa getMahasiswaByNim(String nim) {
        MahasiswaRepository mhsRepo = new MahasiswaRepository();
        Mahasiswa mhs = mhsRepo.getMahasiswaById(nim);
        if (mhs == null) {
            throw new RuntimeException("Mahasiswa dengan NIM " + nim + " tidak ditemukan");
        }
        return mhs;
    }

    /**
     * Validasi apakah mahasiswa exists
     * @param nim -> NIM Mahasiswa
     * @return boolean -> true jika exists
     */
    public boolean isMahasiswaExist(String nim) {
        MahasiswaRepository mhsRepo = new MahasiswaRepository();
        return mhsRepo.getMahasiswaById(nim) != null;
    }

    // ==================== KELAS MANAGEMENT ====================

    /**
     * Mendapatkan kelas berdasarkan NID Dosen
     * @param nid -> NID Dosen
     * @return List Kelas atau empty list
     */
    public List<Kelas> getKelasByDosen(String nid) {
        KelasRepository kelasRepo = new KelasRepository();
        List<Kelas> listKelas = kelasRepo.getKelasByIdDosen(nid);
        if (listKelas.isEmpty()) {
            return Collections.emptyList();
        }
        return listKelas;
    }

    /**
     * Mendapatkan kelas berdasarkan ID Mata Kuliah
     * @param idMatkul -> ID Mata Kuliah
     * @return List RegistrasiKelas atau empty list
     */
    public List<RegistrasiKelas> getKelasByMatkul(String idMatkul) {
        KelasRepository kelasRepo = new KelasRepository();
        List<RegistrasiKelas> listKelas = kelasRepo.getKelasByIdMatkul(idMatkul);
        if (listKelas.isEmpty()) {
            return Collections.emptyList();
        }
        return listKelas;
    }

    /**
     * Mendapatkan kapasitas kelas
     * @param idKelas -> ID Kelas
     * @return int kapasitas
     */
    public int getKapasitasKelas(String idKelas) {
        KelasRepository kelasRepo = new KelasRepository();
        return kelasRepo.getKapasitasKelas(idKelas);
    }

    // ==================== MATA KULIAH MANAGEMENT ====================

    /**
     * Mendapatkan mata kuliah berdasarkan ID Prodi
     * @param idProdi -> ID Program Studi
     * @return List Matkul atau empty list
     */
    public List<Matkul> getMatkulByProdi(String idProdi) {
        MatkulRepository matkulRepo = new MatkulRepository();
        List<Matkul> listMatkul = matkulRepo.getMatkulByIdProdi(idProdi);
        if (listMatkul.isEmpty()) {
            return Collections.emptyList();
        }
        return listMatkul;
    }

    // ==================== USER MANAGEMENT ====================

    /**
     * Login user dan mendapatkan role
     * @param username -> ID User
     * @param password -> Password
     * @return String role atau null jika login gagal
     */
    public String login(String username, String password) {
        UserRepository userRepo = new UserRepository();
        return userRepo.Login(username, password);
    }
}