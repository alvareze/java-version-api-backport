# Backport of Java version API released in JDK 10.
An implementation of the Java Version API for Java versions 8, 7, 5 and 5. This code compiles and runs with Java version 5 and later. The version API is a reimplemented for Java versions prior to version 10. The code continues to work with newer versions of Java using introspection to retrieve version information. 

This code was created as part of a presentation on the Java Version API for the Miami Java User Group (MJUG).
[Presentation Link](https://github.com/alvareze/presentations/tree/main/2024-10-MJUG)

# Usage
Three static methods are implemented.
```java
System.out.println( "backport.feature="  + com.alvareze.version.RuntimeVersion.version().feature());
System.out.println( "backport.interim="  + com.alvareze.version.RuntimeVersion.version().interim());
System.out.println( "backport.update="   + com.alvareze.version.RuntimeVersion.version().update());
System.out.println( "backport.version="  + com.alvareze.version.RuntimeVersion.version().version());
```
[Link to JavaDoc from JDK version 10](https://docs.oracle.com/javase/10/docs/api/java/lang/Runtime.Version.html)

# Build
mvn clean install

