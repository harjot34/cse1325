#include <iostream> 
#include <iomanip>
#include "matrix3.h"
using namespace std;

        Matrix3::Matrix3(){
        
        }
        Matrix3::Matrix3(int m00, int m10, int m20, int m01, int m11, int m21, int m02, int m12, int m22){
			for(int i= 0; i < 3; i++)
			{
			   for(int j = 0; j < 3; j++)
			   {
				  data[i][j] = 0;
			   }
			}
			 data[0][0] = m00; 
			 data[1][0] = m10; 
			 data[2][0] = m20; 
			 data[0][1] = m01; 
			 data[1][1] = m11; 
			 data[2][1] = m21; 
			 data[0][2] = m02; 
			 data[1][2] = m12; 
			 data[2][2] = m22;
		}
 	       
			
		int Matrix3::get(int x, int y){
			return data[x][y];
		}
		
		Matrix3 operator+(Matrix3 rhs){
            int addData[3][3];
 
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
				    addData[i][j] = data[i][j] + rhs.data[i][j];
				}
			}

			for (int i = 0; i < 3; i++) { 
				for (int j = 0; j < 3; j++) {
				    rhs.data[i][j] = addData[i][j];
				}
			}
            return rhs;
		}
		
		std::ostream& operator<<(std::ostream &out, Matrix3 m){
	        //for (int r = 0; r < 3; r++) 
			//{ 
			//	out << m.get(r, 0); 
			//	for (int c = 0; c < 3; c++) 
			//	{ 
			//	    out << " " << m.get(r,c); 
			//	} 
			//} 
			return out;
		}
	
		std::istream& operator>>(std::istream &in, Matrix3 m){
			//for (int r = 0; r < 3; r++) 
			//	{ 
			//		in >> m.get(r, 0); 
			//		for (int c = 0; c < 3; c++) 
			//		{ 
			//			in >> " " >> m.get(r,c); 
			//		}  
			//	} 
		   return in;
		}


