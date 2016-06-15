(function () {
    'use strict';

    var app = angular.module('application', []);
    app.controller('demoController', function ($scope,$http)  {
        $scope.datas =[];       // เก็บข้อมูลทั้งหมดที่ถูกส่งจากฟอร์ม
        $scope.data ={};        // ข้อมูลที่ผูกกับ form
        $scope.datarps = {};
        $scope.rowCollection = [];
        
  		 $scope.viewDataPage = true;
		 $scope.viewUpdatePage = false;
    
        $scope.rps =[];
        // ฟังก์ชั่น เพิ่มข้อมูลลง datas
        
    	$http.get('http://localhost:8080/namedcq/getnews').
  	  success(function(data, status, headers, config) {
        $scope.rps = data;

  	  }).
  	  error(function(data, status, headers, config) {
  		  
  	  });
    	 $scope.delData = function (rp) {
    	 
    		 var index = $scope.rps.indexOf(rp);
    		// alert( "Is ok rps : " + $scope.rps[index].hotNewsName);
    		 var req = {
             		 method: 'POST',
             		 url: 'http://localhost:8080/namedcq/delNews',
             		 headers: {
             		   'Content-Type': 'application/json; charset=utf-8'
             		 },
          		 data: { 
       				"newId":$scope.rps[index].newId
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
    	 
    	 $scope.updateData = function (rp) {
    		  
        	
        		 var index = $scope.rps.indexOf(rp);
        		 
        		 $scope.viewDataPage = false;
        		 $scope.viewUpdatePage = true;
        		 
        		 $scope.data.NewsName = $scope.rps[index].hotNewsName;
        		 $scope.data.News = $scope.rps[index].hotNews;
        		 
        		 
       	        $scope.addDataUpdate = function (datas) {
    	            datas.push($scope.data);
    	            $scope.data = {};
    	            alert( " index is : " + index);
   
     			  
    	            var req = {
    	             		 method: 'POST',
    	             		 url: 'http://localhost:8080/namedcq/updateNews',
    	             		 headers: {
    	             		   'Content-Type': 'application/json; charset=utf-8'
    	             		 },
    	          		 data: { 
    	       				"newId":$scope.rps[index].newId,
                            "hotNewsName" : $scope.datas[0].NewsName,
                            "hotNews" : $scope.datas[0].News
                           
    	       			       }
    	             		 }
    	              $http(req).
    	              success(function(data, status, headers, config) {
    	           // 	  alert( "Is ok 1 message: " + status +"data is " + $scope.choice);
    	              //  alert( "Is ok 2 message: " + status +"data is " + $scope.choices);
    	            
    	               window.location.reload();
    	              }).
    	              error(function(data, status, headers, config) {
    	                alert( "failure message: " + status);
    	                window.location.reload();
    	             
    	              });
    	            
    	    	
    	            
    	            
    	            
    	        };
        		
        		 
        		 
        		 
        	 };
        
        	 
         	$scope.back = function (rp) {
         		 $scope.viewDataPage = true;
        		 $scope.viewUpdatePage = false;
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
    });

})();