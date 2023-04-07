#pragma once



//template <class T> bool find(const T& liste, const int leange, double key) {
//
//	for (int i = 0; i < leange; i++) {
//
//		if (liste[i] == key) {
//			return true;
//		}
//	}
//	return false;
//}
//
////template <class T, class ArrayList> bool operator==(const ArrayList& other, const ArrayList& other1) {
////
////	if (other.leange != other1.leange) {
////
////		std::cout << " false " << std::endl;
////		return false;
////	}
////
////	int speicher = 0;
////
////	for (int i = 0; i < other.leange; i++) {
////
////		if (other.get(i) == other1.get(i)) {
////
////			speicher = speicher + 1;
////		}
////	}
////	if (speicher == other.leange) {
////		std::cout << " true " << std::endl;
////		return true;
////	}
////	else {
////		std::cout << " false " << std::endl;
////		return false;
////	}
////
////}
////
////template <class T, class ArrayList> bool operator!=(const ArrayList& other, const ArrayList& other1) {
////
////	if (other.leange != other1.leange) {
////
////		std::cout << " true " << std::endl;
////		return true;
////	}
////
////	int speicher = 0;
////
////	for (int i = 0; i < other.leange; i++) {
////
////		if (other.get(i) == other1.get(i)) {
////
////			speicher = speicher + 1;
////		}
////	}
////	if (speicher == other.leange) {
////		std::cout << " false " << std::endl;
////		return false;
////	}
////	else {
////		std::cout << " true " << std::endl;
////		return true;
////	}
////
////}
////
////template <class T>
////ArrayList<T>::ArrayList(const int &size) : liste(new T[size]{
////}
////
////template <class T>
////ArrayList<T>::ArrayList(const ArrayList& other) : ArrayList(other.leange) {
////	for (int i = 0; i < other.leange; i++) {
////		liste[i] = other.liste[i];
////	}
////
////}
//
//
//template <class T, int leange> class ArrayList {
//
//private:
//	T *liste;
//
//public:
//
//
//	ArrayList();
//
//	ArrayList(const ArrayList& other);
//
//	~ArrayList() {
//		std::cout << "ArrayList deleted" << std::endl;
//		delete[] liste;
//	}
//
//	T operator[](const int &i)const;
//	T& operator[](const int &i);
//
//
//	T get(int i) const;
//
//	void set(int i, T number);
//
//	bool operator==(const ArrayList<T, leange>& other);
//
//	bool operator!=(const ArrayList<T, leange>& other);
//
//	int getLength() const;
//
//
//	ArrayList& operator=(const ArrayList& other);
//
//	//Aufgabe 5. ->3.
//	class ArrayListIterator {
//	private:
//		int offset;
//		const ArrayList<T, leange> &list;
//	public:
//		ArrayListIterator(int offset, ArrayList<T, leange> &list) : offset(offset), list(list) {};
//
//		void operator++() {
//			offset++;
//		}
//
//		bool operator!=(ArrayListIterator &iterator) {
//
//			if (&iterator.list == &list) {
//				return iterator.offset != offset;
//			}
//			else {
//				return true;
//			}
//		}
//
//
//		T& operator*() {
//			return list.liste[offset];
//		}
//
//	};
//
//	ArrayListIterator begin() {
//		return ArrayListIterator(0, *this);
//	}
//
//	ArrayListIterator  end() {
//		return ArrayListIterator(leange, *this);
//	}
//
//
//};
//
////class ArrayList {
////private:
////	double *liste;
////	int leange;
////
////public:
////
////	ArrayList(const int &size);
////	ArrayList(const ArrayList &other);
////	~ArrayList();
////	ArrayList& operator=(const ArrayList& other);
////	double operator[](int i);
////	const double operator[](int i) const ;
////	
////	double get(int i) const;
////	void set(int i, double number);
////
////
////
////	friend bool operator==(const ArrayList& other, const ArrayList& other1);
////	//friend bool operator==(const ArrayList& other, const double other1);
////	friend bool operator!=(const ArrayList& other, const ArrayList& other1);
////
////	friend std::ostream& operator<<(std::ostream& out, const ArrayList& other);
////
////	
////	
////};
//
//	/*ArrayList(const int &size);
//	ArrayList(const ArrayList &other);
//	~ArrayList();
//	ArrayList& operator=(const ArrayList& other);
//	double operator[](int i);
//	const double operator[](int i) const;
//
//	T get(int i) const;
//	void set(int i, T number);*/
//
//	//friend bool operator==(const ArrayList& other, const ArrayList& other1);
//	////friend bool operator==(const ArrayList& other, const double other1);
//	//friend bool operator!=(const ArrayList& other, const ArrayList& other1);
//
//	//friend std::ostream& operator<<(std::ostream& out, const ArrayList& other);
//
//
//
//
//template <class T, int leange> std::ostream& operator<<(std::ostream& out, const ArrayList<T, leange> &other) {
//
//	for (int i = 0; i < other.getLength(); i++) {
//		out << "[" << other.get(i) << "]";
//	}
//	return out;
//}
//
//template<class T, int leange>
//inline ArrayList<T, leange>::ArrayList()
//{
//	liste = new T[leange];
//}
//
////KopierKonstruktor
//template<class T, int leange>
//inline ArrayList<T, leange>::ArrayList(const ArrayList & other)
//{
//	for (int i = 0; i < other.leange; i++) {
//		liste[i] = other.liste[i];
//	}
//}
//
////Index Operator Lesen
//template<class T, int leange> T ArrayList<T, leange>::operator[](const int &i)const
//{
//	return (this->liste[i]);
//}
//
////Index Operator Schreiben
//template<class T, int leange> T& ArrayList<T, leange>::operator[](const int &i)
//{
//	return (this->liste[i]);
//}
//
////Methode get
//template<class T, int leange>
//inline T ArrayList<T, leange>::get(int i) const
//{
//	if (i >= 0 && i <= (leange - 1)) {
//		return liste[i];
//	}
//	else {
//		throw std::range_error("Fehler");
//	}
//}
//
////Methode set
//template<class T, int leange>
//inline void ArrayList<T, leange>::set(int i, T number)
//{
//	if ((i >= 0) && (i <= (leange - 1))) {
//		liste[i] = number;
//	}
//	else {
//
//		//throw std::range_error("Fehler");
//	}
//}
//
////operator==
//template<class T, int leange>
//inline bool ArrayList<T, leange>::operator==(const ArrayList<T, leange>& other)
//{
//	if (other.leange != this->leange) {
//
//		std::cout << " false " << std::endl;
//		return false;
//	}
//
//	int speicher = 0;
//
//	for (int i = 0; i < other.leange; i++) {
//
//		if (other.get(i) == this->get(i)) {
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
//}
//
////operator!=
//template<class T, int leange>
//inline bool ArrayList<T, leange>::operator!=(const ArrayList<T, leange>& other)
//{
//	if (other.leange != this->leange) {
//
//		std::cout << " true " << std::endl;
//		return true;
//	}
//
//	int speicher = 0;
//
//	for (int i = 0; i < other.leange; i++) {
//
//		if (other.get(i) == this->get(i)) {
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
//}
//
////getLeange----------
//template<class T, int leange>
//inline int ArrayList<T, leange>::getLength() const
//{
//	return leange;
//}
//
////------Nachtragen------------------------------------------------------------------------------------
//template<class T, int leange>
//inline ArrayList<T, leange> & ArrayList<T, leange>::operator=(const ArrayList<T, leange> & other)
//{
//	if (*this == other) {
//		return *this;
//	}
//	delete[] liste;
//	leange = other.leange;
//	liste = new T[leange];
//
//	for (int i = 0; i < leange; i++) {
//		liste[i] = other.liste[i];
//	}
//	return *this;
//}

