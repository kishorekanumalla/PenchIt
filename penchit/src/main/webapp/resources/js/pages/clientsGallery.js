headerApp.controller('ClientsGalleryCtrl', function($scope, $http, $location, $uibModal){
	
	
	$("#welcomeContent").hide();
	$(":file").filestyle({placeholder: "Upload Picture"});
	var fromPage = $("#fromPage").val();
	$scope.slides = [];
	$scope.myInterval = 5000;
	$scope.noWrapSlides = false;
	findAllPics();
	
	function findAllPics(){
	var url =  _contextPath + "/loadClientGalleryPics?type="+fromPage;
	$http({
        method: 'GET',
        url: url,
        data:  ""
      })
      .success(function(data, status) { 
    	  if (data.status == "SUCCESS") {
    		 var result = data.result;
    		 for (var i=0;i<result.length;i++) {
    			 result[i].image = "data:image/png;base64," + result[i].clientGalleryPic;
    			 $scope.slides.push(result[i]);
    		 }
    	  }
      })
      .error(function(data, status) {
          alert( "Exception details: " + JSON.stringify({data: data}));
      });
	}
	$scope.selectPicture = function(clientsGalleryObj) {
		var imageId = clientsGalleryObj.clientGalleryId;
		$("#deletePicId").val(imageId);
		$(".modal-body").text(clientsGalleryObj.clientGalleryName);
		 
		 $( "#pictureContent" ).dialog({
	   	      resizable: false,
	   	      modal: true,
	   	      show: { effect: "blind", duration: 800 }
	   	    });
//		 document.getElementById("clientsPictureSrcId").src = "data:image/png;base64," + clientsGalleryObj.clientGalleryPic;
		 
		 
 }
	
	function setTimerImageDisplay(clientsGalleryObj) {
		
		 /* var url =  _contextPath + "/displayClientGalleryImage?imageId="+imageId+"&type="+fromPage;
			$http({
		        method: 'GET',
		        url: url,
		        data:  ""
		      })
		      .success(function(data, status) { 
		    	  if (data.status == "SUCCESS") {
		    		 var result = data.result;
//		    		 $("#pictureSrcId").removeAttr("src").attr("src", "data:image/png;base64," + result.clientGalleryPic);
//		    		 $("#pictureSrcId").attr("src", "data:image/png;base64," + result.clientGalleryPic+"&"+Math.floor(Math.random()*1000));
//		    		 $("#pictureSrcId").attr("src", $("#pictureSrcId").attr("src")+"?timestamp=" + new Date().getTime());
//		    		 $("#pictureSrcId").removeAttr("src").attr("src", "data:image/png;base64," + result.clientGalleryPic);
//		    		 document.getElementById("pictureSrcId").src = "data:image/png;base64," + result.clientGalleryPic +"?timestamp=" + new Date().getTime();
		    		 $( "#pictureContent" ).dialog({
			    		  autoOpen: false,
			    	      resizable: false,
			    	      modal: true,
			    	      show: { effect: "blind", duration: 800 }
			    	    });
			    	  $( "#pictureContent" ).dialog("open");
		    		 
		    	  }
		      })
		      .error(function(data, status) {
		          alert( "Exception details: " + JSON.stringify({data: data}));
		      });*/
		
	}
	
$scope.removeErrorMessage = function(errorId) {
	$("#" +errorId).hide();
}
$scope.uploadPicture = function() {
	var picFile = $("#picId").val();

	if ($.trim(picFile).length <= 0) {
		$("#picError").show();
		return false;
	}
	
	var file = document.forms['clientsGalleryForm']['picId'].files[0];
	var filename = picFile.replace(/^.*[\\\/]/, '');
    var title = filename.substr(0, filename.lastIndexOf('.'));
    var fromPage = $("#fromPage").val();
	var url =  _contextPath + "/savePicture";
	var formData = new FormData();  
	formData.append("file", file);
	formData.append("title", title);
	formData.append("type", fromPage);
	$http({
        method: 'POST',
        url: url,
        headers: { 'Content-Type': undefined},
        enctype: 'multipart/form-data',
        data:  formData
      })
      .success(function(data, status) { 
    	  if (data.status == "SUCCESS") {
    		  $(":file").filestyle('clear');
    		 $scope.slides = [];
     		 $scope.myInterval = 5000;
     		 $scope.noWrapSlides = false;
     		 var result = data.result;
      		 for (var i=0;i<result.length;i++) {
      			 result[i].image = "data:image/png;base64," + result[i].clientGalleryPic;
      			 $scope.slides.push(result[i]);
      		 }
    		  openSMModalWindow($uibModal);
    	  }
      })
      .error(function(data, status) {
          alert( "Exception details: " + JSON.stringify({data: data}));
      });
}


$scope.closeImageDialog = function() {
	$('#pictureContent').dialog('destroy');
}

$scope.deleteImageDialog = function() {
	var deleteImageId = $("#deletePicId").val();
	var fromPage = $("#fromPage").val();
	var url =  _contextPath + "/deleteClientGallery?deleteImageId="+deleteImageId+"&type="+fromPage;
	$http({
        method: 'GET',
        url: url,
        data:  ""
      })
      .success(function(data, status) { 
    	  if (data.status == "SUCCESS") {
    		  $("#pictureContent").dialog( "destroy" ); 
    		 var result = data.result;
    		 $scope.slides = [];
    		 $scope.myInterval = 5000;
    		 $scope.noWrapSlides = false;
     		 for (var i=0;i<result.length;i++) {
     			 result[i].image = "data:image/png;base64," + result[i].clientGalleryPic;
     			 $scope.slides.push(result[i]);
     		 }
     		openSMModalWindow($uibModal);
    	  }
      })
      .error(function(data, status) {
          alert( "Exception details: " + JSON.stringify({data: data}));
      });
}
});
