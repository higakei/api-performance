<%
option explicit:
Response.ContentType = "application/json; charset=utf-8"
with Server.CreateObject("Nasp")
	.Name = Request.ServerVariables("URL"):
	
	.AddScript Me:
	
	.TemplateFolder = Server.MapPath("../template/"):
	.Template = "Test.json":
	.Process():
end with



public _
function OnDraw_Json(oMain, vParam)
	dim json:
	json = "{""result"":""すいようのどようのうしのひ""}":
	oMain.View("result") = json:
	oMain.ProcessTemplate vParam(0):
end function
%>
