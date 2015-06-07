/*
var Nodo = require("./main.js");
 */
var method = Nodo.prototype;

function Nodo(nombreGramatica, esTerminal, hileraTerminal) {
  this.nombreGramatica = nombreGramatica;
  this.esTerminal = esTerminal;

  if(this.esTerminal)
    this.hileraTerminal = hileraTerminal;
  else
    this.hileraTerminal = "";

  this.hijos = [];
  this.nHijos = 0;
};

method.agregarHijo = function(h) {
  this.hijos.push(h);
  this.nHijos++;
};

method.imprimir = function(tab) {
  
  aux = this.esTerminal ? (": "+this.hileraTerminal) : "";
  console.log(tab+this.nombreGramatica+aux);

  function llamadoRecursivoPorQueLosForAquiApestan(element) {
    element.imprimir(tab+"\t");
  }
  this.hijos.forEach(llamadoRecursivoPorQueLosForAquiApestan);

};

module.exports = Nodo;


var nodo1 = new Nodo("A", false);
var nodo2 = new Nodo("B", true, "val1");
var nodo3 = new Nodo("C", true, "val2");
 
nodo1.agregarHijo(nodo2);
nodo1.agregarHijo(nodo3);
nodo1.imprimir("");

