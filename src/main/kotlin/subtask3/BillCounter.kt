package subtask3

class BillCounter {

    // TODO: Complete the following function
    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        var total = 0
        var correct = 0
        for( index in 0..bill.size - 1) {
            if(index != k) {
                correct += bill[index]
            }
            total += bill[index]
        }
        if(correct/2 == b) return "Bon Appetit"
        else return (b - correct / 2).toString()
    }
}
