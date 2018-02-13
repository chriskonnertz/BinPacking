package de.chriskonnertz.firstFit

/**
 * Concrete implementation of the first fit algorithm.
 */
open class FirstFit : BinPackingAlgorithm() {
    override fun createInstance(): BinPackingAlgorithm {
        return FirstFit()
    }

    override fun solveForCapacity(lengths: List<Int>): ArrayList<Bin> {
        if (binCapacity <= 0) {
            throw Exception("The bin capacity cannot be less than 1")
        }
        if (lengths.isEmpty()) {
            throw Exception("The lengths parameter has to have at least one item")
        }

        val bins: ArrayList<Bin> = arrayListOf()

        for (length in lengths) {
            if (length > binCapacity) {
                throw Exception("The length cannot be greater than the bin capacity")
            }

            var found = false

            // Try to put the length (part) in an existing bin, if it has enough space left
            for (bin in bins) {
                if (length <= bin.getRestLength()) {
                    bin.addPart(length)
                    found = true
                    break
                }
            }

            // If there was not a bin with enough space, create a new bin
            if (!found) {
                val bin = Bin(binCapacity)
                bin.addPart(length)
                bins.add(bin)
            }
        }

        // Calculate the total rest length (unused space) of all bins
        bins.onEach { totalRest += it.getRestLength() }

        return bins
    }
}