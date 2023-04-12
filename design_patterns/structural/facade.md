# Facade pattern
## Description
Unified interface for software projects, in general it can be said that the facade pattern is a perfect solution when looking for the simplification of complex software, it has the characteristic of hiding the complexity of interacting with a set of subsystems by providing a high-level interface, which is responsible for performing the communication with all the necessary subsystems.

## Problem
Suppose we have a complex system that, being very flexible, requires the configuration of many parameters to achieve a specific purpose. On the other hand, we have a client system that intends to use part of the functionality that the first system offers, but many of the configuration operations are always the same.

Another problem that this pattern tries to solve is the use of several subsystem interfaces through a single access point.
Therefore, this pattern will be applied when:
- Our client system has to access some of the functionality of a complex system.
- There are very frequent tasks or configurations, and it is convenient to simplify the usage code.
- We need to make a library more readable.
- Our client systems have to access several APIs and we want to simplify this access.

## Solution
The solution consists of creating a façade class that provides the functionality in a simple way to the client system. This class will use the complex class or the different components of the required systems and provide them through simpler operations.

## Code
To exemplify the facade pattern we have the following class in charge of printing a document in the format indicated.

public clase Impresora {
 		private String tipoDocumento;
 		private String hoja;
 		private boolean color;
 		private String texto;
 		public String getTipoDocumento() {
 		 		return tipoDocumento;
 		 }

 		 public void setTipoDocumento(String tipoDocumento) {
 		 		this.tipoDocumento = tipoDocumento;
 		}

 		public void setHoja(String hoja) {
 		 		this.hoja = hoja;
 		}

 		public String getHoja() {
 		 		return hoja;
 		}

 		public void setColor(boolean color) {
 		 		this.color = color;
 		}

 		public boolean getColor() {
 		 		return color;
 		}

 		public void setTexto(String texto) {
 		 		this.texto = texto;
 		}

 		public String getTexto() {
 		 		return texto;
 		}

 		public void imprimir() {
 		 		impresora.imprimirDocumento();
 		}
 }

Since many documents will have a similar structure, we proceed to create a class fachadaImpresoraNormal that helps us to simplify the printing of documents with the most common format and thus avoid repetition of code.

public class FachadaImpresoraNormal {
 		Impresora impresora;
 		public FachadaImpresoraNormal(String texto) {
 		 		super();
 		 		impresora= new Impresora();
 		 		impresora.setColor(true);
 		 		impresora.setHoja("A4");
 		 		impresora.setTipoDocumento("PDF");
 		 		impresora.setTexto(texto);
 		 }

 		public void imprimir() {
 		 		impresora.imprimirDocumento();
 		 }
 }

Thanks to the previous facade, the main client class is as follows:

public class PrincipalCliente {
 		public static void main(String[] args) {

 		 		FachadaImpresoraNormal fachada1= new FachadaImpresoraNormal("texto1");
 		 		fachada1.imprimir();

 		 		FachadaImpresoraNormal fachada2= new FachadaImpresoraNormal("texto2");
 		 		fachada2.imprimir();

 		 		Impresora i3 = new Impresora();
 		 		i3.setHoja("a4");
 		 		i3.setColor(true);
 		 		i3.setTipoDocumento("excel");
 		 		i3.setTexto("texto 3");
 		 		i3.imprimirDocumento();
 		}
 }

In this last class we see how the task of printing the document is simplified for the examples of "facade1" and "facade2" saving us code while on the other hand we see the example of "i3" where we notice the extra lines necessary to print another document in a different format without using the facade pattern.
