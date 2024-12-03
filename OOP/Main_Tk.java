import java.io.*;
import java.util.Scanner;

public class Main_Tk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int soNam = 0, soNu = 0;
        String filePath = "NhanVien.txt";
        int choice;

        do {
            System.out.println("---------------------");
            System.out.println("1. Thong ke nhan vien");
            System.out.println("0. Thoat chuong trinh");

            System.out.print("Nhap lua chon: ");
            choice = sc.nextInt();
            sc.nextLine(); // Đọc dòng trống còn lại sau khi nhập số

            switch (choice) {
                case 1:
                    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            if (line.toLowerCase().contains("gioi tinh: nam".toLowerCase())) {
                                soNam++;
                            } else if (line.toLowerCase().contains("gioi tinh: nu".toLowerCase())) {
                                soNu++;
                            }
                        }
                        int sum = soNam + soNu;

                        System.out.println("Thong ke nhan vien");
                        System.out.println("Tong so nhan vien la: " + sum);
                        System.out.println("Trong do:");
                        System.out.println("- So nhan vien nam: " + soNam);
                        System.out.println("- So nhan vien nu: " + soNu);
                        System.out.println("=-=");
                    } catch (IOException e) {
                        System.out.println("Loi khi doc file: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Thoat chuong trinh.");
                    break;

                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        } while (choice != 0);

        sc.close();
    }
}
