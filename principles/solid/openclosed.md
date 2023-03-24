## Open/Closed

["The Open/Closed Principle (OCP) is an object-oriented design principle that states that classes should be open for extension but closed for modification. This means that a class should be able to extend its behavior without changing its original source code. In other words, new functionalities should be added to a class without modifying its existing implementation. This ensures greater stability and reliability of the system as a whole, as changes made to a class will not affect its current operation or that of other components that depend on it."]

### Bad example:

[#include <stdio.h>

void print_message(char* message) {
   printf("%s\n", message);
}

void print_message_with_time(char* message) {
   time_t current_time;
   time(&current_time);
   printf("%s: %s\n", ctime(&current_time), message);
}]

### Good example:

[#include <stdio.h>

void print_message(char* message) {
   printf("%s\n", message);
}

void print_message_uppercase(char* message) {
   char* uppercase_message = uppercase_string(message);
   print_message(uppercase_message);
   free(uppercase_message);
}

char* uppercase_string(char* message) {
   // implementation to convert the message to uppercase
}]

### Related principles

- [Separación de intereses] 


---
[Back to the list](./README.md)