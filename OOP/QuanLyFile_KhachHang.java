import java.io.*;

public class QuanLyFile_KhachHang {

    // Lưu danh sách khách hàng vào file
    public static void luuDanhSachKhachHang(KhachHang[] danhSach, int soLuong, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < soLuong; i++) {
                writer.write(danhSach[i].toString());
                writer.newLine();
            }
        }
    }

    // Đọc danh sách khách hàng từ file
    public static int docDanhSachKhachHang(KhachHang[] danhSach, String filename) throws IOException {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                KhachHang kh = parseKhachHangFromLine(line);
                if (kh != null) {
                    danhSach[count++] = kh;
                }
            }
        }
        return count;
    }

    // Phương thức này phân tích một dòng văn bản và tạo đối tượng KhachHang
    private static KhachHang parseKhachHangFromLine(String line) {
        String[] parts = line.split(", ");
        if (parts.length < 6) {
            System.out.println("Dữ liệu không hợp lệ: " + line);
            return null;
        }
        String name = parts[0].split(": ")[1];
        int age = Integer.parseInt(parts[1].split(": ")[1]);
        String gender = parts[2].split(": ")[1];
        String address = parts[3].split(": ")[1];
        String id = parts[4].split(": ")[1];
        String phoneNumber = parts[5].split(": ")[1];

        return new KhachHang(name, age, gender, address, id, phoneNumber);
    }
}