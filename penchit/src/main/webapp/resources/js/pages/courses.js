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
	  
	  $("#logoId").filestyle('clear');
	 //Assisgn values from course object
  	$scope.courseName = course.courseName;
	$scope.courseDesc = course.courseDesc;
	$scope.courseSyllabus = course.courseSyllabus;
	$scope.coursePrice = course.coursePrice;
	$scope.versionId = course.version;
	$("#courseId").val(course.courseId);
	$("#courseLogoNameId").val(course.courseLogoName)
	$("#logoName").text(course.courseLogoName);
	$("#courseLogoContent").val(course.courseLogo);
	$scope.removeAllErrorMessagesInCourse();
  }
$scope.selectGroup = function(group) {
	resetValues();
	$scope.selectedCourseLabel = "Please select a Course";
	$scope.courseItems = [];
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
	 $scope.selectedCourseLabel = "Please select a Course";
	var groupName = $scope.selectedGroupLabel;
	if (groupName.length == 0 || groupName == "Please select a Group") {
		$("#groupNameError").show();
		return false;
	}
	resetValues();
}

$scope.removeErrorMessage = function(errorId) {
	$("#" +errorId).hide();
}

$scope.addCourse = function() {
	if (isFormValid() && isCourseUnique()) {
	    submitDetails();
	}
};

function submitDetails() {
	var file = $("#logoId").val();
    var filename = file.replace(/^.*[\\\/]/, '');
    var title = filename.substr(0, filename.lastIndexOf('.'));
    var courseLogoContent = $("#courseLogoContent").val();
	var url =  _contextPath + "/saveCourse";
	
	
	
	var courseName = $scope.courseName;
	var courseDesc = $scope.courseDesc;
	var courseSyllabus = $scope.courseSyllabus;
	var coursePrice = $scope.coursePrice;
	var version = $scope.versionId;
	var courseLogoName = title;
	var groupName = $scope.selectedGroupLabel;
	
	$scope.selectedCourseLabel = "Please select a Course";
	$scope.courseItems = [];
	
	var courseForm = {
			"courseName":courseName,
			"courseDesc":courseDesc,
			"courseSyllabus":courseSyllabus,
			"coursePrice":coursePrice,
			"version":version,
			"courseLogoName":courseLogoName,
			"groupName":groupName,
			"courseLogo":""
			
	};
//	var contactInfo =  JSON.stringify(courseForm);
	
	
	$http({
        method: 'POST',
        url: url,
        data:  courseForm
      })
      .success(function(data, status) {  
    	  if (data.status == "SUCCESS") {
    		  if ($.trim(title).length > 0) {
    			  for(var i=0; i< data.result.length; i++) {
    		          $scope.courseItems.push(data.result[i]);
    		          var coursename = data.result[i].courseName;
    		          if (coursename == $scope.courseName){
    		        	  saveImageLogo(data.result[i].courseId,groupName,title);
    		          }
    			  }
    			  
    		  }else {
    			  for(var i=0; i< data.result.length; i++) {
    		          $scope.courseItems.push(data.result[i]);
    		          var coursename = data.result[i].courseName;
    		          if (coursename == $scope.courseName){
    		        	  $("#courseId").val(data.result[i].courseId);
    		        	  $("#courseLogoNameId").val(data.result[i].courseLogoName);
    		        	  $("#logoName").text(data.result[i].courseLogoName);
    		        	  $("#courseLogoContent").val(data.result[i].courseLogo);
    		          }
    			}
    	    	  $scope.selectedCourseLabel = $scope.courseName;
    	    	  $("#logoId").filestyle('clear');
    	    	  $("#viewLogo").show();
    	    	  openSMModalWindow($uibModal);
    		  }
    	  }
      })
      .error(function(data, status) {
          alert( "Exception details: " + JSON.stringify({data: data}));
      });	 
	
}
function saveImageLogo(courseId, groupName, title) {
	
	$scope.selectedCourseLabel = "Please select a Course";
	$scope.courseItems = [];
	 var courseLogoContent = $("#courseLogoContent").val();
	 var url =  _contextPath + "/saveCourseLogo";
	var formData = new FormData();  
	formData.append("file", courseLogoContent);
	formData.append("courseId", courseId);
	formData.append("groupName", groupName);
	$http({
        method: 'POST',
        url: url,
        headers: { 'Content-Type': undefined},
        enctype: 'multipart/form-data',
        data:  formData
      })
      .success(function(data, status) {                       
    	  for(var i=0; i< data.result.length; i++) {
	          $scope.courseItems.push(data.result[i]);
	          var coursename = data.result[i].courseName;
	          if (coursename == $scope.courseName){
	        	  $("#courseId").val(data.result[i].courseId);
	        	  $("#courseLogoNameId").val(data.result[i].courseLogoName);
	        	  $("#courseLogoContent").val(data.result[i].courseLogo);
	          }
		}
    	  $scope.selectedCourseLabel = $scope.courseName;
    	  $("#logoId").filestyle('clear');
    	  $("#viewLogo").show();
    	  $("#logoName").text(title);
    	  openSMModalWindow($uibModal);
      })
      .error(function(data, status) {
          alert( "Exception details: " + JSON.stringify({data: data}));
      });
}
function isCourseUnique() {
	var result = true;
	var courseName = $scope.courseName;
	var courseLabelName = $scope.selectedCourseLabel;
	  var courseItems = $scope.courseItems;
	  for (var i=0;i<courseItems.length;i++){
		  if(courseItems[i].courseName == courseName && courseLabelName != courseName){
			  $("#courseUniqueNameError").show();
			  return false;
		  }
	  }
	  return result;
}
function isFormValid() {
	var result = true;
	var courseName = $scope.courseName;
	var courseDesc = $scope.courseDesc;
	var courseSyllabus = $scope.courseSyllabus;
	var coursePrice = $scope.coursePrice;
	var logoId = $("#logoId").val();
	var groupName = $scope.selectedGroupLabel;
	var selectedCourseLabel = $scope.selectedCourseLabel;
	var logoName = $("#logoName").val();
	var courseLogoName = $("#courseLogoNameId").val();
	
	if (groupName.length == 0 || groupName == "Please select a Group") {
		$("#groupNameError").show();
		return false;
	}
	
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
	if ($.trim(logoId).length == 0 && $.trim(logoName).length == 0 && $.trim(courseLogoName).length == 0) {
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
	$("courseUniqueNameError").hide();
}


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

function resetValues() {
	$scope.selectedCourseLabel = "Please select a Course";
	$scope.courseName = "";
	$scope.courseDesc = "";
	$scope.courseSyllabus = "";
	$scope.coursePrice = "";
	$scope.versionId = "";
	$("#viewLogo").hide();
	$("#courseLogoContent").val("");
	$("#logoId").val("");
	$("#courseId").val("");
	$("#courseLogoNameId").val("");
	$("#logoId").filestyle('clear');
}
$scope.deleteCourse = function() {
	var selectedCourseLabel = $scope.selectedCourseLabel;
	var groupName = $scope.selectedGroupLabel;
	if (selectedCourseLabel.length == 0 || selectedCourseLabel == "Please select a Course") {
		$("#courseNameEmptyError").show();
		return false;
	} else {
		var courseId = $("#courseId").val();
		if ($.trim(courseId).length > 0){
			var url =  _contextPath + "/deleteCourse?courseId="+courseId+"&groupName="+groupName;
			$scope.selectedCourseLabel = "Please select a Course";
			$scope.courseItems = [];
			$http.get(url).success(function(data, status) {
				  if (data.status == "SUCCESS") {
					  for(var i=0; i< data.result.length; i++) {
						  $scope.courseItems.push(data.result[i]);
						}
					  openSMModalWindow($uibModal);
				  } else if (data.status == "FAILURE") {
			  		alert("Course delete failed")
			  	}
				resetValues();  
			   }).error(function(data, status) {
			           $scope.messages = data || "Request failed";
			           $scope.status = status;
			           alert("Delete group exception");
			   });  
		} 
	}
	
}
$scope.clearlOGO = function () {
	$("#viewLogo").hide();
	$("#courseLogoNameId").val("");
	$("#logoName").val("");
	$("#courseUniqueNameError").hide();
}

});

function uploadFile(){
	var file = document.forms['groupsForm']['logoId'].files[0];
	$("#courseLogoContent").val(file);	
	$("#viewLogo").hide();
}

