import ply.lex as lex
import ply.yacc as yacc
import sys
import datetime

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

def p_tipo5(p):
    "expression : CMP  R NUMBER R NUMBER" 
    p[0] = '1111' + p[3] + p[5] + '0000'


def p_tipo6(p):
    "expression : NOT  R NUMBER R NUMBER" 
    p[0] = '1111' + p[3] + '0000' + p[5] 

def p_tipo7(p):
    "expression : cod5  R NUMBER R NUMBER R NUMBER" 
    p[0] = p[1] + p[3] + p[5] + p[7] 

def p_cod5(p):
    '''cod5 : AND
            | OR 
            | XOR
            | ADD
            | SUB '''
    if(p[1] == 'AND'):
        p[0] = '1000';
    elif(p[1] == 'OR'):
        p[0] = '1001'
    elif(p[1] == 'XOR'):
        p[0] = '1010'
    elif(p[1] == 'ADD'):
        p[0] = '1100'
    else:
        p[0] = '1101'



# Error rule for syntax errors
def p_error(p):
    print "Syntax error in input!"

# Build the parser
parser = yacc.yacc()

if sys.argv[1] == "-c":
    time = datetime.datetime.now()
    ms = time.microsecond
    nombreArchivo = str(ms) + '.txt'

    try:
        file = open(nombreArchivo,'w+')   # Trying to create a new file or open one
        
        inputFile = open(sys.argv[2], "r")
        s = inputFile.readlines()
        for line in s:
            result = parser.parse(line)
            file.write(result+'\n');
            print result 

        file.close()

    except:
        print('Something went wrong! Can\'t tell what?')
        sys.exit(0)

    