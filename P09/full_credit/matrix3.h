#include <iostream>

class Matrix3 {
    private:
        int data[3][3] = {};
        
    public: 
        Matrix3();
	Matrix3(int m00, int m01, int m02, int m03, int m10, int m11, int m20, int m21, int m22);       			
	int get(int x, int y);
	Matrix3 operator+(Matrix3 rhs);
	friend std::ostream& operator<<(std::ostream &out, Matrix3 &m);
	friend std::istream& operator>>(std::ostream &in, Matrix3 &m);

};
