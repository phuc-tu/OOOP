import java.io.*;
import java.util.Scanner;

public class DanhSachChiTietDonNhapHangImpl implements DanhSachChiTietDonNhapHang {
    private ChiTietDonNhapHang[] danhSachChiTiet;
    private int soLuongChiTiet;

    public DanhSachChiTietDonNhapHangImpl() {
        this.danhSachChiTiet = new ChiTietDonNhapHang[100];
        this.soLuongChiTiet = 0;
    }

    @Override
    public void themChiTietDonNhapHang(ChiTietDonNhapHang ctnh) {
        if (soLuongChiTiet < danhSachChiTiet.length) {
            danhSachChiTiet[soLuongChiTiet++] = ctnh;
        } else {
            System.out.println("Danh sach chi tiet don nhap hang da day.");
        }
    }

    @Override
    public void suaChiTietDonNhapHang(ChiTietDonNhapHang ctnh, String maPn) {
        for (int i = 0; i < soLuongChiTiet; i++) {
            if (danhSachChiTiet[i] != null && danhSachChiTiet[i].getMaPn().equals(maPn)) {
                danhSachChiTiet[i] = ctnh;
                return;
            }
        }
        System.out.println("Khong tim thay chi tiet don nhap hang voi ma: " + maPn);
    }

    @Override
    public void xoaChiTietDonNhapHang(String maPn) {
        for (int i = 0; i < soLuongChiTiet; i++) {
            if (danhSachChiTiet[i] != null && danhSachChiTiet[i].getMaPn().equals(maPn)) {
                for (int j = i; j < soLuongChiTiet - 1; j++) {
                    danhSachChiTiet[j] = danhSachChiTiet[j + 1];
                }
                danhSachChiTiet[--soLuongChiTiet] = null;
                return;
            }
        }
        System.out.println("Khong tim thay chi tiet don nhap hang de xoa.");
    }

    @Override
    public ChiTietDonNhapHang timChiTietDonNhapHang(String maPn) {
        for (int i = 0; i < soLuongChiTiet; i++) {
            if (danhSachChiTiet[i] != null && danhSachChiTiet[i].getMaPn().equals(maPn)) {
                return danhSachChiTiet[i];
            }
        }
        return null;
    }

    @Override
    public void hienThiDonChiTietNhapHang() {
        for (int i = 0; i < soLuongChiTiet; i++) {
            if (danhSachChiTiet[i] != null) {
                System.out.println(danhSachChiTiet[i]);
            }
        }
    }

    // Lưu danh sách vào file
    public void luuFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) { // Append mode
            for (int i = 0; i < soLuongChiTiet; i++) {
                if (danhSachChiTiet[i] != null) {
                    writer.write(danhSachChiTiet[i].toString());
                    writer.newLine();
                }
            }
        }
    }

    // Đọc danh sách từ file và lưu vào bộ nhớ
    public void docFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        soLuongChiTiet = 0;

        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(", ");
            if (fields.length >= 5) {
                try {
                    String maPn = fields[0].split(": ")[1];
                    String maSp = fields[1].split(": ")[1];
                    double sl = Double.parseDouble(fields[2].split(": ")[1]);
                    double donGia = Double.parseDouble(fields[3].split(": ")[1]);

                    ChiTietDonNhapHang ctnh = new ChiTietDonNhapHang(maPn, maSp, sl, donGia);
                    themChiTietDonNhapHang(ctnh);
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