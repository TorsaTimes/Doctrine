package ctr2;

public class TestUnmodifiablePattern {


	public static void main(String[] args) {

		Dog winnie = new Dog("Winnie", 47);
        WrapperUnmodifiableDog tiger = new WrapperUnmodifiableDog(winnie);//Wrapper Object erzeugt das unveränderbar ist! 
        
        System.out.println(winnie + " Dog winnie ausgeben");
        System.out.println(tiger + " Dog tiger ausgeben");
        
        //tiger.setName("Esel"); //Wirft eine Exception UnsupportedOperationException
        //tiger.setName("ferkel");//Wirft eine Exception UnsupportedOperationException

        winnie.setName("Eule");//Dog Object winnie name verändern geht
        winnie.setSize(11);//Dog Object winnie size verändern geht
        
        
        System.out.println(winnie + " Dog winnie ausgeben");
        System.out.println(tiger + " Dog tiger ausgeben darf nicht sein");
        
        Dog ferkel = new Dog("Schweinchen" , 99);
        
        DogPair ferkelTiger = new DogPair(ferkel,tiger);//DogPair erzeugt
        System.out.println(ferkelTiger + " Dog winnieTiger ausgeben");//DogPair ferkelTiger ausgeben Big dog = ferkel small Dog = tiger
        Dog rabbit = ferkelTiger.getSmallDog();//small dog = tiger
        
        System.out.println(rabbit + " Dog rabbit ausgeben");//Ausgabe: My name is ESEL, my size is 11cm
        
       
        System.out.println(rabbit.getSize());//11
        
        DogPair winnieSchweinchen = new DogPair(winnie,ferkel);
        
        System.out.println(winnieSchweinchen.getSmallDog());

		
	}

}
