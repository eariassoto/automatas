import ply.lex as lex

reserved = { 
'NOOP':'NOOP', 
'LOAD':'LOAD', 
'STORE':'STORE', 
'LOADI':'LOADI',
'STOREI':'STOREI',
'JMP':'JMP',
'BB':'BB',
'BEQ':'BEQ',
'AND':'AND',
'OR':'OR',
'XOR':'XOR',
'NOT':'NOT',
'ADD':'ADD',
'SUB':'SUB',
'SHIFT':'SHIFT',
'CMP':'CMP',
'R':'R' 
}

# List of token names.   This is always required
tokens = [
   'NUMBER',
   'NAME'
] + list(reserved.values())


literals = ['[',']']

def t_NAME(t):
    r'[a-zA-Z_][a-zA-Z_]*'
    t.type = reserved.get(t.value,'NAME')    # Check for reserved words
    return t


def t_NUMBER(t):
    r'\d+'
    t.value = '{0:04b}'.format(int(t.value))  
    return t

def t_newline(t):
    r'\n+'
    t.lexer.lineno += len(t.value)
    
def t_STRING(t):
    r'\"([^\\"]|(\\.))*\"'
    escaped = 0
    str = t.value[1:-1]
    new_str = ""
    for i in range(0, len(str)):
        c = str[i]
        if escaped:
            if c == "n":
                c = "\n"
            elif c == "t":
                c = "\t"
            new_str += c
            escaped = 0
        else:
            if c == "\\":
                escaped = 1
            else:
                new_str += c
    t.value = new_str
    return t


# A string containing ignored characters (spaces and tabs)
t_ignore  = ' \t'

# Error handling rule
def t_error(t):
    print "Illegal character '%s'" % t.value[0]
    t.lexer.skip(1)

# Build the lexer
lexer = lex.lex()  

import ply.yacc as yacc
import sys

names = {}
  
def p_statement_expr(p): 
    'statement : expression' 
    p[0] = p[1] 

def p_tipo1(p):
    "expression : cod1 R NUMBER '[' NUMBER ']'"
    p[0] = p[1] + p[3] + '0000' + p[5]

def p_cod1(p):
    '''cod1 : LOAD
              | STORE '''
    if(p[1] == 'LOAD'):
        p[0] = '0001';
    else:
        p[0] = '0010'

def p_tipo2(p):
    "expression : cod2 R NUMBER NUMBER"
    p[0] = p[1] + p[3] + p[4] + '0000'

def p_cod2(p):
    '''cod2 : LOADI
              | SHIFT '''
    if(p[1] == 'LOADI'):
        p[0] = '0011';
    else:
        p[0] = '1110'

def p_tipo3(p):
    "expression : STOREI NUMBER '[' NUMBER ']'"
    p[0] = '0100' + '0000' + p[2] + p[4] 

def p_tipo4(p):
    "expression : cod4 '[' NUMBER ']'"
    p[0] = p[1] + '00000000' + p[3]

def p_cod4(p):
    '''cod4 : JMP
              | BB 
              | BEQ '''
    if(p[1] == 'JMP'):
        p[0] = '0101';
    elif(p[1] == 'BB'):
        p[0] = '0110'
    else:
        p[0] = '0111'

# Error rule for syntax errors
def p_error(p):
    print "Syntax error in input!"

# Build the parser
parser = yacc.yacc()

if len(sys.argv) == 1:
    while True:
        try:
            s = raw_input('> ')
        except EOFError:
            break
        if not s: continue
        result = parser.parse(s)
        print result
elif sys.argv[1] == "-f":
    f = open(sys.argv[2], "r")
    s = f.readlines()
    for line in s:
        result = parser.parse(line)
        print result 