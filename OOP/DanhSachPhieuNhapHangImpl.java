import java.io.*;

public class DanhSachPhieuNhapHangImpl implements DanhSachPhieuNhapHang {
    private PhieuNhapHang[] danhSachPhieu;
    private int soLuongPhieu;

    public DanhSachPhieuNhapHangImpl() {
        this.danhSachPhieu = new PhieuNhapHang[100];
        this.soLuongPhieu = 0;
    }

    @Override
    public void themPhieu(PhieuNhapHang phieu) {
        if (soLuongPhieu < danhSachPhieu.length) {
            danhSachPhieu[soLuongPhieu++] = phieu;
        } else {
            System.out.println("Danh sach da day day,ko the them");
        }
    }

    @Override
    public void suaPhieu(String maPhieu, PhieuNhapHang phieuMoi) {
        for (int i = 0; i < soLuongPhieu; i++) {
            if (danhSachPhieu[i] != null && danhSachPhieu[i].getMaPhieu().equals(maPhieu)) {
                danhSachPhieu[i] = phieuMoi;
                System.out.println("Sua phieu nhap thanh cong.");
                return;
            }
        }
        System.out.println("Khong tim thay phieu: " + maPhieu);
    }

    @Override
    public void xoaPhieu(String maPhieu) {
        for (int i = 0; i < soLuongPhieu; i++) {
            if (danhSachPhieu[i] != null && danhSachPhieu[i].getMaPhieu().equals(maPhieu)) {
                for (int j = i; j < soLuongPhieu - 1; j++) {
                    danhSachPhieu[j] = danhSachPhieu[j + 1];
                }
                danhSachPhieu[--soLuongPhieu] = null;
                System.out.println("Xoa phieu thanh cong");
                return;
            }
        }
        System.out.println("Khong tim thay phieu voi ma " + maPhieu);
    }

    @Override
    public PhieuNhapHang timPhieu(String maPhieu) {
        for (int i = 0; i < soLuongPhieu; i++) {
            if (danhSachPhieu[i] != null && danhSachPhieu[i].getMaPhieu().equals(maPhieu)) {
                return danhSachPhieu[i];
            }
        }
        System.out.println("Ko tim thay phieu voi ma" + maPhieu);
        return null;
    }

    @Override
    public void hienThiPhieu() {
        if (soLuongPhieu == 0) {
            System.out.println("Danh sach phieu trong");
        } else {
            for (int i = 0; i < soLuongPhieu; i++) {
                System.out.println(danhSachPhieu[i]);
            }
        }
    }

    public void luuFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < soLuongPhieu; i++) {
                if (danhSachPhieu[i] != null) {
                    writer.write(danhSachPhieu[i].toString());
                    writer.newLine();
                }
            }
        }
    }

    public void docFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        soLuongPhieu = 0;

        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(", ");

            if (fields.length == 4) {
                try {
                    String maPhieu = fields[0].split(": ")[1];
                    String maNcc = fields[1].split(": ")[1];
                    String ngayNhap = fields[2].split(": ")[1];
                    double tongTien = Double.parseDouble(fields[3].split(": ")[1]);

                    PhieuNhapHang phieu = new PhieuNhapHang(maPhieu, maNcc, ngayNhap, tongTien);
                    themPhieu(phieu);
                } catch (Exception e) {
                    System.out.println("Loi khi doc dong: " + line);
                }
            } else {
                System.out.println("Du lieu khong day du: " + line);
            }
        }
        reader.close();
    }
}
