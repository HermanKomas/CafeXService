package com.cafex

import org.specs2.mutable.Specification

class ServiceChargeSpec extends Specification {

  val menu: Seq[MenuItem] = Menu.getMenu

  "Service Charge" should {
    "give zero when order only drinks" in {
      val order = menu.filter(_.productType == "drinks")

      CafeXService.serviceCharge(order) must be equalTo 0
    }

    "give 10 percent when any food" in {
      val order = Seq(menu(1), menu(2))

      CafeXService.serviceCharge(order) must
        be equalTo CafeXService.totalAmount(order) * 0.1.toFloat
    }

    "give 20 perecent when any hot food" in {
      val order = menu
        .filter(_.productType == "food")
        .filter(_.productType == "hot")

      CafeXService.serviceCharge(order) must
        be equalTo CafeXService.totalAmount(order) * 0.2.toFloat
    }

    "give max amount of £20" in {
      val order = Seq(
        menu(3), menu(3), menu(3), menu(3), menu(3), menu(3),
        menu(3), menu(3), menu(3), menu(3), menu(3), menu(3),
        menu(3), menu(3), menu(3), menu(3), menu(3), menu(3),
        menu(3), menu(3), menu(3), menu(3), menu(3), menu(3),
        menu(3), menu(3), menu(3), menu(3), menu(3), menu(3)
      )

      println(CafeXService.totalAmount(order))

      CafeXService.serviceCharge(order) must be equalTo 20
    }

  }
}
