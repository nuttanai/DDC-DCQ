(function () {
    'use strict';

var app = angular.module('application', ['ckeditor','ngSanitize']);
    app.controller('demoController', function ($scope,$http,$q,$sce) {
    
        $scope.datas =[];       
        $scope.data ={};       
        $scope.rps =[];
        $scope.qa =[];
        $scope.docid=[];
        $scope.choices = [{id: ''}];
        var setid = 0 ;
        $scope.viewMainPage = true;
         $scope.viewAnsPage = false;
          $scope.viewNewsPage = false;
         
        
            
      	  $scope.options = {
    	  language: 'en',
  	  	  allowedContent: true,
  	      entities: false
 	 		};

 	    // Called when the editor is completely ready.
	     $scope.onReady = function () {
         // ...
	      };
         
        
         $http.get('http://54.255.180.58:8080/namedcq/getnews').
    	  success(function(data, status, headers, config) {
          $scope.rps = data;

    	  }).
    	  error(function(data, status, headers, config) {
    		  
    	  });
    	  
    	//  $http.get('http://localhost:8080/namedcq/getListQAIndex').
    	  $http.get('http://54.255.180.58:8080/namedcq/getListQAIndex').
    	  success(function(data, status, headers, config) {
          $scope.qa = data;

    	  }).
    	  error(function(data, status, headers, config) {
    		  
    	  });
    
        // ฟังก์ชั่น เพิ่มข้อมูลลง datas
        $scope.addData = function (datas ) {
        
                $scope.viewMainPage = false;
         $scope.viewAnsPage = false;
          $scope.viewNewsPage = true;
          
            datas.push($scope.data);
            $scope.data = {};
            var req = {
             		 method: 'POST',
             		 url: 'http://54.255.180.58:8080/namedcq/setNews',
             		 headers: {
             		   'Content-Type': 'application/json; charset=utf-8'
             		 },
          		 data: { 
       				"hotNewsName":$scope.datas[0].NewsName,
       				"hotNews": $scope.datas[0].News
       			       }
             		 }
              $http(req).
              success(function(data, status, headers, config) {
              //  alert( "Is ok message: " + status);
                window.location.reload();
              }).
              error(function(data, status, headers, config) {
           //     alert( "failure message: " + status);
                window.location.reload();
             
              });
            
        };
        
     $scope.Dedata = function (){
          window.location.reload();
     		 alert( "Dedata ");
     };
     
          $scope.addNews = function (){
                  $scope.viewMainPage = false;
         $scope.viewAnsPage = true;
          $scope.viewNewsPage = false;
     };
     
       	 $scope.ansData = function (rp) {
    		 var index = $scope.qa.indexOf(rp);
    	
    		           $scope.viewMainPage = false;
         $scope.viewAnsPage = true;
          $scope.viewNewsPage = false;
    		 
    		 alert( "Is ok rps : " + index);
    		 
    		 $scope.data.textareaQ = $scope.qa[index].questions;
    		 $scope.data.textareaAns = $scope.qa[index].answers;
    		 $scope.data.ownA = $scope.qa[index].ownA;
    		 
    		 
    		   	  $scope.options = {
     			language: 'en',
  	  			allowedContent: true,
  	  			entities: false
 	 		};

 	 // Called when the editor is completely ready.
	 		 $scope.onReady = function () {
    
					  };
    	    
    		 
    		 alert( "Is ok rps : 1" + $scope.qa[index].qid);
    	
    		 

    		 $scope.addDataAns = function (datas) { 
    			 datas.push($scope.data);
 	            $scope.data = {};
    		 

 	           
	            var req = {
	             		 method: 'POST',
	             	//	 url: 'http://localhost:8080/namedcq/updateQAns',
	             	     url: 'http://54.255.180.58:8080/namedcq/updateQAns',
	             		 headers: {
	             		   'Content-Type': 'application/json; charset=utf-8'
	             		 },
	          		 data: { 
	       			 "qid":$scope.qa[index].qid,
	       			 "questions":$scope.qa[index].questions,
		       		 "answers":$scope.datas[0].textareaAns,
		       		 "ownQ":$scope.qa[index].ownQ,
                     "ownA" : $scope.datas[0].ownA,
                     "qGroup" : $scope.qa[index].qGroup
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
    		 
    	 };
    
    
    
    
    });
    


    

})();

