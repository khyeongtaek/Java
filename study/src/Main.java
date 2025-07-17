

public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

//        System.out.println(list);
        list.add(1);
        System.out.println(list);
        list.add(1);list.add(1);list.add(1);list.add(1);
        list.add(1);list.add(1);list.add(1);list.add(1);
        list.add(1);list.add(1);
        System.out.println(list);
        list.trimToSize();
        System.out.println(list);


    }
}