grammar CorelDRAWPal;

/*
"PANTONE Process Yellow CH"    0    0  100    0
*/

@header {
package com.deflatedpickle.olio.coreldraw;
}

start: rgb (NEWLINE rgb)+;

rgb: name INT INT INT INT;
name: STRING;

STRING: QUOTE ~["\r\n]* QUOTE;
QUOTE: '"' ;
NEWLINE: '\r\n' | '\n';
INT: [0-9]+;

WS: [ \t\r\n] -> channel(HIDDEN);