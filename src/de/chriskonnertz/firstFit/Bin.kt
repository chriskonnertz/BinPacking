package de.chriskonnertz.firstFit

/**
 * This class represents a container for the parts
 */
class Bin(val capacity: Int) {
    /** Array list with the parts that are in the bin */
    private var parts: ArrayList<Int> = arrayListOf()
    /** Size of the unused space */
    private var rest: Int = capacity

    /** Add a part to the container */
    fun addPart(part: Int) {
        if (part > rest) {
            throw Exception("Cannot add part that is larger than the remaining space")
        }

        parts.add(part)
        rest -= part
    }

    /** Returns the free space */
    fun getFreeSpace(): Int {
        return rest
    }

    /** Getter for the parts property */
    fun getAllParts(): ArrayList<Int> {
        return parts
    }
}