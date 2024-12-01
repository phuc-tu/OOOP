import java.io.*;

public class QuanLyFile_Ctnh {
    // Lưu danh sách chi tiết đơn nhập hàng vào file
    public static void luuDanhSachChiTietDonNhapHang(ChiTietDonNhapHang[] danhSach, int soLuong, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < soLuong; i++) {
                writer.write(danhSach[i].toString());
                writer.newLine();
            }
        }
    }

    // Đọc danh sách chi tiết đơn nhập hàng từ file
    public static int docDanhSachChiTietDonNhapHang(ChiTietDonNhapHang[] danhSach, String filename) throws IOException {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                ChiTietDonNhapHang ctnh = parseChiTietDonNhapHangFromLine(line);
                if (ctnh != null) {
                    danhSach[count++] = ctnh;
                }
            }
        }
        return count;
    }

    // Phân tích dòng dữ liệu và tạo đối tượng ChiTietDonNhapHang
    private static ChiTietDonNhapHang parseChiTietDonNhapHangFromLine(String line) {
        String[] parts = line.split(", ");
        if (parts.length < 5) {
            System.out.println("Du lieu khong hop le: " + line);
            return null;
        }

        try {
            String maPn = parts[0].split(": ")[1];
            String maSp = parts[1].split(": ")[1];
            double sl = Double.parseDouble(parts[2].split(": ")[1]);
            double donGia = Double.parseDouble(parts[3].split(": ")[1]);

            return new ChiTietDonNhapHang(maPn, maSp, sl, donGia);
        } catch (Exception e) {
            System.out.println("Loi khi phan tich du lieu: " + line);
            return null;
        }
    }
}
