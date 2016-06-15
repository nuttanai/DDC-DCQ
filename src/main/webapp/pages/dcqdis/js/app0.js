angular.module("app",[])
.service("ninenik",["$http",function($http){
    this.showArticle = function($scope){
         var url="http://www.ninenik.com/demo/today_view_article.php?callback=JSON_CALLBACK";

       // $http.get("http://54.255.180.58:8080/namedcq/getNews").
       // $http.get("http://localhost:8080/namedcq/getnews").
         
         var req = {
        		 method: 'POST',
        		 url: 'http://localhost:8080/namedcq/getDataForListView',
        		 headers: {
        		   'Content-Type': 'application/json; charset=utf-8'
        		 },
        		 data: { 
        				"activityHierarchyForDataMain":"0",
        				"activtyHierarchyOwner":"กรมขนส่ง",
        				"activtyHierarchyOwnerID":"1",
        				"activtyName":"ต่อทะเบียน",
        				"activtyID":"2"
        			   }
        		}

        	//	$http(req).success(function(){...}).error(function(){...});
         
        $http(req).
        success(function(data, status, headers, config) {
          alert( "Is ok message: " + status);
      //    alert(data);
        }).
        error(function(data, status, headers, config) {
          alert( "failure message: " + status);
        });


    };
}])
.controller("appController",["$scope","ninenik",function($scope,ninenik){
    $scope.data1="1";
    $scope.articles=[];
    ninenik.showArticle($scope);
}]);
