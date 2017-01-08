var customizePizza = angular.module('pizzaApp', []);

customizePizza.controller('cart', function($scope, $http) {
	var self = this;
	var url = 'http://gs-sts-cloud-foundry-deployment-nrsorg.cfapps.io/cart/items/count';
	//url = 'http://localhost:8081/cart/items/count';
	
	$http.get(url).then(function(response) {
		alert('?? called cart/items/count'+ JSON.stringify(response.data));
		self.items = response.data;
	}, function(response){alert('?? err');});
	
	
});

customizePizza.controller('pizza', function($scope, $http) {
    $scope.list = [];
    
    
    $scope.submitForm = function() {

      if ($scope.pizza) {
      	
        $scope.list.push(this.text);

        $http({

            //url: "http://localhost:8081/pizza",
            url: "http://gs-sts-cloud-foundry-deployment-nrsorg.cfapps.io/pizza",
            data: $scope.pizza,
            method: 'POST',
            headers : {'Content-Type':'application/json; charset=UTF-8'}

        }).success(function(data){

            console.log("OK", data);
            
            //TODO: update cart to reflect user's successful submission
            //TODO: angular.element(document.getElementById('cntrl1')).scope().$apply();
            
            //display success message
            $scope.pizza = {"status":"Submit success", "status_color":"label-success"};  
            

        }).error(function(err){"ERR", console.log(err)});
        
      }};
    });

