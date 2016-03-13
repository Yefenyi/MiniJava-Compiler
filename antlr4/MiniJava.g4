grammar MiniJava;
@header {package antlr4;}

// LEXER RULES
program : token;
token : INTEGER | OPERATOR | DELIMITER | ID | RESERVEDWORD;


// LEXER
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
	| ('System.out.println' {!('A' <= _input.LA(1) && _input.LA(1) <= 'z' || '0' <= _input.LA(1) && _input.LA(1) <= '9')}?);
INTEGER	: ( NONZERODIGIT DIGIT* )  | '0';
OPERATOR: '+' | '-' | '*' | '/' | '<' | '<=' | '>=' | '>' | '==' | '!=' | '&&' | '||' | '!';
DELIMITER: ';' | '.' | ',' | '=' | '(' | ')' | '{' | '}' | '[' | ']';
ID : LETTER (LETTER | DIGIT)*;

fragment LETTER	: [a-zA-Z] ;
fragment DIGIT	: [0-9] ;
fragment NONZERODIGIT : [1-9] ;
WS: ([ \n\t\r]+ | COMMENT) -> skip;
COMMENT: (('/*' .*? '*/') | ('//' .*? ~[\n\r]*)) -> skip;