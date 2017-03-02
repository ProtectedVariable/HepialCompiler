import java.util.*;
import java_cup.runtime.*;

%%
%class HepialF
%cup
%line
%column
%unicode

BEGINPRG=debutprg\b
ENDPRG=finprg\b
PRG=programme\b
SEMICOLON=\;
IDENT=([A-Za-z])([A-Za-z0-9])*\b
COMA=\,
CONST=constante\b
EQ=\=
OPENPAR=\(
CLOSEPAR=\)
BEGINFUNC=debutfonc\b
ENDFUNC=finfonc\b
INT=entier\b
BOOL=booleen\b
OPENSQ=\[
CLOSESQ=\]
DOUBLEDOT=\.\.
REA=lire\b
WRIT=ecrire\b
STRING=\".*\"
RETUR=retourne\b
IF=si\b
THEN=alors\b
ELSE=sinon\b
ENDIF=finsi\b
WHIL=tantque\b
DO=faire\b
ENDWHIL=fintantque\b
FO=pour\b
FROM=allantde\b
TO=a\b
ENDFOR=finpour\b
TRUE=vrai\b
FALSE=faux\b
PLUS=\+
MINUS=\-
TIME=\*
DIV=\/
DOUBLEQ=\=\=
DIFF=\<\>
LT=\<
GT=\>
LE=\<\=
GE=\>\=
AND=et\b
OR=ou\b
NOTN=\~
NOT=non\b
INTCONST=((\+?|\-?)([0-9])+)\b
%%
{BEGINPRG} {
    return new Symbol(sym.beginPrg);
}

{ENDPRG} {
    return new Symbol(sym.endPrg);
}

{PRG} {
    return new Symbol(sym.prg);
}

{SEMICOLON} {
    return new Symbol(sym.semicolon);
}

{COMA} {
    return new Symbol(sym.coma);
}

{CONST} {
    return new Symbol(sym.const);
}

{EQ} {
    return new Symbol(sym.eq);
}

{OPENPAR} {
    return new Symbol(sym.openpar);
}

{CLOSEPAR} {
    return new Symbol(sym.closepar);
}

{BEGINFUNC} {
    return new Symbol(sym.beginfunc);
}

{ENDFUNC} {
    return new Symbol(sym.endfunc);
}

{INT} {
    return new Symbol(sym.int);
}

{BOOL} {
    return new Symbol(sym.bool);
}

{OPENSQ} {
    return new Symbol(sym.opensq);
}

{CLOSESQ} {
    return new Symbol(sym.closesq);
}

{DOUBLEDOT} {
    return new Symbol(sym.doubledot);
}

{REA} {
    return new Symbol(sym.rea);
}

{WRIT} {
    return new Symbol(sym.writ);
}

{STRING} {
    return new Symbol(sym.string);
}

{RETUR} {
    return new Symbol(sym.retur);
}

{IF} {
    return new Symbol(sym.if);
}

{THEN} {
    return new Symbol(sym.then);
}

{ELSE} {
    return new Symbol(sym.else);
}

{ENDIF} {
    return new Symbol(sym.endif);
}

{WHIL} {
    return new Symbol(sym.whil);
}

{DO} {
    return new Symbol(sym.do);
}

{ENDWHIL} {
    return new Symbol(sym.endwhil);
}

{FO} {
    return new Symbol(sym.fo);
}

{FROM} {
    return new Symbol(sym.from);
}

{TO} {
    return new Symbol(sym.to);
}

{ENDFOR} {
    return new Symbol(sym.endfor);
}

{TRUE} {
    return new Symbol(sym.true);
}

{FALSE} {
    return new Symbol(sym.false);
}

{PLUS} {
    return new Symbol(sym.plus);
}

{MINUS} {
    return new Symbol(sym.minus);
}

{TIME} {
    return new Symbol(sym.time);
}

{DIV} {
    return new Symbol(sym.div);
}

{DOUBLEQ} {
    return new Symbol(sym.doubleq);
}

{DIFF} {
    return new Symbol(sym.diff);
}

{LT} {
    return new Symbol(sym.lt);
}

{GT} {
    return new Symbol(sym.gt);
}

{LE} {
    return new Symbol(sym.le);
}

{GE} {
    return new Symbol(sym.ge);
}

{AND} {
    return new Symbol(sym.and);
}

{OR} {
    return new Symbol(sym.or);
}

{NOTN} {
    return new Symbol(sym.notn);
}

{NOT} {
    return new Symbol(sym.not);
}

{INTCONST} {
    return new Symbol(sym.intConst);
}

{IDENT} {
    return new Symbol(sym.ident);
}

[\ |\t|\n|\r|\r\n]                  {}
. {}
