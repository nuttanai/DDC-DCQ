(function () {
    'use strict';

var app = angular.module('application', ['ckeditor']);
    app.controller('demoController', function ($scope,$http,$q,$sce) {
        $scope.datas =[];       // เก็บข้อมูลทั้งหมดที่ถูกส่งจากฟอร์ม
        $scope.data ={};        // ข้อมูลที่ผูกกับ form
        $scope.rps =[];
        $scope.docid=[];
        $scope.choices = [{id: ''}];
        var setid = 0 ;
         $scope.myHTML = "";
         
           
         
    	$http.get('http://54.255.180.58:8080/namedcq/getListDocAll').
    	  success(function(data, status, headers, config) {
          $scope.rps = data;

    	  }).
    	  error(function(data, status, headers, config) {
    		  
    	  });
  
  $scope.options = {
    language: 'en',
    allowedContent: true,
    entities: false
  };

  // Called when the editor is completely ready.
  $scope.onReady = function () {
    // ...
  };
 
 
        // ฟังก์ชั่น เพิ่มข้อมูลลง datas
        $scope.addData = function (datas,choice) {
        	  datas.push($scope.data);
              $scope.data = {};
           //   alert("ROCK" + $scope.datas[0].textareaDocHowTo);
           
           $scope.trustedExample = $sce.trustAsHtml($scope.datas[0].textareaDocHowTo);
           
        
              var deferred = $q.defer();
              var promise = deferred.promise;
              deferred.resolve("nothing");
            $scope.myHTML = $scope.datas[0].textareaDocHowTo;
              promise.then(function(promise) {
            	  console.log( "then(function(promise):  11111111111");
            	  var req = {
                   		 method: 'POST',
                    		 url: 'http://54.255.180.58:8080/namedcq/setDocDetail',
                    		 headers: {
                    		   'Content-Type': 'application/json; charset=utf-8'
                    		 },
                 		 data: { 
                 			 
                            "docDetail" : $scope.datas[0].textareaDocName.docHierarchyName,
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
           	           url: 'http://54.255.180.58:8080/namedcq/getDocDetail',
           	           headers: {
           	             'Content-Type': 'application/json; charset=utf-8'
           	           },
           	        data: { 
           	                "docHierarchyName" : $scope.datas[0].textareaDocName.docHierarchyName
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
            	        url: 'http://54.255.180.58:8080/namedcq/setDocLink',
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
            	  
            	  
              }).then(function(promise) {
            	  console.log( "then(function(promise):  44444444444444");
            	  
        

            	    console.log( "Is ok message: parseInt(setid) " + $scope.docid.docDetailId);
            	    
            	    var req4 = {
            	        method: 'POST',
            	        url: 'http://54.255.180.58:8080/namedcq/updateDocHi',
            	        headers: {
            	          'Content-Type': 'application/json; charset=utf-8'
            	        },
            	     data: {                    
            	           "docHierarchyId" :  $scope.datas[0].textareaDocName.docHierarchyId,
            	           "docHierarchyName" :  $scope.datas[0].textareaDocName.docHierarchyName,
            	           "docHierarchyOwner" :  $scope.datas[0].textareaDocName.docHierarchyOwner,
            	           "docDetail" : 1
            	          }
            	        }
            	    $http(req4).
            	    success(function(data, status, headers, config) {
            	      console.log( "Is ok message for updateDocHi: " + status);

            	    }).
            	    error(function(data, status, headers, config) {
            	      console.log( "failure message for updateDocHi: " + status);

            	    });
            	    
            	 
            	  
            	  
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
    
    app.directive('taskManager', function(){
    return {
        restrict: 'A', // ชนิดของ Directive 'E'lement or 'A'ttribute
        templateUrl: 'docdetail.html', // เป็นส่วนที่กำหนด template ภายในของ directive ตัวนั้น
        controller: function () {
        
        CKEDITOR.replace('editor1');
        
        $(".textarea").wysihtml5();
        
        }, // ในกรณีที่จำเป็นต้องใช้การคิด Logic หรือมีฟังก์ชั่นการทำงาน
        link: function () {} //ส่วนที่ทำการ binding event ให้กับองค์ประกอบใน directive
         
    };
});
    

})();
