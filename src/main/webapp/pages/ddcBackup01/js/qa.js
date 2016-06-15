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
		 $scope.viewAnsPage = false;
    
        $scope.rps =[];
        // ฟังก์ชั่น เพิ่มข้อมูลลง datas
        
    	$http.get('http://localhost:8080/namedcq/getQA').
  	  success(function(data, status, headers, config) {
        $scope.rps = data;
        
		    	$http.get('http://localhost:8080/namedcq/getListQCat').
		  	  success(function(data, status, headers, config) {
		        $scope.rpscat = data;
		
		  	  }).
		  	  error(function(data, status, headers, config) {
		  		  
		  	  });
		        
        

  	  }).
  	  error(function(data, status, headers, config) {
  		  
  	  });
    	 $scope.delData = function (rp) {
    	 
    		 var index = $scope.rps.indexOf(rp);
    		 alert( "Is ok rps : " + $scope.rps[index].qid);
    		 
    	        var req = {
	             		 method: 'POST',
	             		 url: 'http://localhost:8080/namedcq/delQAns',
	             		 headers: {
	             		   'Content-Type': 'application/json; charset=utf-8'
	             		 },
	          		 data: { 
	       			 "qid":$scope.rps[index].qid
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
    	 
     	$scope.back = function (rp) {
     		 $scope.viewDataPage = true;
    		 $scope.viewUpdatePage = false;
    		 $scope.viewAnsPage = false;
       	};
    	
    	 $scope.ansData = function (rp) {
    		 var index = $scope.rps.indexOf(rp);
    		 $scope.viewDataPage = false;
    		 $scope.viewUpdatePage = false;
    		 $scope.viewAnsPage = true;
    		// alert( "Is ok rps : " + index);
    		 
    		 $scope.data.textareaQ = $scope.rps[index].questions;
    		 $scope.data.textareaAns = $scope.rps[index].answers;
    		 $scope.data.ownA = $scope.rps[index].ownA;
    		 
    	    
    		 
    	//	 alert( "Is ok rps : 1" + $scope.rps[index].qid);
    	//	 alert( "Is ok rps : 2" + $scope.rps[index].questions);
    	//	 alert( "Is ok rps : 3" + $scope.rps[index].answers);
    	//	 alert( "Is ok rps : 4" + $scope.rps[index].ownQ);
    	//	 alert( "Is ok rps : 5" + $scope.rps[index].ownA);
    	//	 alert( "Is ok rps : 6" + $scope.rps[index].qGroup);
    		 

    		 $scope.addDataAns = function (datas) { 
    			 datas.push($scope.data);
 	            $scope.data = {};
    		 

 	            
       		    		// alert( "Is ok rps : 7" + $scope.datas[0].textareaAns);
    		    		// alert( "Is ok rps : 8" + $scope.datas[0].ownA);
	            var req = {
	             		 method: 'POST',
	             		 url: 'http://localhost:8080/namedcq/updateQAns',
	             		 headers: {
	             		   'Content-Type': 'application/json; charset=utf-8'
	             		 },
	          		 data: { 
	       			 "qid":$scope.rps[index].qid,
	       			 "questions":$scope.rps[index].questions,
		       		 "answers":$scope.datas[0].textareaAns,
		       		 "ownQ":$scope.rps[index].ownQ,
                     "ownA" : $scope.datas[0].ownA,
                     "qGroup" : $scope.rps[index].qGroup
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
    	 
    	 $scope.updateData = function (rp) {
    		 
    		 $scope.viewDataPage = false;
    		 $scope.viewUpdatePage = true;
    		 $scope.viewAnsPage = false;
    		  
        	
        		 var index = $scope.rps.indexOf(rp);
        		 
        		
        		 
        
        	//	 $scope.data.NewsName = $scope.rps[index].hotNewsName;
        	//	 $scope.data.News = $scope.rps[index].hotNews;
        		 
         		 $scope.data.textareaQ = $scope.rps[index].questions;
        		 $scope.data.textareaAns = $scope.rps[index].answers;
        		 $scope.data.ownA = $scope.rps[index].ownA;
        		 $scope.data.ownQ = $scope.rps[index].ownQ;
        		 
        		 
     	        $scope.addDataUpdate = function (datas ) {
    	            datas.push($scope.data);
    	            $scope.data = {};
    	         //   alert( "failure index: " + index);
    	            alert( "Is ok docDetailId : " );
    	         //   alert( "failure docDetail: " + $scope.datas[0].textareaDocName );
    	         
    	       	   //   		 alert( "Is ok rps : 1-" + $scope.rps[index].qid);
    	      	   //   		 alert( "Is ok rps : 2" + $scope.datas[0].textareaQ);
    	      	   //    		 alert( "Is ok rps : 3" + $scope.datas[0].textareaAns);
    	      	    //   		 alert( "Is ok rps : 4" + $scope.datas[0].ownQ);
    	      	      // 		 alert( "Is ok rps : 5" + $scope.datas[0].ownA);
    	      	       	//	 alert( "Is ok rps : 6 $scope.rps[index].qGroup  " + $scope.rps[index].qGroup);
    	           
    	           
    	            var req = {
   	             		 method: 'POST',
   	             		 url: 'http://localhost:8080/namedcq/updateQAns',
   	             		 headers: {
   	             		   'Content-Type': 'application/json; charset=utf-8'
   	             		 },
   	          		 data: { 
               		 "qid":$scope.rps[index].qid,
	       			 "questions":$scope.datas[0].textareaQ,
		       		 "answers":$scope.datas[0].textareaAns,
		       		 "ownQ":$scope.datas[0].ownQ,
                     "ownA" : $scope.datas[0].ownA,
                     "qGroup" :$scope.rps[index].qGroup
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
        		 
        		 
        		 
        		 
        		 

//        		 $scope.data.textareaQ = $scope.rps[index].hotNewsName;
  //      		 $scope.data.textareaAns = $scope.rps[index].hotNews;
        	//	 $scope.data.ownQ = $scope.rps[index].hotNews;
        	//	 $scope.data.ownA = $scope.rps[index].hotNews;
        		 
             //    <h3>Qcat : {{data.selectQcat}}</h3>

           //      <h3>Q : {{data.textareaQ}}</h3>

             //    <h3>Ans : {{data.textareaAns}}</h3>

            //     <h3>OwnQ : {{data.ownQ}}</h3>

            //     <h3>OwnA : {{data.ownA}}</h3>
                 
                 
        		// alert( "Is ok rps : " + $scope.rps[index].hotNewsName);
                 
                 
        		// alert( "Is ok rps : " + $scope.rps[index].hotNewsName);
        		 
        		 
        		 
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
