## Chain of Responsibility 

This is a behavioral design pattern that allows requests to be passed between the links in a chain of handler objects. When each handler object receives a request, through its logic, it decides whether to solve the requested request, or pass the responsibility to the next handler, and so on until the request is solved.

The main advantages of this pattern is that the request handling order can be controlled and new handlers can be added without altering the already functional code, although there is the risk that the request cannot be resolved by any of the handlers. 

## Class Diagram of example:

![classDiagram](http://www.plantuml.com/plantuml/png/hP91IyD048Nl-HLpJ2avgBUWWeIYFTh4auYCoJHPsCo6tQaWiV_TJQsmXqsXnPoIcVVUV1b6iP3TOasmBb3hWgPl61Fmpx8bUH1VKORJmVP_xpburoA7JwEQP9yajKRdeDRkaPWiwZLlZUrnaXwJikfzitf-MPNLmGjtSFLRHx5Fo8qccuS0X-ROatIcsSCo6ZqHnRoBozWBmswd1LbccQ_FOWuZ_vcrwgWkTyDWx3pipPcmGMPwwGexLBmXDnXs-A6qagyZtkW4HTL-KkybAThMvL2ALTo-lWLHuGtUVcTP_AWYid3PiNRuUyaCQfRTn-UTDeIJJmj3XXy0)

## Example
Let's take the example of a call center. When calling, a bot does not give general information about the services it can provide. If the user does not need general information, but what he needs is communication with a consultant, then the responsibility for the request will fall on the next handler object, which will check if he can provide a solution or pass it to the next handler.

```Java
public interface ICallCenter{
    public void getAtention(int prmAtention);
}
```
So that all handlers know what to do, we use an interface with a base method, with which all handler objects can pass the request.

```Java
public class clsGeneralInformation implements ICallCenter{
    final int T_REQUEST = 1;
    ICallCenter atrHandler;

    public clsGeneralInformation(ICallCenter prmHandler){
        this.atrHandler = prmHandler;
    }

    @Override
    public void getAtention(int prmAtention){
        if(prmAtention == T_REQUEST){
            System.out.println("You are in the General information section");
        }else{
            atrHandler.getAtention(prmAtention);
        }
    }
}
```
Here we can see the `clsGeneralInformation` class which implements the `ICallCenter` interface. When checking if `prmAtention` is equal to the type of request required by the user, it will provide a solution to it, or the responsibility will be passed to the following link handler, overwriting the interface method.

```Java
public class clsConsultant implements ICallCenter{
    final int T_REQUEST = 2;
    ICallCenter atrHandler;

    public clsConsultant(ICallCenter prmHandler){
        this.atrHandler = prmHandler;
    }

    @Override
    public void getAtention(int prmAtention){
        if(prmAtention == T_REQUEST){
            System.out.println("You are in the Consultant section");
        }else{
            atrHandler.getAtention(prmAtention);
        }
    }
}
```
The same thing happens in the `clsCosultant` class. Being in the middle of the links, the object of this class receives the request of the `clsGeneralInformation` object and evaluates if it is possible to solve this problem. . Otherwise, by implementing the `gettAtention` method of the `ICallCenter` interface, pass the request to the next handler object. 

```Java
public class clsThecSupport implements ICallCenter{
    final int T_REQUEST = 3;
    ICallCenter atrHandler;

    public clsThecSupport(){}

    @Override
    public void getAtention(int prmAtention){
        if(prmAtention == T_REQUEST){
            System.out.println("You are in the Thecnical Support section");
        }else{
            System.out.println("It is not possible to manage your equest");
        }
    }
}
```
For the last part, we have the last handler object, which is the outermost part of the handler chain. This object has the last option to solve the request requested by the client. In case of not being able to solve it, it will show a message informing what happened. 

```Java
public class clsChainResponsability{
    public static void main(String[] args){
        clsThecSupport supportThenical = new clsThecSupport();
        clsConsultant atrConsultant = new clsConsultant(supportThenical);
        clsGeneralInformation atrGeneralInformation = new clsGeneralInformation(atrConsultant);
        
        atrGeneralInformation.getAtention(1);
    
    }
}
```
Here we have the base class of the entire program, which is hosted by the main method. When initializing objects, we start with the `atrGeneralInformation` attribute which is the first in the chain of handlers. From there, the object will determine if it has what is necessary to solve the request, or it will pass the responsibility to the other object, which in this case would be `atrConsultant`.

[Back](../behavioral/README.md)