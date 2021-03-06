package proscalafx.ch03

import scalafx.beans.property.IntegerProperty
import javafx.beans.binding.Bindings
import scalafx.beans.property.StringProperty

object TriangleAreaFluentExample extends App {
  val x1 = IntegerProperty(0)
  val y1 = IntegerProperty(0)
  val x2 = IntegerProperty(0)
  val y2 = IntegerProperty(0)
  val x3 = IntegerProperty(0)
  val y3 = IntegerProperty(0)

  val area = ((x1 * y2) + (x2 * y3) + (x3 * y1) - (x1 * y3) - (x2 * y1) - (x3 * y2)) / 2.0

  val output = Bindings.format(
    "For A(%d,%d), B(%d,%d), C(%d,%d), the area of triangle ABC is %.1f",
    x1.delegate, y1.delegate, x2.delegate, y2.delegate, x3.delegate, y3.delegate, area.delegate)

  x1() = 0; y1() = 0
  x2() = 6; y2() = 0
  x3() = 4; y3() = 3

  println(output.get)

  x1() = 1; y1() = 0
  x2() = 2; y2() = 2
  x3() = 0; y3() = 1

  println(output.get)
}