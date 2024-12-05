
public class Main_Sp {

    public static void main(String[] args) {

        DanhSachSanPham danhSachSanPham = new DanhSachSanPham();

        danhSachSanPham.docFile("OOP/sanpham.txt");
        danhSachSanPham.choose();

        danhSachSanPham.ghiFile("OOP/sanpham.txt");
    }
}
