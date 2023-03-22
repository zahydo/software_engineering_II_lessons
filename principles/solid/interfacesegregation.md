# I
## Interface Segregation
One should avoid having a single large and confusing interface, and instead should divide it into smaller and more manageable interfaces.
### Bad example:
Suppose we have an interface that does the following:
```JAVA:
    public interface Calculate{
        void arithmeticMean();
        void geometricMean();
        void mode();
        void smallestData();
        void largestData();
        void peopleCloseToArithmeticMean();
        void personWithLargestData();
        void peopleWithMode();
    }

```
This naturally violates the principle because Calculate is taking care of many functions, and some are not really of its nature.
### Good example:

```JAVA:
    public interface Calculate{
        void arithmeticMean();
        void geometricMean();
        void mode();
    }

    public interface MinMax{
        void minData();
        void maxData();
    }

    public interface PersonData{
        void personsCloseToArithmeticMean();
        void personWithMaxData();
        void personsWithMode();
    }

```
By separating the different functionalities into smaller and specialized interfaces, it allows classes to implement the necessary functionalities.



### Related patterns
- Separation of Concerns
- Code For The Maintainer
- Composition Over Inheritance