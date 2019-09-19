package com.cafex

import org.specs2.mutable.Specification

class TotalAmountSpec extends Specification {

  val menu: Seq[MenuItem] = Menu.getMenu

  "Total Amount" should {
    "give a valid amount for an order" in {
      val order = menu.drop(2)

      CafeXService.totalAmount(order) must be equalTo 6.5.toFloat
    }

    "give a valid amount for an order of drinks" in {
      val order = menu.filter(_.productType == "drink")

      CafeXService.totalAmount(order) must be equalTo 1.5.toFloat
    }

    "give a valid amount for hot menu items" in {
      val order = menu.filter(_.serveType == "hot")

      CafeXService.totalAmount(order) must be equalTo 5.5.toFloat
    }
  }
}
