<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="css/jquery-ui-1.7.2.custom.css" />
<title>Add Tracker Location</title>
</head>
<body>


<table cellspacing="0" cellpadding="0" width="100%">
	<tr id="header">
		<td id="header"style="border-bottom-style: none">
			<div id="header" style="border-bottom-style: none">
				<h1></h1>
			</div>
			<div>
				<h1 style="width: 500px">
					<b>Update Tracker Location</b>
				</h1>
			</div>
		</td>
		
		<td id="headerline">
				<div id="headerline">
				<h1></h1>
				</div>
			
		</td>
	</tr>
	
</table>

  <!-- Start of FORM -->
  <form name="trackerData" method="post" action="AddLocationServlet" id="AddLocationServlet" onsubmit="go();return false;">

   <table  align="left" style="padding-left: 30px; height: 311px; width: 498px">
        <tr>
          <td style="padding-top: 12px; text-align: right;">
          		Cycle ID
          </td>

          <td style="padding-top: 12px; text-align: left;">
          	<input id="CycleID" type="text" style="width: 200px" maxlength="64" name="CycleID" value="" />
          </td>
		</tr>
		
		 <tr>
          <td style="padding-top: 12px; text-align: right;">
          		Timestamp
          </td>

          <td style="padding-top: 12px; text-align: left;">
          	<input id="Timestamp" type="text" style="width: 200px" maxlength="64" name="Date" value="" />
          </td>
		</tr>
		
		<tr>
          <td style="padding-top: 12px; text-align: right;">
          		Latitude
          </td>

          <td style="padding-top: 12px; text-align: left;">
          	<input id="Latitude" type="text" style="width: 200px" maxlength="64" name="Latitude" value="" />
          </td>
		</tr>
		
		 <tr>
          <td style="padding-top: 12px; text-align: right;">
          		Longtitude
          </td>

          <td style="padding-top: 12px; text-align: left;">
          	<input id="Longtitude" type="text" style="width: 200px" maxlength="64" name="Longtitude" value="" />
          </td>
		</tr>
		
		<tr>
           <td style="text-align: left;">          	
          </td>
        </tr>
        
		<tr>
          <td>&nbsp;</td>
          <td style="height: 39px; width: 169px; ">&nbsp;<input id="b_submit" name="submit" type="submit" value="Add" style="font-weight: bold; color: #222; height: 33px; width: 132px">              
          </td>
          
          
        </tr>
		
	</table>
  </form>

</body>
</html>