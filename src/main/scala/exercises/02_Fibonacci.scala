package exercises

object Fibonacci {
  
  /**
   * Implement the classic Fibonacci sequence, where
   *    fib(1) = 1
   *    fib(2) = 1
   *    fib(n) = fib(n-1) + fib(n-2)
   */
  def fib(n: Int): Int = {
    val base_case = n < 2
    base_case ? 1 : fib(n-1) + fib(n-2)
  }
}
