package de.chriskonnertz.firstFit

/**
 * This is a container object for the result of the bin packaging algorithm.
 */
class Result(val minEvalValue: Int, val bestBins: ArrayList<Bin>) {
    /** Prints out information about the bin */
    fun print() {
        println("Optimization done.")
        println("Result:")

        if (bestBins.isNotEmpty()) {
            println("Best bin capacity: " + bestBins.first().capacity +
                    " - Used bins: " + bestBins.size +
                    " - Evaluation value: " + minEvalValue)
            printBins()
        } else {
            println("No result available. Add at least one available bin capacity that is greater than all parts.")
        }
    }

    /** Prints out ("visualises") the bins and their parts */
    fun printBins() {
        for ((index, bin: Bin) in bestBins.withIndex()) {
            println((index + 1).toString() + ". Bin" +
                    " - Unused space: " + bin.getFreeSpace() +
                    " - Parts: " + bin.getAllParts())
        }
    }
}