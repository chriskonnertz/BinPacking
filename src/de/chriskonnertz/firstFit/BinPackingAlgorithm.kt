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
        var minEvalValue = Int.MAX_VALUE
        var bestLengthBins: ArrayList<Bin> = arrayListOf()

        for (availableLength: Int in availableLengths) {
            // Ignore lengths that are longer than the available length (= the bin capacity)
            if (availableLength < lengths.max()!!) {
                continue
            }

            firstFit = createInstance()
            firstFit.binCapacity = availableLength

            val lengthBins = firstFit.solveForCapacity(lengths)

            // Find the available length that has the smallest evaluation value
            if (firstFit.getEvaluation() <= minEvalValue) {
                minEvalValue = firstFit.getEvaluation()
                bestLengthBins = lengthBins
            }
        }

        return Result(minEvalValue, bestLengthBins)
    }

    /**
     * Returns a value that is used for the evaluation of the result.
     * Smaller value are considered to be preferable.
     */
    protected open fun getEvaluation(): Int {
        // Per default, use the total rest for the evaluation
        return this.totalRest
    }
}