angular.module('hello', []).controller('home', function($http) {
	var self = this;
	var url = 'http://gs-sts-cloud-foundry-deployment-nrsorg.cfapps.io/greeting';
	url = 'http://localhost:8081/greeting?name=foobar';
	$http.get(url).then(function(response) {
		self.greeting = response.data;
	}, function(response){alert('?? err');})
});
