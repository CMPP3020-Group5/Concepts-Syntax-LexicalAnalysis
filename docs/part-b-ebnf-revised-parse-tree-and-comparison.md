1.ebnf:

<decl> ::= <array-decl> | <average-decl>

<array-decl> ::= "int[]" <variable> "=" <list> ";"

<average-decl> ::= "double" <variable> "=" "average" "(" <list> ")" ";"

<variable> ::= <letter> { <character> }

<letter> ::= "a" | "b" | "c" | "d" | "e" | "f" | "g"
           | "h" | "i" | "j" | "k" | "l" | "m" | "n"
           | "o" | "p" | "q" | "r" | "s" | "t" | "u"
           | "v" | "w" | "x" | "y" | "z"

<character> ::= <letter> | <digit> | "_"

<number> ::= <digit> { <digit> }

<digit> ::= "0" | "1" | "2" | "3" | "4"
          | "5" | "6" | "7" | "8" | "9"

<list> ::= "[" <components> "]"

<components> ::= <number> { "," <number> }




2.Explain the benefits of using EBNF over traditional BNF, particularly in terms of readability and clarity:

Curly braces { ... } indicate zero or more repetitions. This replaces the recursive list rule and makes the grammar easier to read.  


3.Remove any ambiguity present in the BNF grammar through syntax modifications in the EBNF version: 

The original BNF allowed any valid type to be combined with any valid expression. The revised EBNF separates array declarations and average declarations so that int[] is associated with a list expression and double is associated with an average expression. This makes the syntax more precise.
