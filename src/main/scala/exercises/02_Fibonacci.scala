package exercises

object Fibonacci {
  
  /**
   * Implement the classic Fibonacci sequence, where
   *    fib(1) = 1
   *    fib(2) = 1
   *    fib(n) = fib(n-1) + fib(n-2)
   */
  def fib(n: Int): Int = {
    if (n < 3) 1 else (fib(n-1) + fib(n-2))
  }
}
