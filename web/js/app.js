/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var application = angular.module('ricettario', []);

application.controller("controller", function($scope, $http) {
        
        $http.get('/Ricettario/ricettafindall').
            then(function(response) {
                $scope.rest = response.data;
            });
    });