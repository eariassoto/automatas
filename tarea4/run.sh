clear
cd gramatica1/
java -jar jflex-1.6.1.jar alto_intermedio.flex
wine yacc.exe -J alto_intermedio.y
javac *.java
java Parser ../alto.txt
mv intermedio.code ../gramatica2/
cd ../gramatica2/
python intermedio_maquina.py -c intermedio.code
mv intermedio.code maquina.code ../
cd ..
