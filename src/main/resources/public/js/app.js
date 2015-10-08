var app  = angular.module("app", ["ngResource", "ngRoute", "oitozero.ngSweetAlert"]);

app.config(function($routeProvider) {
	$routeProvider
	.when("/home"      ,{templateUrl :  "/views/home.html"        })
	.when("/ads"       ,{templateUrl :  "/views/ads/list.html"    })
	.when("/ad/:id?"   ,{templateUrl :  "/views/ads/form.html"    })
	.when("/"          ,{redirectTo  :  "/home"                   })
	.otherwise({redirectTo : "/"});
});


app.factory("userService"        , function($resource){ return $resource("/api/users/:id");          });
app.factory("roleService"        , function($resource){ return $resource("/api/roles/:id");          });
app.factory("brandService"       , function($resource){ return $resource("/api/brands/:id");         });
app.factory("modelService"       , function($resource){ return $resource("/api/models/:id");         });
app.factory("adService"          , function($resource){ return $resource("/api/ads/:id");            });
app.factory("connexionService"   , function($resource){ return $resource("/api/connexions/:id");     });
app.factory("searchQueryService" , function($resource){ return $resource("/api/searchqueries/:id");  });

