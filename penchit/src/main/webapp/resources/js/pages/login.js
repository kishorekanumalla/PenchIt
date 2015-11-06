var loginApp = angular.module('loginApp', []);
loginApp.controller('loginController', function($scope, $location) {
	$("#bootStrapId").attr("disabled", "disabled");
	var url = "" + $location.$$absUrl;
    $scope.displayLoginError = (url.indexOf("error") >= 0);
});