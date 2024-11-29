import java.io.*;
import java.util.Scanner;

public class Main_Nv {
    public static void main(String[] args) throws IOException {
        DanhSachNhanVienImpl danhSach = new DanhSachNhanVienImpl();
        Scanner sc = new Scanner(System.in);

        // Doc du lieu tu file (neu co)
        try {
            danhSach.docFile("NhanVien.txt");
        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Them nhan vien (va luu vao file)");
            System.out.println("2. Sua nhan vien");
            System.out.println("3. Xoa nhan vien");
            System.out.println("4. Tim nhan vien");
            System.out.println("5. Hien thi danh sach nhan vien");
            System.out.println("6. Thoat");
            System.out.print("Chon: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Doc ky tu newline con lai

            switch (choice) {
                case 1:
                    // Them nhan vien moi
                    NhanVien nv = new NhanVien();
                    nv.nhap(); // Nhap thong tin nhan vien moi
                    danhSach.themNhanvien(nv); // Them nhan vien vao danh sach
                    try {
                        danhSach.luuFile("NhanVien.txt"); // Ghi danh sach nhan vien vao file
                        System.out.println("Nhan vien da duoc them va luu vao file.");
                    } catch (IOException e) {
                        System.out.println("Loi khi luu nhan vien vao file: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Nhap ma nhan vien can sua: ");
                    String idSua = sc.nextLine();
                    NhanVien nvMoi = new NhanVien();
                    nvMoi.nhap();
                    danhSach.suaNhanvien(idSua, nvMoi);
                    try {
                        danhSach.luuFile("NhanVien.txt"); // Luu lai danh sach nhan vien sau khi sua
                        System.out.println("Nhan vien da duoc sua va luu vao file.");
                    } catch (IOException e) {
                        System.out.println("Loi khi luu nhan vien vao file: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Nhap ma nhan vien can xoa: ");
                    String idXoa = sc.nextLine();
                    danhSach.xoaNhanvien(idXoa);
                    try {
                        danhSach.luuFile("NhanVien.txt"); // Luu lai danh sach nhan vien sau khi xoa
                        System.out.println("Nhan vien da duoc xoa va luu vao file.");
                    } catch (IOException e) {
                        System.out.println("Loi khi luu nhan vien vao file: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Nhap ma nhan vien can tim: ");
                    String idTim = sc.nextLine();
                    NhanVien nvTim = danhSach.timNhanvien(idTim);
                    System.out.println(nvTim != null ? nvTim : "Khong tim thay nhan vien voi ma nay.");
                    break;

                case 5:
                    System.out.println("Danh sach nhan vien:");
                    danhSach.hienThiNhanvien();
                    break;

                case 6:
                    exit = true;
                    System.out.println("Chuong trinh ket thuc.");
                    break;

                default:
                    System.out.println("Lua chon khong hop le.");
                    break;
            }
        }
        sc.close();
    }
}
