angular.module('jobApp')
.controller('JobsCtrl', function($scope, Api){
  Api.jobs().then(function(res){ $scope.jobs = res.data; });
  $scope.apply = function(jobId){
    var application = { userId: 1, jobId: jobId };
    Api.apply(application).then(function(){ alert('Applied!'); });
  };
})
.controller('PostCtrl', function($scope, Api){
  $scope.job = {};
  $scope.postJob = function(){ Api.postJob($scope.job).then(function(){ alert('Posted'); $scope.job = {}; }); };
})
.controller('ProfileCtrl', function($scope, Api){
  $scope.user = Api.getCurrentUser();

  $scope.saveProfile = function(){
    Api.saveUser($scope.user).then(function(res){
      alert('Profile saved');
      localStorage.setItem('currentUser', JSON.stringify(res.data)); // update stored user
      $scope.user = res.data;
    });
  };
});

.controller('LoginCtrl', function($scope, $location, Api){
  $scope.login = function(){
    Api.login($scope.email).then(function(res){
      localStorage.setItem('currentUser', JSON.stringify(res.data));
      $location.path('/jobs');
    });
  };
})
$scope.apply = function(jobId){
  var user = Api.getCurrentUser();
  if(!user.userId){ alert('Login first'); return; }

  var application = { userId: user.userId, jobId: jobId };
  Api.apply(application).then(function(){ alert('Applied!'); });
};


