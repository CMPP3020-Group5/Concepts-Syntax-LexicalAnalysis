# Part B: steps 1 & 2

## Problem Statement:

Given a set of numbers, find their average.

## Pseudocode

```text
//Get the user's input
numbersString = INPUT

//Parse and validate the input as an array of number
numbersArray = parse(numbersString)

//Initialize total and count
total = 0
count = 0

//Calculate the total and count by looping through the number array
for number in numbers_array {
    total += number
    count++
}

//Calculate the average
average = total/count

//Display the result
print(average)
```
