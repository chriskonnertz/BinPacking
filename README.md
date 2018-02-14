# BinPacking

Examples of algorithms that solve the bin packing problem. Implemented in Kotlin.
A demo is included (`Demo.kt`).

Learn more about the problem and the algorithms: https://en.wikipedia.org/wiki/Bin_packing_problem

## Implemented algorithms

* First Fit (class `FirstFit`)
* First Fit Decreasing (class `FirstFitDecreasing`)

The concrete algorithm classes inherit from the abstract super class `BinPackagingAlgorithm`.

## Example demo output

Output from the demo (`Demo.kt`): 

```
Testing algorithms...
Available bin capacities: 5000, 6000, 70000, 
Parts: [1000, 2000, 3000, 4000]

Using class de.chriskonnertz.firstFit.FirstFit
Optimization done.
Result:
Best bin capacity: 6000 - Used bins: 2 - Evaluation value: 2000
1. Bin - Unused space: 0 - Parts: [1000, 2000, 3000]
2. Bin - Unused space: 2000 - Parts: [4000]

Using class de.chriskonnertz.firstFit.FirstFitDecreasing
Optimization done.
Result:
Best bin capacity: 5000 - Used bins: 2 - Evaluation value: 0
1. Bin - Unused space: 0 - Parts: [4000, 1000]
2. Bin - Unused space: 0 - Parts: [3000, 2000]

Process finished with exit code 0
```