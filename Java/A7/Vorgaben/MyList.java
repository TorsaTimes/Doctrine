public class MyList {

  public static void main(String[] args) {
     MyList l= new MyList();
     for (int i=1; i<=10; ++i)
        l.add(8*i);
     l.remove(2);
     for (int i=l.size()-1; i>=0; --i)
         System.out.print(" " + l.get(i));
     System.out.println();
   }
}
