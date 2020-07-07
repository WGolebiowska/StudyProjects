#include <iostream>
#include <cmath>
using namespace std;

/*
==========Assignment No. 4==========


Design and implement class Point with (x, y, z) coordinates. It should have following functionalities:

- access to coordinate by index number
- calculating distance between 2 points
- adding/subtracting 2 points
- symmetrical product of point and floating point number
- comparing size of two points
- << and >> operators.

 with name, surname, age and address fields. Address should be an dynamic Address class object. Address class should have city, zipcode, street and street number fields. 

Both classes should have default constructor and second constructor for initializing objects with given values of for all fields. Also they should have << operator.


Testing code is given (in main).

*/

class Point {

  public:
    Point(const double &a1, const double &a2, const double &a3){
      p[0]=a1;
      p[1]=a2;
      p[2]=a3;
    };

    Point(){
      p[0]=0;
      p[1]=0;
      p[2]=0;
    };

    Point(const double (&r)[3]){
      p[0] = r[0];
      p[1] = r[1];
      p[2] = r[2];
    };

    const double & operator[](const int index) const {
      return p[index];
    };

    double & operator [] (const int index){
      return p[index];
    };

    const double distance(const Point &a) const {
      double x = (a[0] - p[0]) * (a[0] - p[0]);
      double y = (a[1] - p[1]) * (a[1] - p[1]);
      double z = (a[2] - p[2]) * (a[2] - p[2]);
      return sqrt(x+y+z);
    };

    const Point operator + (const Point &a) const {
      double tab2[3];
      tab2[0] = p[0]+a[0];
      tab2[1] = p[1]+a[1];
      tab2[2] = p[2]+a[2];
      return Point(tab2);
    };

    const Point operator - (const Point &a) const {
      double tab2[3];
      tab2[0] = p[0]-a[0];
      tab2[1] = p[1]-a[1];
      tab2[2] = p[2]-a[2];
      return Point(tab2);
    };

    friend ostream & operator << (ostream &, const Point &);
    friend istream & operator >> (istream &, Point &);
    friend const Point operator * (const Point &, double );
    friend const Point operator * (double, const Point &);
    friend const bool operator < (const Point&, const Point&);
    friend bool operator == (const Point &, const Point &);

  private:

    double p[3];
};

ostream & operator << (ostream &o, const Point &a){
  return o << a[0] << "," << a[1] <<"," << a[2];
}

  bool operator == (const Point & a, const Point & b){
  double a1 = a.distance(a);
  double a2 = b.distance(b);
  double dis = abs(a1-a2);
  return ((a.distance(Point())==b.distance(Point()))&&(dis<0.0000000001));
}


istream & operator >> (istream &o, Point &a){
  return o >> a[0] >> a[1] >> a[2];
}

const Point operator * (const Point &a, double x){
  double tab2[3];
  tab2[0] = a[0]*x;
  tab2[1] = a[1]*x;
  tab2[2] = a[2]*x;
  return Point(tab2);
}

const Point operator * (double x, const Point &a){
  double tab2[3];
  tab2[0] = a[0]*x;
  tab2[1] = a[1]*x;
  tab2[2] = a[2]*x;
  return Point(tab2);
}

const bool operator < (const Point &p1, const Point &p2){
    return (p1.distance(Point()) < p2.distance(Point()) \);
}

int main(){

  double x[2][3] = {{1.0, 1.0, 1.0},
                    {1.0, 2.0, 3.0}};

  Point p1(x[0]), p2(x[1]);
  const Point p3(0.4, 0.2, 0.1);

  cout << p1 << ", " << p2 << '\n';
  cout << p3[0] << ' ' << p3[1] << ' ' << p3[2] << '\n';
  cout << p1.distance(Point()) << ", "<< p3.distance(p1) << '\n';
  cout << p1 + p2 << ", "<< p1 - p3 << '\n';
  cout << 3.14 * p2 << ", " << p2 * 3.14 << '\n';
  cout << (p1 < p3) << ", " << (p1 == Point(1.0, 1.0,1.0)) << '\n';

  cin >> p1;
  cout << p1 << '\n';

  return 0;
}
