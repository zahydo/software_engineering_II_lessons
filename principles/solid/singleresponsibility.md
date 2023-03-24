## Single Responsibility

This is the most important and fundamental principle of SOLID, this principle states that, "A class should have one, and only one, reason to change." If, on the other hand, a class has multiple responsibilities, this implies that a change in one responsibility will cause a change in another responsibility.

### Bad example:

class Auto {  
    String marca;
    String modelo;
    String color;

    Auto(String marca, String modelo, String color){ 
        this.marca = marca; 
        this.modelo = modelo; 
        this.color = color; 
    }

    String getMarcaAuto(){ 
        return marca;
    }
    String getModeloAuto(){ 
        return marca;
    }
    String getColorAuto(){ 
        return marca;
    }

    void guardarAutoBD(Auto auto){
    ...
    }
}

In the previous example you can see that the Auto class allows both access to the properties of the class and also to perform operations on the Database, so the class already has more than one responsibility, which goes against the above principle. One way to correct this would be to separate the responsibilities of the class, so another class can be created to take care of the database operations. As shown in the following example:

### Good example:

class Auto {  
    String marca;
    String modelo;
    String color;

    Auto(String marca, String modelo, String color){ 
        this.marca = marca; 
        this.modelo = modelo; 
        this.color = color; 
    }

    String getMarcaAuto(){ 
        return marca;
    }
    String getModeloAuto(){ 
        return marca;
    }
    String getColorAuto(){ 
        return marca;
    }
}

class AutoBD{  
    void guardarAutoBD(Auto auto){ 
    ... 
    }
    void eliminarAutoBD(Auto auto){
    ...
    }
}

### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)