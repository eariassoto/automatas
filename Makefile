go:
	clear
	java -jar jflex.jar reglas.flex
	javac AnalizadorL.java AnalisisCodigo.java
	java AnalisisCodigo

compileflex:
	java -jar jflex.jar reglas.flex
