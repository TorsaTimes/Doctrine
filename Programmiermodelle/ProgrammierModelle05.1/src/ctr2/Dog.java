package ctr2;


public class Dog {
	
	private String name;
	private int size;

	Dog(String name, int size) {
		setName(name);
		setSize(size);
	}
	
	  Dog(Dog d1){
	        this.name = d1.getName();
	        this.size = d1.getSize();
	    }

	String getName() {
		return this.name;
	}

	int getSize() {
		return this.size;
	}

	void setName(String name) {
		if (name == null)
			throw new IllegalArgumentException();
		this.name = name;
	}

	void setSize(int size) {
		if (size < 0 || size > 100)
			throw new IllegalArgumentException();
		this.size = size;
	}

	@Override
	public String toString() {
		return "My name is " + name.toUpperCase() + ", my size is " + size + "cm";
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null || getClass() != other.getClass())
			return false;
		Dog dog = (Dog) other;
		return name.equals(dog.name) && size == dog.size;
	}
}
