# Flyweight pattern
## Description
This pattern tries to increase the performance of applications where a multitude of similar objects are used. The basis of this pattern is that the objects to be repeated contain common characteristics. The goal is to eliminate existing redundancy by sharing common features.
Flyweight shares state to support many small objects increasing the efficiency in memory space at the cost of time and processing resources.

## Problem
Our system has one type of component that is repeated numerous times, and the instances have several characteristics in common. We want to optimize the size in memory it occupies to get the most out of the system and not waste resources with redundant data.
It is applied when:
- We need to eliminate or reduce redundancy when we have many objects that share a lot of information.
- Our support has limited memory and this needs to be used optimally.
- The self-identity of the objects is irrelevant.

## Solution
To solve this scenario, we must abstract the characteristics of the element to be replicated into 2 groups: intrinsic and extrinsic. The former refers to the common states of the object or group of objects to be replicated, while the latter refer to the instance's own characteristics.
Thus, our objective will be to study the common characteristics of the objects and create an extrinsic class. Then, when making the different instances, we will take the common (intrinsic) part and complement it with the specific data of the instance.

## Code
This pattern is very used in videogames, since it allows us that elements with many characteristics in common can be reproduced without wasting the memory that they would spend making an instance for each one.
This pattern will be exemplified with trees of a scenario, so the first steps will be to define the Flyweight interface where we are interested in the extrinsic characteristic.

public interface IArbolLigero
{
     public String getTipo();
     public void dibujar( long x, long y, long z );
}

Then we will create the ConcreteFlyweight, which in this case will represent the concrete tree by defining its intrinsic characteristics.

public class Arbol implements IArbolLigero
{
        private String tipo;
        public Arbol( String tipo )
        {
                this.tipo = tipo;
        }
   
        @Override
        public String getTipo()
        {
                return this.tipo;
        }
       
        @Override
        public void dibujar( long x, long y, long z )
        {
                System.out.println("Árbol [" + this.getTipo() + "] dibujado en las coordenadas ("+x+", "+y+", "+z+")" );
        }
}

we continue with the FlyweightFactory which will be defined as:

public class FabricaDeArboles

{
        private Map arboles;

        public FabricaDeArboles()
        {
                this.arboles = new HashMap();
        }
       
        public IArbolLigero getArbol( String tipo )
        {
                // If we don't have any tree of the requested type, we create it
                if(!arboles.containsKey(tipo))
                {
                        arboles.put(tipo, new Arbol(tipo));
                }
                
                // We return the tree of the corresponding type.
                return arboles.get(tipo);
        }
}

Finally, we will now define our client as if it were the engine of a video game that has to fill a landscape with pine, fir and willow trees:

public static void main(String args)
{
// We get the number of trees to draw by parameter
int num_arboles = Integer.PatronesInt(args[0]);



// We define the tree types
String[] tipos = {"pino","abeto","sauce"};

// We create the tree factory
FabricaDeArboles f = new FabricaDeArboles();

// We will create as many trees as specified by parameter
// The type of tree will be selected randomly
Random r = new Random(tipos.length),
p = new Random();

for(int i=0;i<num_arboles;i++)
        {
                f.getArbol(tipos[r.nextInt()]).dibujar(p.nextLong(), p.nextLong(), p.nextLong());
        }
}
