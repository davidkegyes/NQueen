rmdir /Q/S build
mkdir build
javac -d build src/edu/sapi/mestint/*.java
cd build
jar cvfe ../NQueen.jar edu.sapi.mestint.NQueen edu/sapi/mestint/*.class
cd ..