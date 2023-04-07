// Aufgabenblatt3.cpp : Diese Datei enthält die Funktion "main". Hier beginnt und endet die Ausführung des Programms.
//

#include "pch.h"
#include <iostream>
#include "Vector3D.h"




	Vector3D::Vector3D(float x=0, float y=0, float z=0) :x(x), y(y), z(z) {
	}
	

	/*Vector3D::Vector3D() {
		x = 0; y = 0; z = 0;
	}*/

	Vector3D::Vector3D(const Vector3D& other) : x(other.x),y(other.y),z(other.z) {};
	

	Vector3D Vector3D::operator+(const Vector3D& other1) {
		Vector3D result(this->x + other1.x,this->y + other1.y,this->z + other1.z);
		return result;
	}
	Vector3D operator-(const Vector3D& other, const Vector3D& other1) {
		Vector3D result(other.x - other1.x, other.y - other1.y, other.z - other1.z);
		return result;
	}
	std::ostream& operator<<(std::ostream& out, const Vector3D& other) {
		out << '(' << other.x << ',' << other.y << ',' << other.z << ')';
		return out;

	}
	Vector3D operator*(const float other, const Vector3D& other1) {
		Vector3D result(other * other1.x, other * other1.y, other * other1.z);
		return result;
	}

	Vector3D operator*(const Vector3D& other, const float other1) {
		Vector3D result = other1 * other;
		return result;

	}

	float operator*(const Vector3D& other, const Vector3D& other1) {
		
		float result = (other.x * other1.x) + (other.y * other1.y) +  (other.z * other1.z);
		return result;

	}

	/*Vector3D operator*(const Vector3D& other, const Vector3D& other1) {
		Vector3D result(other.x * other1.x, other.y * other1.y, other.z * other1.z);
		return result;
	}*/

	void Vector3D::dump() {

		std::cout << x << y << z << std::endl;

	}
	

int main()
{
   

	Vector3D vector1(2, 3, 4);
	Vector3D vector2(2, 3, 4);
	Vector3D vector3(0, 0, 0);

	std::cout << "Vector1" << std::endl;
	std::cout << vector1 << std::endl;
	std::cout << "Vector2" << std::endl;
	std::cout << vector2 << std::endl;
	std::cout << "Vector3" << std::endl;
	std::cout << vector3 << std::endl;

	std::cout << "Vector1 - Vector2" << std::endl;
	std::cout << vector1 - vector2 << std::endl;
	std::cout << "Vector1 + Vector2" << std::endl;
	std::cout << vector1 + vector2 << std::endl;
	
	std::cout << "Vector4 = Vector1" << std::endl;
	Vector3D vector4 = vector1;
	vector4 = vector1;
	std::cout << vector4 << std::endl;

	std::cout << "float zahl 5 * vector2" << std::endl;
	std::cout <<  5 * vector2 << std::endl;
	std::cout << vector2 * 5 << std::endl;
	std::cout << "Vector1 * vector2" << std::endl;
	std::cout << vector1 * vector2 << std::endl;


}

// Programm ausführen: STRG+F5 oder "Debuggen" > Menü "Ohne Debuggen starten"
// Programm debuggen: F5 oder "Debuggen" > Menü "Debuggen starten"

// Tipps für den Einstieg: 
//   1. Verwenden Sie das Projektmappen-Explorer-Fenster zum Hinzufügen/Verwalten von Dateien.
//   2. Verwenden Sie das Team Explorer-Fenster zum Herstellen einer Verbindung mit der Quellcodeverwaltung.
//   3. Verwenden Sie das Ausgabefenster, um die Buildausgabe und andere Nachrichten anzuzeigen.
//   4. Verwenden Sie das Fenster "Fehlerliste", um Fehler anzuzeigen.
//   5. Wechseln Sie zu "Projekt" > "Neues Element hinzufügen", um neue Codedateien zu erstellen, bzw. zu "Projekt" > "Vorhandenes Element hinzufügen", um dem Projekt vorhandene Codedateien hinzuzufügen.
//   6. Um dieses Projekt später erneut zu öffnen, wechseln Sie zu "Datei" > "Öffnen" > "Projekt", und wählen Sie die SLN-Datei aus.
