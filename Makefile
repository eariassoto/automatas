go:
	cls
	java -jar jflex.jar reglas.flex
	javac Pair.java AnalizadorL.java AnalisisCodigo.java
	java AnalisisCodigo

compileflex:
	java -jar jflex.jar reglas.flex
