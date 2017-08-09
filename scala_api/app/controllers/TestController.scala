package controllers

import javax.inject.{Inject, Singleton}

import play.api.libs.json._
import play.api.mvc.{Action, AnyContent, Controller}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

@Singleton
class TestController @Inject() extends Controller {

  def index = Action {
    Ok(Json.obj("result" -> "すいようのどようのうしのひ"))
      .as("application/json; charset=utf-8")
  }

  def indexByAsync: Action[AnyContent] = Action.async {
    Future {
      Ok(Json.obj("result" -> "すいようのどようのうしのひ"))
        .as("application/json; charset=utf-8")
    }
  }

  def test2(size: Int) = Action {
    Ok(createJson(size)).as("application/json; charset=utf-8")
  }

  def test2ByAsync(size: Int): Action[AnyContent] = Action.async {
    Future {
      Ok(createJson(size)).as("application/json; charset=utf-8")
    }
  }

  private def createJson(size: Int): JsObject = {
    val list = (1 to size).map { i =>
      Map(s"key$i" -> s"value$i")
    }
    val json = Json.obj("results" -> list)
    println(s"size $size:${json.toString().getBytes.length} bytes")
    json
  }
}
