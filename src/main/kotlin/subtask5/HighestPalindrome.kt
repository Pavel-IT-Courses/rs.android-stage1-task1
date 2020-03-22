package subtask5

import java.lang.IllegalArgumentException

class HighestPalindrome {

    // TODO: Complete the following function
    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        var wrong = 0
        var left = k
        for(i in 0..(n - 1) / 2) {

            if(digitString[i] != digitString[n - 1 - i]) {
                ++wrong
            }
        }

        if(wrong > k) return "-1"
        val output = charArrayOf(*digitString.toCharArray())
        if((k - wrong) < 1) {
            for(i in 0..(n - 1) / 2) {
                if(digitString[i] != digitString[n - 1 - i]) {
                    val f = Integer.parseInt(digitString[i].toString())
                    val s = Integer.parseInt(digitString[n - 1 - i].toString())
                    if(f > s) {
                        output[i] = digitString[i]
                        output[n - 1 - i] = digitString[i]
                        println(output[n - 1 - i])
                    }
                    else {
                        output[i] = digitString[n - 1 - i]
                        output[n - 1 - i] = digitString[n - 1 - i]
                    }
                    left = left - 2
                }
            }
            if(n % 2 == 1) output[n / 2] = digitString[n / 2]
            val builder = StringBuilder()
            for(c in output) builder.append(c)
            return builder.toString()
        }
        else if(output.all{
                it == '9'
            }) {
            val builder = StringBuilder()
            for(c in output) builder.append(c)
            return builder.toString()
        }
        else {
            output[0] = '9'
            output[n - 1] = '9'
            left = left - 2
            for(i in 1..n-2) output[i] == digitString[i]
            val builder = StringBuilder()
            for(c in output) builder.append(c)
            println(" " + n + " " + left + " " + builder.toString())
            return highestValuePalindrome(n, left, builder.toString())
        }
        return "-1"
    }
}
