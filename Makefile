go:
	java -jar jflex.jar frases.flex
	javac AnalizadorL.java AnalisisCodigo.java
	java AnalisisCodigo

compileflex:
	java -jar jflex.jar frases.flex
