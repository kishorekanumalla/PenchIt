headerApp.controller('GroupsCtrl', function($scope, $http, $location, $uibModal){
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
		  
	  }
  }
  $scope.removeAllErrorMessages = function() {
	  $("#groupNameError").hide();
	  $("#groupUniqueNameError").hide();
	  $("#groupError1").hide();
	  $("#groupError2").hide();
	  $("#groupError3").hide();
	  $("#groupError4").hide();
	  $("#groupError5").hide();
	  
	  
  };
  $scope.editGroup = function() {
	  $("#addGroupId").hide();
	  $("#editGroupId").show();
	  $("#groupUniqueNameError").text('');
	  if (isValidForm()) {
		  submitDetails();
	  }
	};
	$scope.addGroup = function() {
		$("#addGroupId").show();
		$("#editGroupId").hide();
		$("#groupUniqueNameError").text('');
		  if (isValidForm()) {
			  if(isGroupUnique()) {
				 submitDetails();
			  }
		  }
		};
	function isGroupUnique() {
		var result = true;
		var groupName = $scope.groupName;
		  var groupItems = $scope.groupItems;
		  for (var i=0;i<groupItems.length;i++){
			  if(groupItems[i].groupName == groupName){
				  $("#groupUniqueNameError").show();
				  $("#groupUniqueNameError").text("Group Name is already exisiting")
				  return false;
			  }
		  }
		  return result;
	}
	function submitDetails() {
		$scope.removeAllErrorMessages();
		  
		  var division = "";
		  $scope.groupItems = [];
		  division = divisionAppender(division,$scope.group1);
		  division = divisionAppender(division,$scope.group2);
		  division = divisionAppender(division,$scope.group3);
		  division = divisionAppender(division,$scope.group4);
		  division = divisionAppender(division,$scope.group5);
		  
		  if (division != "") {
			  division = division.substring(1, division.length);
		  }
		  var groupsForm = {
	                "groupName" : $scope.groupName,
	                "division" : division
	        };
			
			var url =  _contextPath + "/saveGroup";
			$scope.groupItems = [];
		    var response = $http.post(url,groupsForm); //passing mockForm
		    response.success(function(data, status, headers, config) {
		    	if (data.status == "SUCCESS") {
		    		for(i=0; i< data.result.length; i++) {
		    			$scope.groupItems.push(data.result[i]); 

			  		}
		    		for (var i =0;i<5;i++) {
		    			  var groupVar = "group" + (i+1);
		    			  $scope[groupVar] = ""; 
		    			  
		    		  }
		    		$scope.groupName = "";
		    		$scope.selectedGroupLabel = "Please select a Group";
		    	} else {
		    		alert("ADD Group failed")
		    	}
		    	
		    });
		    response.error(function(data, status, headers, config) {
		        alert("Exception details: " + JSON.stringify({
		            data: $scope.formData //used formData model here
		        }));
		    });
	}
	function isValidForm() {
		var result = true;
		var groupName = $scope.groupName;
		
		if ($.trim(groupName).length == 0){
			$("#groupNameError").show();
			result = false;
		}
		if (result) {
			result = isValidDivision();
		}
		
		
		return result;
	}
	function isValidDivision() {
		var result = true;
		var highestDegree = "";
		for (var i=0;i<5;i++) {
			var groupVar = "group" + (i+1);
			if($.trim($scope[groupVar]).length > 0){
				highestDegree = i+1;
            }
		}
		for (var i=highestDegree;i>0;i--) {
			var groupVar = "group" + (i);
			if($.trim($scope[groupVar]).length <= 0){
				var groupError = "groupError" + (i);
				$("#" +groupError).text("Please enter Group " + (i));
				$("#" +groupError).show();
				result = false;
            }
		}
		return result;
	}
	function divisionAppender(division, value){
		if (value!= 'undefined' && value != undefined && value.length >0) {
			division = division + "," + value;
		} 
		return division;
	}
	$scope.removeErrorMsgs = function(msgId) {
		$("#" +msgId).hide();
	};
	
	$scope.addNewGroup = function() {
		$scope.removeAllErrorMessages();
		$("#addGroupId").show();
		$("#editGroupId").hide();
		$scope.groupName = '';
		resetValues();
		
	};
	
	$scope.deleteGroup = function() {
		var selectedGroupName = $scope.selectedGroupLabel;
		var isOldGroup = false;
		var groupItems = $scope.groupItems;
		for (var i=0;i<groupItems.length;i++){
			if (groupItems[i].groupName == selectedGroupName){
				isOldGroup = true;
			}
		}
		if (isOldGroup){
			var url =  _contextPath + "/deleteGroup?groupName="+selectedGroupName;
			$scope.groupItems = [];
			$http.get(url).success(function(data, status) {
				  if (data.status == "SUCCESS") {
					  for(var i=0; i< data.result.length; i++) {
				          $scope.groupItems.push(data.result[i]);
						}
					  openSMModalWindow($uibModal);
				  } else if (data.status == "FAILURE") {
			  		alert("Group delete failed")
			  	}
				  
			   }).error(function(data, status) {
			           $scope.messages = data || "Request failed";
			           $scope.status = status;
			           alert("Delete group exception");
			   });  
		} 
		resetValues();
		
		
	};
	function resetValues() {
		$scope.removeAllErrorMessages();
		$("#addGroupId").show();
		$("#editGroupId").hide();
		$scope.selectedGroupLabel = "Please select a Group";
		$scope.groupName = '';
		for (var i=5;i>0;i--){
			var divName = "group" + i;
			$scope[divName] = '';
		}
	}
	
	

});