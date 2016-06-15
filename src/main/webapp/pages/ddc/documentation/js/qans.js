(function () {
    'use strict';

    var app = angular.module('application', []);
    app.controller('demoController', function ($scope, $http) {
    	
        $scope.datas =[];       // เก็บข้อมูลทั้งหมดที่ถูกส่งจากฟอร์ม
        $scope.data ={};        // ข้อมูลที่ผูกกับ form
        
        $scope.rps =[];
       
        
    	$http.get('http://localhost:8080/namedcq/getListQCat').
    	  success(function(data, status, headers, config) {
          $scope.rps = data;

    	  }).
    	  error(function(data, status, headers, config) {
    		  
    	  });

        // ฟังก์ชั่น เพิ่มข้อมูลลง datas
        $scope.addData = function (datas) {
            datas.push($scope.data);
            $scope.data = {};
       
            var req = {
            		 method: 'POST',
            		 url: 'http://localhost:8080/namedcq/setQAns',
            		 headers: {
            		   'Content-Type': 'application/json; charset=utf-8'
            		 },
         		 data: { 
                    "qGroup" : $scope.datas[0].selectQcat.qCatId,
                    "ownQ" : $scope.datas[0].ownQ,
                    "ownA" : $scope.datas[0].ownA,
                    "answers" : $scope.datas[0].textareaAns,
                    "questions" : $scope.datas[0].textareaQ
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
