## Interface Segregation

[Interface segregation is a software design technique that aims to simplify code structure by avoiding classes or modules being forced to implement unused methods. Instead, several smaller and more specific interfaces should be created for each use case. This technique helps keep code organized, reduces software complexity, and allows for greater flexibility in extending the software. In summary, interface segregation is an effective way to improve the quality and efficiency of software design]

### Bad example:

interface OperationInterface {
    int sum(int x, int y);
    int multiply(int x, int y);
}

class Data {
    int x;
    int y;
    
    public Data(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    static void performOperation(Data data, OperationInterface operationInterface) {
        // Sumar x e y
        int result = operationInterface.sum(data.x, data.y);
        System.out.println("Resultado de la suma: " + result);
        
        result = operationInterface.multiply(data.x, data.y);
        System.out.println("Resultado de la multiplicación: " + result);
    }
    
    public static void main(String[] args) {
        Data myData = new Data(5, 10);
        
        OperationInterface operationInterface = new OperationInterface() {
            public int sum(int x, int y) { return x + y; }
            public int multiply(int x, int y) { return x * y; }
        };
        
        performOperation(myData, operationInterface);
    }
}

### Good example:

interface MultiplyInterface {
    int multiply(int x, int y);
}

class Data {
    int x;
    int y;
    
    public Data(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    static void multiplyData(Data data, MultiplyInterface multiplyInterface) {
        // Multiplicar x e y
        int result = multiplyInterface.multiply(data.x, data.y);
        System.out.println("Resultado de la multiplicación: " + result);
    }
    
    public static void main(String[] args) {
        Data myData = new Data(5, 10);
        
        MultiplyInterface multiplyInterface = new MultiplyInterface() {
            public int multiply(int x, int y) { return x * y; }
        };
        
        multiplyData(myData, multiplyInterface);
    }
  }


### Related principles

- YAGNI
- Boy-Scout



---
[Back to the list](./README.md)