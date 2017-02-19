package my.will.be.done.js.facade

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("file-saver", JSImport.Namespace)
object FileSaver extends js.Object {
  def saveAs(blobFileData: js.Any,
             filename: js.UndefOr[String] = js.undefined,
             disableAutoBom: js.UndefOr[Boolean] = js.undefined): Unit =
    js.native
}
