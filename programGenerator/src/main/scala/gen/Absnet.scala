package org.emergentorder.onnx

import org.emergentorder.onnx.backends._
import org.emergentorder.union._
import scala.reflect.ClassTag
import spire.implicits._
import spire.math.UByte
import spire.math.UShort
import spire.math.Complex
import spire.math.Numeric

class Absnet() {
  val Abs: AbsV6 = new NGraphOperatorBackendFull()
  def program(inputDatax: Tensor[Float]): List[Tuple1[Tensor[Float]]] =
    for {
      nodex <- List(inputDatax)
      nodey <- List(Abs.AbsV6("y", X = nodex))
    } yield (nodey)
}
