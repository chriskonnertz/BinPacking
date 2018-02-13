package de.chriskonnertz.firstFit

/**
 * The difference in comparison to the simple first fit algorithm is
 * that the lengths (parts) will be ordered before the optimization starts
 */
class FirstFitDecreasing : FirstFit() {
    override fun solveForCapacity(lengths: List<Int>): ArrayList<Bin> {
        /** Sort the lengths in a descending order */
        val sortedLengths = lengths.sortedDescending()

        return super.solveForCapacity(sortedLengths)
    }
}