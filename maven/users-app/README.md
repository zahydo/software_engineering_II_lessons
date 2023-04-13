# Steps before to run
Running a Maven project typically involves compiling the code, running tests, and packaging the application into a distributable format. Here are the steps to run a Maven project:

1. Open a command prompt or terminal window.
2. Navigate to the directory containing the project's POM file.
3. Run the `mvn clean` command to clean any previously compiled code and generated files.
4. Run the `mvn compile` command to compile the project's source code.
5. Run the `mvn test` command to run the project's tests. If the tests fail, you may need to fix any errors before proceeding.
6. Run the `mvn package` command to package the compiled code into a distributable format, such as a JAR or WAR file.
7. The packaged artifact will be created in the target directory. You can run the application by executing the main class in the artifact, or by deploying the artifact to a server or container.

# Running the application

To run the application using Maven, you can use the exec plugin to execute the main class. Here are the steps to do this:

1. Open a command prompt or terminal window.
2. Navigate to the directory containing the project's POM file.
3. Run the following command to execute the main class:

```
mvn exec:java -Dexec.mainClass="com.unicauca.app.presentation.App"
```

Replace com.example.MainClass with the fully qualified name of the main class.

If the main class requires any command-line arguments or system properties, you can specify those on the command line as well, using the -D option to set system properties and providing the arguments after the exec:java goal.

Note that if the main class depends on any external libraries or frameworks, you may need to add those dependencies to the project's POM file, so that Maven can download and include them automatically. You can also use the dependency:copy-dependencies goal to copy the project's dependencies to a specific directory, and then add that directory to the classpath when running the application.

In addition to the exec plugin, Maven provides several other plugins that can be used to run applications, such as the jetty-maven-plugin for running web applications and the spring-boot-maven-plugin for running Spring Boot applications. The specific plugin and configuration required to run a Maven project may vary depending on the project's configuration and requirements. It's always a good idea to consult the project's documentation or README file for specific instructions on how to run the project using Maven.