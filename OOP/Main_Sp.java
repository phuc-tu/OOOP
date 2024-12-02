import java.io.File;

public class Main_Sp {

    public static void main(String[] args) {

        DanhSachSanPham danhSachSanPham = new DanhSachSanPham();

        String filePath = "sanpham.txt";

        danhSachSanPham.choose();

        danhSachSanPham.ghiFile(filePath);
    }
}
