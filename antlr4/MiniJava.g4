grammar MiniJava;
@header {
	package antlr4;
}
// LEXER RULES
program : token;
token : INTEGER | OPERATOR | DELIMITER | ID | RESERVEDWORD;


// LEXER
ID : LETTER (LETTER | DIGIT)*;
INTEGER	: ( NONZERODIGIT DIGIT* )  | '0';
OPERATOR: '+' | '-' | '*' | '/' | '<' | '<=' | '>=' | '>' | '==' | '!=' | '&&' | '||' | '!';
DELIMITER: ';' | '.' | ',' | '=' | '(' | ')' | '{' | '}' | '[' | ']';
RESERVEDWORD: 'class'
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
	| 'System.out.println';

fragment LETTER	: [a-zA-Z] ;
fragment DIGIT	: [0-9] ;
fragment NONZERODIGIT : [1-9] ;
WS: ([ \n\t\r]+ | COMMENT) -> skip;
COMMENT: (('/*' .*? '*/') | ('//' .*? [\n\r])) -> skip;