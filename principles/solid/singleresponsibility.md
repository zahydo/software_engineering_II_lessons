## Single Responsibility

[The Single Responsibility Principle (SRP) states that a class or module should have only one responsibility. In other words, a class or module should have only one reason to change. The SRP promotes cohesion and modularity in software design, which makes the system easier to understand, maintain, and scale.]

### Bad example:

[#include <stdio.h>

void read_file(char* filename) {
   FILE* file = fopen(filename, "r");
   char buffer[256];
   while (fgets(buffer, sizeof(buffer), file)) {
      printf("%s", buffer);
   }
   fclose(file);
   // Do some data processing
   // ...
   // Write data to the database
   // ...
}]

### Good example:

[#include <stdio.h>

void read_file(char* filename) {
   FILE* file = fopen(filename, "r");
   char buffer[256];
   while (fgets(buffer, sizeof(buffer), file)) {
      printf("%s", buffer);
   }
   fclose(file);
}

void process_data(char* data) {
   // Do some data processing
   // ...
}

void write_to_database(char* data) {
   // Write data to the database
   // ...
}

int main() {
   char* filename = "data.txt";
   FILE* file = fopen(filename, "r");
   char buffer[256];
   while (fgets(buffer, sizeof(buffer), file)) {
      process_data(buffer);
      write_to_database(buffer);
   }
   fclose(file);
   return 0;
}]

### Related principles

- BESO
- separation of interests

