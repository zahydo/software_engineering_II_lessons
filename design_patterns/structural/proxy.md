# Proxy pattern
## Description
Proxy is a structural design pattern that allows you to provide a proxy for another object. This is a design pattern that focuses its attention on the mediation between one object and another. It is said mediation because this pattern allows us to perform certain actions before and after performing the action desired by the user. The Proxy is characterized by the fact that the client is totally unaware that a mediation is taking place because the client receives an object identical in structure to the expected one and is not aware of the implementation behind the executed interface, thus the client interacts with the Proxy without knowing it.

## Problem
The proxy pattern attempts to provide an intermediary object that represents or replaces the original object for the purpose of controlling access and other characteristics of the original object.
It is applied when:
The Proxy pattern is used when a reference to an object more flexible or sophisticated than a pointer is needed. Depending on the required functionality we can find several applications:
- Remote proxy: represents an object in another address space.
- Virtual proxy: delays the creation of expensive objects.
- Protection proxy: controls access to an object.
- Intelligent reference: has the same purpose as a pointer, but also performs additional actions on the object, such as concurrency control.

## Solution
The solution to this problem is to create a Subject interface that defines all the functionality that our object has to provide. This interface, obviously, has to be implemented by the real object. We will also create a Proxy Object that will maintain a reference to the real object, and that will also implement the Subject interface, so that when specifying the functionality it is indifferent whether the Proxy or the real object is being executed.

## Code
In this case we are going to do a classic example of access control by means of a protection proxy. To do so, let's imagine a scenario in which you want to download some material that, although publicly available, is not allowed to be possessed in the customer's country. First, we define the interface of the download server:

public interface Server{
        public void download(String url);
}

Next, we are going to implement our real server:

public class RealServer implements Server{      
        private int port;
        private String host;

        public RealServer(int port, String host){
                this.port=port;
                this.host=host;
                System.out.println("Servidor iniciado...");
        }

        public void download(String url){
                System.out.println("Descargando "+host+":"+port+"/"+url);
        }
}

Now we are going to implement the proxy that includes the restricted access control:

public class ProxyServer implements Server{
        RealServer srv;
        private int port;
        private String host;

        public ProxyServer(int port, String host){
                this.port=port;
                this.host=host;
                srv=null;
                System.out.println("Proxy iniciado...");
        }

        public void download(String url){
                if(!isRestricted(url))
                {
                        if(srv = null)
                        {
                                srv = new RealServer(port,host);
                        }
                        srv.download(url);
                }
                else{
                        System.out.println("Actualmente se encuentra en un área que no permite la descarga del fichero.");
                }
        }

        public boolean isRestricted(String fichero)
        {
                return !fichero.equals("/descarga/prohibida.avi");
        }
}

And we finish by testing everything using our client's main method:

public static void main(String [] args){
        // Create the proxy to the download page
        Server srv = new ProxyServer(20,"http://paginadedescarg.as");

        // Download an allowed file
        srv.download("/descarga/permitida.avi");      

        // This is where the RealServer object is created.
        // Let's try now with a restricted download
        srv.download("/descarga/prohibida.avi");

}
