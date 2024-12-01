import java.io.IOException;
import java.util.Scanner;

public class Main_Ctnh {
    public static void main(String[] args) throws IOException {
        DanhSachChiTietDonNhapHangImpl danhSach = new DanhSachChiTietDonNhapHangImpl();
        Scanner scanner = new Scanner(System.in);

        // Đọc danh sách từ file khi khởi động
        danhSach.docFile("ChiTietDonNhapHang.txt");

        boolean running = true;

        while (running) {
            System.out.println("\n1. Them chi tiet don nhap hang (va luu vao file)");
            System.out.println("2. Sua chi tiet don nhap hang");
            System.out.println("3. Xoa chi tiet don nhap hang");
            System.out.println("4. Tim chi tiet don nhap hang");
            System.out.println("5. Hien thi danh sach chi tiet don nhap hang");
            System.out.println("6. Thoat");
            System.out.print("Chon: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ ký tự xuống dòng sau khi nhập số

            switch (choice) {
                case 1: // Thêm chi tiết đơn nhập hàng
                    ChiTietDonNhapHang ctnh = new ChiTietDonNhapHang();
                    ctnh.nhap();
                    danhSach.themChiTietDonNhapHang(ctnh);

                    try {
                        danhSach.luuFile("ChiTietDonNhapHang.txt");
                        System.out.println("Chi tiet don nhap hang da duoc them va luu vao file.");
                    } catch (IOException e) {
                        System.out.println("Loi khi luu chi tiet don nhap hang vao file: " + e.getMessage());
                    }
                    break;

                case 2: // Sửa chi tiết đơn nhập hàng
                    System.out.print("Nhap ma phieu nhap hang can sua: ");
                    String maPnSua = scanner.nextLine();
                    ChiTietDonNhapHang ctnhMoi = new ChiTietDonNhapHang(); // Sửa

                    ctnhMoi.nhap();
                    danhSach.suaChiTietDonNhapHang(ctnhMoi, maPnSua);

                    try {
                        danhSach.luuFile("ChiTietDonNhapHang.txt");
                        System.out.println("Chi tiet don nhap hang da duoc sua va luu vao file.");
                    } catch (IOException e) {
                        System.out.println("Loi khi luu chi tiet don nhap hang vao file: " + e.getMessage());
                    }
                    break;

                case 3: // Xóa chi tiết đơn nhập hàng
                    System.out.print("Nhap ma phieu nhap hang can xoa: ");
                    String maPnXoa = scanner.nextLine();
                    danhSach.xoaChiTietDonNhapHang(maPnXoa);

                    try {
                        danhSach.luuFile("ChiTietDonNhapHang.txt");
                        System.out.println("Chi tiet don nhap hang da duoc xoa va luu vao file.");
                    } catch (IOException e) {
                        System.out.println("Loi khi luu chi tiet don nhap hang vao file: " + e.getMessage());
                    }
                    break;

                case 4: // Tìm chi tiết đơn nhập hàng
                    System.out.print("Nhap ma phieu nhap hang can tim: ");
                    String maPnTim = scanner.nextLine();
                    ChiTietDonNhapHang ketQua = danhSach.timChiTietDonNhapHang(maPnTim);
                    System.out.println(ketQua != null ? ketQua : "Khong tim thay chi tiet voi ma nay.");
                    break;

                case 5: // Hiển thị danh sách chi tiết đơn nhập hàng
                    danhSach.hienThiDonChiTietNhapHang();
                    break;

                case 6: // Thoát chương trình
                    running = false;
                    System.out.println("Chuong trinh ket thuc.");
                    break;

                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }

        scanner.close();
    }
}