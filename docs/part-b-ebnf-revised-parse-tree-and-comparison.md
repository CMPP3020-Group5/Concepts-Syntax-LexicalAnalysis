1.ebnf:

request = "average", "(", list, ")" ;
list = "[", components, "]" ;
components = number, { ",", number } ;
number = digit, { digit } ;
digit = "0" | "1" | "2" | "3" | "4"
      | "5" | "6" | "7" | "8" | "9" ;




2.Explain the benefits of using EBNF over traditional BNF, particularly in terms of readability and clarity:

Curly braces { ... } indicate zero or more repetitions. This replaces the recursive list rule and makes the grammar easier to read.


3.Remove any ambiguity present in the BNF grammar through syntax modifications in the EBNF version:

The original simplified BNF is unambiguous, so no ambiguity needs to be removed. The revised EBNF preserves an unambiguous list structure while replacing the declaration-based input with a single average(list) command. This simplifies user input and parsing without changing the average calculation.