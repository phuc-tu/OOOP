import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Shop_main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("CHUONG TRINH QUAN LI ADMIN");
            System.out.println("1. Quan li nhan vien:");
            System.out.println("2. Quan li khach hang:");
            System.out.println("3. Quan li nha cung cap:");
            System.out.println("4. Quan li phieu nhap hang:");
            System.out.println("5. Quan li chi tiet nhap hang:");
            System.out.println("0. Thoat chuong trinh");

            int chon;
            try {
                System.out.print("Nhap lua chon cua ban: ");
                chon = sc.nextInt(); // Lấy giá trị người dùng nhập

                if (chon == 0) {
                    System.out.println("Thoat chuong trinh, bye nha!");
                    break;
                }

                switch (chon) {
                    case 1:
                        Main_Nv.main(new String[] {});
                        break;
                    case 2:
                        Main_Kh.main(new String[] {});
                        break;
                    case 3:
                        Main_Ncc.main(new String[] {});
                        break;
                    case 4:
                        Main_Pnh.main(new String[] {});
                        break;
                    case 5:
                        Main_Ctnh.main(new String[] {});
                        break;
                    default:
                        System.out.println("Lua chon khong hop le. Moi ban nhap lai.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Vui long nhap so nguyen hop le!");
                sc.nextLine(); // Xóa bỏ dữ liệu không hợp lệ trong Scanner
            } catch (IOException e) {
                System.out.println("Có lỗi xảy ra: " + e.getMessage());
            }
        }
        sc.close(); // Đóng Scanner sau khi sử dụng
    }
}
