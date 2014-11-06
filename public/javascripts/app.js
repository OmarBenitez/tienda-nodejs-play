angular.module('tienditaApp', ['ngResource']).config(function($routeProvider) {
    $routeProvider
            .when('/', {
                templateUrl: 'public/views/home.html'
                , controller: 'home'})
            .when('/detalle/', {
                templateUrl: 'public/views/detalle.html'
                , controller: 'detalle'
            })
            .when('/add/', {
                templateUrl: 'public/views/new.html'
                , controller: 'nuevo'
            })
            .otherwise({redirectTo: '/'});
}).factory('appFactory', function($http, $rootScope) {

    var service = {};
    service.data = [];

    service.sendEvent = function(event) {
        $rootScope.$broadcast(event);
    }

    service.load = function() {
        $http.get('productos.json').success(function(data) {
            service.data = data;
            service.sendEvent('productos');
        })
    };

    return service;

}).controller('main', function($scope) {

}).controller('home', function($scope, appFactory) {
    $scope.prods = [];
    appFactory.load();
    $scope.$on('productos', function() {
        $scope.prods = appFactory.data;
    });
}).controller('detalle', function($scope, appFactory) {
    $scope.prods = [];
    appFactory.load();
    $scope.$on('productos', function() {
        $scope.prods = appFactory.data;
    });
}).controller('nuevo', function($scope) {
    $scope.send = function(dato){
        
    };
})

        ;
