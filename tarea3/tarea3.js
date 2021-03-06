var Nodo = require('./arboln.js');
/* parser generated by jison 0.4.15 */
/*
  Returns a Parser object of the following structure:

  Parser: {
    yy: {}
  }

  Parser.prototype: {
    yy: {},
    trace: function(),
    symbols_: {associative list: name ==> number},
    terminals_: {associative list: number ==> name},
    productions_: [...],
    performAction: function anonymous(yytext, yyleng, yylineno, yy, yystate, $$, _$),
    table: [...],
    defaultActions: {...},
    parseError: function(str, hash),
    parse: function(input),

    lexer: {
        EOF: 1,
        parseError: function(str, hash),
        setInput: function(input),
        input: function(),
        unput: function(str),
        more: function(),
        less: function(n),
        pastInput: function(),
        upcomingInput: function(),
        showPosition: function(),
        test_match: function(regex_match_array, rule_index),
        next: function(),
        lex: function(),
        begin: function(condition),
        popState: function(),
        _currentRules: function(),
        topState: function(),
        pushState: function(condition),

        options: {
            ranges: boolean           (optional: true ==> token location info will include a .range[] member)
            flex: boolean             (optional: true ==> flex-like lexing behaviour where the rules are tested exhaustively to find the longest match)
            backtrack_lexer: boolean  (optional: true ==> lexer regexes are tested in order and for each matching regex the action code is invoked; the lexer terminates the scan when a token is returned by the action code)
        },

        performAction: function(yy, yy_, $avoiding_name_collisions, YY_START),
        rules: [...],
        conditions: {associative list: name ==> set},
    }
  }


  token location info (@$, _$, etc.): {
    first_line: n,
    last_line: n,
    first_column: n,
    last_column: n,
    range: [start_number, end_number]       (where the numbers are indexes into the input string, regular zero-based)
  }


  the parseError function receives a 'hash' object with these members for lexer and parser errors: {
    text:        (matched text)
    token:       (the produced terminal token, if any)
    line:        (yylineno)
  }
  while parser (grammar) errors will also provide these members, i.e. parser errors deliver a superset of attributes: {
    loc:         (yylloc)
    expected:    (string describing the set of expected tokens)
    recoverable: (boolean: TRUE when the parser has a error recovery rule available for this particular error)
  }
*/
var parser = (function(){
var o=function(k,v,o,l){for(o=o||{},l=k.length;l--;o[k[l]]=v);return o},$V0=[1,7],$V1=[1,15],$V2=[1,16],$V3=[1,17],$V4=[1,18],$V5=[1,19],$V6=[1,20],$V7=[1,21],$V8=[1,22],$V9=[2,58],$Va=[16,17,18,19,20,40,41,42,51],$Vb=[16,17,18,19,20,22],$Vc=[1,34],$Vd=[1,53],$Ve=[1,54],$Vf=[1,52],$Vg=[2,53],$Vh=[6,16,17,18,19,20,24,25,44,51],$Vi=[1,64],$Vj=[1,65],$Vk=[1,66],$Vl=[1,67],$Vm=[1,68],$Vn=[1,69],$Vo=[6,8],$Vp=[1,74],$Vq=[1,75],$Vr=[1,76],$Vs=[1,77],$Vt=[1,78],$Vu=[10,11,12,13,14],$Vv=[6,10,11,12,13,14],$Vw=[8,48];
var parser = {trace: function trace() { },
yy: {},
symbols_: {"error":2,"class":3,"CLASS":4,"id":5,"ID":6,"pc":7,"PC":8,"valor":9,"INTN":10,"REALN":11,"CARAC":12,"HILERA":13,"VBOOL":14,"tipodat":15,"INT":16,"CHAR":17,"BOOL":18,"FLOAT":19,"STRING":20,"tipodatMetodo":21,"VOID":22,"operincdec":23,"++":24,"--":25,"X":26,"opercomp":27,"==":28,"<=":29,">=":30,"!=":31,"&&":32,"||":33,"operasig":34,"+=":35,"-=":36,"*=":37,"/=":38,"modificador":39,"PUBLIC":40,"PRIVATE":41,"PROTECTED":42,"if":43,"IF":44,"comp":45,"insif":46,"(":47,")":48,"{":49,"bloque":50,"}":51,"pos":52,"pre":53,"incdec":54,"asignacion":55,"definicion":56,"declaracion":57,"=":58,"instruccion":59,"metodo":60,"instruccionCodigo":61,"bloqueCodigo":62,"programa":63,"expressions":64,"EOF":65,"$accept":0,"$end":1},
terminals_: {2:"error",4:"CLASS",6:"ID",8:"PC",10:"INTN",11:"REALN",12:"CARAC",13:"HILERA",14:"VBOOL",16:"INT",17:"CHAR",18:"BOOL",19:"FLOAT",20:"STRING",22:"VOID",24:"++",25:"--",28:"==",29:"<=",30:">=",31:"!=",32:"&&",33:"||",35:"+=",36:"-=",37:"*=",38:"/=",40:"PUBLIC",41:"PRIVATE",42:"PROTECTED",44:"IF",47:"(",48:")",49:"{",51:"}",58:"=",65:"EOF"},
productions_: [0,[3,1],[5,1],[7,1],[9,1],[9,1],[9,1],[9,1],[9,1],[15,1],[15,1],[15,1],[15,1],[15,1],[21,1],[21,1],[21,1],[21,1],[21,1],[21,1],[23,1],[23,1],[26,1],[26,1],[27,1],[27,1],[27,1],[27,1],[27,1],[27,1],[34,1],[34,1],[34,1],[34,1],[39,1],[39,1],[39,1],[43,1],[45,4],[46,9],[52,3],[53,3],[54,1],[54,1],[55,4],[56,3],[57,5],[59,1],[59,1],[59,1],[59,1],[59,1],[50,2],[50,0],[60,8],[61,1],[61,1],[62,2],[62,0],[63,5],[64,2]],
performAction: function anonymous(yytext, yyleng, yylineno, yy, yystate /* action[1] */, $$ /* vstack */, _$ /* lstack */) {
/* this == yyval */

var $0 = $$.length - 1;
switch (yystate) {
case 1:
 this.$ = new Nodo("class", true, $$[$0]); 
break;
case 2:
 this.$ = new Nodo("id", true, $$[$0]); 
break;
case 3:
 this.$ = new Nodo("pc", true, $$[$0]); 
break;
case 4: case 5: case 6: case 7: case 8:
 this.$ = new Nodo("valor", true, $$[$0]); 
break;
case 9: case 10: case 11: case 12: case 13:
 this.$ = new Nodo("tipodat", true, $$[$0]); 
break;
case 14: case 15: case 16: case 17: case 18: case 19:
 this.$ = new Nodo("tipodatMetodo", true, $$[$0]); 
break;
case 20: case 21:
 this.$ = new Nodo("operincdec", true, $$[$0]); 
break;
case 22: case 23: case 42: case 43: case 51:
 this.$ = $$[$0]; 
break;
case 24: case 25: case 26: case 27: case 28: case 29:
 this.$ = new Nodo("opercomp", true, $$[$0]); 
break;
case 30: case 31: case 32: case 33:
 this.$ = new Nodo("operasig", true, $$[$0]); 
break;
case 34: case 35: case 36:
 this.$ = new Nodo("modificador", true, $$[$0]); 
break;
case 37:
 this.$ = new Nodo("if", true, $$[$0]); 
break;
case 38:
 this.$ = new Nodo("comp", false); 
     this.$.agregarHijo($$[$0-3]);
     this.$.agregarHijo($$[$0-2]);
     this.$.agregarHijo($$[$0-1]);
     this.$.agregarHijo($$[$0]);
   
break;
case 39:
 this.$ = new Nodo("insif", false); 
     this.$.agregarHijo($$[$0-8]);
     this.$.agregarHijo($$[$0-6]);
     this.$.agregarHijo($$[$0-5]);
     this.$.agregarHijo($$[$0-4]);
     this.$.agregarHijo($$[$0-1]);
   
break;
case 40:
 this.$ = new Nodo("pos", false);
   this.$.agregarHijo($$[$0-2]);
   this.$.agregarHijo($$[$0-1]);
   this.$.agregarHijo($$[$0]);
   
break;
case 41:
 this.$ = new Nodo("pre", false);
   this.$.agregarHijo($$[$0-2]);
   this.$.agregarHijo($$[$0-1]);
   this.$.agregarHijo($$[$0]);
   
break;
case 44:
 this.$ = new Nodo("asignacion", false);
   this.$.agregarHijo($$[$0-3]);
   this.$.agregarHijo($$[$0-2]);
   this.$.agregarHijo($$[$0-1]);
   this.$.agregarHijo($$[$0]);
   
break;
case 45:
this.$ = new Nodo("definicion", false);
   this.$.agregarHijo($$[$0-2]);
   this.$.agregarHijo($$[$0-1]);
   this.$.agregarHijo($$[$0]);
   
break;
case 46:
 this.$ = new Nodo("declaracion", false);
   this.$.agregarHijo($$[$0-4]);
   this.$.agregarHijo($$[$0-3]);
   this.$.agregarHijo($$[$0-1]);
   this.$.agregarHijo($$[$0]);
   
break;
case 52:
 
       this.$ = new Nodo("bloque", false);
       this.$.agregarHijo($$[$0-1]);
       if($$[$0].nombreGramatica == "bloque"){
              for(i = 0; i < $$[$0].nHijos; i++) {
                     this.$.agregarHijo($$[$0].hijos[i]);
              }
       }
   
break;
case 53:
this.$ = new Nodo("finbloque", false); 
break;
case 54:
 this.$ = new Nodo("metodo", false);
   this.$.agregarHijo($$[$0-7]);
   this.$.agregarHijo($$[$0-6]);
   this.$.agregarHijo($$[$0-5]);
   if($$[$0-1].nombreGramatica == "bloque"){
      this.$.agregarHijo($$[$0-1]);
   }
   
break;
case 56:
this.$ = $$[$0];
break;
case 57:
 this.$ = new Nodo("bloqueCodigo", false); 
   this.$.agregarHijo($$[$0-1]);
   if($$[$0].nombreGramatica == "bloqueCodigo"){
              for(i = 0; i < $$[$0].nHijos; i++) {
                     this.$.agregarHijo($$[$0].hijos[i]);
              }
       }
   
break;
case 58:
 this.$ = new Nodo("finbloquecodigo", false); 
break;
case 59:
 this.$ = new Nodo("programa", false);
   this.$.agregarHijo($$[$0-4]);
   this.$.agregarHijo($$[$0-3]);
   if($$[$0-1].nombreGramatica == "bloqueCodigo"){
      this.$.agregarHijo($$[$0-1]);
   }
   
break;
case 60:

       $$[$0-1].imprimir("");
       return $$[$0-1];
   
break;
}
},
table: [{3:3,4:[1,4],63:2,64:1},{1:[3]},{65:[1,5]},{5:6,6:$V0},{6:[2,1]},{1:[2,60]},{49:[1,8]},o([8,24,25,28,29,30,31,32,33,35,36,37,38,47,48,49,58],[2,2]),{15:13,16:$V1,17:$V2,18:$V3,19:$V4,20:$V5,39:14,40:$V6,41:$V7,42:$V8,51:$V9,56:11,60:12,61:10,62:9},{51:[1,23]},{15:13,16:$V1,17:$V2,18:$V3,19:$V4,20:$V5,39:14,40:$V6,41:$V7,42:$V8,51:$V9,56:11,60:12,61:10,62:24},o($Va,[2,55]),o($Va,[2,56]),{5:25,6:$V0},{16:[1,27],17:[1,28],18:[1,29],19:[1,30],20:[1,31],21:26,22:[1,32]},{6:[2,9]},{6:[2,10]},{6:[2,11]},{6:[2,12]},{6:[2,13]},o($Vb,[2,34]),o($Vb,[2,35]),o($Vb,[2,36]),{65:[2,59]},{51:[2,57]},{7:33,8:$Vc},{5:35,6:$V0},{6:[2,14]},{6:[2,15]},{6:[2,16]},{6:[2,17]},{6:[2,18]},{6:[2,19]},o($Va,[2,45]),o([6,16,17,18,19,20,24,25,40,41,42,44,51],[2,3]),{47:[1,36]},{48:[1,37]},{49:[1,38]},{5:46,6:$V0,15:49,16:$V1,17:$V2,18:$V3,19:$V4,20:$V5,23:51,24:$Vd,25:$Ve,43:50,44:$Vf,45:44,46:45,50:39,51:$Vg,52:47,53:48,54:42,55:41,57:43,59:40},{51:[1,55]},{5:46,6:$V0,15:49,16:$V1,17:$V2,18:$V3,19:$V4,20:$V5,23:51,24:$Vd,25:$Ve,43:50,44:$Vf,45:44,46:45,50:56,51:$Vg,52:47,53:48,54:42,55:41,57:43,59:40},o($Vh,[2,47]),o($Vh,[2,48]),o($Vh,[2,49]),o($Vh,[2,50]),o($Vh,[2,51]),{23:59,24:$Vd,25:$Ve,27:58,28:$Vi,29:$Vj,30:$Vk,31:$Vl,32:$Vm,33:$Vn,34:57,35:[1,60],36:[1,61],37:[1,62],38:[1,63]},o($Vh,[2,42]),o($Vh,[2,43]),{5:70,6:$V0},{47:[1,71]},{5:72,6:$V0},{47:[2,37]},o($Vo,[2,20]),o($Vo,[2,21]),o($Va,[2,54]),{51:[2,52]},{9:73,10:$Vp,11:$Vq,12:$Vr,13:$Vs,14:$Vt},{5:80,6:$V0,9:81,10:$Vp,11:$Vq,12:$Vr,13:$Vs,14:$Vt,26:79},{7:82,8:$Vc},o($Vu,[2,30]),o($Vu,[2,31]),o($Vu,[2,32]),o($Vu,[2,33]),o($Vv,[2,24]),o($Vv,[2,25]),o($Vv,[2,26]),o($Vv,[2,27]),o($Vv,[2,28]),o($Vv,[2,29]),{58:[1,83]},{5:84,6:$V0},{7:85,8:$Vc},{7:86,8:$Vc},o($Vw,[2,4]),o($Vw,[2,5]),o($Vw,[2,6]),o($Vw,[2,7]),o($Vw,[2,8]),{7:87,8:$Vc},o($Vw,[2,22]),o($Vw,[2,23]),o($Vh,[2,40]),{9:88,10:$Vp,11:$Vq,12:$Vr,13:$Vs,14:$Vt},{27:89,28:$Vi,29:$Vj,30:$Vk,31:$Vl,32:$Vm,33:$Vn},o($Vh,[2,41]),o($Vh,[2,44]),o($Vh,[2,38]),{7:90,8:$Vc},{5:80,6:$V0,9:81,10:$Vp,11:$Vq,12:$Vr,13:$Vs,14:$Vt,26:91},o($Vh,[2,46]),{48:[1,92]},{49:[1,93]},{5:46,6:$V0,15:49,16:$V1,17:$V2,18:$V3,19:$V4,20:$V5,23:51,24:$Vd,25:$Ve,43:50,44:$Vf,45:44,46:45,50:94,51:$Vg,52:47,53:48,54:42,55:41,57:43,59:40},{51:[1,95]},o($Vh,[2,39])],
defaultActions: {4:[2,1],5:[2,60],15:[2,9],16:[2,10],17:[2,11],18:[2,12],19:[2,13],23:[2,59],24:[2,57],27:[2,14],28:[2,15],29:[2,16],30:[2,17],31:[2,18],32:[2,19],52:[2,37],56:[2,52]},
parseError: function parseError(str, hash) {
    if (hash.recoverable) {
        this.trace(str);
    } else {
        throw new Error(str);
    }
},
parse: function parse(input) {
    var self = this, stack = [0], tstack = [], vstack = [null], lstack = [], table = this.table, yytext = '', yylineno = 0, yyleng = 0, recovering = 0, TERROR = 2, EOF = 1;
    var args = lstack.slice.call(arguments, 1);
    var lexer = Object.create(this.lexer);
    var sharedState = { yy: {} };
    for (var k in this.yy) {
        if (Object.prototype.hasOwnProperty.call(this.yy, k)) {
            sharedState.yy[k] = this.yy[k];
        }
    }
    lexer.setInput(input, sharedState.yy);
    sharedState.yy.lexer = lexer;
    sharedState.yy.parser = this;
    if (typeof lexer.yylloc == 'undefined') {
        lexer.yylloc = {};
    }
    var yyloc = lexer.yylloc;
    lstack.push(yyloc);
    var ranges = lexer.options && lexer.options.ranges;
    if (typeof sharedState.yy.parseError === 'function') {
        this.parseError = sharedState.yy.parseError;
    } else {
        this.parseError = Object.getPrototypeOf(this).parseError;
    }
    function popStack(n) {
        stack.length = stack.length - 2 * n;
        vstack.length = vstack.length - n;
        lstack.length = lstack.length - n;
    }
    _token_stack:
        function lex() {
            var token;
            token = lexer.lex() || EOF;
            if (typeof token !== 'number') {
                token = self.symbols_[token] || token;
            }
            return token;
        }
    var symbol, preErrorSymbol, state, action, a, r, yyval = {}, p, len, newState, expected;
    while (true) {
        state = stack[stack.length - 1];
        if (this.defaultActions[state]) {
            action = this.defaultActions[state];
        } else {
            if (symbol === null || typeof symbol == 'undefined') {
                symbol = lex();
            }
            action = table[state] && table[state][symbol];
        }
                    if (typeof action === 'undefined' || !action.length || !action[0]) {
                var errStr = '';
                expected = [];
                for (p in table[state]) {
                    if (this.terminals_[p] && p > TERROR) {
                        expected.push('\'' + this.terminals_[p] + '\'');
                    }
                }
                if (lexer.showPosition) {
                    errStr = 'Parse error on line ' + (yylineno + 1) + ':\n' + lexer.showPosition() + '\nExpecting ' + expected.join(', ') + ', got \'' + (this.terminals_[symbol] || symbol) + '\'';
                } else {
                    errStr = 'Parse error on line ' + (yylineno + 1) + ': Unexpected ' + (symbol == EOF ? 'end of input' : '\'' + (this.terminals_[symbol] || symbol) + '\'');
                }
                this.parseError(errStr, {
                    text: lexer.match,
                    token: this.terminals_[symbol] || symbol,
                    line: lexer.yylineno,
                    loc: yyloc,
                    expected: expected
                });
            }
        if (action[0] instanceof Array && action.length > 1) {
            throw new Error('Parse Error: multiple actions possible at state: ' + state + ', token: ' + symbol);
        }
        switch (action[0]) {
        case 1:
            stack.push(symbol);
            vstack.push(lexer.yytext);
            lstack.push(lexer.yylloc);
            stack.push(action[1]);
            symbol = null;
            if (!preErrorSymbol) {
                yyleng = lexer.yyleng;
                yytext = lexer.yytext;
                yylineno = lexer.yylineno;
                yyloc = lexer.yylloc;
                if (recovering > 0) {
                    recovering--;
                }
            } else {
                symbol = preErrorSymbol;
                preErrorSymbol = null;
            }
            break;
        case 2:
            len = this.productions_[action[1]][1];
            yyval.$ = vstack[vstack.length - len];
            yyval._$ = {
                first_line: lstack[lstack.length - (len || 1)].first_line,
                last_line: lstack[lstack.length - 1].last_line,
                first_column: lstack[lstack.length - (len || 1)].first_column,
                last_column: lstack[lstack.length - 1].last_column
            };
            if (ranges) {
                yyval._$.range = [
                    lstack[lstack.length - (len || 1)].range[0],
                    lstack[lstack.length - 1].range[1]
                ];
            }
            r = this.performAction.apply(yyval, [
                yytext,
                yyleng,
                yylineno,
                sharedState.yy,
                action[1],
                vstack,
                lstack
            ].concat(args));
            if (typeof r !== 'undefined') {
                return r;
            }
            if (len) {
                stack = stack.slice(0, -1 * len * 2);
                vstack = vstack.slice(0, -1 * len);
                lstack = lstack.slice(0, -1 * len);
            }
            stack.push(this.productions_[action[1]][0]);
            vstack.push(yyval.$);
            lstack.push(yyval._$);
            newState = table[stack[stack.length - 2]][stack[stack.length - 1]];
            stack.push(newState);
            break;
        case 3:
            return true;
        }
    }
    return true;
}};
/* generated by jison-lex 0.3.4 */
var lexer = (function(){
var lexer = ({

EOF:1,

parseError:function parseError(str, hash) {
        if (this.yy.parser) {
            this.yy.parser.parseError(str, hash);
        } else {
            throw new Error(str);
        }
    },

// resets the lexer, sets new input
setInput:function (input, yy) {
        this.yy = yy || this.yy || {};
        this._input = input;
        this._more = this._backtrack = this.done = false;
        this.yylineno = this.yyleng = 0;
        this.yytext = this.matched = this.match = '';
        this.conditionStack = ['INITIAL'];
        this.yylloc = {
            first_line: 1,
            first_column: 0,
            last_line: 1,
            last_column: 0
        };
        if (this.options.ranges) {
            this.yylloc.range = [0,0];
        }
        this.offset = 0;
        return this;
    },

// consumes and returns one char from the input
input:function () {
        var ch = this._input[0];
        this.yytext += ch;
        this.yyleng++;
        this.offset++;
        this.match += ch;
        this.matched += ch;
        var lines = ch.match(/(?:\r\n?|\n).*/g);
        if (lines) {
            this.yylineno++;
            this.yylloc.last_line++;
        } else {
            this.yylloc.last_column++;
        }
        if (this.options.ranges) {
            this.yylloc.range[1]++;
        }

        this._input = this._input.slice(1);
        return ch;
    },

// unshifts one char (or a string) into the input
unput:function (ch) {
        var len = ch.length;
        var lines = ch.split(/(?:\r\n?|\n)/g);

        this._input = ch + this._input;
        this.yytext = this.yytext.substr(0, this.yytext.length - len);
        //this.yyleng -= len;
        this.offset -= len;
        var oldLines = this.match.split(/(?:\r\n?|\n)/g);
        this.match = this.match.substr(0, this.match.length - 1);
        this.matched = this.matched.substr(0, this.matched.length - 1);

        if (lines.length - 1) {
            this.yylineno -= lines.length - 1;
        }
        var r = this.yylloc.range;

        this.yylloc = {
            first_line: this.yylloc.first_line,
            last_line: this.yylineno + 1,
            first_column: this.yylloc.first_column,
            last_column: lines ?
                (lines.length === oldLines.length ? this.yylloc.first_column : 0)
                 + oldLines[oldLines.length - lines.length].length - lines[0].length :
              this.yylloc.first_column - len
        };

        if (this.options.ranges) {
            this.yylloc.range = [r[0], r[0] + this.yyleng - len];
        }
        this.yyleng = this.yytext.length;
        return this;
    },

// When called from action, caches matched text and appends it on next action
more:function () {
        this._more = true;
        return this;
    },

// When called from action, signals the lexer that this rule fails to match the input, so the next matching rule (regex) should be tested instead.
reject:function () {
        if (this.options.backtrack_lexer) {
            this._backtrack = true;
        } else {
            return this.parseError('Lexical error on line ' + (this.yylineno + 1) + '. You can only invoke reject() in the lexer when the lexer is of the backtracking persuasion (options.backtrack_lexer = true).\n' + this.showPosition(), {
                text: "",
                token: null,
                line: this.yylineno
            });

        }
        return this;
    },

// retain first n characters of the match
less:function (n) {
        this.unput(this.match.slice(n));
    },

// displays already matched input, i.e. for error messages
pastInput:function () {
        var past = this.matched.substr(0, this.matched.length - this.match.length);
        return (past.length > 20 ? '...':'') + past.substr(-20).replace(/\n/g, "");
    },

// displays upcoming input, i.e. for error messages
upcomingInput:function () {
        var next = this.match;
        if (next.length < 20) {
            next += this._input.substr(0, 20-next.length);
        }
        return (next.substr(0,20) + (next.length > 20 ? '...' : '')).replace(/\n/g, "");
    },

// displays the character position where the lexing error occurred, i.e. for error messages
showPosition:function () {
        var pre = this.pastInput();
        var c = new Array(pre.length + 1).join("-");
        return pre + this.upcomingInput() + "\n" + c + "^";
    },

// test the lexed token: return FALSE when not a match, otherwise return token
test_match:function (match, indexed_rule) {
        var token,
            lines,
            backup;

        if (this.options.backtrack_lexer) {
            // save context
            backup = {
                yylineno: this.yylineno,
                yylloc: {
                    first_line: this.yylloc.first_line,
                    last_line: this.last_line,
                    first_column: this.yylloc.first_column,
                    last_column: this.yylloc.last_column
                },
                yytext: this.yytext,
                match: this.match,
                matches: this.matches,
                matched: this.matched,
                yyleng: this.yyleng,
                offset: this.offset,
                _more: this._more,
                _input: this._input,
                yy: this.yy,
                conditionStack: this.conditionStack.slice(0),
                done: this.done
            };
            if (this.options.ranges) {
                backup.yylloc.range = this.yylloc.range.slice(0);
            }
        }

        lines = match[0].match(/(?:\r\n?|\n).*/g);
        if (lines) {
            this.yylineno += lines.length;
        }
        this.yylloc = {
            first_line: this.yylloc.last_line,
            last_line: this.yylineno + 1,
            first_column: this.yylloc.last_column,
            last_column: lines ?
                         lines[lines.length - 1].length - lines[lines.length - 1].match(/\r?\n?/)[0].length :
                         this.yylloc.last_column + match[0].length
        };
        this.yytext += match[0];
        this.match += match[0];
        this.matches = match;
        this.yyleng = this.yytext.length;
        if (this.options.ranges) {
            this.yylloc.range = [this.offset, this.offset += this.yyleng];
        }
        this._more = false;
        this._backtrack = false;
        this._input = this._input.slice(match[0].length);
        this.matched += match[0];
        token = this.performAction.call(this, this.yy, this, indexed_rule, this.conditionStack[this.conditionStack.length - 1]);
        if (this.done && this._input) {
            this.done = false;
        }
        if (token) {
            return token;
        } else if (this._backtrack) {
            // recover context
            for (var k in backup) {
                this[k] = backup[k];
            }
            return false; // rule action called reject() implying the next rule should be tested instead.
        }
        return false;
    },

// return next match in input
next:function () {
        if (this.done) {
            return this.EOF;
        }
        if (!this._input) {
            this.done = true;
        }

        var token,
            match,
            tempMatch,
            index;
        if (!this._more) {
            this.yytext = '';
            this.match = '';
        }
        var rules = this._currentRules();
        for (var i = 0; i < rules.length; i++) {
            tempMatch = this._input.match(this.rules[rules[i]]);
            if (tempMatch && (!match || tempMatch[0].length > match[0].length)) {
                match = tempMatch;
                index = i;
                if (this.options.backtrack_lexer) {
                    token = this.test_match(tempMatch, rules[i]);
                    if (token !== false) {
                        return token;
                    } else if (this._backtrack) {
                        match = false;
                        continue; // rule action called reject() implying a rule MISmatch.
                    } else {
                        // else: this is a lexer rule which consumes input without producing a token (e.g. whitespace)
                        return false;
                    }
                } else if (!this.options.flex) {
                    break;
                }
            }
        }
        if (match) {
            token = this.test_match(match, rules[index]);
            if (token !== false) {
                return token;
            }
            // else: this is a lexer rule which consumes input without producing a token (e.g. whitespace)
            return false;
        }
        if (this._input === "") {
            return this.EOF;
        } else {
            return this.parseError('Lexical error on line ' + (this.yylineno + 1) + '. Unrecognized text.\n' + this.showPosition(), {
                text: "",
                token: null,
                line: this.yylineno
            });
        }
    },

// return next match that has a token
lex:function lex() {
        var r = this.next();
        if (r) {
            return r;
        } else {
            return this.lex();
        }
    },

// activates a new lexer condition state (pushes the new lexer condition state onto the condition stack)
begin:function begin(condition) {
        this.conditionStack.push(condition);
    },

// pop the previously active lexer condition state off the condition stack
popState:function popState() {
        var n = this.conditionStack.length - 1;
        if (n > 0) {
            return this.conditionStack.pop();
        } else {
            return this.conditionStack[0];
        }
    },

// produce the lexer rule set which is active for the currently active lexer condition state
_currentRules:function _currentRules() {
        if (this.conditionStack.length && this.conditionStack[this.conditionStack.length - 1]) {
            return this.conditions[this.conditionStack[this.conditionStack.length - 1]].rules;
        } else {
            return this.conditions["INITIAL"].rules;
        }
    },

// return the currently active lexer condition state; when an index argument is provided it produces the N-th previous condition state, if available
topState:function topState(n) {
        n = this.conditionStack.length - 1 - Math.abs(n || 0);
        if (n >= 0) {
            return this.conditionStack[n];
        } else {
            return "INITIAL";
        }
    },

// alias for begin(condition)
pushState:function pushState(condition) {
        this.begin(condition);
    },

// return the number of states currently on the stack
stateStackSize:function stateStackSize() {
        return this.conditionStack.length;
    },
options: {},
performAction: function anonymous(yy,yy_,$avoiding_name_collisions,YY_START) {
var YYSTATE=YY_START;
switch($avoiding_name_collisions) {
case 0:/* con esto vale madre los espacios */
break;
case 1:return 11
break;
case 2:return 10
break;
case 3:return 12
break;
case 4:return 13
break;
case 5:return 14
break;
case 6:return 42
break;
case 7:return 40
break;
case 8:return 41
break;
case 9:return 22
break;
case 10:return 16
break;
case 11:return 17
break;
case 12:return 19
break;
case 13:return 18
break;
case 14:return 20
break;
case 15:return 4
break;
case 16:return 44       
break;
case 17:return 6
break;
case 18:return 8
break;
case 19:return "{"
break;
case 20:return "}"
break;
case 21:return "("
break;
case 22:return ")"
break;
case 23:return "+="
break;
case 24:return 36
break;
case 25:return 37
break;
case 26:return 38
break;
case 27:return 24
break;
case 28:return 25
break;
case 29:return "COMILLA"
break;
case 30:return 28
break;
case 31:return 29
break;
case 32:return 30
break;
case 33:return 31
break;
case 34:return 32
break;
case 35:return 33
break;
case 36:return 58
break;
case 37:return 65
break;
case 38:return 'INVALID'
break;
}
},
rules: [/^(?:\s+)/,/^(?:[0-9]+(\.[0-9]+)?\b)/,/^(?:[0-9]+\b)/,/^(?:'[a-zA-z]')/,/^(?:".*")/,/^(?:true|false\b)/,/^(?:protected\b)/,/^(?:public\b)/,/^(?:private\b)/,/^(?:void\b)/,/^(?:int\b)/,/^(?:char\b)/,/^(?:float\b)/,/^(?:bool\b)/,/^(?:String\b)/,/^(?:class\b)/,/^(?:if\b)/,/^(?:[a-zA-Z]+)/,/^(?:;)/,/^(?:\{)/,/^(?:\})/,/^(?:\()/,/^(?:\))/,/^(?:\+=)/,/^(?:-=)/,/^(?:\*=)/,/^(?:\/=)/,/^(?:\+\+)/,/^(?:--)/,/^(?:")/,/^(?:==)/,/^(?:<=)/,/^(?:>=)/,/^(?:!=)/,/^(?:&&)/,/^(?:\|\|)/,/^(?:=)/,/^(?:$)/,/^(?:.)/],
conditions: {"INITIAL":{"rules":[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38],"inclusive":true}}
});
return lexer;
})();
parser.lexer = lexer;
function Parser () {
  this.yy = {};
}
Parser.prototype = parser;parser.Parser = Parser;
return new Parser;
})();


if (typeof require !== 'undefined' && typeof exports !== 'undefined') {
exports.parser = parser;
exports.Parser = parser.Parser;
exports.parse = function () { return parser.parse.apply(parser, arguments); };
exports.main = function commonjsMain(args) {
    if (!args[1]) {
        console.log('Usage: '+args[0]+' FILE');
        process.exit(1);
    }
    var source = require('fs').readFileSync(require('path').normalize(args[1]), "utf8");
    return exports.parser.parse(source);
};
if (typeof module !== 'undefined' && require.main === module) {
  exports.main(process.argv.slice(1));
}
}