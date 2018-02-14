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
     * It returns an array list wih bins that hold the parts.
     */
    abstract fun solveForCapacity(parts: List<Int>): ArrayList<Bin>

    /**
     * This method uses the concrete algorithm class to execute the optimization
     * for every available bin size (bin capacity)
     * [availableBinCapacities] is an array with the possible bin capacities and
     * [parts] is a list of the parts you want to put into bins.
     */
    fun solve(availableBinCapacities: Array<Int>, parts: List<Int>): Result {
        var firstFit: BinPackingAlgorithm
        var minEvalValue = Int.MAX_VALUE
        var bestBins: ArrayList<Bin> = arrayListOf()

        for (availableBinCapacity: Int in availableBinCapacities) {
            // Ignore any available bin capacity that is not big enough to hold the biggest part
            if (availableBinCapacity < parts.max()!!) {
                continue
            }

            firstFit = createInstance()
            firstFit.binCapacity = availableBinCapacity

            val bins = firstFit.solveForCapacity(parts)

            // Find the available bin capacity that has the smallest evaluation value
            if (firstFit.getEvaluation() <= minEvalValue) {
                minEvalValue = firstFit.getEvaluation()
                bestBins = bins
            }
        }

        return Result(minEvalValue, bestBins)
    }

    /**
     * Returns a value that is used for the evaluation of the result.
     * Smaller values are considered to be preferable.
     */
    protected open fun getEvaluation(): Int {
        // Per default, use the total rest for the evaluation
        return this.totalRest
    }
}
