import java.util.Scanner;

public class NhaCungCap {
    private String maNcc;
    private String tenNcc;
    private String diaChi;
    private String sdt;
    private String gmail;

    public NhaCungCap() {
    }

    public NhaCungCap(String maNcc, String tenNcc, String diaChi, String sdt, String gmail) {
        this.maNcc = maNcc;
        this.tenNcc = tenNcc;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.gmail = gmail;
    }

    public String getMaNcc() {
        return maNcc;
    }

    public void setMaNcc(String maNcc) {
        this.maNcc = maNcc;
    }

    public String getTenNcc() {
        return tenNcc;
    }

    public void setTenNcc(String tenNcc) {
        this.tenNcc = tenNcc;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nha cung cap:");
        maNcc = sc.nextLine();
        System.out.println("Nhap ten nha cung cap:");
        tenNcc = sc.nextLine();
        System.out.println("Nhap dia chi:");
        diaChi = sc.nextLine();
        System.out.println("Nhap so dien thoai:");
        sdt = sc.nextLine();
        System.out.println("Nhap gmail:");
        gmail = sc.nextLine();
    }

    @Override
    public String toString() {
        return "Ma Ncc: " + maNcc + ", Ten Ncc: " + tenNcc + " , Dia chi: " + diaChi + " , So dien thoai: " + sdt
                + " , Gmail: " + gmail;
    }

}
