import java.util.Scanner;

public class NhanVien extends Nguoi {
    private String id;
    private String chucVu;
    private double luong;

    public NhanVien() {
        super();
    }

    public NhanVien(String ten, int tuoi, String gioiTinh, String diaChi, String id, String chucVu, double luong) {
        super(ten, tuoi, gioiTinh, diaChi);
        this.id = id;
        this.chucVu = chucVu;
        this.luong = luong;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    @Override
    public void nhap() {

        super.nhap();

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap nhan vien: ");
        id = sc.nextLine();

        System.out.print("Nhap chuc vu: ");
        chucVu = sc.nextLine();

        System.out.print("Nhap Luong: ");
        luong = sc.nextDouble();
        sc.nextLine(); //
    }

    @Override
    public void hienThiThongTin() {
        System.out.println(" Ten: " + getTen());
        System.out.println("Tuoi: " + getTuoi());
        System.out.println("Gioi Tinh: " + getGioiTinh());
        System.out.println("Dia chi: " + getDiaChi());
        System.out.println("Ma nhan vien: " + id);
        System.out.println("Chuc vu: " + chucVu);
        System.out.println("Luong: " + luong);
    }

    @Override
    public String toString() {
        return super.toString() + ", Ma nhan vien: " + id + ", Chuc vu: " + chucVu + ", Luong: " + luong;
    }
}
