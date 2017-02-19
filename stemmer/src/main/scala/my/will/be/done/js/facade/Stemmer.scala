package my.will.be.done.js.facade

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("stemmer", JSImport.Namespace)
object Stemmer extends js.Object {
  def apply(word: String): String = js.native
}
