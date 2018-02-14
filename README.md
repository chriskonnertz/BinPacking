# BinPacking

Examples of algorithms that solve the bin packing problem. Implemented in Kotlin.
A demo is included (`Demo.kt`).

"In the bin packing problem, objects of different volumes must be packed into a finite number of bins or containers 
each of volume V in a way that minimizes the number of bins used."
Learn more about the problem and the algorithms: https://en.wikipedia.org/wiki/Bin_packing_problem

## Implemented algorithms

* First Fit (class `FirstFit`)
* First Fit Decreasing (class `FirstFitDecreasing`)

The concrete algorithm classes inherit from the abstract super class `BinPackagingAlgorithm`.

## Usage

```kotlin
    /** These are the available capacities (sizes) of the bins */
    val availableBinCapacities = arrayOf(5000, 6000, 70000)
    /** These are the lengths (parts) that we want to put into bins */
    val parts: List<Int> = listOf(1000, 2000, 3000, 4000)

    val firstFit = FirstFit()
    val result = firstFit.solve(availableBinCapacities, parts)
    result.print()
```

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