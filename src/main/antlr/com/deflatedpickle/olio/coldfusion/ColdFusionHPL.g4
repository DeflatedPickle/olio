grammar ColdFusionHPL;

/*
Palette
Version 4.0

0 0 0
*/

@header {
package com.deflatedpickle.olio.coldfusion;
}

start: palette NEWLINE version NEWLINE (NEWLINE rgb)+;

palette: 'Palette';
version: 'Version' (INT PERIOD INT);
rgb: INT INT INT;

STRING: QUOTE ~["\r\n]* QUOTE;
PERIOD: '.';
QUOTE: '"' ;
NEWLINE: '\r\n' | '\n';
INT: [0-9]+;

WS: [ \t\r\n] -> channel(HIDDEN);