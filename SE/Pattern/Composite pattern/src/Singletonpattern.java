public class Singletonpattern {

    public static void main(String[] args ){
        Singleton unique = Singleton.getUniqueInstance().get(0);
        System.out.println(unique.getName());

    }
}
