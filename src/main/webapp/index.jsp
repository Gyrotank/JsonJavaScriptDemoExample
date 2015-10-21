<html>

<head>
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script src="https://code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
</head>

<body>
<h2>Hello World!</h2>

<div id="employeesList">
</div>

<div id="employeeFullInfo">
</div>

<script>
var globalEmployeesUrl = window.location.href.toString();
globalEmployeesUrl += "employees";

$(document).ready(function() {
	
	$("#employeeFullInfo").empty();
	
	$.getJSON(globalEmployeesUrl, function(data) {		
		$.each(data, function(index, value) {				
			$("#employeesList").append("<p>" + value.lastName + "</p>");
			$("#employeesList").append('<button id="employeebutton' + value.id + '" onclick="displayEmployee(' + value.id + ')">' + "Full Info" + '</button>');
		});			
	});	
});

function displayEmployee(currentEmployeeId) {
	
	$("#employeeFullInfo").empty();
	
	$.getJSON(globalEmployeesUrl + '/' + currentEmployeeId, function(data) {		
		$("#employeeFullInfo").append("<p>" + data.id + "</p><p>" + data.firstName + "</p><p>" + data.lastName + "</p><p>" + data.email + "</p>");			
	});
}
</script>
</body>
</html>