package de.chriskonnertz.firstFit

/**
 * Demo method that uses the algorithms with example values
 */
fun main(args: Array<String>) {
    println("Testing algorithms...")

    var firstFit: BinPackingAlgorithm
    var result: Result
    /** These are the available lengths (sizes) of the bins */
    val availableLengths = arrayOf(6000, 20000)
    /** These are the lengths (parts) that we want to put into bins */
    val lengths: List<Int> = listOf(3000, 2000, 2000)

    var stringified = ""
    availableLengths.forEach { stringified += it.toString() + ", " }
    println("Available lengths (bin capacities): " + stringified)
    println("Lengths (parts): " + lengths)

    println()
    firstFit = FirstFit()
    println("Using " + firstFit::class)
    result = firstFit.solve(availableLengths, lengths)
    result.print()

    println()
    firstFit = FirstFitDecreasing()
    println("Using " + firstFit::class)
    result = firstFit.solve(availableLengths, lengths)
    result.print()
}