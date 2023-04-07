#pragma once

class Vector3D {
	const float x, y, z;
	
	public:
	
	Vector3D(float x, float y, float z);
	
	Vector3D(const Vector3D& other);
	
	//~Vector3D();

	void dump();
	
	Vector3D operator+(const Vector3D& other1);
	
	friend Vector3D operator-(const Vector3D& other, const Vector3D& other1);
	
	friend std::ostream& operator<<(std::ostream& out, const Vector3D& other);
	
	friend Vector3D operator*(const float other, const Vector3D& other1);
	
	friend float operator*(const Vector3D& other, const Vector3D& other1);
	
	friend Vector3D operator*(const Vector3D& other, const float other1);
	
	//friend Vector3D operator*(const Vector3D& other, const Vector3D& other1);


	/*Vector3D operator=(const Vector3D& other1) {
		float result = result +  other1.x;
		float result = result + other1.y;
		float result = result + other1.z;
		return result;
	}*/
};
