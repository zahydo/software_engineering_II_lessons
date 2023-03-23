## Dependency Injection

It depends on an abstraction and not on something concrete. It defines that an element must depend on an abstraction and not on something concrete. it is necessary that the code is much more reusable, much more generic so that the code can have as many forms as we want. 

### Bad example

In an application, a view presenter class has a direct dependency on the data model class. This makes the presenter very dependent on the data model and difficult to test.

```Java
public class ViewPresenter {
    private DataModel dataModel = new DataModel();

    public void doSomethingWithData() {
        // Utilizar dataModel
    }
}

public class DataModel {
    // Implementación de modelo de datos
}

```

### Good example

You can create an interface to the data model and make the presenter depend on the interface instead of the particular data model class. In this way, you can provide a different implementation of the data model for different use cases and you can easily test the presenter with a test data model.

```Java
public interface DataModel {
    // Métodos del modelo de datos
}

public class ViewPresenter {
    private DataModel dataModel;

    public ViewPresenter(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    public void doSomethingWithData() {
        // Utilizar dataModel
    }
}

public class MyDataModel implements DataModel {
    // Implementación de modelo de datos
}
```

### Related principles

- [Separation of Concerns](~/principles/general/separationofconcerns.md)
- [Code For The Maintainer](~/principles/general/codeformantainer.md)
- [Boy-Scout Rule](~/principles/general/boyscoutrule.md)

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)