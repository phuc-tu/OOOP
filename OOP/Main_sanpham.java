import java.io.IOException;
import java.util.Scanner;

public class Main_sanpham {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("CHUONG TRINH QUAN LI ADMIN");
            System.out.println("1. Quan li nhan vien:");
            System.out.println("2. Quan li khach hang:");
            System.out.println("3. Quan li nha cung cap:");
            System.out.println("4. Quan li phieu nhap hang:");
            System.out.println("0. Thoat chuong trinh");

            int chon = sc.nextInt();

            if (chon == 0) {
                System.out.println("Thoat chuong trinh, bye nha!");
                break; // Thoát khỏi vòng lặp khi người dùng chọn 0
            }

            try {
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
                    default:
                        System.out.println("Lua chon khong le.Moi ban nhap lai");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Có loi xay ra khi: " + e.getMessage());
            }
        }
    }
}
