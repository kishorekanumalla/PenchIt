headerApp.controller('ContactCtrl', function($scope, $http, $location, $uibModal){
	$("#welcomeContent").hide();
	$('#summerNote').summernote({
		  height: 300,                 // set editor height
          width:700,
		  focus: false,                 // set focus to editable area after initializing summernote
		});
	
	var url =  _contextPath + "/loadContactInfo";
	
  $http.get(url).success(function(data, status) {
	  if (data.status == "SUCCESS") {
		  var result = data.result;
		  $scope.contactName = result.contactName;
		  $scope.contactLandLineNo = result.contactLandLineNo;
		  $scope.contactMobileNo = result.contactMobileNo;
		  $scope.contactEmailId = result.contactEmail;
		  $("#contactId").val(result.contactId);
		  $('#summerNote').code(result.contactAboutsUs);
		  
	  } else if(data.status == "FAILURE"){
  		alert("Fetch Contact failed")
  	}
	  
   }).error(function(data, status) {
           $scope.messages = data || "Request failed";
           $scope.status = status;
           alert(status);
       });  
  
  $scope.submitContact = function() {
	  
	  var contactId = $("#contactId").val();
	  var contactname = $scope.contactName;
	  var contactLandLineNo = $scope.contactLandLineNo;
	  var contactMobileNo = $scope.contactMobileNo;
	  var contactEmailId = $scope.contactEmailId;
	  var sHTML = $('#summerNote').code();
	  
	  var contactInfoVO = {
			  "contactId":contactId,
              "contactName" : contactname,
              "contactLandLineNo" : contactLandLineNo,
              "contactMobileNo" : contactMobileNo,
              "contactEmail" : contactEmailId,
              "contactAboutsUs" : sHTML
      };
//	 var contactInfo =  JSON.stringify(contactInfoVO);
//	 alert(contactInfo);
		var url =  _contextPath + "/saveContact";
		$http({
	        method: 'POST',
	        url: url,
	        data: contactInfoVO
	      })
	      .success(function(data, status) {                       
	    	  openSMModalWindow($uibModal);
	      })
	      .error(function(data, status) {
	    	  alert( "Exception details: " + JSON.stringify({data: data}));
	      });
	  
  }
});