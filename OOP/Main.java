import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        DanhSachNhanVienImpl danhSach = new DanhSachNhanVienImpl();
        Scanner sc = new Scanner(System.in);

        // Đọc dữ liệu từ file (nếu có)
        try {
            danhSach.docFile("NhanVien.txt");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Thêm nhân viên (và lưu vào file)");
            System.out.println("2. Sửa nhân viên");
            System.out.println("3. Xóa nhân viên");
            System.out.println("4. Tìm nhân viên");
            System.out.println("5. Hiển thị danh sách nhân viên");
            System.out.println("7. Thoát");
            System.out.print("Chọn: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Đọc ký tự newline còn lại

            switch (choice) {
                case 1:
                    // Thêm nhân viên mới
                    NhanVien nv = new NhanVien();
                    nv.nhap(); // Nhập thông tin nhân viên mới
                    danhSach.themNhanvien(nv); // Thêm nhân viên vào danh sách
                    try {
                        danhSach.luuFile("NhanVien.txt"); // Ghi danh sách nhân viên vào file
                        System.out.println("Nhân viên đã được thêm và lưu vào file.");
                    } catch (IOException e) {
                        System.out.println("Lỗi khi lưu nhân viên vào file: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Nhập mã nhân viên cần sửa: ");
                    String idSua = sc.nextLine();
                    NhanVien nvMoi = new NhanVien();
                    nvMoi.nhap();
                    danhSach.suaNhanvien(idSua, nvMoi);
                    try {
                        danhSach.luuFile("NhanVien.txt"); // Lưu lại danh sách nhân viên sau khi sửa
                        System.out.println("Nhân viên đã được sửa và lưu vào file.");
                    } catch (IOException e) {
                        System.out.println("Lỗi khi lưu nhân viên vào file: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Nhập mã nhân viên cần xóa: ");
                    String idXoa = sc.nextLine();
                    danhSach.xoaNhanvien(idXoa);
                    try {
                        danhSach.luuFile("NhanVien.txt"); // Lưu lại danh sách nhân viên sau khi xóa
                        System.out.println("Nhân viên đã được xóa và lưu vào file.");
                    } catch (IOException e) {
                        System.out.println("Lỗi khi lưu nhân viên vào file: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Nhập mã nhân viên cần tìm: ");
                    String idTim = sc.nextLine();
                    NhanVien nvTim = danhSach.timNhanvien(idTim);
                    System.out.println(nvTim != null ? nvTim : "Không tìm thấy nhân viên với mã này.");
                    break;

                case 5:
                    System.out.println("Danh sách nhân viên:");
                    danhSach.hienThiNhanvien();
                    break;

                case 7:
                    exit = true;
                    System.out.println("Chương trình kết thúc.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        }
        sc.close();
    }
}
