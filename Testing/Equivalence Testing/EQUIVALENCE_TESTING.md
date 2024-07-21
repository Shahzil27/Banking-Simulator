# The Choice to Omit Equivalence Testing

We chose to omit Equivalence testing in favour of Robust Boundary Value Analysis. We made this decision due to the lack of partitions in acceptable data. When considering if a value is acceptable or not in the context of a withdraw, deposit, or money transfer, it is either within the 
boundary of accepted values or it is outsie of the boundary and cannot be used. Since this is the case, we have decided to use Robust Boundary Value Analysis exclusively as Equivalence testing is not an ideal choice for our project and would not be a good use of time.
Our Robust Boundary Analysis is linked below.

[Robust Boundary Analysis](https://github.com/Shahzil27/Banking-Simulator/tree/main/Testing/Specification%20Based%20Testing/Boundary%20Value%20Analysis)
