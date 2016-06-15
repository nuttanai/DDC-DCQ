(function () {
    'use strict';

    var app = angular.module('application', []);
    app.controller('demoController', function ($scope) {
        $scope.datas =[];       // เก็บข้อมูลทั้งหมดที่ถูกส่งจากฟอร์ม
        $scope.data ={};        // ข้อมูลที่ผูกกับ form
        alert($scope.data);
        // ฟังก์ชั่น เพิ่มข้อมูลลง datas
        $scope.addData = function (datas) {
            datas.push($scope.data);
            $scope.data = {};
          //  alert($scope.data);
        };
    });

})();
