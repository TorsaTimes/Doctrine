package ctr2;

 class WrapperUnmodifiableDog extends Dog{//WrapperUnmodifiableDog extends Dog gleich wie bei UnmodifiableList diese von Collection abgeleitet ist!
	
	private final String name;//gleiche private Attribut wie in der Dog Klasse 
	private final int size;//diese sind jedoch mit final versehen diese sind nach der Initialisierung nicht mehr änderbar.
	 
	 public WrapperUnmodifiableDog(Dog d1) {//Der Konstruktor erhält ein Dog Objekt ähnlich wie bei der UnmodifiableList diese erhält ebenfalls eine Liste von Typ Collection
		super(d1);//Konstruktor der Oberklasse da WrapperUnmodifiableDog abgeleitet von Dog ist 
		this.name = d1.getName();
		this.size = d1.getSize();
	} 
	@Override
	String getName() {
      return name;
	}
	@Override
	int getSize() {
      return size;
	}
	@Override
	public void setName(String name) {//Die setter der Klasse WrapperUnmodifiableDog enthalten die erforderliche Exception
		throw new UnsupportedOperationException();//Exception werfen wie in der Klasse UnmodifiableList
	}
	@Override
	public void setSize(int size) {
		throw new UnsupportedOperationException();//Exception werfen wie in der Klasse UnmodifiableList
	}
	
	@Override
   public String toString(){//Gibt das unveränderbare WrapperUnmodifiableDog Objekt aus!
   return "My name is "+name.toUpperCase()+ ", my size is "+size+"cm";
   }
   
	@Override
   public boolean equals(Object other){
   if(other==null || getClass() != other.getClass()) return false;
   Dog dog=(Dog) other;
   return dog.getName().equals(dog.getName()) && dog.getSize()==dog.getSize();
	}
}
