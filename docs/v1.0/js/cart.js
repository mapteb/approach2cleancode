var customizePizza = angular.module('cartApp', []);

customizePizza.controller('cart', function($scope, $http) {
	
	var self = this;
	
	//cache buster param
	var dt = (new Date()).getSeconds();
	

    var urlstr = "http://springboot-rest-jpa-nsorg.cfapps.io";
    //urlstr = "http://localhost:8081"
	
	url = urlstr + '/cart/items/count?dt='+dt;
	
	$http.get(url).then(function(response) {
		self.items = response.data;
	}, function(response){alert('?? err');});
	
	
});

