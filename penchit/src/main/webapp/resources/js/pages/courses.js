headerApp.controller('CoursesCtrl', function($scope, $http, $location, $uibModal){
	$(":file").filestyle({placeholder: "No file"});
	$("#addCourseId").show();
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
	var url =  _contextPath + "/loadAllCourses";
	$("#addGroupId").show();
	$scope.courseItems = [];
	$scope.selectedCourseLabel = "Please select a Course";
  $http.get(url).success(function(data, status) {
	  if (data.status == "SUCCESS") {
		  for(var i=0; i< data.result.length; i++) {
	          $scope.courseItems.push(data.result[i]);
			}
	  } else if(data.status == "FAILURE"){
  		alert("Fetch course failed")
  	}
	  
   }).error(function(data, status) {
           $scope.messages = data || "Request failed";
           $scope.status = status;
           alert(status);
       });  
$scope.selectGroup = function(group) {
	$("#groupNameError").hide();
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
$scope.addNewCourse = function() {
	$("#addCourseId").show();
	var groupName = $scope.selectedGroupLabel;
	if (groupName.length == 0 || groupName == "Please select a Group") {
		$("#groupNameError").show();
		return false;
	}
}

$scope.removeErrorMessage = function(errorId) {
	$("#" +errorId).hide();
}

$scope.addCourse = function() {
	if (isFormValid()) {
		alert("Success")
	}
}

function isFormValid() {
	var result = true;
	var courseName = $scope.courseName;
	var courseDesc = $scope.courseDesc;
	var courseSyllabus = $scope.courseSyllabus;
	var coursePrice = $scope.coursePrice;
	
	if ($.trim(courseName).length == 0) {
		$("#courseNameError").show();
		result = false;
	}
	if ($.trim(courseDesc).length == 0) {
		$("#courseDescError").show();
		result = false;
	}
	if ($.trim(courseSyllabus).length == 0) {
		$("#courseSyllabusError").show();
		result = false;
	}
	if ($.trim(coursePrice).length == 0) {
		$("#coursePriceError").show();
		result = false;
	}
	
	return result;
}

$scope.removeAllErrorMessagesInCourse = function() {
	$("#courseNameError").hide();
	$("#courseDescError").hide();
	$("#courseSyllabusError").hide();
	$("#coursePriceError").hide();
}

$scope.setTitle = function(fileInput) {

    var file=fileInput.value;
    var filename = file.replace(/^.*[\\\/]/, '');
    var title = filename.substr(0, filename.lastIndexOf('.'));
    alert(title);
    $("#title").val(title);
};

});
