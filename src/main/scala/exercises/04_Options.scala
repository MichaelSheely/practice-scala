package exercises

import sys.error

/**
 * In this exercise, we'll practice using `Option`s, which are a nicer
 * alternative to `null`s. (If you're familiar with Haskell's `Maybe`, 
 * that's what we're talking about.)
 * 
 * For more information on `Option`s, see:
 * 	 http://danielwestheide.com/blog/2012/12/19/the-neophytes-guide-to-scala-part-5-the-option-type.html
 * 	 http://blog.originate.com/blog/2014/06/15/idiomatic-scala-your-options-do-not-match/
 * 
 * These exercises are taken from ScalaLabs:
 * 		https://github.com/scala-labs/scala-labs/blob/master/labs/src/main/scala/org/scalalabs/basic/lab03/OptionExercise.scala
 */

object Options {
  /**
   * This map contains sample testdata to clarify this exercise.
   * It contains key value pairs where:
   * - the key is a room number
   * - the value can be:
   * -- the amount of people in the room (filled: Some("10"), empty: None)
   * -- the room is not available (Some("locked"))
   */
  val rooms = Map(1 -> Some("12"), 2 -> None, 3 -> Some("locked"),
                  4 -> Some("14"), 5 -> Some("8"), 6 -> Some("locked"))
  
  /**
   * Implement the room state method that should return the state of a room
   * as a String as follows:
   * - filled: return total people:     E.g: Some("12") is "12"
   * - locked: return "not available"   E.g. Some("locked") is "not available"
   * - empty:  return "empty"	        E.g. None is "empty"
   * - does not exist: 					"not existing"
   */
  def roomState(rooms: Map[Int, Option[String]], room: Int): String = {
    val room_state = rooms.get(room) 
    if (!room_state.isDefined) {
      "not existing"
    } else if (room_state.get == None) {
      "empty"
    } else if (room_state.get.get == "locked") {
      "not available"
    } else {
      room_state.get.get
    }
  }

  /**
   * Given a room number, extracts either:
   *   None (if there are no people in the room)
   *   Some() number of people in the room
   */
  def peopleInRoom(rooms: Map[Int, Option[String]], room: Int): Option[Int] = {
    roomState(rooms, room) match {
      case "not existing" => None
      case "empty" => None
      case "not available" => None
      case x => Some(x.toInt)
    }
  }

  /**
   * Calculate the total amount of people in all rooms
   */
  def totalPeopleInRooms(rooms: Map[Int, Option[String]]): Int = {
    //rooms.keys.map(roomNumToOccupancy(rooms, _: Int)).foldLeft(0)(_ + _)
    rooms.keys.map(peopleInRoom(rooms, _: Int).getOrElse(0)).foldLeft(0)(_ + _)
  }
}
