'use strict';

/* Controllers */

var phonecatApp = angular.module('furryNinjas', []);

phonecatApp.controller('UsersListCtrl', function($scope) {
  $scope.users = [
    {'username': 'Leandro',
     'email': 'as@asd.com'},
  ];
});
