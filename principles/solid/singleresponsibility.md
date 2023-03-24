## Single Responsibility (SRP)
The Single Responsibility Principle states that "a class or module should have only one reason to change." The idea behind SRP is that a class or module should have a single responsibility or job, and should not have multiple, unrelated responsibilities.

To make it easier to understand, let's first look at a code example that violates the SRP.


### Bad example:

```
public class Calculator{
    private int num1;
    private int num2;

    Calculator(){

    }

    Calculator(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;

    }

    public int add(){
        return num1 + num2;
    }

    public int sub(){
        retunr num1 - num2;
    }

    public int mul(){
        return num1 * num2;
    }

    public double div(){
        return num1/num2;
    }

    public void InputData(){
        Console.WriteLine("Ingrese El Numero 1:");
        num1 = Console.ReadLine();
        Console.WriteLine("Ingrese El Numero 2:");
        num2 = Console.ReadLine();
    }

    public Void PrintMenu(){
        Console.WriteLine("------Menu-----------")
        Console.WriteLine("Press 1 to addition");
        Console.WriteLine("Press 2 to subtract");
        Console.WriteLine("Press 3 to multipy");
        Console.WriteLine("Press 4 to divide");
    }

    Public void Menu(int Option, int num1, int num2){
        switch(option){
            case 1:
                printResult(add(num1, num2));
                break;
            case 2:
                printResult(sub(num1, num2));
                break;
            case 3:
                printResult(mul(num1,num2));
                break;
            case 4:
                printResult(div(num1,num2));
        }
        
    }

    public void printResutl(double result){
        Console.WriteLine("El Resultado es:"+result);
    }


}

```
Upon examining the class "Calculate," it is evident that it has three distinct responsibilities. Firstly, it is responsible for performing operations. Secondly, it handles all menu-related tasks, and lastly, it manages data. This is problematic since it violates the Single Responsibility Principle. Ideally, "Calculate" should only have one responsibility, which is to perform operations.

To rectify this issue, we can apply the SRP principle. In the subsequent example, we will demonstrate how this can be achieved.


### Good example:

```
public class Calculator{

    Calculator(){

    }

    public int add(int num1, int num2){
        return num1 + num2;
    }

    public int sub(int num1, int num2){
        retunr num1 - num2;
    }

    public int mul(int num1, int num2){
        return num1 * num2;
    }

    public double div(int num1, int num2){
        return num1/num2;
    }
}

public class UserInterface {
    UserInterface() {}

    public void printMenu() {
        Console.WriteLine("------Menu-----------")
        Console.WriteLine("Press 1 to addition");
        Console.WriteLine("Press 2 to subtract");
        Console.WriteLine("Press 3 to multiply");
        Console.WriteLine("Press 4 to divide");
    }

    public int getUserChoice() {
        int choice = Console.ReadLine();
        return choice;
    }

    public void printResult(double result) {
        Console.WriteLine("El Resultado es:" + result);
    }
}

public class Data{
    int num1;
    int num2;

    Data(){

    }

     Data(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }

      public void InputData(){
        Console.WriteLine("Ingrese El Numero 1:");
        num1 = Console.ReadLine();
        Console.WriteLine("Ingrese El Numero 2:");
        num2 = Console.ReadLine();
    }
}


public class menu{
    private Data data;
    Private Calculator calulator;
    private UserInterface userInterface;

    Menu(){

    }

    data.InputData();
    userInterface.printMenu();
    

    Public void Menu(int Option){
        switch(option){
            case 1:
                userInterface.printResult(add(data.num1, data.num2));
                break;
            case 2:
                userInterface.printResult(sub(data.num1, data.num2));
                break;
            case 3:
                userInterface.printResult(mul(data.num1,data.num2));
                break;
            case 4:
                userInterface.printResult(div(data.num1,data.num2));
        }
        
    }
}

```
We have applied the Single Responsibility Principle (SRP) by creating four classes, each with a specific responsibility. The first class, Calculator, is responsible for performing all operations. The second class, UserInterface, manages all aspects of the user's interaction with the program. The third class, Data, manages all relevant data. Finally, the Menu class is responsible for managing all aspects of the program's menu.

By applying the SRP in this way, we have ensured that each class has a clear and distinct responsibility, which makes the program easier to understand, maintain, and modify.





### Related principles

- [Links to other principles] 
- [Separation of Concerns](../general/separationofconcerns.md)
- [Code For The Maintainer](../general/codeformantainer.md)
- [Boy-Scout Rule](../general/boyscoutrule.md)

### Related patterns

- [Pattern names]


[Back to the list](./README.md)