import ply.lex as lex
import ply.yacc as yacc
import sys
import datetime
import math

# List of token names.   This is always required
tokens = [
   'NUMBER',
   'V'
]


literals = ['+','-','^']

def t_V(t):
    r'[a-zA-Z]'
    return t


def t_NUMBER(t):
    r'\d+'
    t.value = int(t.value)  
    return t

def t_newline(t):
    r'\n+'
    t.lexer.lineno += len(t.value)

t_ignore  = ' \t'

def t_error(t):
    print "Illegal character '%s'" % t.value[0]
    t.lexer.skip(1)

lexer = lex.lex()  
  
def p_statement_expr(p): 
    'statement : p' 
    p[0] = p[1] 

def p_expresion(p):
    "p : monomio simbolo p"
    p[0] = p[1] + p[3]

def p_expresion2(p):
    "p : monomio"
    p[0] = p[1]

def p_monomio(p):
    "monomio : NUMBER V '^' NUMBER"
    p[0] = math.pow(p[1],p[4])

def p_simbolo(p):
    '''simbolo : '+'
               | '-' '''
    p[0] = p[1]

# Error rule for syntax errors
def p_error(p):
    print "Syntax error in input!"

# Build the parser
parser = yacc.yacc()

while True:
   try:
       s = raw_input('> ')
   except EOFError:
       break
   if not s: continue
   result = parser.parse(s)
   print(result)