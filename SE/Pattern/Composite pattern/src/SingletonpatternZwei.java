public class SingletonpatternZwei {

    public static void main(String[] args) {
        SingletonZwei unique = SingletonZwei.getUniqueInstance();
        System.out.println(unique.getName());
        SingletonZwei unique1 = SingletonZwei.getUniqueInstance();
        System.out.println(unique1.getName());
        System.out.println(unique1.getCount());
    }
}
