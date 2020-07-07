#include <iostream>
#include <cmath>
using namespace std;

/*
==========Assignment No. 2==========

Design and implement classes: Point and Polygon. 

Point must have 3 coordinates (x, y, z) and there should be method for calculating distance between two objects and set of access methods for modifying field values.

Polygon is described by set of points. This class should have default constructor and constructor for defining set of points describing its objects. Also it should have methods to access amount of points in given instance and to calculate its circumference and method for substituting set of points for another.


Testing code is given (in main).

*/

class Point{
    private:

        double _x;
        double _y;

    public:
    
        Point():_x(0), _y(0){};
        Point(double x, double y):_x(x), _y(y){};

        double& x(){return _x;};
        double& y(){return _y;};
        const double& x() const {return _x;};
        const double& y() const {return _y;};

        double distance(const Point &a){return sqrt((a.x() - _x) * (a.x() - _x) + (a.y() - _y) * (a.y() - _y));};
};

class Polygon{
    private:

        int _size;
        Point* _pointer;

    public:

        Polygon():_size(0), _pointer(0){};

        Polygon(const Point *first, const Point *last):_size(last - first > 0 ? last - first : 0), _pointer(_size > 0 ? new Point[_size] : 0){
            for(int i = 0; i < _size; ++i)
                _pointer[i] = first[i];
        }

        Polygon(const Polygon &r):_size(r._size),_pointer(_size > 0 ? new Point [_size] : 0){
            for(int i = 0; i < _size; ++i){
                _pointer[i]=r._pointer[i];
            }
        }

        Polygon& operator = (const Polygon &r){
            if(this != &r){
                delete [] _pointer;
                _size = r._size;

                for(int i = 0; i < _size; ++i)
                    _pointer[i]=r._pointer[i];
            }
            return *this;
        }

        double perimeter(){
            if (_size == 0 || _size == 1)
                return 0;

            else if (_size == 2)
                return _pointer[0].distance(_pointer[1]);

            else if (_size > 2){
                double perimeter = 0;

                for(int i = 0; i < _size-1; ++i)
                    perimeter += _pointer[i].distance(_pointer[i+1]);

                perimeter += _pointer[0].distance(_pointer[_size]);
                return perimeter;
            }
        }

        Point& Point(int index){return _pointer[index];};

        void _points(Point *first, Point *last){
            last - first > 0 ? _size = last - first : _size = 0;
            _size > 0 ? _pointer = new Point[_size] : _pointer = 0;

            for(int i = 0; i < _size; ++i)
                _pointer[i] = first[i];
        }
        
        double quantity(){return _size;};

        ~Polygon(){delete [] _pointer;};

};

int main(){
    Point p(2, 3); 
    cout << p.x() << ' ' << p.y() << '\n'; 

    p.x() = 1; 
    p.y() = 1; 
    cout << p.x() << ' ' << p.y() << '\n'; 
    cout << p.distance(Point()) << '\n'; 

    Point t[] = { Point(0, 1), Point(0, 0), Point(1, 0), Point(1, 1) }; 
    Polygon w1(t, t+4); 
    cout << w1.perimeter() << '\n'; 

    w1.Point(1) = Point(0.5, 0.5); 
    cout << w1.perimeter() << '\n'; 

    Polygon w2; 
    w2._points(t, t+3); 
    cout << w2.perimeter() << '\n'; 

    for (int i = 0; i < w2.quantity(); ++i)   
        cout << w2.Point(i).x() << ' ' << w2.Point(i).y() << '\n';

    return 0;
}