var DataApp = angular.module('DataApp', []);

DataApp.controller('DataController', ['DataFactory', function(DataFactory){
        
        var self = this;
        
        self.data = [];
        
        self.getRandomData = function (num, input){
            
            DataFactory.getRandomData(num, input).then(function (success){
                
                self.data = success.data;
                
            }, function (error){
                
                console.log("something went wrong");
            });
        };
        
}]);

DataApp.factory('DataFactory', ['$http', function ($http){
        
        var getRandomData = function (num, input){
            
            var url = "api/addresses" + num + "/" + input;
            
            return $http.get(url);
        };
        
        return  {
            
            getRandomData: getRandomData
        };
}]);
