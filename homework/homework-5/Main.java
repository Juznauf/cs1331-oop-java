import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> ls1 = new MyList();
        ls1.add(1);
        ls1.add(2);
        ls1.add(3);
        ls1.add(3);
        System.out.println(ls1.contains(3));
        System.out.println(ls1);
        System.out.println(ls1.get(0));
        ls1.replace(2, 6);
        System.out.println(ls1.get(1));
        ls1.remove(6);
        System.out.println(ls1.get(1));
        System.out.println(ls1.size());
        ls1.clear();
        System.out.println(ls1.size());
        System.out.println(ls1.isEmpty());
    }
}