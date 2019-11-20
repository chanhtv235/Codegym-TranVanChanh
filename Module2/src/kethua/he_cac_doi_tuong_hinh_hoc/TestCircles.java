package kethua.he_cac_doi_tuong_hinh_hoc;

public class TestCircles {
    public static void main(String[] args) {
            Circle circle = new Circle();
            System.out.println(circle);

            circle = new Circle(3.5);
            System.out.println(circle);

            circle = new Circle("indigo", false, 3.5);
            System.out.println(circle);
    }

}
