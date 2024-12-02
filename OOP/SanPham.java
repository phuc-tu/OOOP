import java.util.Scanner;

public abstract class SanPham {

    private String MaSP;
    private String tensp;
    private int sl;
    private int dongia;
    private String mau;
    private String size;
    private String chatlieu;
    private int dodayde;
    Scanner sc = new Scanner(System.in);

    public SanPham() {
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String maSP) {
        MaSP = maSP;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getChatlieu() {
        return chatlieu;
    }

    public void setChatlieu(String chatlieu) {
        this.chatlieu = chatlieu;
    }

    public int getDodayde() {
        return dodayde;
    }

    public void setDodayde(int dodayde) {
        this.dodayde = dodayde;
    }

    public void nhapSanPham() {
        System.out.print("Nhap ma san pham: ");
        this.MaSP = sc.nextLine();

        System.out.print("Nhap ten san pham: ");
        this.tensp = sc.nextLine();

        System.out.print("Nhap so luong: ");
        this.sl = sc.nextInt();

        System.out.print("Nhap don gia: ");
        this.dongia = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhap mau: ");
        this.mau = sc.nextLine();

        System.out.print("Nhap size: ");
        this.size = sc.nextLine();

        System.out.print("Nhap chat lieu: ");
        this.chatlieu = sc.nextLine();

        System.out.print("Nhap do day de: ");
        this.dodayde = sc.nextInt();
    }

    public void hienThiSanPham() {
        System.out.println("Ma san pham: " + MaSP);
        System.out.println("Ten san pham: " + tensp);
        System.out.println("So luong: " + sl);
        System.out.println("Don gia: " + dongia);
        System.out.println("Mau: " + mau);
        System.out.println("Size: " + size);
        System.out.println("Chat lieu: " + chatlieu);
        System.out.println("Do day de: " + dodayde);
    }

    public int tinhGiaTri() {
        return sl * dongia;
    }

    public abstract void tinhToan();
}
