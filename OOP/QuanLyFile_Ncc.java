import java.io.*;

public class QuanLyFile_Ncc {
    public static void luuDanhSachNhaCungCap(NhaCungCap[] danhSach, int soLuong, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < soLuong; i++) {
                writer.write(danhSach[i].toString());
                writer.newLine();
            }
        }
    }

    public static int docDanhSachNhaCungCap(NhaCungCap[] danhSach, String filename) throws IOException {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                NhaCungCap ncc = parseNhaCungCapFromLine(line);
                if (ncc != null) {
                    danhSach[count++] = ncc;
                }
            }
        }
        return count;
    }

    private static NhaCungCap parseNhaCungCapFromLine(String line) {
        String[] parts = line.split(", ");
        if (parts.length < 5) {
            System.out.println("Du lieu khong hop le: " + line);
            return null;
        }

        String maNcc = parts[0].split(": ")[1];
        String tenNcc = parts[1].split(": ")[1];
        String diaChi = parts[2].split(": ")[1];
        String sdt = parts[3].split(": ")[1];
        String gmail = parts[4].split(": ")[1];

        return new NhaCungCap(maNcc, tenNcc, diaChi, sdt, gmail);
    }
}
