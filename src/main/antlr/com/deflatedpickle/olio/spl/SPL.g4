grammar SPL;

/*
##Sketch RGBPalette 0
0.000000 0.000000 0.000000	Black
0.100000 0.100000 0.100000	90% Black
*/

@header {
package com.deflatedpickle.olio.spl;
}

start: HEADER (NEWLINE rgb)+;

name: (CHAR | INT)+;
rgb: r=FLOAT g=FLOAT b=FLOAT name;

HEADER: '##Sketch RGBPalette 0';

CHAR: [A-Za-z%];
FLOAT: INT PERIOD INT+;
INT: [0-9]+;
PERIOD: '.';
NEWLINE: '\r\n' | '\n';

WS: [ \t\r\n] -> channel(HIDDEN);