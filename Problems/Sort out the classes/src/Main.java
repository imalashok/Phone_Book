class Sort {
    public static void sortShapes(Shape[] array,
                                  List<Shape> shapes,
                                  List<Polygon> polygons,
                                  List<Square> squares,
                                  List<Circle> circles) {
        for (Shape a : array) {
            if (a.getClass() == Polygon.class) {
                polygons.add((Polygon) a);
            } else if (a.getClass() == Square.class) {
                squares.add((Square) a);
            } else if (a.getClass() == Circle.class) {
                circles.add((Circle) a);
            } else {
                shapes.add(a);
            }
        }
    }
}

//Don't change classes below
class Shape { }
class Polygon extends Shape { }
class Square extends Polygon { }
class Circle extends Shape { }