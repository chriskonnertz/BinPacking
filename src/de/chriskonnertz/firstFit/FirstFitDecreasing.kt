package de.chriskonnertz.firstFit

/**
 * The difference in comparison to the simple first fit algorithm is
 * that the parts will be ordered before the optimization starts
 */
class FirstFitDecreasing : FirstFit() {
    override fun createInstance(): BinPackingAlgorithm {
        return FirstFitDecreasing()
    }

    override fun solveForCapacity(parts: List<Int>): ArrayList<Bin> {
        /** Sort the parts in a descending order */
        val sortedParts = parts.sortedDescending()

        return super.solveForCapacity(sortedParts)
    }
}