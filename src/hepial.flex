import java.util.*;
import java_cup.runtime.*;

%%
%class HepialF
%cup
%line
%column
%unicode

BEGINPRG='debutprg'
ENDPRG='finprg'

%%

{BEGINPRG} {
    return new Symbol(sym.beginPrg);
}
