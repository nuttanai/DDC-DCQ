(function () {
    'use strict';

    var app = angular.module('application', []);
    app.controller('demoController', function ($scope,$http) {
        $scope.datas =[];       // เก็บข้อมูลทั้งหมดที่ถูกส่งจากฟอร์ม
        $scope.data ={};        // ข้อมูลที่ผูกกับ form
        
        //  alert($scope.data);
        // ฟังก์ชั่น เพิ่มข้อมูลลง datas
        $scope.addData = function (datas) {
            datas.push($scope.data);
        //    alert(datas);
            $scope.data = {};
            
        //   alert(data.text);
        //   alert(data);
       //    alert($scope.datas[0].text);
           console.log($scope.datas[0].text);
           
           


           var req = {
          		 method: 'POST',
          		 url: 'http://localhost:8080/namedcq/setDataForProvince',
          		 headers: {
          		   'Content-Type': 'application/json; charset=utf-8'
          		 },
       		 data: { 
    				"provinces":$scope.datas[0].text,
    				"region":$scope.datas[0].textarea
    			   }
          			   
          		}
           $http(req).
           success(function(data, status, headers, config) {
             alert( "Is ok message: " + status);
             alert( "Is ok data: " + data);
             
             window.location.reload();
         //    $scope.data ={};   
        
           }).
           error(function(data, status, headers, config) {
             alert( "failure message: " + status);
             alert( "Is Not ok message: " + status);
             alert( "Is No data: " + data);
             window.location.reload();
           //  $scope.data ={};  
           });
           
           
       

        };
    });

})();
