import java.util.*;
import java_cup.runtime.*;

%%
%class HepialF
%cup
%line
%column
%unicode

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
INTCONST=((\+?|\-?)([0-9])+)
%%
{BEGINPRG} {
	System.out.println("I've seen sym.t_beginPrg "+yytext());
    return new Symbol(sym.t_beginPrg);
}

{ENDPRG} {
	System.out.println("I've seen sym.t_endPrg "+yytext());
    return new Symbol(sym.t_endPrg);
}

{PRG} {
	System.out.println("I've seen sym.t_prg "+yytext());
    return new Symbol(sym.t_prg);
}

{SEMICOLON} {
	System.out.println("I've seen sym.t_semicolon "+yytext());
    return new Symbol(sym.t_semicolon);
}

{COMA} {
	System.out.println("I've seen sym.t_coma "+yytext());
    return new Symbol(sym.t_coma);
}

{CONST} {
	System.out.println("I've seen sym.t_const "+yytext());
    return new Symbol(sym.t_const);
}

{EQ} {
	System.out.println("I've seen sym.t_eq "+yytext());
    return new Symbol(sym.t_eq);
}

{OPENPAR} {
	System.out.println("I've seen sym.t_openpar "+yytext());
    return new Symbol(sym.t_openpar);
}

{CLOSEPAR} {
	System.out.println("I've seen sym.t_closepar "+yytext());
    return new Symbol(sym.t_closepar);
}

{BEGINFUNC} {
	System.out.println("I've seen sym.t_beginfunc "+yytext());
    return new Symbol(sym.t_beginfunc);
}

{ENDFUNC} {
	System.out.println("I've seen sym.t_endfunc "+yytext());
    return new Symbol(sym.t_endfunc);
}

{INT} {
	System.out.println("I've seen sym.t_int "+yytext());
    return new Symbol(sym.t_int);
}

{BOOL} {
	System.out.println("I've seen sym.t_bool "+yytext());
    return new Symbol(sym.t_bool);
}

{OPENSQ} {
	System.out.println("I've seen sym.t_opensq "+yytext());
    return new Symbol(sym.t_opensq);
}

{CLOSESQ} {
	System.out.println("I've seen sym.t_closesq "+yytext());
    return new Symbol(sym.t_closesq);
}

{DOUBLEDOT} {
	System.out.println("I've seen sym.t_doubledot "+yytext());
    return new Symbol(sym.t_doubledot);
}

{REA} {
	System.out.println("I've seen sym.t_read "+yytext());
    return new Symbol(sym.t_read);
}

{WRIT} {
	System.out.println("I've seen sym.t_write "+yytext());
    return new Symbol(sym.t_write);
}

{STRING} {
	System.out.println("I've seen sym.t_string "+yytext());
    return new Symbol(sym.t_string);
}

{RETUR} {
	System.out.println("I've seen sym.t_return "+yytext());
    return new Symbol(sym.t_return);
}

{IF} {
	System.out.println("I've seen sym.t_if "+yytext());
    return new Symbol(sym.t_if);
}

{THEN} {
	System.out.println("I've seen sym.t_then "+yytext());
    return new Symbol(sym.t_then);
}

{ELSE} {
	System.out.println("I've seen sym.t_else "+yytext());
    return new Symbol(sym.t_else);
}

{ENDIF} {
	System.out.println("I've seen sym.t_endif "+yytext());
    return new Symbol(sym.t_endif);
}

{WHIL} {
	System.out.println("I've seen sym.t_while "+yytext());
    return new Symbol(sym.t_while);
}

{DO} {
	System.out.println("I've seen sym.t_do "+yytext());
    return new Symbol(sym.t_do);
}

{ENDWHIL} {
	System.out.println("I've seen sym.t_endwhile "+yytext());
    return new Symbol(sym.t_endwhile);
}

{FO} {
	System.out.println("I've seen sym.t_for "+yytext());
    return new Symbol(sym.t_for);
}

{FROM} {
	System.out.println("I've seen sym.t_from "+yytext());
    return new Symbol(sym.t_from);
}

{TO} {
	System.out.println("I've seen sym.t_to "+yytext());
    return new Symbol(sym.t_to);
}

{ENDFOR} {
	System.out.println("I've seen sym.t_endfor "+yytext());
    return new Symbol(sym.t_endfor);
}

{TRUE} {
	System.out.println("I've seen sym.t_true "+yytext());
    return new Symbol(sym.t_true);
}

{FALSE} {
	System.out.println("I've seen sym.t_false "+yytext());
    return new Symbol(sym.t_false);
}

{PLUS} {
	System.out.println("I've seen sym.t_plus "+yytext());
    return new Symbol(sym.t_plus);
}

{MINUS} {
	System.out.println("I've seen sym.t_minus "+yytext());
    return new Symbol(sym.t_minus);
}

{TIME} {
	System.out.println("I've seen sym.t_time "+yytext());
    return new Symbol(sym.t_time);
}

{DIV} {
	System.out.println("I've seen sym.t_div "+yytext());
    return new Symbol(sym.t_div);
}

{DOUBLEQ} {
	System.out.println("I've seen sym.t_doubleq "+yytext());
    return new Symbol(sym.t_doubleq);
}

{DIFF} {
	System.out.println("I've seen sym.t_diff "+yytext());
    return new Symbol(sym.t_diff);
}

{LT} {
	System.out.println("I've seen sym.t_lt "+yytext());
    return new Symbol(sym.t_lt);
}

{GT} {
	System.out.println("I've seen sym.t_gt "+yytext());
    return new Symbol(sym.t_gt);
}

{LE} {
	System.out.println("I've seen sym.t_le "+yytext());
    return new Symbol(sym.t_le);
}

{GE} {
	System.out.println("I've seen sym.t_ge "+yytext());
    return new Symbol(sym.t_ge);
}

{AND} {
	System.out.println("I've seen sym.t_and "+yytext());
    return new Symbol(sym.t_and);
}

{OR} {
	System.out.println("I've seen sym.t_or "+yytext());
    return new Symbol(sym.t_or);
}

{NOTN} {
	System.out.println("I've seen sym.t_notn "+yytext());
    return new Symbol(sym.t_notn);
}

{NOT} {
	System.out.println("I've seen sym.t_not "+yytext());
    return new Symbol(sym.t_not);
}

{INTCONST} {
	System.out.println("I've seen sym.t_intConst "+yytext());
    return new Symbol(sym.t_intConst, Integer.parseInt(yytext()));
}

{IDENT} {
	System.out.println("I've seen sym.t_ident "+yytext());
    return new Symbol(sym.t_ident, yytext());
}

[\ |\t|\n|\r|\r\n]                  {}
. {}
