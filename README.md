# NQueen

Precondition to compile is that the JDK 8 JAVA_HOME environment variable is set and added to Path.

To compile
$ ./build.bat

The program places 8 Queens on a a Chess table without collisions.
First output is the starting table state and last is the result.

$ java -jar NQueen.jar
````
Initial
_       _       _       _       _       _       _       8
1       _       _       _       _       _       _       _
_       2       _       _       _       _       _       _
_       _       _       _       _       _       7       _
_       _       3       _       _       _       _       _
_       _       _       4       _       _       _       _
_       _       _       _       _       6       _       _
_       _       _       _       5       _       _       _
Solution:
_       _       _       4       _       _       _       _
_       2       _       _       _       _       _       _
_       _       _       _       _       _       _       8
_       _       _       _       5       _       _       _
_       _       _       _       _       _       7       _
1       _       _       _       _       _       _       _
_       _       3       _       _       _       _       _
_       _       _       _       _       6       _       _

````