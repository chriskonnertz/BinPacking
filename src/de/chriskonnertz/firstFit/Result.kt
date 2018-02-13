package de.chriskonnertz.firstFit

/**
 * This is a container object for the result of the bin packaging algorithm.
 */
class Result(val minEvalValue: Int, val bestLengthBins: ArrayList<Bin>) {
    /** Prints out information about the bin */
    fun print() {
        println("Optimization done.")
        println("Result:")

        if (bestLengthBins.isNotEmpty()) {
            println("Best length: " + bestLengthBins.first().capacity +
                    " - Used bins: " + bestLengthBins.size +
                    " - Evaluation value: " + minEvalValue)
            printBinsAndParts()
        } else {
            println("No result available. Add at least one available length that is greater than all lengths (parts).")
        }
    }

    /** Prints out ("visualises") the bins and their parts */
    fun printBinsAndParts() {
        for ((index, bin: Bin) in bestLengthBins.withIndex()) {
            println((index + 1).toString() + ". Bin" +
                    " - Parts: " + bin.getAllParts() +
                    " - Unused space: " + bin.getRestLength())
        }
    }
}