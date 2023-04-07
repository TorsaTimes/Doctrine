package ctr2;

class DogPair{
	private final Dog small, big;
	DogPair(Dog dog1, Dog dog2) {
	if(dog1.getSize()<dog2.getSize()){
	this.small = dog1;
	this.big = dog2;
	}
	else{
	this.small = dog2;
	this.big = dog1;
	} }
	public Dog getSmallDog(){//Defensive Kopie die Methode getSmallDog gibt ein Objekt der Klasse WrapperUnmodifiableDog zurück
		WrapperUnmodifiableDog wrapperDog = new WrapperUnmodifiableDog(small);
		return wrapperDog;
	}
	@Override
	public String toString(){
	return "Small Dog: "+small+"\n"+
	"Big Dog: "+big;
	}
	}
