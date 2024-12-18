import java.io.*;

public class DanhSachKhachHangImpl implements DanhSachKhachHang {
    private KhachHang[] danhSachKhachHang;
    private int soLuongKhachHang;

    public DanhSachKhachHangImpl() {
        this.danhSachKhachHang = new KhachHang[100];
        this.soLuongKhachHang = 0;
    }

    @Override
    public void themKhachhang(KhachHang kh) {
        for (int i = 0; i < soLuongKhachHang; i++) {
            if (danhSachKhachHang[i] != null && danhSachKhachHang[i].getId().equals(kh.getId())) {
                System.out.println("Khach hang voi ma " + kh.getId() + " da ton tai trong danh sach. Khong the them.");
                return;
            }
        }

        if (soLuongKhachHang < danhSachKhachHang.length) {
            danhSachKhachHang[soLuongKhachHang++] = kh;
        } else {
            System.out.println("Danh sach khach hang da day, khong the them khach hang.");
        }
    }

    @Override
    public void suaKhachhang(String id, KhachHang kh) {
        for (int i = 0; i < soLuongKhachHang; i++) {
            if (danhSachKhachHang[i] != null && danhSachKhachHang[i].getId().equals(id)) {
                danhSachKhachHang[i] = kh;
                return;
            }
        }
        System.out.println("Khong tim thay khach hang co ma: " + id);
    }

    @Override
    public void xoaKhachhang(String id) {
        for (int i = 0; i < soLuongKhachHang; i++) {
            if (danhSachKhachHang[i] != null && danhSachKhachHang[i].getId().equals(id)) {

                for (int j = i; j < soLuongKhachHang - 1; j++) {
                    danhSachKhachHang[j] = danhSachKhachHang[j + 1];
                }
                danhSachKhachHang[--soLuongKhachHang] = null;
                return;
            }
        }
        System.out.println("Khong tim thay khach hang de xoa.");
    }

    @Override
    public KhachHang timKhachHang(String id) {
        for (int i = 0; i < soLuongKhachHang; i++) {
            if (danhSachKhachHang[i] != null && danhSachKhachHang[i].getId().equals(id)) {
                return danhSachKhachHang[i];
            }
        }
        return null;
    }

    @Override
    public void hienThiKhachhang() {
        if (soLuongKhachHang == 0) {
            System.out.println("Danh sach khach hang trong.");
            return;
        }
        for (int i = 0; i < soLuongKhachHang; i++) {
            if (danhSachKhachHang[i] != null) {
                System.out.println(danhSachKhachHang[i]);
            }
        }
    }

    // Thống kê

    public void luuFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < soLuongKhachHang; i++) {
                if (danhSachKhachHang[i] != null) {
                    writer.write(danhSachKhachHang[i].toString());
                    writer.newLine();
                }
            }
        }
    }

    
    public void docFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            soLuongKhachHang = 0;
    
            while ((line = reader.readLine()) != null) {
                try {
                    String[] fields = line.split(", ");
                    if (fields.length < 6) {
                        System.out.println("Dong du lieu khong day du: " + line);
                        continue;
                    }
    
                    // Xử lý dữ liệu, kiểm tra từng trường
                    String name = fields[0].split(": ")[1];
                    int age = Integer.parseInt(fields[1].split(": ")[1]);
    
                    // Xử lý đặc biệt cho "Gioi tinh" và "Dia chi"
                    String gender = fields[2].split(": ")[1].trim();
                    String address = fields[3].split(": ")[1];
    
                    // Kiểm tra nếu "Gioi tinh" không hợp lệ
                    if (!gender.equals("Nam") && !gender.equals("Nu")) {
                        // Nếu không phải, hoán đổi giá trị giữa "Gioi tinh" và "Dia chi"
                        String temp = gender;
                        gender = address;
                        address = temp;
                    }
    
                    String id = fields[4].split(": ")[1];
                    String sdt = fields[5].split(": ")[1];
    
                    // Tạo đối tượng KhachHang
                    KhachHang kh = new KhachHang(name, age, gender, address, id, sdt);
                    themKhachhang(kh);
    
                } catch (Exception e) {
                    System.out.println("Loi khi doc dong: " + line);
                }
            }
        }
    }
    
    

}
