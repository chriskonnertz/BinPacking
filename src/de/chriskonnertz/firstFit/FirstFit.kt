package de.chriskonnertz.firstFit

/**
 * Concrete implementation of the first fit algorithm.
 */
open class FirstFit : BinPackingAlgorithm() {
    override fun createInstance(): BinPackingAlgorithm {
        return FirstFit()
    }

    override fun solveForCapacity(parts: List<Int>): ArrayList<Bin> {
        if (binCapacity <= 0) {
            throw Exception("The bin capacity cannot be less than 1")
        }
        if (parts.isEmpty()) {
            throw Exception("The parts parameter has to have at least one item")
        }

        val bins: ArrayList<Bin> = arrayListOf()

        for (part in parts) {
            if (part > binCapacity) {
                throw Exception("The part cannot be greater than the bin capacity")
            }

            var found = false

            // Try to put the part in an existing bin, if it has enough space left
            for (bin in bins) {
                if (part <= bin.getFreeSpace()) {
                    bin.addPart(part)
                    found = true
                    break
                }
            }

            // If there was not a bin with enough space, create a new bin
            if (!found) {
                val bin = Bin(binCapacity)
                bin.addPart(part)
                bins.add(bin)
            }
        }

        // Calculate the total rest (unused space) of all bins
        bins.onEach { totalRest += it.getFreeSpace() }

        return bins
    }
}