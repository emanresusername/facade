package my.will.be.done.js

import my.will.be.done.js.facade.FileSaver
import org.scalajs.dom.raw.{Node, XMLSerializer, Blob, BlobPropertyBag}
import scala.scalajs.js

object NodeSaver {
  def apply(node: Node, name: js.UndefOr[String], `type`: js.UndefOr[String]) = {
    val xmlSerializer = new XMLSerializer()
    val svgString     = xmlSerializer.serializeToString(node)
    val blob          = new Blob(js.Array(svgString), BlobPropertyBag(`type`))
    FileSaver.saveAs(blob, name)
  }
}
