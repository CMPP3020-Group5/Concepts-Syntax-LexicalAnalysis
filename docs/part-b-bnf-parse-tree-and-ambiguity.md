int[] numbers = [5, 8, 12, 4, 10];

int average = sum(numbers)/count(numbers);


<!-- <decl> ::= <type> <variable> "=" <expr> ";"
<type> ::= "int" | "int[]"
<variable> ::= <letter> | <letter> <remaining>
<remaining> ::= <character> | <character> <remaining>
<expr> ::= <list> | "sum" "(" <list> ")" "/" "count" "(" <list> ")"
<letter> ::= "a" |"b" | "c" | "d" | "e" | "f" | "g" | "h" | "i" | "j" | "k" | "l" | "m" | "n" | "o" | "p" | "q" | "r" | "s" | "t" | "u" | "v" | "w" | "x" | "y" | "z"
<character> ::= <letter> | <number>
<number> ::= <digit> | <digit> <number>
<digit> ::= "0"| "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9"
<list> ::= "[" <components> "]"
<components> ::= <number> | <number> "," <components> -->



<decl> ::= <type> <variable> "=" <expr> ";"
<type> ::= "int" | "int[]"
<variable> ::= "numbers" | "average"
<expr> ::= <list> | "sum" "(" <list> ")" "/" "count" "(" <list> ")"
<number> ::= "0"| "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9" |"10" | "11" | "12"
<list> ::= "[" <components> "]"
<components> ::= <number> | <number> "," <components>