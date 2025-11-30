package logic;

import java.util.Collections;
import java.util.List;
import DTO.TagihanDTO;
import repo.KeuanganRepository;

public class FiturKeuangan {

    private KeuanganRepository keuanganRepo;

    public FiturKeuangan() {
        this.keuanganRepo = new KeuanganRepository();
    }

    public List<TagihanDTO> getDaftarTagihan(String nim) {
        List<TagihanDTO> list = keuanganRepo.getTagihanByNIM(nim);
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        return list;
    }

    /**
     * @param listIdNilai -> List ID Nilai yang dicentang di tabel
     */
    public boolean prosesPembayaran(List<String> listIdNilai) {
        if (listIdNilai == null || listIdNilai.isEmpty()) {
            throw new RuntimeException("Tidak ada item yang dipilih untuk dibayar.");
        }
        return keuanganRepo.bayarTagihan(listIdNilai);
    }

    public String getInfoHargaSKS() {
        double harga = keuanganRepo.getHargaPerSKS();
        return String.format("Rp %,.0f", harga);
    }
}