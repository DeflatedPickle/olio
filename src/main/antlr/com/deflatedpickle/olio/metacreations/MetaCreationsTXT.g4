grammar MetaCreationsTXT;

/*
ROWS 7
COLS 1
WIDTH 140
HEIGHT 30
TEXTHEIGHT 12
SPACING 1
R:247, G:224, B:23  HV:0.00, SV:0.00, VV:0.00  PANTONE Yellow C
*/

@header {
package com.deflatedpickle.olio.metacreations;
}

start: rows NEWLINE cols NEWLINE width NEWLINE height NEWLINE text_height NEWLINE spacing (NEWLINE line)+;

rows: ROWS INT;
cols: COLS INT;
width: WIDTH INT;
height: HEIGHT INT;
text_height: TEXT_HEIGHT INT;
spacing: SPACING INT;

name: CHAR (CHAR | INT)+;
line: R COLON INT COMMA G COLON INT COMMA B COLON INT HV COLON FLOAT COMMA SV COLON FLOAT COMMA VV COLON FLOAT name;

ROWS: 'ROWS';
COLS: 'COLS';
WIDTH: 'WIDTH';
HEIGHT: 'HEIGHT';
TEXT_HEIGHT: 'TEXTHEIGHT';
SPACING: 'SPACING';
R: 'R';
G: 'G';
B: 'B';
HV: 'HV';
SV: 'SV';
VV: 'VV';

PERIOD: '.';
COMMA: ',';
COLON: ':';
NEWLINE: '\r\n' | '\n';
CHAR: [A-Za-z];
INT: [0-9]+;
FLOAT: INT PERIOD INT+;

SPACE: [ \t\r\n] -> channel(HIDDEN);

