
public class qlsp {

    public static void main(String[] args) {
        DanhSachSanPham sp = new DanhSachSanPham();
        DanhSachChiTietDonNH ct = new DanhSachChiTietDonNH();
        DanhSachHoaDon hd = new DanhSachHoaDon();
        qlbh ql = new qlbh();
        ql.nhapfile(sp, ct, hd);
        ql.choose(sp, ct, hd);
        ql.ghiFile(sp, ct, hd);
    }

}
