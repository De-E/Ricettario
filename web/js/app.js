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
    }).when("/insertR", {
        templateUrl : "view/insertRicetta.html",
        controller : "insertRicettaController"
    });
});

application.controller("controller", function($scope, $http)
{
});

application.controller("listRicettaController", function ($scope, $http)
{
    /**
     * Clean the list space.
     * 
     */
    $scope.clean = function()
    {
        var oldelements = document.getElementById("listRicettaContainer");
        oldelements.innerHTML = "";
        oldelements.appendChild(document.createElement("hr"));
        delete oldelements;
    }
    
    /**
     * Fill the list space with array content.
     * @param {vector} array array of ricette.
     */
    $scope.enroll = function(array)
    {
        var listRicettaContainer = document.getElementById("listRicettaContainer");
                
        for(var i=0; i<array.length; i++)
        {
            var newelement = document.createElement("div");
            newelement.setAttribute("class","post-preview");
            var a = document.createElement("a");
            a.setAttribute("href","#!/readR/"+array[i].idr);

            var h = document.createElement("h2");
            h.setAttribute("class","post-title");
            h.innerHTML=array[i].namer;
            a.appendChild(h);
            h = document.createElement("h3");
            h.setAttribute("class","post-subtitle");
            h.innerHTML=array[i].shortdescr;
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
    }
    
    $scope.list = function()
    {
        $http.get('/Ricettario/listR').
            then(function(response) {
                
                //clean previous elements
                $scope.clean();
                
                //insert new elements
                $scope.enroll(response.data);
        });
    };
    
    $scope.search = function ()
    {
        var param = document.getElementById("searchbar").value;
        
        $http.get("/Ricettario/searchR?param=" + param)
            .then(function (response)
            {
                $scope.clean();
                $scope.enroll(response.data);
            });
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
                
                document.getElementById("namer").innerHTML = rest.namer;
                
                document.getElementById("descr").innerHTML = rest.descr;
            });
        
        $http.get("/Ricettario/readIR?idr="+id)
            .then(function (response)
            {
                var rest = response.data;
                
                var ingredients = document.getElementById("ingredients");
                var table = document.createElement("table");
                table.setAttribute("style", "width:100%")
                
                for (var i=0; i<rest.length; i++)
                {
                    var tr = document.createElement("tr");
                    var td = document.createElement("td");
                    td.innerHTML = rest[i].qt;
                    tr.appendChild(td);
                    var td = document.createElement("td");
                    td.innerHTML = rest[i].unit;
                    tr.appendChild(td);
                    var td = document.createElement("td");
                    td.innerHTML = rest[i].namei;
                    tr.appendChild(td);
                    
                    table.appendChild(tr);    
                }
                ingredients.appendChild(table);
                ingredients.appendChild(document.createElement("hr"));
            });
    };
});

application.controller("insertRicettaController", function ($scope, $http)
{    
    $scope.listIngredients = function ()
    {
        $http.get("/Ricettario/listI")
                .then(function (response)
                {
                    var rest = response.data;
                    var select = document.getElementById("ilist");
                    for(var i=0; i<rest.length; i++)
                    {
                        var option = document.createElement("option");
                        option.innerHTML = rest[i].namei;
                        option.setAttribute("id",rest[i].idi);
                        select.appendChild(option);
                    }
                });
    };
    
    $scope.addIngredient = function ()
    {
        var ingredient = document.getElementById("ingredient").cloneNode(true);
        var ingredients = document.getElementById("ingredients");
        ingredients.appendChild(ingredient);
    };
    
    $scope.newIngredient = function ()
    {
        var namei = prompt("Nome ingrediente", "Inserire il nome");
        var ingredient = {
            idi: 0,
            namei: namei
        };
        $http.post("/Ricettario/insertI", ingredient)
                .then(function (response)
        {
            if(response.data==true)
            {
                alert("Inserted");
                location.reload();
            }else{
                alert("Error");
            }
        });
    };
    
    $scope.insertRecipe = function ()
    {
        var namer = document.getElementById("namer").value;
        var timer = document.getElementById("timer").value;
        var temp = document.getElementById("temp").value;
        var descr = document.getElementById("descr").value;
        var shortdescr = document.getElementById("shortdescr").innerHTML;
        
        var recipe = {
            "idr": 0,
            "namer": namer,
            "timer": timer,
            "temp": temp,
            "descr": descr,
            "shortdescr": shortdescr
        };
        $http.post('/Ricettario/insertR', recipe)
            .then(function(response)
            {
                var ir = response.data;
                var list = [];
                
                var ingredients = document.getElementById("ingredients").getElementsByTagName("tr");
                for(var i=0; i<ingredients.length; i++)
                {
                    var ii = ingredients[i]
                            .getElementsByTagName("select")
                            .ilist[ingredients[i].getElementsByTagName("select").ilist.selectedIndex]
                            .id;
                    var qt = ingredients[i].getElementsByTagName("input").qt.value;
                    var unit = ingredients[i].getElementsByTagName("input").unit.value;
                    
                    var recipeingredient = {
                        recipeingredientPK: {idr: ir, idi: ii},
                        qt: qt,
                        unit: unit,
                    };
                    
                    list[i] = recipeingredient;
                }
                $http.post("/Ricettario/insertRI", list)
                        .then(function (response) {});
                location.reload();
            });
    };
    
    $scope.insertIngredientRecipe = function (elements)
    {
                
    };
});