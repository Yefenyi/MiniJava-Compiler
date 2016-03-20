grammar MiniJava;
@header {package antlr4;}
//Grammer Rules
//Precedence of operators
//Lowest first
eQE: cE(EQUALS|NOTEQUALS)cE 
	| cE;
cE: aOE cEP;
cEP: (LT|GT|GEQ|LEQ) aOE cEP
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
dE: dE DOT ID LPREN (/*nothing*/|eQE (COMMA eQE)*) RPREN
	|hPE;
hPE: NEW ID LPREN RPREN
| ID
| THIS
| INTEGER
| NULL
| TRUE
| FALSE
| LPREN eQE RPREN;

program: mainClassDecl classDecl*; 
mainClassDecl: CLASS ID LCURL PUBLIC STATIC VOID MAIN LPREN STRING 
	LBRACKET RBRACKET ID RPREN LCURL stmt* RCURL RCURL;
classDecl: CLASS ID (/*nothing*/|(LBRACKET EXTENDS ID RBRACKET)) LCURL
classVarDecl* methodDecl* RCURL; 
classVarDecl: type ID;
methodDecl: PUBLIC type ID LPREN (/*nothing*/|formal (COMMA formal)*) RPREN
	LCURL stmt* RETURN eQE SEMI RCURL;
type: INT|BOOLEAN|ID;
formal: type ID;
stmt: type ID ASSIGN eQE SEMI
	|LCURL stmt* RCURL
	|IF LPREN eQE RPREN stmt ELSE stmt
	|WHILE LPREN eQE RPREN stmt
	|SYSTEMPRINT LPREN eQE RPREN SEMI
	|ID ASSIGN eQE SEMI;

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