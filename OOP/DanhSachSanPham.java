import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachSanPham implements IsanPham {
    private static sanpham[] sp = new sanpham[0];
    Scanner sc = new Scanner(System.in);
    int length;

    public int check(int id) {
        for (sanpham sp1 : sp) {
            if (sp1.getMaSP() == id) {
                return -1;
            }
        }
        return 1;
    }

    @Override

    public void taoDS() {
        int n;
        System.out.println("Nhap so san pham moi can nhap: ");
        n = sc.nextInt();

        int chon;
        for (int i = 0; i < n; i++) {
            System.out.println("Muon nhap sneaker hay cao_got :");
            System.out.println("1.Sneaker");
            System.out.println("2.Cao_got");
            sanpham newSp;
            chon = sc.nextInt();
            sc.nextLine();
            if (chon == 1) {
                newSp = new Sneaker();
            } else if (chon == 2) {
                newSp = new CaoGot();
            } else {
                newSp = new Sneaker();
            }
            newSp.nhap();
            while (check(newSp.getMaSP()) == -1) {
                System.out.println("Ma san pham bi trung, nhap lai:");
                newSp.nhap();
            }
            sp = Arrays.copyOf(sp, sp.length + 1);
            sp[sp.length - 1] = newSp;
        }
    }

    public void nhapSP() {
        int n;
        System.out.println("nhap so san pham can nhap them: ");
        n = sc.nextInt();
        int chon;
        int current = sp.length;
        sp = Arrays.copyOf(sp, sp.length + n);
        for (int i = 0; i < n; i++) {
            sanpham newSp;
            System.out.println("nhap chon:");
            chon = sc.nextInt();
            if (chon == 1) {
                newSp = new Sneaker();
            } else if (chon == 2) {
                newSp = new CaoGot();
            } else {
                newSp = new Sneaker();
            }
            newSp.nhap();
            sp[current + i] = newSp;

        }
    }

    public void docFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0) {
                    String type = parts[0].trim();
                    sanpham newSp = null;

                    try {
                        if ("Sneaker".equalsIgnoreCase(type) && parts.length == 11) {
                            int maSP = Integer.parseInt(parts[1].trim());
                            String tenSP = parts[2].trim();
                            int soLuong = Integer.parseInt(parts[3].trim());
                            int donGia = Integer.parseInt(parts[4].trim());
                            String mau = parts[5].trim();
                            String chatLieu = parts[6].trim();
                            int doDayDe = Integer.parseInt(parts[7].trim());
                            int size = Integer.parseInt(parts[8].trim());
                            String coGiay = parts[9].trim();
                            String ungDung = parts[10].trim();
                            newSp = new Sneaker(maSP, tenSP, soLuong, donGia, mau, chatLieu, doDayDe, size, coGiay,
                                    ungDung);
                        } else if ("Cao_got".equalsIgnoreCase(type) && parts.length == 11) {

                            int maSP = Integer.parseInt(parts[1].trim());
                            String tenSP = parts[2].trim();
                            int soLuong = Integer.parseInt(parts[3].trim());
                            int donGia = Integer.parseInt(parts[4].trim());
                            String mau = parts[5].trim();
                            String chatLieu = parts[6].trim();
                            int doDayDe = Integer.parseInt(parts[7].trim());
                            int size = Integer.parseInt(parts[8].trim());
                            String kieuGot = parts[9].trim();
                            int deCao = Integer.parseInt(parts[10].trim());
                            newSp = new CaoGot(maSP, tenSP, soLuong, donGia, mau, chatLieu, doDayDe, size, kieuGot,
                                    deCao);
                        }

                        if (newSp != null) {
                            sp = Arrays.copyOf(sp, sp.length + 1);
                            sp[sp.length - 1] = newSp;
                        } else {
                            System.out.println("Di lieu khong hop le: " + line);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Loi dinh dang: " + line);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Thieu truong hop du lieu: " + line);
                    }
                }
            }
            System.out.println("Doc file thanh cong");
        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }
    }

    public void ghiFile(String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (sanpham sp1 : sp) {

                bw.write(sp1.getMaSP() + "," +
                        sp1.getTensp() + "," +
                        sp1.getSl() + "," +
                        sp1.getDongia() + "," +
                        sp1.getMau() + "," +
                        sp1.getChatlieu() + "," +
                        sp1.getDodayde() + "," +
                        sp1.getSize());
                bw.newLine();
            }
            System.out.println("Ghi file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi khi doc file " + e.getMessage());
        }
    }

    public void showDs() {
        for (sanpham sp1 : sp) {
            sp1.xuat();
        }
    }

    @Override

    public void xoa() {
        System.out.println("Nhap ma san pham can xoa: ");
        int id = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < sp.length; i++) {
            if (sp[i].getMaSP() == id) {
                found = true;

                for (int j = i; j < sp.length - 1; j++) {
                    sp[j] = sp[j + 1];
                }

                sp = Arrays.copyOf(sp, sp.length - 1);
                System.out.println("Đã xóa sản phẩm có mã: " + id);
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sản phẩm với mã: " + id);
        }
    }

    public void sort() {
        for (int i = 0; i < sp.length - 1; i++) {
            for (int j = 0; j < sp.length - 1 - i; j++) {
                if (sp[j].getDongia() > sp[j + 1].getDongia()) {
                    sanpham temp = sp[j];
                    sp[j] = sp[j + 1];
                    sp[j + 1] = temp;
                }
            }
        }

    }

    @Override
    public int FindID(int id1) {
        sort();
        int l = 0;
        int r = sp.length - 1;
        sort();
        while (l <= r) {
            int mid = (l + r) / 2;
            if (sp[mid].getMaSP() == id1) {
                return sp[mid].getDongia();

            } else if (sp[mid].getMaSP() < id1) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return 0;
    }

    public void TimTheoTen() {
        System.out.println("nhap vao  ten sinh vien can tim: ");
        String ten = sc.nextLine();

        String[] DanhSachTen = new String[sp.length];
        for (int i = 0; i < sp.length; i++) {
            DanhSachTen[i] = sp[i].getTensp();
        }
        int index = Arrays.asList(DanhSachTen).indexOf(ten);
        System.out.println("ten sinh vien tim thay: ");
        if (index != -1) {
            sp[index].xuat();
        } else {
            System.out.println("khong tim thay");
            sc.nextLine();
        }
    }

    @Override
    public void timGanDungTen() {
        System.out.println("Nhap ten san pham can tim: ");
        String tenCanTim = sc.nextLine().trim().toLowerCase();
        boolean found = false;
        for (sanpham sp1 : sp) {
            if (sp1.getTensp().toLowerCase().contains(tenCanTim)) {
                sp1.xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay san pham nao gan dung.");
        }
    }

    public void choose() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Tao danh sach san pham");
            System.out.println("2. Hien thi danh sach san pham");
            System.out.println("3. Xoa san pham");
            System.out.println("4. Nhap them san pham");
            System.out.println("5. Tim san pham theo ten");
            System.out.println("6. Tim san pham gan dung ten");
            System.out.println("7. Thoát");
            System.out.print("Nhap lua chon: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    taoDS();
                    break;
                case 2:
                    showDs();
                    break;
                case 3:
                    xoa();
                    break;
                case 4:
                    nhapSP();
                    break;
                case 5:
                    TimTheoTen();
                    break;
                case 6:
                    timGanDungTen();
                    break;
                case 7:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 7);
    }

}
