
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object welcome_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class welcome extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String, style: String = "scala"):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.44*/(""" 

"""),_display_(/*3.2*/defining(play.core.PlayVersion.current)/*3.41*/ { version =>_display_(Seq[Any](format.raw/*3.54*/("""

"""),format.raw/*5.1*/("""<link rel="stylesheet" media="screen" href="/@documentation/resources/style/main.css">

<section id="top">
  <div class="wrapper">
    <h1><a href="https://playframework.com/documentation/"""),_display_(/*9.59*/version),format.raw/*9.66*/("""/Home">"""),_display_(/*9.74*/message),format.raw/*9.81*/("""</a></h1>
  </div>
</section>

<div id="content" class="wrapper doc">
<article>

  <h1>Welcome to Play</h1>

  <p>
    Congratulations, you’ve just created a new Play application. This page will help you with the next few steps.
  </p>

  <blockquote>
    <p>
      You’re using Play """),_display_(/*24.26*/version),format.raw/*24.33*/("""
    """),format.raw/*25.5*/("""</p>
  </blockquote>

  <h2>Why do you see this page?</h2>

    <p>
      The <code>conf/routes</code> file defines a route that tells Play to invoke the <code>HomeController.index</code> action
      whenever a browser requests the <code>/</code> URI using the GET method:
    </p>

    <pre><code># Home page
GET     /               controllers.HomeController.index</code></pre>

    <p>
      Play has invoked the <code>controllers.HomeController.index</code> method to obtain the <code>Action</code> to execute:
    </p>

    <pre><code>def index = Action """),format.raw/*42.35*/("""{"""),format.raw/*42.36*/(""" """),format.raw/*42.37*/("""implicit request: Request[AnyContent] =>
  Ok(views.html.index("Your new application is ready!"))
"""),format.raw/*44.1*/("""}"""),format.raw/*44.2*/("""</code></pre>

    <p>
      An action is a function that handles the incoming HTTP request, and returns the HTTP result to send back to the web client.
      Here we send a <code>200 OK</code> response, using a template to fill its content.
    </p>

    <p>
      The template is defined in the <code>app/views/index.scala.html</code> file and compiled as a Scala function.
    </p>

    <pre><code>@(message: String)

@main("Welcome to Play") """),format.raw/*57.27*/("""{"""),format.raw/*57.28*/("""

    """),format.raw/*59.5*/("""@welcome(message)

"""),format.raw/*61.1*/("""}"""),format.raw/*61.2*/("""</code></pre>

    <p>
      The first line of the template defines the function signature. Here it just takes a single <code>String</code> parameter.
      This template then calls another function defined in <code>app/views/main.scala.html</code>, which displays the HTML
      layout, and another function that displays this welcome message. You can freely add any HTML fragment mixed with Scala
      code in this file.
    </p>

    <p>You can read more about <a href="https://www.playframework.com/documentation/"""),_display_(/*70.86*/version),format.raw/*70.93*/("""/ScalaTemplates">Twirl</a>, the template language used by Play, and how Play handles <a href="https://www.playframework.com/documentation/"""),_display_(/*70.232*/version),format.raw/*70.239*/("""/ScalaActions">actions</a>.</p>

    <h2>Async Controller</h2>

    Now that you've seen how Play renders a page, take a look at <code>AsyncController.scala</code>, which shows how to do asynchronous programming when handling a request.  The code is almost exactly the same as <code>HomeController.scala</code>, but instead of returning <code>Result</code>, the action returns <code>Future[Result]</code> to Play.  When the execution completes, Play can use a thread to render the result without blocking the thread in the mean time.

    <p>
        <a href=""""),_display_(/*77.19*/routes/*77.25*/.AsyncController.message),format.raw/*77.49*/("""">Click here for the AsyncController action!</a>
    </p>

    <p>
        You can read more about <a href="https://www.playframework.com/documentation/"""),_display_(/*81.87*/version),format.raw/*81.94*/("""/ScalaAsync">asynchronous actions</a> in the documentation.
    </p>

    <h2>Count Controller</h2>

    <p>
        Both the HomeController and AsyncController are very simple, and typically controllers present the results of the interaction of several services.  As an example, see the <code>CountController</code>, which shows how to inject a component into a controller and use the component when handling requests.  The count controller increments every time you click on it, so keep clicking to see the numbers go up.
    </p>

    <p>
        <a href=""""),_display_(/*91.19*/routes/*91.25*/.CountController.count),format.raw/*91.47*/("""">Click here for the CountController action!</a>
    </p>

    <p>
        You can read more about <a href="https://www.playframework.com/documentation/"""),_display_(/*95.87*/version),format.raw/*95.94*/("""/ScalaDependencyInjection">dependency injection</a> in the documentation.
    </p>

    <h2>Need more info on the console?</h2>

  <p>
    For more information on the various commands you can run on Play, i.e. running tests and packaging applications for production, see <a href="https://playframework.com/documentation/"""),_display_(/*101.187*/version),format.raw/*101.194*/("""/PlayConsole">Using the Play console</a>.
  </p>  

  <h2>Need to set up an IDE?</h2>

  <p>
      You can start hacking your application right now using any text editor. Any changes will be automatically reloaded at each page refresh, 
      including modifications made to Scala source files.
  </p>

  <p>
      If you want to set-up your application in <strong>IntelliJ IDEA</strong> or any other Java IDE, check the 
      <a href="https://www.playframework.com/documentation/"""),_display_(/*113.61*/version),format.raw/*113.68*/("""/IDE">Setting up your preferred IDE</a> page.
  </p>

  <h2>Need more documentation?</h2>

  <p>
    Play documentation is available at <a href="https://www.playframework.com/documentation/"""),_display_(/*119.94*/version),format.raw/*119.101*/("""">https://www.playframework.com/documentation</a>.
  </p>

  <p>
    Play comes with lots of example templates showcasing various bits of Play functionality at <a href="https://www.playframework.com/download#examples">https://www.playframework.com/download#examples</a>.
  </p>

  <h2>Need more help?</h2>

  <p>
    Play questions are asked and answered on Stackoverflow using the "playframework" tag: <a href="https://stackoverflow.com/questions/tagged/playframework">https://stackoverflow.com/questions/tagged/playframework</a>
  </p>

  <p>
    The <a href="http://groups.google.com/group/play-framework">Play Google Group</a> is where Play users come to seek help,
    announce projects, and discuss issues and new features. If you don’t have a Google account, you can still join the mailing
    list by sending an e-mail to
    <strong>play-framework+subscribe@googlegroups.com</strong>.
  </p>

  <p>
    Gitter is a real time chat channel, like IRC. The <a href="https://gitter.im/playframework/playframework">playframework/playframework</a>  channel is used by Play users to discuss the ins and outs of writing great Play applications.
  </p>
 
</article>

<aside>
  <h3>Browse</h3>
  <ul>
    <li><a href="https://playframework.com/documentation/"""),_display_(/*148.59*/version),format.raw/*148.66*/("""">Documentation</a></li>
    <li><a href="https://playframework.com/documentation/"""),_display_(/*149.59*/version),format.raw/*149.66*/("""/api/"""),_display_(/*149.72*/style),format.raw/*149.77*/("""/index.html">Browse the """),_display_(/*149.102*/{style.capitalize}),format.raw/*149.120*/(""" """),format.raw/*149.121*/("""API</a></li>
  </ul>
  <h3>Start here</h3>
  <ul>
    <li><a href="https://playframework.com/documentation/"""),_display_(/*153.59*/version),format.raw/*153.66*/("""/PlayConsole">Using the Play console</a></li>
    <li><a href="https://playframework.com/documentation/"""),_display_(/*154.59*/version),format.raw/*154.66*/("""/IDE">Setting up your preferred IDE</a></li>
    <li><a href="https://playframework.com/download#examples">Example Projects</a>
  </ul>
  <h3>Help here</h3>
  <ul>
    <li><a href="https://stackoverflow.com/questions/tagged/playframework">Stack Overflow</a></li>
    <li><a href="http://groups.google.com/group/play-framework">Mailing List</a></li>
    <li><a href="https://gitter.im/playframework/playframework">Gitter Channel</a></li>
  </ul>
  
</aside>

</div>
""")))}))
      }
    }
  }

  def render(message:String,style:String): play.twirl.api.HtmlFormat.Appendable = apply(message,style)

  def f:((String,String) => play.twirl.api.HtmlFormat.Appendable) = (message,style) => apply(message,style)

  def ref: this.type = this

}


}

/**/
object welcome extends welcome_Scope0.welcome
              /*
                  -- GENERATED --
                  DATE: Tue Feb 20 22:09:46 EST 2018
                  SOURCE: /Users/eshan.tandon/IdeaProjects/play-scala-starter-example-2.5.x/app/views/welcome.scala.html
                  HASH: 7aa321be921779288e09cdbbe2ed5ba757e3eb25
                  MATRIX: 538->1|675->43|704->47|751->86|801->99|829->101|1044->291|1071->298|1105->306|1132->313|1444->598|1472->605|1504->610|2092->1170|2121->1171|2150->1172|2275->1270|2303->1271|2777->1719|2806->1720|2839->1726|2885->1746|2913->1747|3459->2266|3487->2273|3654->2412|3683->2419|4271->2980|4286->2986|4331->3010|4511->3163|4539->3170|5126->3730|5141->3736|5184->3758|5364->3911|5392->3918|5742->4239|5772->4246|6282->4728|6311->4735|6529->4925|6559->4932|7844->6190|7873->6197|7984->6280|8013->6287|8047->6293|8074->6298|8128->6323|8169->6341|8200->6342|8336->6450|8365->6457|8497->6561|8526->6568
                  LINES: 20->1|25->1|27->3|27->3|27->3|29->5|33->9|33->9|33->9|33->9|48->24|48->24|49->25|66->42|66->42|66->42|68->44|68->44|81->57|81->57|83->59|85->61|85->61|94->70|94->70|94->70|94->70|101->77|101->77|101->77|105->81|105->81|115->91|115->91|115->91|119->95|119->95|125->101|125->101|137->113|137->113|143->119|143->119|172->148|172->148|173->149|173->149|173->149|173->149|173->149|173->149|173->149|177->153|177->153|178->154|178->154
                  -- GENERATED --
              */
          