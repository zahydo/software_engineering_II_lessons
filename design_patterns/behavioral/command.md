# Command 
## Description
The Command Design Pattern is a behavioral design pattern that provides a way to decouple an object that invokes an operation from the object that knows how to perform it. This pattern encapsulates a request for an operation in a command object, which allows the invoker object to store the command object and call its execute method when the operation is required.
## Problem:
 Sometimes it's necessary to implement functionality that allows for the separation of the object invoking an operation from the object actually performing it. In this case, it's not possible to directly invoke the required operation on the receiver object, as the invoker object has no knowledge of the receiver object's implementation details.
## Solution:
The Command Design Pattern provides a way to decouple the invoker object from the receiver object by encapsulating the request for an operation in a command object. This command object is responsible for invoking the required operation on the receiver object. The invoker object simply has to store the command object and call its execute method when the operation is required. This allows for the receiver object to be easily swapped out or modified without impacting the invoker object.
## Example: 
### Structure
<p align="center">
    <img src="./diagrams/command.svg"/>
</p>
### Implementation