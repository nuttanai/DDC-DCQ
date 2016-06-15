(function () {
    'use strict';

    var app = angular.module('application', []);
    app.controller('demoController', function ($scope,$http,$q) {
        $scope.datas =[];       // เก็บข้อมูลทั้งหมดที่ถูกส่งจากฟอร์ม
        $scope.data ={};        // ข้อมูลที่ผูกกับ form
        $scope.rps =[];
        $scope.docid=[];
        $scope.choices = [{id: ''}];
        var setid = 0 ;

  
 
        // ฟังก์ชั่น เพิ่มข้อมูลลง datas
        $scope.addData = function (datas,choice) {
        	  datas.push($scope.data);
              $scope.data = {};
              
              var deferred = $q.defer();
              var promise = deferred.promise;
              deferred.resolve("nothing");
             
              promise.then(function(promise) {
            	  console.log( "then(function(promise):  11111111111");
            	  var req = {
                   		 method: 'POST',
                    		 url: 'http://localhost:8080/namedcq/setDocDetail',
                    		 headers: {
                    		   'Content-Type': 'application/json; charset=utf-8'
                    		 },
                 		 data: { 
                            "docDetail" : $scope.datas[0].textareaDocName,
                            "docHowTo" : $scope.datas[0].textareaDocHowTo
              			       }
                    		 }
            	 
            	  return    $http(req).success(function(data, status, headers, config) {
                    	 console.log( "Is ok message: " + status);
                     }).
                     error(function(data, status, headers, config) {
                    	 console.log( "failure message: " + status);
                     });
            	   
              }).then(function(promise) {
            	  console.log( "then(function(promise):  222222222");
            	  
            	  var req2 = {
           	           method: 'POST',
           	           url: 'http://localhost:8080/namedcq/getDocDetail',
           	           headers: {
           	             'Content-Type': 'application/json; charset=utf-8'
           	           },
           	        data: { 
           	                "docHierarchyName" : $scope.datas[0].textareaDocName
           	          //    "docHierarchyName" : "as"
           	             }
           	           }
            	  return $http(req2).
           	    success(function(data, status, headers, config) {
           	      console.log( "Is ok message: " + status);
           	      console.log( "Is ok message: " + data);
           	     
           	      $scope.docid = data;

           	     console.log( "Is ok message: docDetailId " + $scope.docid.docDetailId);
           	     console.log( "Is ok message: docDetail " + $scope.docid.docDetail);
           	     
           	     console.log( "Is ok message: setid " + setid);
        
           	    }).
           	    error(function(data, status, headers, config) {
           	      console.log( "failure message: " + status);
           	   
           	    });
            	  
              }).then(function(promise) {
            	  console.log( "then(function(promise):  33333333333");
            	  
             	    var x;
            	    for (x in $scope.choices) {
            	        

            	    console.log( "Is ok message: parseInt(setid) " + $scope.docid.docDetailId);
            	    
//            	      	console.log( "Is ok message:parseInt($scope.docid.docDetailId) " + parseInt($scope.docid.docDetailId));
            	    var req3 = {
            	        method: 'POST',
            	        url: 'http://localhost:8080/namedcq/setDocLink',
            	        headers: {
            	          'Content-Type': 'application/json; charset=utf-8'
            	        },
            	     data: {                    
            	           "docLinkOwner" : $scope.docid.docDetailId,
            	           "docLink" : $scope.choices[x].name 
            	          }
            	        }
            	    $http(req3).
            	    success(function(data, status, headers, config) {
            	      console.log( "Is ok message for link: " + status);

            	    }).
            	    error(function(data, status, headers, config) {
            	      console.log( "failure message for link: " + status);

            	    });
            	    
            	 }  // end loop link 
            	  
            	  
              });
          
         
        };
        
       
        
        $scope.addNewChoiceX = function() {
        //	 alert(choices[0].name);
        //	alert("ROCK");
        };
        
        
        $scope.addNewChoice = function() {
            var newItemNo = $scope.choices.length+1;
            $scope.choices.push({'id':'choice' +newItemNo});
        };

        $scope.showAddChoice = function(choice) {
           return choice.id === $scope.choices[$scope.choices.length-1].id;
        };
        
        
    });

})();
