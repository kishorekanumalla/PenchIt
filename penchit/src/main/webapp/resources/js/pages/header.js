var headerApp = angular.module("headerApp",['ngRoute','ui.bootstrap']);

headerApp.controller('locationController', function($scope){
	
	$("#bootStrapId").removeAttr("disabled", "disabled");
	
	
})

headerApp.config(function($routeProvider){
	$routeProvider
		.when( '/groups', { 
			templateUrl: 'groups.html',
			controller: 'GroupsCtrl' } )
		.when('/courses', { 
			templateUrl: 'courses.html',
			controller: 'CoursesCtrl'  })
		.when('/contact', { 
			templateUrl: 'contact.html',
			controller: 'ContactCtrl'  })
		.when('/clients', { 
			templateUrl: 'clients.html',
			controller: 'ClientsGalleryCtrl'})
		.when('/gallery', { 
			templateUrl: 'gallery.html',
			controller: 'ClientsGalleryCtrl'  })
		.when('/mainScreen', { 
			templateUrl: 'mainScreen.html',
			controller: 'MainGalleryCtrl'  });
});

headerApp.controller('ModalInstanceCtrl', function ($scope, $uibModalInstance) {

	  $scope.ok = function () {
	    $uibModalInstance.close();
	  };

	  $scope.cancel = function () {
	    $uibModalInstance.dismiss('cancel');
	  };
	});





