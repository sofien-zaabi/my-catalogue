var app=angular.module("MyCat",[]);
app.controller("CatController",function($scope,$http){
	$scope.produits=[];
	$scope.serchTerm=null;
	$scope.pageCourant=0;
	$scope.chrager=function(){
	$http.get("/produitsParST?ST="+$scope.searchTerm+"&page="+$scope.pageCourant)
	.success(function(data){
		$scope.produits=data;
		$scope.pages=new Array(data.totalPages);
	});
	};
	$scope.gotoPages=function(p){
		$scope.pageCourant=p;
		$scope.charger();
	};
});