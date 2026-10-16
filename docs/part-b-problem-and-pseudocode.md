# Part B: steps 1 & 2

## Problem Statement:

Given a set of numbers, find their average.

## Pseudocode

```text
// Get the user's input
numbersString = INPUT

// Parse and validate the input based on the defined syntax
numbersArray = parse(numbersString)

// Initialize total and count
total = 0
count = 0

// Calculate the total and count by looping through the numbers array
for number in numbersArray {
    total += number
    count++
}

// Calculate the average
average = total / count

// Display the result
print(average)
```
