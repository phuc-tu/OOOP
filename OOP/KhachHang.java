import java.util.Scanner;

public class KhachHang extends Nguoi {
    private String id;
    private String sdt;

    public KhachHang() {

    }

    public KhachHang(String ten, int tuoi, String diaChi, String gioiTinh, String id, String sdt) {
        super(ten, tuoi, gioiTinh, diaChi);
        this.id = id;
        this.sdt = sdt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma khach hang:");
        id = sc.nextLine();
        System.out.println("Nhap so dien thoai:");
        sdt = sc.nextLine();
    }

    public void hienThiThongTin() {
        System.out.println("Ten::" + getTen());
        System.out.println("Tuoi:" + getTuoi());
        System.out.println("Dia chi:" + getDiaChi());
        System.out.println("Gioi tinh:" + getGioiTinh());
        System.out.println("Ma khach hang:" + id);
        System.out.println("So dien thoai:" + sdt);
    }

    @Override
    public String toString() {
        return super.toString() + ", Ma Khach hang: " + id + ", So dien thoai " + sdt;
    }

}
