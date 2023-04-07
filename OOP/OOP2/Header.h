#pragma once
#pragma once



template <class T> bool find(const T& liste, const int leange, double key) {

	for (int i = 0; i < leange; i++) {

		if (liste[i] == key) {
			return true;
		}
	}
	return false;
}

//template <class T, class ArrayList> bool operator==(const ArrayList& other, const ArrayList& other1) {
//
//	if (other.leange != other1.leange) {
//
//		std::cout << " false " << std::endl;
//		return false;
//	}
//
//	int speicher = 0;
//
//	for (int i = 0; i < other.leange; i++) {
//
//		if (other.get(i) == other1.get(i)) {
//
//			speicher = speicher + 1;
//		}
//	}
//	if (speicher == other.leange) {
//		std::cout << " true " << std::endl;
//		return true;
//	}
//	else {
//		std::cout << " false " << std::endl;
//		return false;
//	}
//
//}
//
//template <class T, class ArrayList> bool operator!=(const ArrayList& other, const ArrayList& other1) {
//
//	if (other.leange != other1.leange) {
//
//		std::cout << " true " << std::endl;
//		return true;
//	}
//
//	int speicher = 0;
//
//	for (int i = 0; i < other.leange; i++) {
//
//		if (other.get(i) == other1.get(i)) {
//
//			speicher = speicher + 1;
//		}
//	}
//	if (speicher == other.leange) {
//		std::cout << " false " << std::endl;
//		return false;
//	}
//	else {
//		std::cout << " true " << std::endl;
//		return true;
//	}
//
//}
//
//template <class T>
//ArrayList<T>::ArrayList(const int &size) : liste(new T[size]{
//}
//
//template <class T>
//ArrayList<T>::ArrayList(const ArrayList& other) : ArrayList(other.leange) {
//	for (int i = 0; i < other.leange; i++) {
//		liste[i] = other.liste[i];
//	}
//
//}


template <class T> class ArrayList {

private:
	T *liste;
	int leange;

public:

	/*friend std::ostream& operator<<(std::ostream& o, const ArrayList<T>& x);
	friend bool operator==(const ArrayList <T>& other, const ArrayList <T>& other1);
	friend bool operator!=(const ArrayList <T>& other, const ArrayList <T>& other1);
	ArrayList(const int & size);
	ArrayList(const ArrayList& other);*/

	ArrayList(const int &size) : liste(new T[size]), leange(size) {
	}

	ArrayList(const ArrayList& other) : ArrayList(other.leange) {

		for (int i = 0; i < other.leange; i++) {
			liste[i] = other.liste[i];
		}
	}

	~ArrayList() {
		std::cout << "ArrayList deleted" << std::endl;
		delete liste;
	}


	T get(int i) const {
		if (i >= 0 && i <= (leange - 1)) {
			return liste[i];
		}
		else {
			throw std::range_error("Fehler");
		}
	}

	void set(int i, T number) {
		if ((i >= 0) && (i <= (leange - 1))) {
			liste[i] = number;
		}
		else {

			//throw std::range_error("Fehler");
		}
	}

	bool operator==(const ArrayList<T>& other) {
		if (other.leange != this->leange) {

			std::cout << " false " << std::endl;
			return false;
		}

		int speicher = 0;

		for (int i = 0; i < other.leange; i++) {

			if (other.get(i) == this->get(i)) {

				speicher = speicher + 1;
			}
		}
		if (speicher == other.leange) {
			std::cout << " true " << std::endl;
			return true;
		}
		else {
			std::cout << " false " << std::endl;
			return false;
		}
	}

	bool operator!=(const ArrayList<T>& other) {

		if (other.leange != this->leange) {

			std::cout << " true " << std::endl;
			return true;
		}

		int speicher = 0;

		for (int i = 0; i < other.leange; i++) {

			if (other.get(i) == this->get(i)) {

				speicher = speicher + 1;
			}
		}
		if (speicher == other.leange) {
			std::cout << " false " << std::endl;
			return false;
		}
		else {
			std::cout << " true " << std::endl;
			return true;
		}

	}

	T& operator[](int i) {//index operator überladen zuweisen

		return liste[i];
	}

	const T operator[](const int i) const {//index operator überladen ausgeben

		return liste[i];
	}


	int getLength() const {
		return leange;

	}
};



//class ArrayList {
//private:
//	double *liste;
//	int leange;
//
//public:
//
//	ArrayList(const int &size);
//	ArrayList(const ArrayList &other);
//	~ArrayList();
//	ArrayList& operator=(const ArrayList& other);
//	double operator[](int i);
//	const double operator[](int i) const ;
//	
//	double get(int i) const;
//	void set(int i, double number);
//
//
//
//	friend bool operator==(const ArrayList& other, const ArrayList& other1);
//	//friend bool operator==(const ArrayList& other, const double other1);
//	friend bool operator!=(const ArrayList& other, const ArrayList& other1);
//
//	friend std::ostream& operator<<(std::ostream& out, const ArrayList& other);
//
//	
//	
//};

	/*ArrayList(const int &size);
	ArrayList(const ArrayList &other);
	~ArrayList();
	ArrayList& operator=(const ArrayList& other);
	double operator[](int i);
	const double operator[](int i) const;

	T get(int i) const;
	void set(int i, T number);*/

	//friend bool operator==(const ArrayList& other, const ArrayList& other1);
	////friend bool operator==(const ArrayList& other, const double other1);
	//friend bool operator!=(const ArrayList& other, const ArrayList& other1);

	//friend std::ostream& operator<<(std::ostream& out, const ArrayList& other);




template <class T> std::ostream& operator<<(std::ostream& out, const ArrayList<T> &other) {

	for (int i = 0; i < other.getLength(); i++) {
		out << "[" << other.get(i) << "]";
	}
	return out;
}
