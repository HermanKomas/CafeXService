package com.cafex

object CafeXService {

  val menu: Seq[MenuItem] = Menu.getMenu

  def totalAmount(order: Seq[MenuItem]): Float = order.map(_.price).sum

  def serviceCharge(order: Seq[MenuItem]): Float = order.map(_.productType) match {
    case _ if !order.exists(_.productType != "drink") => // only drinks
      0.toFloat
    case _ if order.exists{o => o.productType == "food" && o.serveType == "hot"} => // some hot food
      totalAmount(order) match {
        case p if p <= 20.toFloat => (p * 0.2).toFloat
        case p if p > 20.toFloat => 20.toFloat
      }
    case _ if order.exists(_.productType != "drink") => // some food
      (totalAmount(order) * 0.1).toFloat
  }
}