## Liskov Substitution

The Liskov Substitution Principle states that derived classes should be usable in place of their base classes without affecting the behavior of the program. This ensures coherence in the design of the class hierarchy and interoperability between classes. In summary, a derived class should be a valid substitute for its base class, without the program having to know details of its concrete implementation.

### Bad example:

interface OperationInterface {
    int operate(int a, int b);
}

class Main {
    static int add(int a, int b) {
        return a + b;
    }
    
    static int subtract(int a, int b) {
        return a - b;
    }
    
    public static void main(String[] args) {
        OperationInterface functionPtr = Main::add;
        System.out.println("The result of 3 + 4 is: " + functionPtr.operate(3, 4));
        
        functionPtr = Main::subtract;
        System.out.println("The result of 3 - 4 is: " + functionPtr.operate(3, 4));
    }
}

### Good example:

class Point {
    int x;
    int y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    void print() {
        System.out.printf("(%d, %d)\n", x, y);
    }
    
    void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
}

class Main {
    public static void main(String[] args) {
        Point p = new Point(3, 4);
        
        p.print();
        p.move(1, -2);
        p.print();
    }
}
### Related principles

- KISS


[Back to the list](./README.md)