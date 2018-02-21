
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/eshan.tandon/IdeaProjects/play-scala-starter-example-2.5.x/conf/routes
// @DATE:Tue Feb 20 22:09:45 EST 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
