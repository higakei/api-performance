package controllers

import javax.inject.{Inject, Singleton}

import play.api.libs.json._
import play.api.mvc.{Action, Controller}

@Singleton
class TestController @Inject() extends Controller {

  def index = Action {
    Ok(Json.obj("result" -> "すいようのどようのうしのひ"))
      .as("application/json; charset=utf-8")
  }
}
