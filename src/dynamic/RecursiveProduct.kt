package dynamic



object RecursiveProduct {



    fun productOf2(a: Int, b: Int): Int {
        TODO("move to recursive package")

        if (a == 1) return b

        val prev = productOf2(a - 1, b)

        return prev + b
    }
}