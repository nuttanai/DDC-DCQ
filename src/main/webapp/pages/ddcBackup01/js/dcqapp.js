(function () {
	'use strict';

	var app = angular.module('application', []);
	app.controller('storeController', function ($scope, SushiService) {
		$scope.sushis = [];

			SushiService.getSushis().then(function (data) {
			$scope.sushis = data;
		});
		$scope.purchase = function (item) {
			if (item.quantity > 0) {
				return true;
			} else {
				return false;
			}
		};
		$scope.clickAdd = function (item) {
			item.quantity += 1;
		};
		$scope.clickRemove = function (item) {
			if (item.quantity > 0) {
				item.quantity -= 1;
				return true;
			} else {
				return false;
			}
		};
	}).


	factory('SushiService', function ($http, $q) {
		'use strict';

		return {
			getSushis : function () {
				var deferred = $q.defer();

	//		$http.get('http://golfapipol.github.io/angularjs-th/demo/sushi.json').success(function (data) {
	//			alert( "Is ok message: " + status);
	//				deferred.resolve(data);
	//			}); http://hello-angularjs.appspot.com/getAllProfiles http://rest-service.guides.spring.io/greeting

				$http.get('http://localhost:8080/namedcq/getnews'). 
				success(function(data, status, headers, config) {
					alert( "Is ok message: " + status);
					deferred.resolve(data);
				}).
				error(function(data, status, headers, config) {
					alert( "failure message: " + status);
				});



				return deferred.promise;
			}
		};
	});

})();
