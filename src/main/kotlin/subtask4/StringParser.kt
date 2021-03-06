package subtask4

import java.util.*

class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        var simple = Stack<StringBuilder>()
        var triangle = Stack<StringBuilder>()
        var square = Stack<StringBuilder>()
        val output = mutableListOf<String>()
        var count = 0
        val map = hashMapOf<Int, StringBuilder>()
        for(c in inputString) {
            when(c) {
                '(' -> {
                    updateStacks(simple, triangle, square, c)
                    val builder = StringBuilder()
                    simple.push(builder)
                    map.put(count++, builder)
                }
                '<' -> {
                    updateStacks(simple, triangle, square, c)
                    val builder = StringBuilder()
                    triangle.push(builder)
                    map.put(count++, builder)
                }
                '[' -> {
                    updateStacks(simple, triangle, square, c)
                    val builder = StringBuilder()
                    square.push(builder)
                    map.put(count++, builder)
                }
                ')' -> {
                    if(!simple.empty()) output.add(simple.pop().toString())
                    updateStacks(simple, triangle, square, c)
                }
                '>' -> {
                    if(!triangle.empty()) output.add(triangle.pop().toString())
                    updateStacks(simple, triangle, square, c)
                }
                ']' -> {
                    if(!square.empty()) output.add((square.pop().toString()))
                    updateStacks(simple, triangle, square, c)
                }
                else -> updateStacks(simple, triangle, square, c)
            }

        }

        val outputArray = mutableListOf<String>()
        for(i in 0..map.size - 1) outputArray.add(map[i].toString())
        return outputArray.toTypedArray()
        // return output.toTypedArray()
    }

    private fun updateStacks(simple: Stack<StringBuilder>, triangle: Stack<StringBuilder>, square: Stack<StringBuilder>, c: Char) {
        for(s in simple) s.append(c)
        for(t in triangle) t.append(c)
        for(q in square) q.append(c)
    }
}
