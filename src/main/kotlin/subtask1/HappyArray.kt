package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        var happyList = sadArray.toMutableList()
        var intermediate: MutableList<Int> = mutableListOf()

        for (i in 0..happyList.size - 1) {
            if (i == 0 || i == happyList.size - 1 || (happyList[i - 1] + happyList[i + 1]) > happyList[i]) intermediate.add(
                happyList[i]
            )
        }

        while(happyList != intermediate) {
            happyList = intermediate
            intermediate = mutableListOf()
            for (i in 0..happyList.size - 1) {
                if (i == 0 || i == happyList.size - 1 || (happyList[i - 1] + happyList[i + 1]) > happyList[i]) {
                        intermediate.add(
                        happyList[i]
                    )
                }
            }
        }
        return happyList.toIntArray()

    }

}
