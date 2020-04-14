package org.emergentorder.onnx

import scala.reflect.ClassTag
import spire.math.Numeric
import org.emergentorder.onnx._

class ONNXBytesDataSource(onnxBytes: Array[Byte]) extends AutoCloseable with DataSource {

  val onnxHelper = new ONNXHelper(onnxBytes)

  override def getParams[T: Numeric: ClassTag](name: String): Tensor[T] = {
    val params = onnxHelper.params.filter(x => x._1 == name).headOption
    params match {
      case Some(x) => TensorFactory.getTensor(x._3.asInstanceOf[Array[T]], x._4)
      case None =>
        throw new Exception("No params found for param name: " + name)
    }
  }

  override def close(): Unit = {

//    onnxHelper.close

  }

}
