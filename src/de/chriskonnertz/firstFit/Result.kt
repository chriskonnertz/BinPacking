package de.chriskonnertz.firstFit

class Result(val minTotalRest: Int, val bestLengthBins: ArrayList<Bin>) {
    fun print() {
        println("Optimization done.")
        println("Result:")
        if (bestLengthBins.isNotEmpty()) {
            println("Best length: " + bestLengthBins.first().capacity +
                    " - Used bins: " + bestLengthBins.size +
                    " - Total rest: " + minTotalRest)
        } else {
            println("No result available. Add at least one available length.")
        }
    }
}