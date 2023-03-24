## Interface Segregation

[Interface segregation is a software design technique that aims to simplify code structure by avoiding classes or modules being forced to implement unused methods. Instead, several smaller and more specific interfaces should be created for each use case. This technique helps keep code organized, reduces software complexity, and allows for greater flexibility in extending the software. In summary, interface segregation is an effective way to improve the quality and efficiency of software design]

### Bad example:

[#include <stdio.h>


typedef struct {
  int (*sum)(int x, int y);
  int (*multiply)(int x, int y);
} OperationInterface;

typedef struct {
  int x;
  int y;
} Data;


void performOperation(Data* data, OperationInterface* operationInterface) {
  // Sumar x e y
  int result = operationInterface->sum(data->x, data->y);
  printf("Resultado de la suma: %d\n", result);
  

  result = operationInterface->multiply(data->x, data->y);
  printf("Resultado de la multiplicación: %d\n", result);
}

int main() {

  Data myData = { .x = 5, .y = 10 };
  

  OperationInterface* operationInterface = &(OperationInterface) { 
    .sum = [](int x, int y) -> int { return x + y; },
    .multiply = [](int x, int y) -> int { return x * y; }
  };
  performOperation(&myData, operationInterface);
  
  return 0;
}]

### Good example:

[#include <stdio.h>


typedef struct {
  int (*multiply)(int x, int y);
} MultiplyInterface;


typedef struct {
  int x;
  int y;
} Data;


void multiplyData(Data* data, MultiplyInterface* multiplyInterface) {
  // Multiplicar x e y
  int result = multiplyInterface->multiply(data->x, data->y);
  printf("Resultado de la multiplicación: %d\n", result);
}

int main() {
  
  Data myData = { .x = 5, .y = 10 };
  
  MultiplyInterface* multiplyInterface = &(MultiplyInterface) { .multiply = [](int x, int y) -> int { return x * y; } };
  multiplyData(&myData, multiplyInterface);
  return 0;
]

### Related principles

- YAGNI
- Boy-Scout



---
[Back to the list](./README.md)