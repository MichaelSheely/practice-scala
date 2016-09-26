package exercises

object Palindrome {
  /**
   * Returns a set of the alphabetic characters
   */
  val alphaChars : Set[Char] = (('a' to 'z') ++ ('A' to 'Z')).toSet
  /**
   * Returns true iff char is alphabetic
   */
  def isAlpha(char: Char): Boolean = {
    alphaChars contains char
  }
  /** 
   *  True if the string is a palindrome, after removing all non-alphabetic 
   *  characters (e.g., spaces, numbers, and punctuation).
   *  
   *  Hint: the Scala collections API is your friend
   *  http://docs.scala-lang.org/overviews/collections/overview.html 
   */
  def isPalindrome(s: String): Boolean = {
    val alpha_chars = s.toLowerCase.toList.filter(isAlpha)
    val reversal = alpha_chars.reverse
    alpha_chars == reversal
  }

}
