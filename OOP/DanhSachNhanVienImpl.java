import java.io.*;

public class DanhSachNhanVienImpl implements DanhSachNhanVien {
    private NhanVien[] danhSachNhanVien;
    private int soLuongNhanVien;

    public DanhSachNhanVienImpl() {
        this.danhSachNhanVien = new NhanVien[100];
        this.soLuongNhanVien = 0;
    }

    @Override
    public void themNhanvien(NhanVien nv) {
        for (int i = 0; i < soLuongNhanVien; i++) {
            if (danhSachNhanVien[i] != null && danhSachNhanVien[i].getId().equals(nv.getId())) {
                System.out.println("Nhan vien voi ma " + nv.getId() + " da ton tai trong danh sach. Khong the them.");
                return;
            }
        }

        if (soLuongNhanVien < danhSachNhanVien.length) {
            danhSachNhanVien[soLuongNhanVien++] = nv;
        } else {
            System.out.println("Danh sach nhan vien da day, khong the them nhan vien.");
        }
    }

    @Override
    public void suaNhanvien(String id, NhanVien nv) {
        for (int i = 0; i < soLuongNhanVien; i++) {
            if (danhSachNhanVien[i] != null && danhSachNhanVien[i].getId().equals(id)) {
                danhSachNhanVien[i] = nv;
                return;
            }
        }
        System.out.println("Khong tim thay nhan vien co ma: " + id);
    }

    @Override
    public void xoaNhanvien(String id) {
        for (int i = 0; i < soLuongNhanVien; i++) {
            if (danhSachNhanVien[i] != null && danhSachNhanVien[i].getId().equals(id)) {

                for (int j = i; j < soLuongNhanVien - 1; j++) {
                    danhSachNhanVien[j] = danhSachNhanVien[j + 1];
                }
                danhSachNhanVien[--soLuongNhanVien] = null;
                return;
            }
        }
        System.out.println("Khong tim thay nhan vien de xoa.");
    }

    @Override
    public NhanVien timNhanvien(String id) {
        for (int i = 0; i < soLuongNhanVien; i++) {
            if (danhSachNhanVien[i] != null && danhSachNhanVien[i].getId().equals(id)) {
                return danhSachNhanVien[i];
            }
        }
        return null;
    }

    public NhanVien[] timTenNhanvienGanDung(String tenGanDung) {
        String tenCanTim = tenGanDung.toLowerCase();
        NhanVien[] ketQuaTam = new NhanVien[soLuongNhanVien];
        int soLuongKetQua = 0;

        for (int i = 0; i < soLuongNhanVien; i++) {
            if (danhSachNhanVien[i] != null) {
                String tenNhanVien = danhSachNhanVien[i].getTen().toLowerCase();
                if (tenNhanVien.contains(tenCanTim)) {
                    ketQuaTam[soLuongKetQua++] = danhSachNhanVien[i];
                }
            }
        }

        NhanVien[] ketQuaChinhThuc = new NhanVien[soLuongKetQua];
        for (int i = 0; i < soLuongKetQua; i++) {
            ketQuaChinhThuc[i] = ketQuaTam[i];
        }

        return ketQuaChinhThuc;
    }

    @Override
    public void hienThiNhanvien() {
        if (soLuongNhanVien == 0) {
            System.out.println("Danh sach nhan vien trong.");
            return;
        }
        for (int i = 0; i < soLuongNhanVien; i++) {
            if (danhSachNhanVien[i] != null) {
                System.out.println(danhSachNhanVien[i]);
            }
        }
    }

    public void luuFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < soLuongNhanVien; i++) {
                if (danhSachNhanVien[i] != null) {
                    writer.write(danhSachNhanVien[i].toString());
                    writer.newLine();
                }
            }
        }
    }

    public void docFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        soLuongNhanVien = 0;

        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(", ");
            if (fields.length >= 7) {
                try {
                    String name = fields[0].split(": ")[1];
                    int age = Integer.parseInt(fields[1].split(": ")[1]);
                    String gender = fields[2].split(": ")[1];
                    String address = fields[3].split(": ")[1];
                    String id = fields[4].split(": ")[1];
                    String chucvu = fields[5].split(": ")[1];
                    double luong = Double.parseDouble(fields[6].split(": ")[1]);

                    NhanVien nv = new NhanVien(name, age, gender, address, id, chucvu, luong);
                    themNhanvien(nv);
                } catch (Exception e) {
                    System.out.println("Loi khi doc dong: " + line);
                }
            } else {
                System.out.println("Dong du lieu khong day du: " + line);
            }
        }

    }
}
