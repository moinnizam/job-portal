angular.module('jobApp', ['ngRoute'])
.config(function($routeProvider){
  $routeProvider
    .when('/login', { templateUrl: 'login.html', controller: 'LoginCtrl' })
    .when('/jobs', { templateUrl: 'jobs.html', controller: 'JobsCtrl' })
    .when('/post', { templateUrl: 'post.html', controller: 'PostCtrl' })
    .when('/profile', { templateUrl: 'profile.html', controller: 'ProfileCtrl' })
    .otherwise({ redirectTo: '/jobs' });
})

.controller('MainCtrl', function($scope, $location, Api){
  $scope.currentUser = Api.getCurrentUser();

  $scope.logout = function(){
    localStorage.removeItem('currentUser');
    $scope.currentUser = {};
    $location.path('/login');
  };
});

