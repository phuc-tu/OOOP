public interface DanhSachPhieuNhapHang {
    void themPhieu(PhieuNhapHang phieu);

    void suaPhieu(String maPhieu, PhieuNhapHang phieuMoi);

    void xoaPhieu(String maPhieu);

    PhieuNhapHang timPhieu(String maPhieu);

    void hienThiPhieu();
}
