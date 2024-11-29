public interface DanhSachNhanVien {
    void themNhanvien(NhanVien nv);

    void suaNhanvien(String id, NhanVien nv);

    void xoaNhanvien(String id);

    NhanVien timNhanvien(String id);

    void hienThiNhanvien();
}
