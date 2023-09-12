grammar HPL;

/*
Palette
Version 4.0

0 0 0
*/

@header {
package com.deflatedpickle.olio.hpl;
}

start: header NEWLINE version NEWLINE (NEWLINE rgb)+;

header: 'Palette';
version: 'Version' (INT PERIOD INT);
rgb: INT INT INT;

STRING: QUOTE ~["\r\n]* QUOTE;
PERIOD: '.';
QUOTE: '"' ;
NEWLINE: '\r\n' | '\n';
INT: [0-9]+;

WS: [ \t\r\n] -> channel(HIDDEN);