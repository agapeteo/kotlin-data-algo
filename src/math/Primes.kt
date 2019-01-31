package math

class Primes {
    companion object {
        fun isPrime(n: Int): Boolean {
            val nSqr = Math.sqrt(n.toDouble())
            var i = 2
            while (i <= nSqr) {
                if (n % i == 0) return false
                i++
            }
            return true
        }
    }
}
