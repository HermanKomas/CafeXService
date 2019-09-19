package com.cafex

object Menu {
  val getMenu: Seq[MenuItem] =
    Seq(
      MenuItem(1, "Cola", "drink", "cold", 0.5.toFloat),
      MenuItem(2, "Coffee", "drink", "hot", 1),
      MenuItem(3, "Cheese Sandwich", "food", "cold", 2),
      MenuItem(4, "Steak Sandwich", "food", "hot", 4.5.toFloat)
    )
}
