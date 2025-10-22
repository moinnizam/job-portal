angular.module('jobApp')
.factory('Api', function($http){
  var base = '/api';
  return {
    jobs: function(){ return $http.get(base + '/jobs'); },
    postJob: function(job){ return $http.post(base + '/jobs', job); },
    saveUser: function(user){ return $http.post(base + '/users', user); },
    apply: function(application){ return $http.post(base + '/applications', application); },
    login: function(email){ return $http.post('/api/auth/login', { email: email }); },
    getCurrentUser: function(){ return JSON.parse(localStorage.getItem('currentUser') || '{}'); }

  };
});