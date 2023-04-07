#pragma once


#include <string>
#include <iostream>
#include <ostream>

namespace hfu {

	template <class T> bool find(const T *liste, const int leange, const T &key) {

	for (int i = 0; i < leange; i++) {

		if (liste[i] == key) {
			return true;
		}
	}
	return false;
}


	class Book {

	private:

		const std::string buchTitle;
		const std::string autor;
		const std::string anDatum;
		const bool status = false;


	public:

		std::string getStatus() const;
		std::string getBuchTitle() const;
		std::string getAutor() const;
		std::string getAnDatum() const;
		void dump() const;
		~Book();
		static std::string today();
		Book operator[](int i);
		Book get(int i);

		

		Book(const std::string autor, const std::string titel) :autor(autor), buchTitle(titel), anDatum(today()), status(true) {};
		Book(const std::string autor, const std::string titel, const std::string datum) :Book(autor, titel, datum, true) {};
		Book(const std::string autor, const std::string titel, const std::string datum, bool status) :autor(autor), buchTitle(titel), anDatum(datum), status(status) { std::cout << this->getBuchTitle() << " Normaler ctor" << std::endl; };

		Book() {};


		
		
		
		//bool operator<(const lhs,const rhs);

		//const Book& Book::operator=(const Book& other) {

		//	buchTitle = other.getBuchTitle;
		//	autor = other.getAutor;
		//	anDatum = other.getAnDatum;

		//	return *this;
		//}

	};

	std::ostream& operator<<(std::ostream& out, const hfu::Book& other);
	bool operator==(const Book& other, const Book& other1);
	bool operator<(const Book& other, const Book& other1);
}