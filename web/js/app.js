/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var application = angular.module('ricettario', ['ngRoute']);

application.config(function ($routeProvider)
{
    $routeProvider
    .when("/", {
        templateUrl : "view/listRicetta.html",
        controller : "listRicettaController"
    }).when("/readR/:ID", {
        templateUrl : "view/readRicetta.html",
        controller : "readRicettaController"
    });
});

application.controller("controller", function($scope, $http)
{
    $scope.insert = function()
    {
        var ricetta = {
            idr:0,
            tempo:0,
            temperatura:0,
            nome:"",
            descrizione:"",
        };
        
        $http.post('/Ricettario/insertR', ricetta)
            .then(function(response)
            {
                $scope.rest = response.data;
            });
    };
});

application.controller("listRicettaController", function ($scope, $http)
{
    $scope.list = function()
    {
        $http.get('/Ricettario/listR').
            then(function(response) {
                var rest = response.data;
                
                //clean previous elements
                var oldelements = document.getElementsByClassName("post-preview");
                if(oldelements.length>0)
                {
                    for(var i=oldelements.length-1; i>=0; i--)
                    {
                        oldelements.item(i).outerHTML="";
                    }
                }
                delete oldelements;
                
                //insert new elements
                var listRicettaContainer = document.getElementById("listRicettaContainer");
                
                for(var i=0; i<rest.length; i++)
                {
                    var newelement = document.createElement("div");
                    newelement.setAttribute("class","post-preview");
                    var a = document.createElement("a");
                    a.setAttribute("href","#!/readR/"+rest[i].idr);
                    
                    var h = document.createElement("h2");
                    h.setAttribute("class","post-title");
                    h.innerHTML=rest[i].name;
                    a.appendChild(h);
                    h = document.createElement("h3");
                    h.setAttribute("class","post-subtitle");
                    h.innerHTML=rest[i].shortdesc;
                    a.appendChild(h);
                    
                    var p = document.createElement("p");
                    p.setAttribute("class","post-meta");
                    p.innerHTML = "Ricettario of Raffaele F. Mancino";
                    a.appendChild(p)
                    
                    newelement.appendChild(a);
                    
                    listRicettaContainer.appendChild(newelement);
                    listRicettaContainer.appendChild(
                        document.createElement("hr")
                    );
                }
                delete element;
        });
    };
    
    $scope.search = function ()
    {
        console.log(document.getElementById("searchbar").value);
    }
});

application.controller("readRicettaController", function ($scope, $http, $routeParams)
{
    var id=$routeParams.ID;
    
    $scope.getRicetta = function ()
    {
        $http.get("/Ricettario/readR?idr="+id)
            .then(function (response)
            {
                var rest = response.data;
                
                document.getElementById("name").innerHTML = rest.name;
                
                document.getElementById("desc").innerHTML = rest.desc;
            });
        
        $http.get("/Ricettario/readIR?idr="+id)
            .then(function (response)
            {
                var rest = response.data;
                var ingredients = document.getElementById("ingredients");
                for (var i=0; i<rest.length; i++)
                {
                    var div = document.createElement("div");
                    div.setAttribute("class", "align-content-center");
                    div.innerHTML = rest[i].nome;
                    
                    ingredients.appendChild(div);
                    ingredients.appendChild(document.createElement("hr"));
                }
            });
    };
});
