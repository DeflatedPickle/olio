grammar JascPal;

/*
JASC-PAL
0100
256
128 0 0
*/

@header {
package com.deflatedpickle.olio.jasc;
}

start: header NEWLINE version NEWLINE colour_count (NEWLINE rgb)+;

header: 'JASC-PAL';
version: INT;
colour_count: INT;
rgb: INT INT INT;

NEWLINE: '\r\n' | '\n';
INT: [0-9]+;

WS: [ \t] -> channel(HIDDEN);