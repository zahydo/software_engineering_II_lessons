# I
## Interface Segregation
One should avoid having a single large and confusing interface, and instead should divide it into smaller and more manageable interfaces.
### Bad example:
We need to group functions that allow us to do statistical calculations, so we do the following.
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
Therefore, it is decided to separate by several interfaces (CalculateStatistics, MinMax and PersonStatistics), 
```JAVA:
    public interface CalculateStadistics{
        void arithmeticMean();
        void geometricMean();
        void mode();
    }

    public interface MinMax{
        void minData();
        void maxData();
    }

    public interface PersonStadistics{
        void personsCloseToArithmeticMean();
        void personWithMaxData();
        void personsWithMode();
    }

```
This allows the classes to implement the necessary functionalities, enforcing Interface Segregation.



### Related patterns
- Separation of Concerns
- Code For The Maintainer
- Composition Over Inheritance

---
[Back to the list](./README.md)