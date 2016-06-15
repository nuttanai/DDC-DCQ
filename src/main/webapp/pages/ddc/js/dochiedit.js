(function () {
    'use strict';

    var app = angular.module('application', []);
    app.controller('demoController', function ($scope,$http) {
        $scope.datas =[];       // เก็บข้อมูลทั้งหมดที่ถูกส่งจากฟอร์ม
        $scope.data ={};        // ข้อมูลที่ผูกกับ form
    
        $scope.choices = [{id: ''}];
        
        $scope.rps =[];
       
        
    	$http.get('http://54.255.180.58:8080/namedcq/getListDocAll').
    	  success(function(data, status, headers, config) {
          $scope.rps = data;

    	  }).
    	  error(function(data, status, headers, config) {
    		  
    	  });
        
    
        // ฟังก์ชั่น เพิ่มข้อมูลลง datas
        
        $scope.addData = function (datas) {
            datas.push($scope.data);
           
            $scope.data = {};
        //    alert(choices[0].name);
        //    alert($scope.datas[0].selectHidoc.docHierarchyName);
            
            
            var req = {
           		 method: 'POST',
           		 url: 'http://54.255.180.58:8080/namedcq/setDocHierarchy',
           		 headers: {
           		   'Content-Type': 'application/json; charset=utf-8'
           		 },
        		 data: { 
                   "docHierarchyOwner" : $scope.datas[0].selectHidoc.docHierarchyName,
                   "docHierarchyName" : $scope.datas[0].docName,
                   "docDetail" : 0
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
        
        
        
        
        
     
    }); // con

})();