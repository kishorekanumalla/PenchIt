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
  
  $scope.selectedCourseLabel = "Please select a Course";
  $scope.courseItems = [];
  $scope.selectCourse = function(course) {
	  $("#addCourseId").hide();
	  $("#editCourseId").show();
	  $scope.selectedCourseLabel = course.courseName;
	  $("#courseId").val(course.courseId);
	  $("#viewLogo").show();
	  $("#logoName").text(course.courseLogoName);
	  $("#courseLogoNameId").val(course.courseLogoName);
  }
$scope.selectGroup = function(group) {
	$("#addCourseId").show();
	$("#editCourseId").hide();
	$("#groupNameError").hide();
	  var divsionLabel = "";
	  for (var i =0;i<5;i++) {
		  var groupVar = "group" + (i+1);
		  $scope[groupVar] = ""; 
		  
	  }
	  
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
	  var groupName = $scope.selectedGroupLabel;
	  var url =  _contextPath + "/loadCoursesByGroupName?groupName="+groupName;
		$http({
            method: 'POST',
            url: url,
            data:""
          })
          .success(function(data, status) {                       
        	  for(var i=0; i< data.result.length; i++) {
		          $scope.courseItems.push(data.result[i]);
				}
          })
          .error(function(data, status) {
        	  alert("Fetch course failed")
          });
  }
$scope.addNewCourse = function() {
	 $("#addCourseId").show();
	 $("#editCourseId").hide();
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
		
		var file = $("#logoId").val();
	    var filename = file.replace(/^.*[\\\/]/, '');
	    var title = filename.substr(0, filename.lastIndexOf('.'));
	    var courseLogoContent = $("#courseLogoContent").val();
		
		var url =  _contextPath + "/saveCourse";
		var formData = new FormData();
		formData.append("file",courseLogoContent);
		formData.append("courseName",$scope.courseName);
		formData.append("courseDesc",$scope.courseDesc);
		formData.append("courseSyllabus",$scope.courseSyllabus);
		formData.append("coursePrice",$scope.coursePrice);
		formData.append("version",$scope.versionId);
		formData.append("courseLogoName",title);
		formData.append("groupName",$scope.selectedGroupLabel);
		
		$http({
            method: 'POST',
            url: url,
            headers: { 'Content-Type': undefined},
            data:  formData
          })
          .success(function(data, status) {                       
              alert("Success ... " + status);
          })
          .error(function(data, status) {
              alert("Error ... " + status);
          });

	}
};

function isFormValid() {
	var result = true;
	var courseName = $scope.courseName;
	var courseDesc = $scope.courseDesc;
	var courseSyllabus = $scope.courseSyllabus;
	var coursePrice = $scope.coursePrice;
	var logoId = $("#logoId").val();
	var groupName = $scope.selectedGroupLabel;
	var selectedCourseLabel = $scope.selectedCourseLabel;
	
	if (groupName.length == 0 || groupName == "Please select a Group") {
		$("#groupNameError").show();
		return false;
	}
	/*if (selectedCourseLabel.length == 0 || selectedCourseLabel == "Please select a Course") {
		$("#courseNameEmptyError").show();
		return false;
	}*/
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
		$("#coursePriceError").text("Please enter the Course Price");
		$("#coursePriceError").show();
		result = false;
	}
	if ($.trim(coursePrice).length > 0 && isNaN(coursePrice)) {
		$("#coursePriceError").show();
		$("#coursePriceError").text("Please enter valid price");
		result = false;
	}
	if ($.trim(logoId).length == 0) {
		$("#courseLogoError").show();
		result = false;
	}
	
	return result;
}

$scope.removeAllErrorMessagesInCourse = function() {
	$("#courseNameError").hide();
	$("#courseDescError").hide();
	$("#courseSyllabusError").hide();
	$("#coursePriceError").hide();
	$("#courseLogoError").hide();
}
$scope.uploadFile = function(files) {
	$("#courseLogoContent").val(files[0]);
};  

$scope.viewLogo = function() {
	var courseId = $("#courseId").val();
	var logoName = $("#courseLogoNameId").val();
	var url =  _contextPath + "/displayImage?courseId=" +courseId;
	
	$http({
        method: 'POST',
        url: url,
        data:  ""
      })
      .success(function(data, status) {  
    	  $(".modal-title").text(logoName);
        document.getElementById("imgSrcId").src = "data:image/png;base64," + data.result;
    	  
    	  $( "#imageModalContent" ).dialog({
    	      resizable: false,
    	      modal: true,
    	    });
    	  $("#imageModalContent").parent().find(".ui-dialog-titlebar").hide();
      })
      .error(function(data, status) {
          alert("Error ... " + status);
      });
}; 

$scope.closeImageDialog = function() {
	$("#imageModalContent").dialog( "close" );
}

});

