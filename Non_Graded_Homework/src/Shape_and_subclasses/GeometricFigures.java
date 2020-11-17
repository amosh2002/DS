package Shape_and_subclasses;

public class GeometricFigures {

    public static int getSumOfShapeAreas(Shape[] shapes) {
        // -- Complexity: O(n) -- //
        int sum = 0;
        for (Shape shape : shapes) {
            sum += shape.getArea();
        }
        return sum;
    }

    // Think about sorting the shapes in the array so that the first one has the lowest height and 
    // the last one has the largest height. Think of your own algorithm, use a a temporary array if needed.
    // Please provide the worst case complexity of your algorithm as a comment
    public static void sortShapesByHeight(Shape[] shapes) {
        // -- Complexity: O(n^2) -- //
        for (int i = 0; i < shapes.length; i++) {
            for (int j = 0; j < shapes.length; j++) {
                if (shapes[i].getHeight() < shapes[j].getHeight()) {
                    Shape tmp = shapes[i];
                    shapes[i] = shapes[j];
                    shapes[j] = tmp;
                }
            }
        }
    }

    // ATTENTION! Do not change the code below. Your main task is to make the main function work and 
    // have SUCCESS printed foe all test cases.
    public static void main(String[] str) {
        // Expects the Rectangle class to have a constructor receiving the length and the width
        Shape rect1 = new Rectangle(7, 12);
        Shape rect2 = new Rectangle(15, 5);

        // Expects the Square class to have a constructor receiving the side length
        Shape sq1 = new Square(8);
        Shape sq2 = new Square(6);

        // Expects the IsoscelesTriable to have a constructor receiving the base length and height
        Shape triangle1 = new IsoscelesTriangle(4, 7);
        Shape triangle2 = new IsoscelesTriangle(12, 9);

        // Expects the Circle to have a constructor receiving the radius
        Shape circle1 = new Circle(3);
        Shape circle2 = new Circle(17);


        Shape[] shapes = {rect1, rect2, sq1, sq2, triangle1, triangle2, circle1, circle2};

        for (Shape shape : shapes) {
            shape.describe();
        }
        System.out.println();

        // Uncomment the code below if you need debugging
        //System.out.println("The sum of area of all shapes is " + getSumOfShapeAreas(shapes));
        if (1262 == getSumOfShapeAreas(shapes)) {
            System.out.println("Test1: SUCCESS");
        } else {
            System.out.println("Test1: FAILURE");
        }

        sortShapesByHeight(shapes);
        // Uncomment the block below if you need to do debugging
        /*
        for (Shape shape: shapes) {
            System.out.println(shape.getName() + " height is " + shape.getHeight());
        }
        */

        int i = 0;
        for (; i < shapes.length - 1; i++) {
            if (shapes[i].getHeight() > shapes[i + 1].getHeight()) {
                System.out.println("Test2: FAILURE");
                break;
            }
        }
        if (i == shapes.length - 1) {
            System.out.println("Test2: SUCCESS");
        }

        rect1.moveTo(12, 28);
        // Uncomment the code below if you need debugging
        //System.out.println(rect1.getXCoordinate());
        //System.out.println(rect1.getYCoordinate());

        if (rect1.getXCoordinate() == 12 && rect1.getYCoordinate() == 28) {
            System.out.println("Test3: SUCCESS");
        } else {
            System.out.println("Test3: FAILURE");
        }

        //System.out.println(triangle1.rotate());
        //System.out.println(circle1.rotate());

        if (triangle1.rotate().equals("Rotating Isosceles Triangle Shape - Custom")) {
            System.out.println("Test4: SUCCESS");
        } else {
            System.out.println("Test4: FAILURE");
        }
        if (circle1.rotate().equals("Rotating Circle Shape")) {
            System.out.println("Test5: SUCCESS");
        } else {
            System.out.println("Test5: FAILURE");
        }
    }
}
