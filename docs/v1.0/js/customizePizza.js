var customizePizza = angular.module('pizzaApp', []);


customizePizza.controller('pizza', function($scope, $http) {
	var self = this;
    $scope.list = [];
    
    
    $scope.submitForm = function() {

      if ($scope.pizza) {
    	  
    	  
      	
        $scope.list.push(this.text);
        
        if($scope.pizza.toppingMushroom)$scope.pizza.toppingMushroom='Y';
        if($scope.pizza.toppingPepperoni)$scope.pizza.toppingPepperoni='Y';
        if($scope.pizza.toppingSpinach)$scope.pizza.toppingSpinach='Y';
        $scope.pizza.nextView=new Date();
        
        var urlstr = "http://springboot-rest-jpa-nsorg.cfapps.io";
        //urlstr = "http://localhost:8081"
        //cache buster param
        var dt=(new Date()).getSeconds();
        
        $http({

            url: urlstr + "/pizza?dt="+dt,
            
            //url: "http://gs-sts-cloud-foundry-deployment-nrsorg.cfapps.io/pizza",
            data: $scope.pizza,
            method: 'POST',
            headers : {'Content-Type':'application/json; charset=UTF-8'}

        }).success(function(data){

            console.log("OK", data);
            
            //TODO: update cart to reflect user's successful submission
            //angular.element(document.getElementById('cntrl1')).scope().callrest();
            
            //$scope.$parent.callrest();
            
            
            
            
            //self.pizza = $scope.pizza;
            window.location.href='reviewCart.html';
            
            

        }).error(function(err){
        	"ERR", console.log(err); 
        			
            //display success message
            $scope.pizza.status = "Submit Error";
            $scope.pizza.status_color = "label-danger"; 

        	});
        
      }};
    });


