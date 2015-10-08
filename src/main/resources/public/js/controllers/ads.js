app.controller('IndexController', [ '$scope', '$filter', '$location', 'adService', function($scope, $filter, $location, adService) {    
	$scope.ads = [];
	adService.list(function (data) { 
		$scope.ads = data 
	});