(function () {
    'use strict';

    var app = angular.module('application', []);
    app.controller('demoController', function ($scope,$http)  {
        $scope.datas =[];       // เก็บข้อมูลทั้งหมดที่ถูกส่งจากฟอร์ม
        $scope.data ={};        // ข้อมูลที่ผูกกับ form
        $scope.datarps = {};
        $scope.rowCollection = [];
    
        $scope.rps =[];
        $scope.myVar2 = true;
        $scope.myVar = false;
        // ฟังก์ชั่น เพิ่มข้อมูลลง datas
        
    	$http.get('http://localhost:8080/namedcq/getListDocDe').
  	  success(function(data, status, headers, config) {
        $scope.rps = data;

  	  }).
  	  error(function(data, status, headers, config) {
  		  
  	  });
    	$scope.back = function (rp) {
   		 $scope.myVar = false;
		 $scope.myVar2 = true;
    	}
    	$scope.delData = function (rp) {
  //  		 $scope.myVar = true;
    //		 $scope.myVar2 = false;
    		
    		 
    		 var index = $scope.rps.indexOf(rp);
    		// alert( "Is ok rps : " + $scope.rps[index].docDetail);
    //		 myService.set($scope.rps[index].docDetail);
    	 };
    	 
    	 $scope.updateData = function (rp) {
        	
          		 
        		 var index = $scope.rps.indexOf(rp);
        		// alert( "Is ok rps : " + $scope.rps[index].docDetail);
        		 $scope.myVar = true;
        		 $scope.myVar2 = false;
        		 $scope.data.textareaDocName = $scope.rps[index].docDetail;
        		 $scope.data.textareaDocHowTo = $scope.rps[index].docHowTo;
        		 
        		 
        		 
        	 };
        
        
        $scope.addData = function (datas ) {
            datas.push($scope.data);
            $scope.data = {};
            alert( "Is ok message: " + $scope.datas[0].QCat);
          
            var req = {
             		 method: 'POST',
             		 url: 'http://localhost:8080/namedcq/setQCat',
             		 headers: {
             		   'Content-Type': 'application/json; charset=utf-8'
             		 },
          		 data: { 
       				"qCat":$scope.datas[0].QCat
       			       }
             		 }
              $http(req).
              success(function(data, status, headers, config) {
                alert( "Is ok message: " + status);
                window.location.reload();
              }).
              error(function(data, status, headers, config) {
                alert( "failure message: " + status);
                window.location.reload();
             
              });
            
        };
    }).controller('nextController', function ($scope,$http,$location)  {

    //	$scope.desiredLocation = myService.get();
   // 	alert( "Is ok message: " + $scope.desiredLocation);
    	$location.path();
    	//alert( "Is ok message: " + $location.path());

    	// change the path
    	$location.path('/docedit.html')
    	$location.replace();
    	$location.absUrl();
        

    }).factory('myService', function () {
		   	 var savedData = {}
			 function set(data) {
			   savedData = data;
			 }
			 function get() {
			  return savedData;
			 }
		
			 return {
			  set: set,
			  get: get
			 }
		
		});

})();