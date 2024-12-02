
import java.util.Scanner;

public class CaoGot extends sanpham {
    private String kieugot;
    private int decao;
    Scanner sc = new Scanner(System.in);

    public CaoGot() {

    };

    public CaoGot(int MaSP, String tensp, int sl, int dongia, String mau, String chatlieu, int dodayde, int size,
            String kieugot, int decao) {
        super(MaSP, tensp, sl, dongia, mau, chatlieu, dodayde, size);
        this.kieugot = kieugot;
        this.decao = decao;
    }

    public CaoGot(CaoGot cg1) {
        super((sanpham) cg1);
        this.kieugot = cg1.kieugot;
        this.decao = cg1.decao;
    }

    @Override
    public void nhap() {
        super.nhap();
        this.kieugot = sc.nextLine();
        this.decao = sc.nextInt();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Kieu got :" + this.kieugot);
        System.out.println("De cao :" + this.decao);
    }
}
