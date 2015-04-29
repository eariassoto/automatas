go:
	java -jar jflex.jar frases.flex
	javac AnalizadorL.java
	java AnalizadorL ejemplos/ejemplo1.java
