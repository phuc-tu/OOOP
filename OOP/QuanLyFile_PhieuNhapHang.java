import java.io.*;

public class QuanLyFile_PhieuNhapHang {
    // Lưu danh sách phiếu nhập vào file
    public static void luuDanhSachPhieuNhap(PhieuNhapHang[] danhSach, int soLuong, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < soLuong; i++) {
                writer.write(danhSach[i].toString());
                writer.newLine();
            }
        }
    }

    // Đọc danh sách phiếu nhập từ file
    public static int docDanhSachPhieuNhap(PhieuNhapHang[] danhSach, String filename) throws IOException {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                PhieuNhapHang phieu = parsePhieuNhapFromLine(line);
                if (phieu != null) {
                    danhSach[count++] = phieu;
                }
            }
        }
        return count;
    }

    // Phân tích chuỗi thành đối tượng PhieuNhapHang
    private static PhieuNhapHang parsePhieuNhapFromLine(String line) {
        String[] parts = line.split(", ");
        if (parts.length < 4) { // Kiểm tra dữ liệu có đủ 4 trường không
            System.out.println("Du lieu khong hop le: " + line);
            return null;
        }

        try {
            String maPhieu = parts[0].split(": ")[1];
            String maNcc = parts[1].split(": ")[1];
            String ngayNhap = parts[2].split(": ")[1];
            double tongTien = Double.parseDouble(parts[3].split(": ")[1]);

            return new PhieuNhapHang(maPhieu, maNcc, ngayNhap, tongTien);
        } catch (Exception e) {
            System.out.println("Loi: " + line);
            return null;
        }
    }
}
