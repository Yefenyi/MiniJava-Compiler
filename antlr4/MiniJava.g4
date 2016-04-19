grammar MiniJava;
@header {package antlr4;}
//Grammar Rules
//Precedence of operators
//Lowest first
eQE: cE(EQUALS|NOTEQUALS)cE 
	| cE;
cE: aOE cEP;
cEP: (LT|GT|GEQ|LEQ) aOE
	|;
aOE: aSE aOEP;
aOEP: (AND|OR) aSE aOEP
	|;
aSE: mDE aSEP;
aSEP: (ADD|SUB) mDE aSEP
	|;
mDE: nE mDEP;
mDEP: (DIVIDE|MULTPY) nE mDEP
	|;
nE: (SUB|BANG) nE | dE;
dE: hPE dEP;
dEP: DOT ID LPREN (/*nothing*/|eQE (COMMA eQE)*) RPREN dEP
	|;
hPE: NEW ID LPREN RPREN
| ID
| THIS
| INTEGER
| NULL
| TRUE
| FALSE
| LPREN eQE RPREN;

program: mainClassDecl classDecl* EOF; 
mainClassDecl: CLASS ID LCURL PUBLIC STATIC VOID MAIN LPREN STRING 
	LBRACKET RBRACKET ID RPREN LCURL stmtList RCURL RCURL;
classDecl: CLASS ID (/*nothing*/|(EXTENDS ID)) LCURL
classVarDecl* methodDecl* RCURL; 
classVarDecl: type ID SEMI;
methodDecl: PUBLIC type ID LPREN (/*nothing*/|formal (COMMA formal)*) RPREN
	LCURL stmtList RETURN eQE SEMI RCURL;
type: INT|BOOLEAN|ID;
formal: type ID;
stmt: type ID ASSIGN eQE SEMI
	|LCURL stmtList RCURL
	|IF LPREN eQE RPREN stmt ELSE stmt
	|WHILE LPREN eQE RPREN stmt
	|SYSTEMPRINT LPREN eQE RPREN SEMI
	|ID ASSIGN eQE SEMI;
stmtList: stmt stmtList | ;

// LEXER RULES
//program : token;
//token : INTEGER | OPERATOR | DELIMITER | ID | RESERVEDWORD;


// LEXER
/*RESERVEDWORD: 'class'
	| 'public'
	| 'static'
	| 'extends'
	| 'void'
	| 'int'
	| 'boolean'
	| 'if'
	| 'else'
	| 'while'
	| 'return'
	| 'null'
	| 'true'
	| 'false'
	| 'this'
	| 'new'
	| 'String'
	| 'main'
	| ('System.out.println' {!('A' <= _input.LA(1) && _input.LA(1) <= 'z' || '0' <= _input.LA(1) && _input.LA(1) <= '9')}?);*/
//OPS
EQUALS: '==';
NOTEQUALS: '!=';
LT: '<';
GT: '>';
GEQ: '>=';
LEQ: '<=';
AND: '&&';
OR: '||';
ADD: '+';
SUB: '-';
DIVIDE: '/';
MULTPY: '*';
BANG: '!';
ASSIGN: '=';
//DELIMITER
DOT: '.';
LPREN: '(';
RPREN: ')';
COMMA: ',';
LCURL: '{';
RCURL: '}';
LBRACKET: '[';
RBRACKET: ']';
SEMI:';';
//KEYWORDS
NEW: 'new';
THIS: 'this';
NULL: 'null';
TRUE: 'true';
FALSE: 'false';
CLASS: 'class';
EXTENDS: 'extends';
PUBLIC: 'public';
STATIC: 'static';
VOID: 'void';
MAIN: 'main';
STRING: 'String';
RETURN: 'return';
INT: 'int';
BOOLEAN: 'boolean';
IF: 'if';
ELSE: 'else';
WHILE: 'while';
SYSTEMPRINT: ('System.out.println' {!('A' <= _input.LA(1) && _input.LA(1) <= 'z' || '0' <= _input.LA(1) && _input.LA(1) <= '9')}?);

INTEGER	: ( NONZERODIGIT DIGIT* )  | '0';
OPERATOR: '+' | '-' | '*' | '/' | '<' | '<=' | '>=' | '>' | '==' | '!=' | '&&' | '||' | '!';
DELIMITER: ';' | '.' | ',' | '=' | '(' | ')' | '{' | '}' | '[' | ']';
ID : LETTER (LETTER | DIGIT)*;

fragment LETTER	: [a-zA-Z] ;
fragment DIGIT	: [0-9] ;
fragment NONZERODIGIT : [1-9] ;
WS: ([ \n\t\r]+ | COMMENT) -> skip;
COMMENT: (('/*' .*? '*/') | ('//' .*? ~[\n\r]*)) -> skip;
/*
 used to generate first/Follow sets
 
eQE-> cE eQEOPS cE | cE
eQEOPS ->  EQUALS | NOTEQUALS
cE-> aOE cEP
cEP->  cEPOPS aOE cEP | EPSILON
cEPOPS->  LT | GT | GEQ | LEQ
aOE-> aSE aOEP
aOEP-> aOEPOPS aSE aOEP | EPSILON
aOEPOPS-> AND | OR 
aSE-> mDE aSEP
aSEP-> aSEPOPS mDE aSEP	| EPSILON
aSEPOPS-> ADD | SUB
mDE-> nE mDEP
mDEP-> mDEPOPS nE mDEP | EPSILON
mDEPOPS-> DIVIDE | MULTPY
nE-> nEOPS nE | dE
nEOPS-> SUB | BANG
dE-> hPE dEP
dEP-> DOT ID LPREN ARGS RPREN dEP | EPSILON
ARGS-> eQE | eQE COMMA ARGSC | EPSILON
ARGSC-> eQE | eQE COMMA ARGSC
hPE-> NEW ID LPREN RPREN | ID | THIS | INTEGER | NULL | TRUE | FALSE | LPREN eQE RPREN

program-> mainClassDec | classes
classes-> classDec classes | EPSILON
mainClassDecl-> CLASS ID LCURL PUBLIC STATIC VOID MAIN LPREN STRING LBRACKET RBRACKET ID RPREN LCURL stmt stmts RCURL RCURL
stmts->stmt stmts | EPSILON
classDecl-> CLASS ID LBRACKET EXTENDS ID RBRACKET LCURL classVars methodDecs RCURL
classVars-> classVarDecl classVars | EPSILON
classVarDecl-> type ID
methodDecs-> methodDecl methodDecs | EPSILON
methodDecl-> PUBLIC type ID LPREN formals RPREN LCURL stmts RETURN eQE SEMI RCURL
formals-> formal | formal COMMA formalsc | EPSILON
formalsc-> formal | formal COMMA formalsc
type-> INT | BOOLEAN | ID
formal-> type ID
stmt-> type ID ASSIGN eQE SEMI | LCURL stmts RCURL | IF LPREN eQE RPREN stmt ELSE stmt | WHILE LPREN eQE RPREN stmt | SYSTEMPRINT LPREN eQE RPREN SEMI | ID ASSIGN eQE SEMI
*/