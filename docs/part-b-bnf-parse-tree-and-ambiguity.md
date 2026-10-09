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








Part B 

5. The current lines of code for the problem statement are unambiguous, meaning there is only one way for them to be written. Ambiguity could be added by changing the way the new numbers are added to the list. <components> could potentially have an option to be written as <components> "," <number> which would provide an alternative way to display the list in the parse tree. 