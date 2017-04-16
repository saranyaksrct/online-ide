<%@page language="java" session="true" contentType="text/html; charset=ISO-8859-1"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    
<meta name="viewport" content="width=device-width, initial-scale=1">
    
<!-- The above 3 meta tags *must* come first in the head; any other head content must come 

*after* these tags -->
    
<title>
compiler
</title>
<!-- style -->
<style type="text/css">
  
	#editor { 
        
    width: 600px;
    height: 480px;
	}
	textarea{
	border: 5px solid #C5E2FF;}

h3 {
color:  black;
 font-weight:bold;
}
img{
position: absolute;
top:10px;
right:80px;}
div.heading { text-align:center;
              color:white;
              font-size:20pt;
              font-weight:bold;
              font-family:geneva;
              color:  white;
              text-shadow: 1px 1px 0 rgb(77,162,252) , -1px -1px 0 rgb(77,162,252) , 1px -1px 0 rgb(77,162,252) , -1px 1px 0 rgb(77,162,252) , 4px 4px 8px rgb(44,88,137) , -4px 4px 8px rgb(44,88,137) , 4px -4px 8px rgb(44,88,137) , -4px -4px 8px rgb(44,88,137) ;
            }
.hide{
  visibility:hidden;}
  body{
  background-image: url("1.jpg");
  background-repeat: repeat;}
}

</style>
<!-- sources -->
<script src="ace.js" type="text/javascript" charset="utf-8"></script>


<script src="ext-language_tools.js"></script>
  

<script src="theme-crimson_editor.js" type="text/javascript" 

charset="utf-8"></script>

<script src="mode-c_cpp.js" type="text/javascript" 

charset="utf-8"></script>
<script src="mode-java.js" type="text/javascript" 

charset="utf-8"></script>
<script src="mode-csharp.js" type="text/javascript" 

charset="utf-8"></script>
<!-- editor loading function -->
<script type="text/javascript">
   
window.onload = function() {
ace.require("ace/ext/language_tools");
var editor = ace.edit("editor");
editor.setTheme("ace/theme/crimson_editor");   
editor.getSession().setMode("ace/mode/c_cpp");
editor.setOptions({      
enableBasicAutocompletion: true,
enableSnippets: true,
enableLiveAutocompletion: true
        });
editor.getSession().setValue(document.getElementById("hide").value);
};

function saveTextAsFile()
{
var editor=ace.edit("editor");
document.getElementById("hide").value=editor.getSession().getValue();
}

function cng(sel1)
{
	alert("entered");
var sel=sel1;
var editor=ace.edit("editor");
editor.getSession().setValue("");
if((sel==="C") || (sel==="C++"))
editor.getSession().setMode("ace/mode/c_cpp");
else if(sel==="JAVA")
editor.getSession().setMode("ace/mode/java");
else if(sel==="C#")
editor.getSession().setMode("ace/mode/csharp");
document.getElementById("tx2").value="";
document.getElementById("tx3").value="";
}
	
</script>

</head>

<body bgcolor= #D2E9FF>
<div class=heading>COMPILE AND RUN THE CODE  
</div>
<a href="home.html"><img src="logout.png" height="30" width="40"/></a>
<%String hide=(String) request.getAttribute("hide");
String tx2=(String) request.getAttribute("tx2");
String output=(String) request.getAttribute("output");%>

<form name="myForm" action="servlet3" method="post" onSubmit="saveTextAsFile();">
&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
<select onchange=cng(this.value) name="language"  id="language">
<option value="C" selected="selected">C</option>
<option value="C++">C++</option>
<option value="C#">C#</option>
<option value="JAVA">JAVA</option>
</select>
&nbsp &nbsp
<label><b>Filename:</b></label>&nbsp<input type="text" id="filename" name="filename">
<table width="100%">
<tr>
<td rowspan="2" colspan="2">
<center>
<div id="editor"></div>
</center>
</td>
<td valign="top">
<h3>Input:</h3>
<textarea cols="60" rows="10" name="tx2" id="tx2">
<%if(tx2!=null)
	out.print(tx2);%>
</textarea>
</td>
</tr>
<tr>
<td valign="bottom">
<h3>Output:</h3>
<textarea cols="60" rows="12" name="tx3" id="tx3" >
<%if(output!=null)
	out.print(output);%>
</textarea>
</td>
</tr>
<tr>
<td valign="top">
&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
<input type="submit" value="compile" name="action">
<input type="submit" value="run" name="action">
<textarea class="hide" name="hide" id="hide">
<%if(hide!=null)
	out.print(hide);%>
</textarea>
</td>
</tr>
</table>
</form>
<% 
	    String lang="C";
        if(request.getParameter("language") != null)
        	 lang=request.getParameter("language").toString();
        String file="example";
        if(request.getParameter("filename") != null)
       	 file=request.getParameter("filename").toString();
        %>
        <script>
        document.getElementById("language").value = '<% out.print(lang); %>';
        document.getElementById("language").value = '<% out.print(file); %>';
        </script>
</body>
</html>
