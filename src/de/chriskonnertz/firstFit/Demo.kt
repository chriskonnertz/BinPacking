package de.chriskonnertz.firstFit

/**
 * Demo method that uses the algorithms with example values
 */
fun main(args: Array<String>) {
    println("Testing algorithms...")

    var firstFit: BinPackingAlgorithm
    var result: Result
    /** These are the available capacities (sizes) of the bins */
    val availableBinCapacities = arrayOf(5000, 6000, 70000)
    /** These are the parts that we want to put into bins */
    val parts: List<Int> = listOf(1000, 2000, 3000, 4000)

    var stringified = ""
    availableBinCapacities.forEach { stringified += it.toString() + ", " }
    println("Available bin capacities: " + stringified)
    println("Parts: " + parts)

    println()
    firstFit = FirstFit()
    println("Using " + firstFit::class)
    result = firstFit.solve(availableBinCapacities, parts)
    result.print()

    println()
    firstFit = FirstFitDecreasing()
    println("Using " + firstFit::class)
    result = firstFit.solve(availableBinCapacities, parts)
    result.print()
}