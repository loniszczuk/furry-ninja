'use strict';

/* Controllers */

var furryNinjasApp = angular.module('furryNinjas', []);

furryNinjasApp.controller('UsersListCtrl', function($scope, $http) {
  $http.get('/users').success(function(data){
    $scope.users = data;
  });
});
