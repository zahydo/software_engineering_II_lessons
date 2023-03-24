## Liskov Substitution

[The Liskov Substitution Principle states that derived classes should be usable in place of their base classes without affecting the behavior of the program. This ensures coherence in the design of the class hierarchy and interoperability between classes. In summary, a derived class should be a valid substitute for its base class, without the program having to know details of its concrete implementation.]

### Bad example:

[#include <stdio.h>

int add(int a, int b) {
    return a + b;
}

int subtract(int a, int b) {
    return a - b;
}

int main() {
    int (*function_ptr)(int, int) = &add;
    printf("The result of 3 + 4 is: %d\n", (*function_ptr)(3, 4));
    
    function_ptr = &subtract;
    printf("The result of 3 - 4 is: %d\n", (*function_ptr)(3, 4));
    
    return 0;
}]

### Good example:

[#include <stdio.h>

typedef struct {
    int x;
    int y;
} Point;

void print_point(Point p) {
    printf("(%d, %d)\n", p.x, p.y);
}

void move_point(Point *p, int dx, int dy) {
    p->x += dx;
    p->y += dy;
}

int main() {
    Point p = {3, 4};
    
    print_point(p);
    move_point(&p, 1, -2);
    print_point(p);
    
    return 0;
}
En este ejemplo, se definen dos funciones print_point() y move_point() que trabajan con un objeto Point. Ambas funciones son sustitutos válidos una de la otra, ya que tienen el mismo comportamiento esperado y pueden ser intercambiadas sin problemas. print_point() simplemente imprime las coordenadas x e y de un punto en el formato (x, y), mientras que `move



]

### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)