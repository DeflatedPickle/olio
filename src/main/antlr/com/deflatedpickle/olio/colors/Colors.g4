grammar Colors;

/*
KDE RGB Palette
0 0 0	Black
48 48 48	Almost black
*/

@header {
package com.deflatedpickle.olio.colors;
}

start: HEADER (NEWLINE rgb)+;

name: CHAR (CHAR | INT)+;
rgb: r=INT g=INT b=INT name;

HEADER: 'KDE RGB Palette';

NEWLINE: '\r\n' | '\n';
CHAR: [A-Za-z];
INT: [0-9]+;

WS: [ \t] -> channel(HIDDEN);