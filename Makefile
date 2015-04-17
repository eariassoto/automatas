go:
	java -jar jflex.jar frases.flex
	javac AnalizadorL.java
	java AnalizadorL entrada.dat
