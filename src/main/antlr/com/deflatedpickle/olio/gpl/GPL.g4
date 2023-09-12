grammar GPL;

/*
GIMP Palette
Name: Tango Icon Theme
Columns: 3
#
252 233  79	Butter 1
*/

@header {
package com.deflatedpickle.olio.gpl;
}

start: HEADER NEWLINE NAME palette_name=name NEWLINE COLUMNS columns=INT NEWLINE HASHTAG (NEWLINE rgb)+;

name: CHAR (CHAR | INT)+;
rgb: r=INT g=INT b=INT name;

HEADER: 'GIMP Palette';
NAME: 'Name:';
COLUMNS: 'Columns:';

HASHTAG: '#';
NEWLINE: '\r\n' | '\n';
CHAR: [A-Za-z];
INT: [0-9]+;

WS: [ \t\r\n] -> channel(HIDDEN);