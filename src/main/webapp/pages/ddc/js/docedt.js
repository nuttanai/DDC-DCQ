(function () {
    'use strict';

    var app = angular.module('application', ['ngSanitize','ckeditor']);
    app.controller('demoController', function ($scope,$http,$sce)  {
        $scope.datas =[];       // เก็บข้อมูลทั้งหมดที่ถูกส่งจากฟอร์ม
        $scope.data ={};        // ข้อมูลที่ผูกกับ form
        $scope.datarps = {};
        $scope.rowCollection = [];
        
    
        $scope.rps =[];
        
        $scope.dataDocLink ={}; 
        $scope.dataDocLinks =[];
        
        $scope.myVar2 = true;
        $scope.myVar = false;
        // ฟังก์ชั่น เพิ่มข้อมูลลง datas
        
        
        
       
        
    	$http.get('http://54.255.180.58:8080/namedcq/getListDocDe').
  	  success(function(data, status, headers, config) {
        $scope.rps = data;
         $scope.trustedExample = $sce.trustAsHtml( $scope.rps.docHowTo);
        
        

  	  }).
  	  error(function(data, status, headers, config) {
  		  
  	  });
    	$scope.back = function (rp) {
   		 $scope.myVar = false;
		 $scope.myVar2 = true;
    	};
    	$scope.delData = function (rp) {
  //  		 $scope.myVar = true;
    //		 $scope.myVar2 = false;
	 
    		 var index = $scope.rps.indexOf(rp);
    		alert( "Is ok rps : " + $scope.rps[index].docDetail);
    //		 myService.set($scope.rps[index].docDetail);
    		 
    		 var req = {
             		 method: 'POST',
             		 url: 'http://54.255.180.58:8080/namedcq/delDocDetail',
             		 headers: {
             		   'Content-Type': 'application/json; charset=utf-8'
             		 },
          		 data: { 
       				"docDetailId":$scope.rps[index].docDetailId
       			       }
             		 }
              $http(req).
              success(function(data, status, headers, config) {
                alert( "Is ok message: " + status);
                
              }).
              error(function(data, status, headers, config) {
                alert( "failure message: " + status);
                window.location.reload();
             
              });
    		 
    		 
    	 };
    	 
    	 $scope.updateData = function (rp) {

        		 var index = $scope.rps.indexOf(rp);
//        		 alert( "Is ok rps : " + $scope.rps[index].docDetail);
  //      		 alert( "Is ok rps : " + $scope.rps[index].docDetailId);
        		 $scope.myVar = true;
        		 $scope.myVar2 = false;
        		 
        		 
        		 
        		 
 	            var reqGetDocLink = {
	             		 method: 'POST',
	             		 url: 'http://54.255.180.58:8080/namedcq/getDocLink',
	             		 headers: {
	             		   'Content-Type': 'application/json; charset=utf-8'
	             		 },
	          		 data: { 
	       				"docLinkId":$scope.rps[index].docDetailId,
	       			       }
	             		 }
	              $http(reqGetDocLink).
	              success(function(data, status, headers, config) {
	                alert( "Is ok message: " + status);
	              //  alert( "Is ok rps : " + $scope.dataDocLinks);
	                $scope.dataDocLinks = data;
	        		$scope.choices =  $scope.dataDocLinks;
	        		
	        		 
	        		 
	        		 
	              }).
	              error(function(data, status, headers, config) {
	                alert( "failure message: " + status);
	             
	              });
        		 
        		 
        		 $scope.data.textareaDocName = $scope.rps[index].docDetail;
        		 $scope.data.textareaDocHowTo = $scope.rps[index].docHowTo;
        		 
        		   $scope.options = {
 				   language: 'en',
 				   allowedContent: true,
 				   entities: false
 					 };

  					// Called when the editor is completely ready.
  					$scope.onReady = function () {
  						 $scope.data.textareaDocHowTo = $scope.rps[index].docHowTo;
  					};
 

        		 
        	        $scope.addDataUpdate = function (datas,choice) {
        	            datas.push($scope.data);
        	            $scope.data = {};
        	            alert( " index is : " + index);
       
         			  
        	            var req = {
        	             		 method: 'POST',
        	             		 url: 'http://54.255.180.58:8080/namedcq/updateDocDetail',
        	             		 headers: {
        	             		   'Content-Type': 'application/json; charset=utf-8'
        	             		 },
        	          		 data: { 
        	       				"docDetailId":$scope.rps[index].docDetailId,
                                "docDetail" : $scope.datas[0].textareaDocName,
                                "docHowTo" : $scope.datas[0].textareaDocHowTo
                               
        	       			       }
        	             		 }
        	              $http(req).
        	              success(function(data, status, headers, config) {
        	           // 	  alert( "Is ok 1 message: " + status +"data is " + $scope.choice);
        	              //  alert( "Is ok 2 message: " + status +"data is " + $scope.choices);
        	                var x ;
        	                for (x in $scope.choices) {
        	                	
                	    	    

                           	 //   console.log( "Is ok message: parseInt(setid) " + $scope.docid.docDetailId);
               	    	    	 
        	                	console.log( "Is ok message: parseInt(docLinkId) " + $scope.choices[x].docLinkId);
        	                	 console.log( "Is ok message: parseInt(docLinkOwner) " + $scope.choices[x].docLinkOwner);
        	                	 console.log( "Is ok message: parseInt(docLink) " + $scope.choices[x].docLink);
        	                	var req3 = {
                           	        method: 'POST',
                           	        url: 'http://54.255.180.58:8080/namedcq/updateDocLink',
                           	        headers: {
                           	          'Content-Type': 'application/json; charset=utf-8'
                           	        },
                           	     data: {     
                           	    	 	"docLinkId" : $scope.choices[x].docLinkId,
                           	           "docLinkOwner" : $scope.choices[x].docLinkOwner,
                           	           "docLink" : $scope.choices[x].docLink 
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
        	               window.location.reload();
        	              }).
        	              error(function(data, status, headers, config) {
        	                alert( "failure message: " + status);
        	                window.location.reload();
        	             
        	              });
        	            
        	    	
        	            
        	            
        	            
        	        };
        		 
        		 
        		 
        	 };
        
        
        $scope.addData = function (datas ) {
            datas.push($scope.data);
            $scope.data = {};
            alert( "Is ok message: " + $scope.datas[0].QCat);
          
            var req = {
             		 method: 'POST',
             		 url: 'http://54.255.180.58:8080/namedcq/setQCat',
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