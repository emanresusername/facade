package my.will.be.done.d3

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

sealed abstract class Spiral(val name: String)

object Spiral {
  case object Archimedean extends Spiral("archimedean")
  case object Rectangular extends Spiral("rectangular")
}

@js.native
@JSImport("d3-cloud", JSImport.Namespace)
class CloudLayout extends js.Object {
  def start(): this.type                                       = js.native
  def stop(): this.type                                        = js.native
  def timeInterval(millis: Long): this.type                    = js.native
  def words(): js.Array[WordCount]                             = js.native
  def words(wordCounts: js.Array[WordCount]): this.type        = js.native
  def size(dimensions: js.Array[Int]): this.type               = js.native
  def font(name: String): this.type                            = js.native
  def rotate(fn: js.Function0[Int]): this.type                 = js.native
  def fontSize(fn: js.Function1[WordCount, Double]): this.type = js.native
  def padding(pixels: Int): this.type                          = js.native
  def on[D <: js.Object](event: String,
                         callback: js.Function1[D, Unit]): this.type =
    js.native
  def spiral(spiral: String): this.type = js.native
  // TODO: everything below here
  def fontStyle: this.type  = js.native
  def fontWeight: this.type = js.native
  def canvas: this.type     = js.native
  def random: this.type     = js.native
  def text: this.type       = js.native
}
