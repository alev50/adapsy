var app = angular.module('app', [ 'oauth' ]);

app.config(function($locationProvider, $httpProvider) {
	$locationProvider.html5Mode({
		enabled : true,
		requireBase : false
	}).hashPrefix('!');
	
	$httpProvider.interceptors.push('AuthInterceptor');
});

app.controller('societeController', function($scope, $http, $window, Endpoint, AccessToken, OAuthConfiguration) {
	OAuthConfiguration.getConfig().protectedResources = [ '/contacts' ];
	
	var oauth = {	
		site: 'https://adthurster.herokuapp.com',
		clientId: 'myClient',
		redirectUri: 'https://adthurster.herokuapp.com',
		scope: 'read',
		authorizePath: '/oauth/authorize',
		tokenPath: '/oauth/token',
		responseType: 'token',
		storage: 'sessionStorage'
	}
	
	Endpoint.set(oauth);
	AccessToken.set(oauth);
	
	$scope.logged = !!AccessToken.get();

	if (!$scope.logged) {
		Endpoint.login();
	} else {
		$http.get('https://adthurster.herokuapp.com/contacts/1').then(function(response) {
			$scope.contact = response.data;
		});
	}
	
	$scope.logout = function() {
		Endpoint.logout();
		$window.location.href = '/logout';
	}
});
