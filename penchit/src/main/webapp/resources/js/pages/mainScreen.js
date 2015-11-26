headerApp.controller('MainGalleryCtrl', function($scope, $http, $location, $uibModal){
	$("#welcomeContent").hide();
	
	$(".dropdown-menu > li > a.trigger").on("click",function(e){
		alert();
		var current=$(this).next();
		var grandparent=$(this).parent().parent();
		if($(this).hasClass('left-caret')||$(this).hasClass('right-caret'))
			$(this).toggleClass('right-caret left-caret');
		grandparent.find('.left-caret').not(this).toggleClass('right-caret left-caret');
		grandparent.find(".sub-menu:visible").not(current).hide();
		current.toggle();
		e.stopPropagation();
	});
	$(".dropdown-menu > li > a:not(.trigger)").on("click",function(){
		var root=$(this).closest('.dropdown');
		root.find('.left-caret').toggleClass('right-caret left-caret');
		root.find('.sub-menu:visible').hide();
	});
	

	
	/*var url =  _contextPath + "/loadMainPage";
	$http.get(url).success(function(data, status) {
		  if (data.status == "SUCCESS") {
			  for(var i=0; i< data.result.length; i++) {
		          $scope.groupItems.push(data.result[i]);
				}
		  } else if(data.status == "FAILURE"){
	  		alert("Fetch Group failed")
	  	}
	
	});*/
});


	