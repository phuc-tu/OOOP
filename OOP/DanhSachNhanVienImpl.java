import java.io.*;

public class DanhSachNhanVienImpl implements DanhSachNhanVien {
    private NhanVien[] danhSachNhanVien;
    private int soLuongNhanVien;

    public DanhSachNhanVienImpl() {
        this.danhSachNhanVien = new NhanVien[100]; // Mang co dinh voi kich thuoc 100
        this.soLuongNhanVien = 0;
    }

    @Override
    public void themNhanvien(NhanVien nv) {
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
                // Doi cac phan tu sau len de "xoa" phan tu
                for (int j = i; j < soLuongNhanVien - 1; j++) {
                    danhSachNhanVien[j] = danhSachNhanVien[j + 1];
                }
                danhSachNhanVien[--soLuongNhanVien] = null; // Giam so luong nhan vien
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

    // Luu danh sach nhan vien vao file
    // Lưu danh sách nhân viên vào file (bổ sung vào cuối file)
    public void luuFile(String filename) throws IOException {
        // Sử dụng FileWriter với tham số true để ghi thêm vào cuối file
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));

        // Lưu tất cả nhân viên vào file, mỗi nhân viên một dòng
        for (int i = 0; i < soLuongNhanVien; i++) {
            if (danhSachNhanVien[i] != null) {
                writer.write(danhSachNhanVien[i].toString()); // Ghi thông tin nhân viên
                writer.newLine(); // Xuống dòng sau mỗi nhân viên
            }
        }
        writer.close();
    }

    // Doc danh sach nhan vien tu file
    public void docFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        soLuongNhanVien = 0;

        while ((line = reader.readLine()) != null) {
            // Tach dong thanh cac phan tu bang dau phay va khoang trang
            String[] fields = line.split(", ");

            // Kiem tra neu dong du lieu co du thong tin
            if (fields.length >= 7) {
                try {
                    String name = fields[0].split(": ")[1];
                    int age = Integer.parseInt(fields[1].split(": ")[1]);
                    String gender = fields[2].split(": ")[1];
                    String address = fields[3].split(": ")[1];
                    String id = fields[4].split(": ")[1];
                    String chucvu = fields[5].split(": ")[1];
                    double luong = Double.parseDouble(fields[6].split(": ")[1]);

                    // Tao doi tuong NhanVien va them vao danh sach
                    NhanVien nv = new NhanVien(name, age, gender, address, id, chucvu, luong);
                    themNhanvien(nv);
                } catch (Exception e) {
                    System.out.println("Loi khi doc dong: " + line);
                }
            } else {
                System.out.println("Dong du lieu khong day du: " + line);
            }
        }
        reader.close();
    }
}
