headerApp.controller('CoursesCtrl', function($scope, $http, $location, $uibModal){
	$("#welcomeContent").hide();
	var url =  _contextPath + "/loadAll";
	$("#addGroupId").show();
	$scope.groupItems = [];
	$scope.selectedGroupLabel = "Please select a Group";
  $http.get(url).success(function(data, status) {
	  if (data.status == "SUCCESS") {
		  for(var i=0; i< data.result.length; i++) {
	          $scope.groupItems.push(data.result[i]);
			}
	  } else if(data.status == "FAILURE"){
  		alert("Fetch Group failed")
  	}
	  
   }).error(function(data, status) {
           $scope.messages = data || "Request failed";
           $scope.status = status;
           alert(status);
       });  
$scope.selectGroup = function(group) {
	  var divsionLabel = "";
	  for (var i =0;i<5;i++) {
		  var groupVar = "group" + (i+1);
		  $scope[groupVar] = ""; 
		  
	  }
	  
	  $("#addGroupId").hide();
	  $("#editGroupId").show();
	  $("#groupUniqueNameError").text('');
	  $scope.selectedGroupLabel = group.groupName;
	  $scope.groupName = group.groupName;
	  var division = group.division;
	  var divsionArray = division.split(",");
	  
	  for (var i =0;i<divsionArray.length;i++) {
		  var groupVar = "group" + (i+1);
		  $scope[groupVar] = divsionArray[i]; 
		  divsionLabel = divsionLabel + " >> " + divsionArray[i];
	  }
	  if ($.trim(divsionLabel).length > 0) {
		  $scope.selectedDivisionLabel = divsionLabel.substring(4, divsionLabel.length);
	  }
	  
  }
});
