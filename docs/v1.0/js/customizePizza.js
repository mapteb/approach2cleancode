var customizePizza = angular.module('pizzaApp', []);


customizePizza.controller('pizza', function($scope, $http) {
	var self = this;
    $scope.list = [];
    
    
    $scope.submitForm = function() {

      if ($scope.pizza) {
    	  
      	
        $scope.list.push(this.text);
        
        $scope.pizza.nextView=new Date();
        
        var urlstr = "//springboot-rest-jpa-nsorg.cfapps.io";
        //urlstr = "http://localhost:8081"
        //cache buster param
        var dt=(new Date()).getSeconds();
        
        $http({

            url: urlstr + "/pizza?dt="+dt,
            data: $scope.pizza,
            method: 'POST',
            headers : {'Content-Type':'application/json; charset=UTF-8'}

        }).success(function(data){

            console.log("OK", data);
            window.location.href='reviewCart.html';
            
        }).error(function(err){
        	"ERR", console.log(err); 
            //display success message
            $scope.pizza.status = "Submit Error";
            $scope.pizza.status_color = "label-danger"; 

        	});
        
      }};
    });


