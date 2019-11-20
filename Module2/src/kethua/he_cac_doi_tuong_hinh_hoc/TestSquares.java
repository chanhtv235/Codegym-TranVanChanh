package kethua.he_cac_doi_tuong_hinh_hoc;

public class TestSquares {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);

        square = new Square("red",false,10);
        System.out.println(square);

        square = new Square(2.3);
        System.out.println(square);
    }
}
