package de.chriskonnertz.firstFit

/**
 * Abstract base class for the concrete algorithms.
 * Includes two abstract method that the concrete algorithm classes have to implement.
 */
abstract class BinPackingAlgorithm {
    /** The size of the current bin */
    var binCapacity = 0
    /** The total rest (of all bins) / unused space after the optimization has been executed */
    protected var totalRest = 0

    /**
     * This method has to create and return an instance of the concrete algorithm class
     */
    abstract fun createInstance(): BinPackingAlgorithm

    /**
     * This method has to be implemented by the concrete algorithm class.
     * It executes the algorithm for a specific bin capacity.
     * It returns an array list wih bins that hold the lengths (parts).
     */
    abstract fun solveForCapacity(lengths: List<Int>): ArrayList<Bin>

    /**
     * This method uses the concrete algorithm class to execute the optimization
     * for every available lengths (bin capacity)
     */
    fun solve(availableLengths: Array<Int>, lengths: List<Int>): Result {
        var firstFit: BinPackingAlgorithm
        var minTotalRest = Int.MAX_VALUE
        var bestLengthBins: ArrayList<Bin> = arrayListOf()

        for (availableLength: Int in availableLengths) {
            firstFit = createInstance()
            firstFit.binCapacity = availableLength

            val lengthBins = firstFit.solveForCapacity(lengths)

            if (firstFit.getTotalRestValue() <= minTotalRest) {
                minTotalRest = firstFit.getTotalRestValue()
                bestLengthBins = lengthBins
            }
        }

        return Result(minTotalRest, bestLengthBins)
    }

    /**
     * Getter for the total rest property
     */
    private fun getTotalRestValue(): Int {
        return this.totalRest
    }
}