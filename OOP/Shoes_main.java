import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Shoes_main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("============CHUONG TRINH QUAN LI============ ");
            System.out.println("_______________________________________________");
            System.out.println("1.Quan li san pham;");
            System.out.println("2. Quan li nhan vien:");
            System.out.println("3. Quan li khach hang:");
            System.out.println("4. Quan li nha cung cap:");
            System.out.println("5. Quan li phieu nhap hang:");
            System.out.println("6. Quan li chi tiet nhap hang:");
            System.out.println("7. Quan Li hoa don:");
            System.out.println("8.Quan li chi tiet hoa don:");
            System.out.println("9.Thong ke");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("Chon: ");
            int chon = sc.nextInt();

            switch (chon) {
                case 1:
                    Main_Sp.main(new String[] {});
                    break;
                case 2:
                    Main_Nv.main(new String[] {});
                    break;
                case 3:
                    Main_Kh.main(new String[] {});
                    break;
                case 4:
                    Main_Ncc.main(new String[] {});
                    break;
                case 5:
                    Main_Pnh.main(new String[] {});
                    break;
                case 6:
                    Main_Ctnh.main(new String[] {});
                    break;
                case 7:
                    Main_Dshd.main(new String[] {});
                    break;
                case 8:
                    Main_Cthd.main(new String[] {});
                    break;
                case 9:
                    Main_Tk.main(new String[] {});
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Moi ban nhap lai.");
                    break;
            }

        }
        sc.close();

    }
}