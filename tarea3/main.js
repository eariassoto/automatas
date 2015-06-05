var Nodo = function (texto, esTerminal, hijos) {
  this.texto = texto;
  this.esTerminal = esTerminal;
  this.hijos = hijos;
  this.hayHijos = false;
};

Nodo.prototype.agregarHijo = function(h) {
  this.hijos.push(h);
  this.hayHijos = true;
};

Nodo.prototype.imprimir = function() {
  console.log(this.texto);
  
  if(this.hayHijos)
  for(i = 0; i < this.hijos.length; i++) {
  	this.hijos[i].imprimir();
  }
};

var nodo1 = new Nodo("ddff", true, []);
var nodo2 = new Nodo("hvmh", true, []);
var nodo3 = new Nodo("asdf", true, []);

nodo1.agregarHijo(nodo2);
nodo1.agregarHijo(nodo3);
nodo1.imprimir();