
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Untitled Page</title>
<style type="text/css">
  
	#editor { 
        
    width: 550px;
    height: 425px;
	}


div.heading { text-align:center;
              color:#8bc6eb;
              font-size:25pt;
              font-weight:bold;
              font-family:geneva;
            }

</style>

<script src="ace.js" type="text/javascript" charset="utf-8"></script>


<script src="ext-language_tools.js"></script>
  

<script src="theme-crimson_editor.js" type="text/javascript" charset="utf-8"></script>

<script src="mode-java.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript">

   
window.onload = function() {
ace.require("ace/ext/language_tools");
var editor = ace.edit("editor");
editor.setTheme("ace/theme/crimson_editor");
    
editor.getSession().setMode("ace/mode/java");
editor.setOptions({
            
enableBasicAutocompletion: true,
            
enableSnippets: true,
            
enableLiveAutocompletion: true
        });
    
};

function saveTextAsFile()
{
var editor=ace.edit("editor");
document.getElementById("hide").value=editor.getSession().getValue();
}




</script>

</head>
<body  bgcolor=#8ec5ad >
<form name="Form1" method="post" action="execute" >


&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
<select name="language"  value=s id="language">
<option value="C">C</option>
<option value="C++">C++</option>
<option value="C#">C#</option>
<option value="JAVA">JAVA</option>
</select>
&nbsp &nbsp
Filename:&nbsp<input type="text" value="<%=request.getAttribute("filename")%>" name="filename">
<br/>
<table width="100%">
<tr>
<td rowspan="2" colspan="2">
<center>
<div  id="editor"  ></div>
<textarea name="hide" id="hide"><%=request.getAttribute("hide")%></textarea>
</center>
</td>
<td>
Input:
<br>
<textarea cols="45" rows="11" name="tx2"><%=request.getAttribute("tx2")%>
</textarea>
</td>
</tr>
<tr>
<td>
Output:
<br>
<textarea cols="45" rows="11" name="tx3"><%=request.getAttribute("output")%>
</textarea>
</td>
</tr>
</table>
&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
<input type="button" onclick="saveTextAsFile()" id="save" value="save" name="save">
<input type="submit" value="compile" name="action">
<input type="submit" value="run" name="action">
</form>
</body>
</html>