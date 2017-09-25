<%
option explicit:
Response.ContentType = "application/json; charset=utf-8"
with Server.CreateObject("Nasp")
	.Name = Request.ServerVariables("URL"):
	.AddScript Me:
	.TemplateFolder = Server.MapPath("../template/"):
	.Template = "Test2.json":
	.Process():
end with

public _
function OnDraw_Json(oMain, vParam)
	dim size: size = Request.QueryString("size"):
	dim i: i = 1:
	do until i > CInt(size)
		if(i = 1) then
			oMain.View("comma") = "":
		else
			oMain.View("comma") = ",":
		end if
		oMain.View("key") = "key" & i:
		oMain.View("value") = "value" & i:
		oMain.ProcessTemplate vParam(0):
		i = i + 1:
	loop
end function
%>
