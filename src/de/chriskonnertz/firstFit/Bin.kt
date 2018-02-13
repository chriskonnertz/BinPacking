package de.chriskonnertz.firstFit

class Bin(val capacity: Int) {
    private var parts: ArrayList<Int> = arrayListOf()
    private var rest: Int = capacity

    fun addPart(part: Int) {
        parts.add(part)
        rest -= part
    }

    fun getRestLength(): Int {
        return rest
    }
}