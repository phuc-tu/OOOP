import java.io.*;
import java.util.Scanner;

public class DanhSachNhaCungCapImpl implements DanhSachNhaCungCap {
    private NhaCungCap[] danhSachNhaCungCap;
    private int soLuongNhaCungCap;

    public DanhSachNhaCungCapImpl() {
        this.danhSachNhaCungCap = new NhaCungCap[100];
        this.soLuongNhaCungCap = 0;
    }

    @Override
    public void themNhaCungCap(NhaCungCap ncc) {
        if (soLuongNhaCungCap < danhSachNhaCungCap.length) {
            danhSachNhaCungCap[soLuongNhaCungCap++] = ncc;
        } else {
            System.out.println("Danh sach nha cung cap da day.");
        }
    }

    @Override
    public void suaNhaCungCap(String maNcc, NhaCungCap ncc) {
        for (int i = 0; i < soLuongNhaCungCap; i++) {
            if (danhSachNhaCungCap[i] != null && danhSachNhaCungCap[i].getMaNcc().equals(maNcc)) {
                danhSachNhaCungCap[i] = ncc;
                return;
            }
        }
        System.out.println("Khong tim thay nha cung cap co ma: " + maNcc);
    }

    @Override
    public void xoaNhaCungCap(String maNcc) {
        for (int i = 0; i < soLuongNhaCungCap; i++) {
            if (danhSachNhaCungCap[i] != null && danhSachNhaCungCap[i].getMaNcc().equals(maNcc)) {
                for (int j = i; j < soLuongNhaCungCap - 1; j++) {
                    danhSachNhaCungCap[j] = danhSachNhaCungCap[j + 1];
                }
                danhSachNhaCungCap[--soLuongNhaCungCap] = null;
                return;
            }
        }
        System.out.println("Khong tim thay nha cung cap de xoa.");
    }

    @Override
    public NhaCungCap timNhaCungCap(String maNcc) {
        for (int i = 0; i < soLuongNhaCungCap; i++) {
            if (danhSachNhaCungCap[i] != null && danhSachNhaCungCap[i].getMaNcc().equals(maNcc)) {
                return danhSachNhaCungCap[i];
            }
        }
        return null;
    }

    @Override
    public void hienThiNhaCungCap() {
        if (soLuongNhaCungCap == 0) {
            System.out.println(" Danh sach trong:");
        } else {
            for (int i = 0; i < soLuongNhaCungCap; i++) {
                System.out.println(danhSachNhaCungCap[i]);
            }

        }

        // try (BufferedReader reader = new BufferedReader(new
        // FileReader("NhaCungCap.txt"))) {
        // String line;
        // System.out.println("Danh sach nha cung cap:");
        // while ((line = reader.readLine()) != null) {
        // System.out.println(line);
        // }
        // } catch (IOException e) {
        // System.out.println("Loi khi doc file: " + e.getMessage());
        // }

        // for (int i = 0; i < soLuongNhaCungCap; i++) {
        // System.out.println(danhSachNhaCungCap[i]);
        // }
    }

    public void luuFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) { // Append mode
            for (int i = 0; i < soLuongNhaCungCap; i++) {
                if (danhSachNhaCungCap[i] != null) {
                    writer.write(danhSachNhaCungCap[i].toString());
                    writer.newLine();
                }
            }
        }
    }

    public void docFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        soLuongNhaCungCap = 0;

        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(", ");
            if (fields.length >= 5) {
                try {
                    String maNcc = fields[0].split(": ")[1];
                    String tenNcc = fields[1].split(": ")[1];
                    String diaChi = fields[2].split(": ")[1];
                    String sdt = fields[3].split(": ")[1];
                    String gmail = fields[4].split(": ")[1];

                    NhaCungCap ncc = new NhaCungCap(maNcc, tenNcc, diaChi, sdt, gmail);
                    themNhaCungCap(ncc);
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
