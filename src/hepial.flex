import java_cup.runtime.*;

%%
%class HepialF
%cup
%line
%column
%unicode

%{
    public static int line = 1;
%}

COMMENT=\/\/.*
BEGINPRG=debutprg
ENDPRG=finprg
PRG=programme
SEMICOLON=\;
IDENT=([A-Za-z])([A-Za-z0-9])*
COMA=\,
CONST=constante
EQ=\=
OPENPAR=\(
CLOSEPAR=\)
BEGINFUNC=debutfonc
ENDFUNC=finfonc
INT=entier
BOOL=booleen
OPENSQ=\[
CLOSESQ=\]
DOUBLEDOT=\.\.
REA=lire
WRIT=ecrire
STRING=\".*\"
RETUR=retourne
IF=si
THEN=alors
ELSE=sinon
ENDIF=finsi
WHIL=tantque
DO=faire
ENDWHIL=fintantque
FO=pour
FROM=allantde
TO=a
ENDFOR=finpour
TRUE=vrai
FALSE=faux
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
AND=et
OR=ou
NOTN=\~
NOT=non
INTCONST=(({NOTN}?)([0-9])+)
%%
{COMMENT} {}
{BEGINPRG} {
    return new Symbol(sym.t_beginPrg);
}

{ENDPRG} {
    return new Symbol(sym.t_endPrg);
}

{PRG} {
    return new Symbol(sym.t_prg);
}

{SEMICOLON} {
    return new Symbol(sym.t_semicolon);
}

{COMA} {
    return new Symbol(sym.t_coma);
}

{CONST} {
    return new Symbol(sym.t_const);
}

{EQ} {
    return new Symbol(sym.t_eq);
}

{OPENPAR} {
    return new Symbol(sym.t_openpar);
}

{CLOSEPAR} {
    return new Symbol(sym.t_closepar);
}

{BEGINFUNC} {
    return new Symbol(sym.t_beginfunc);
}

{ENDFUNC} {
    return new Symbol(sym.t_endfunc);
}

{INT} {
    return new Symbol(sym.t_int);
}

{BOOL} {
    return new Symbol(sym.t_bool);
}

{OPENSQ} {
    return new Symbol(sym.t_opensq);
}

{CLOSESQ} {
    return new Symbol(sym.t_closesq);
}

{DOUBLEDOT} {
    return new Symbol(sym.t_doubledot);
}

{REA} {
    return new Symbol(sym.t_read);
}

{WRIT} {
    return new Symbol(sym.t_write);
}

{STRING} {
    return new Symbol(sym.t_string, yytext());
}

{RETUR} {
    return new Symbol(sym.t_return);
}

{IF} {
    return new Symbol(sym.t_if);
}

{THEN} {
    return new Symbol(sym.t_then);
}

{ELSE} {
    return new Symbol(sym.t_else);
}

{ENDIF} {
    return new Symbol(sym.t_endif);
}

{WHIL} {
    return new Symbol(sym.t_while);
}

{DO} {
    return new Symbol(sym.t_do);
}

{ENDWHIL} {
    return new Symbol(sym.t_endwhile);
}

{FO} {
    return new Symbol(sym.t_for);
}

{FROM} {
    return new Symbol(sym.t_from);
}

{TO} {
    return new Symbol(sym.t_to);
}

{ENDFOR} {
    return new Symbol(sym.t_endfor);
}

{TRUE} {
    return new Symbol(sym.t_true);
}

{FALSE} {
    return new Symbol(sym.t_false);
}

{PLUS} {
    return new Symbol(sym.t_plus);
}

{MINUS} {
    return new Symbol(sym.t_minus);
}

{TIME} {
    return new Symbol(sym.t_time);
}

{DIV} {
    return new Symbol(sym.t_div);
}

{DOUBLEQ} {
    return new Symbol(sym.t_doubleq);
}

{DIFF} {
    return new Symbol(sym.t_diff);
}

{LT} {
    return new Symbol(sym.t_lt);
}

{GT} {
    return new Symbol(sym.t_gt);
}

{LE} {
    return new Symbol(sym.t_le);
}

{GE} {
    return new Symbol(sym.t_ge);
}

{AND} {
    return new Symbol(sym.t_and);
}

{OR} {
    return new Symbol(sym.t_or);
}

{NOTN} {
    return new Symbol(sym.t_notn);
}

{NOT} {
    return new Symbol(sym.t_not);
}

{INTCONST} {
    return new Symbol(sym.t_intConst, Integer.parseInt(yytext()));
}

{IDENT} {
    return new Symbol(sym.t_ident, yytext());
}

[\n] {line++;}
[\ |\t|\n|\r|\r]                  {}
. {}
