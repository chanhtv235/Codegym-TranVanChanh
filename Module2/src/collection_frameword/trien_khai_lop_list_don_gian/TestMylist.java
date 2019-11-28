package collection_frameword.trien_khai_lop_list_don_gian;

public class TestMylist {
    public static void main(String[] args) {
        Mylist<Integer> listInterger= new Mylist<Integer>();
        listInterger.add(2);
        listInterger.add(3);
        listInterger.add(3);
        listInterger.add(4);
        System.out.println("element 4"+listInterger.get(0));
        System.out.println("element 1:  "+listInterger.get(1));
        System.out.println("element 2:   "+listInterger.get(2));
        listInterger.add(6);
        System.out.println("element 2:   "+listInterger.get(4));
        //System.out.println("element 6: "+ listInterger.get(6));
        //listInterger.get(-1);
        //System.out.println("element -1: " + listInterger.get(-1));
    }
}
