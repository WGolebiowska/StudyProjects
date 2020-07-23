#include <iostream>
using namespace std;

/*
==========Assignment No. 1==========	 
   
Design and implement classes: Point, Rectangle, Prism, where:	 
  
- Point has 3 coordinates (x, y, z)	 
- Rectangle has width a and height b and is parallel to X-Y plane. Nodes on diagonal have coordinates (x, y, z) and (x + a, y + b, z)	 
- Prism is rectagonal and has height h.	 
  
All classes must have a set of constructors allowing defining objects with given initial values and set of access methods for modifying field values. There should be methods for calculating the area of the rectangle and volume of the prism.	 
  
Testing code is given (in main).
*/

class Point {
    private:

        double _x;
        double _y;
        double _z;

    public:

        Point():_x(0), _y(0), _z(0){};
        Point(double x, double y, double z):_x(x), _y(y), _z(z){};

        double& x(){return _x;};
        double& y(){return _y;};
        double& z(){return _z;};
        const double& x() const {return _x;};
        const double& y() const {return _y;};
        const double& z() const {return _z;};
};

class Rectangle {
    private:

        double _x;
        double _y;
        double _z;
        double _a;
        double _b;

    public:

        Rectangle():_x(0), _y(0), _z(0), _a(0), _b(0){};
        Rectangle(double x, double y, double z, double a, double b):_x(x), _y(y), _z(z), _a(a), _b(b){};
        Rectangle(Point point, double a, double b):_x(point.x()), _y(point.y()), _z(point.z()), _a(a), _b(b){};

        double& x(){return _x;};
        double& y(){return _y;};
        double& z(){return _z;};
        double& a(){return _a;};
        double& b(){return _b;};
        const double& x() const {return _x;};
        const double& y() const {return _y;};
        const double& z() const {return _z;};
        const double& a() const {return _a;};
        const double& b() const {return _b;};

        const double area() const {return _a*_b;};
};

class Prism {

    private:
        double _x;
        double _y;
        double _z;
        double _a;
        double _b;
        double _h;

    public:
        Prism():_x(0), _y(0), _z(0), _a(0), _b(0), _h(0){};
        Prism(double x, double y, double z, double a, double b, double h):_x(x), _y(y), _z(z), _a(a), _b(b), _h(h){};
        Prism(Point &point, double a, double b, double h):_x(point.x()), _y(point.y()), _z(point.z()), _a(a), _b(b), _h(h){};
        Prism(Rectangle rectangle, double h):_x(rectangle.x()), _y(rectangle.y()), _z(rectangle.z()), _a(rectangle.a()), _b(Rectangle.b()), _h(h){};

        double& x(){return _x;};
        double& y(){return _y;};
        double& z(){return _z;};
        double& a(){return _a;};
        double& b(){return _b;};
        double& h(){return _h;};
        const double& x() const {return _x;};
        const double& y() const {return _y;};
        const double& z() const {return _z;};
        const double& a() const {return _a;};
        const double& b() const {return _b;};
        const double& h() const {return _h;};

        const double volume() const {return _a*_b*_h;};

};

int main(){

    Point p1, p2(1, 2, 3); 
    const Point p3(1.1,2.2,3.3);
    cout << p3.x() << '\t' << p3.y() << '\t' << p3.z() << endl;

    p1.x()=1; 
    p1.y()=10; 
    p1.z()=100; 
    cout << p1.x() << '\t' << p1.y() << '\t' << p1.z() << endl;

    Rectangle r1, r2(1,2,3,10.5, 20.5); 
    const Rectangle pr3(p2,5,5); 
    cout << pr3.x() << '\t' << pr3.y() << '\t' << pr3.z() << '\n' << pr3.a() << '\t' << pr3.b() << '\n' << pr3.pole() << endl; 

    r1.x()=2; 
    r1.y()=20; 
    r1.z()=200; 
    r1.a()= 10; 
    r1.b()=10; 
    cout << r1.x() << '\t' << r1.y() << '\t' << r1.z() << '\n' << r1.a() << '\t' << r1.b()<< '\n' << r1.pole() << endl; 

    Prism prism1, prism2(1,2,3,10.5,20.5,30.5), prism3(p2,100,200,300); 
    const Prism prism4(pr3,5); 
    cout << prism4.x() << '\t' << prism4.y() << '\t' << prism4.z() << '\n' << prism4.a() << '\t' << prism4.b() << '\t' << prism4.h() << '\n' << prism4.volume() << endl; 

    prism1.a()=10; 
    prism1.b()=10; 
    prism1.h()=10; 
    cout << prism1.x() << '\t' << prism1.y() << '\t' << prism1.z() << '\n' << prism1.a() << '\t' << prism1.b() << '\t' << prism1.h() << '\n' << prism1.volume() << endl;    

    return 0;
}
