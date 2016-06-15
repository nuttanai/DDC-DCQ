angular.module("app",[])
.service("ninenik",["$http",function($http){
    this.showArticle = function($scope){

	var url="http://www.ninenik.com/demo/today_view_article.php?callback=JSON_CALLBACK";

//        $http.jsonp(url).success(function(result){
//            $scope.articles=result;
//						window.alert("Is Ok");
//						window.alert($scope.articles);
//        }).error(function(){
//					window.alert("Is Error");
//        });
 //var dataSet = '{"activtyName":"ต่อทะเบียน"}';
 var dataSet = { activityName: "ต่อทะเบียน"};

// var dataSetJson = "{"activityHierarchyForDataMain":"0","activtyHierarchyOwner":"กรมขนส่ง","activtyHierarchyOwnerID":"1","activtyName":"ต่อทะเบียน","activtyID":"2"} ";


console.log(dataSet);
				$http.post('http://54.255.180.58:8080/namedcq/getDataForListView', dataSet).
				  success(function(data, status, headers, config) {
						window.alert("Is Ok" );
				//		window.alert(status);
				    // this callback will be called asynchronously
				    // when the response is available
				  }).
				  error(function(data, status, headers, config) {
						window.alert(dataSet);
						window.alert("Is Error");
						window.alert(status);
						window.alert(config);
						window.alert(data);
				    // called asynchronously if an error occurs
				    // or server returns response with an error status.
				  });




    };
}])
.controller("appController",["$scope","ninenik",function($scope,ninenik){
    $scope.data1="1";
    $scope.articles=[];
    ninenik.showArticle($scope);
}]);
