import java.io.*;

public class QuanLyFile_NhanVien {
    public static void luuDanhSachNhanVien(NhanVien[] danhSach, int soLuong, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < soLuong; i++) {
                writer.write(danhSach[i].toString());
                writer.newLine();
            }
        }
    }

    public static int docDanhSachNhanVien(NhanVien[] danhSach, String filename) throws IOException {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                NhanVien nv = parseNhanVienFromLine(line);
                if (nv != null) {
                    danhSach[count++] = nv;
                }
            }
        }
        return count;
    }

    private static NhanVien parseNhanVienFromLine(String line) {
        String[] parts = line.split(", ");
        if (parts.length < 7) {
            System.out.println("Du lieu khong hop le: " + line);
            return null;
        }
        String name = parts[0].split(": ")[1];
        int age = Integer.parseInt(parts[1].split(": ")[1]);
        String gender = parts[2].split(": ")[1];
        String address = parts[3].split(": ")[1];
        String id = parts[4].split(": ")[1];
        String chucvu = parts[5].split(": ")[1];
        double luong = Double.parseDouble(parts[6].split(": ")[1]);

        return new NhanVien(name, age, gender, address, id, chucvu, luong);
    }
}
