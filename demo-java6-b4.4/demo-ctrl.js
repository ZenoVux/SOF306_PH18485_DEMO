let host = "https://rest-api-20613-default-rtdb.asia-southeast1.firebasedatabase.app";
const app = angular.module("app", []);
app.controller("ctrl", ($scope, $http) => {
    $scope.form = {};
    $scope.items = {};
    $scope.reset = () => {
        $scope.form = {gender: true, country: 'VN'};
        $scope.key = null;
    }
    $scope.load_all = () => {
        var url = `${host}/students.json`;
        $http.get(url).then(resp => {
            $scope.items = resp.data;
            console.log("Success", resp);
        }).catch(error => {
            console.log("Error", error);
        });
    }
    $scope.edit = (key) => {
        var url = `${host}/students/${key}.json`;
        $http.get(url).then(resp => {
            $scope.form = resp.data;
            console.log("Success", resp);
        }).catch(error => {
            console.log("Error", error);
        });
    }
    $scope.create = () => {
        var item = angular.copy($scope.form);
        var url = `${host}/students.json`;
        $http.post(url, item).then(resp => {
            $scope.key = resp.data.name;
            $scope.items[$scope.key] = item;
            $scope.reset();
            console.log("Success", resp);
        }).catch(error => {
            console.log("Error", error);
        });        
    }
    $scope.update = () => {
        var item = angular.copy($scope.form);
        var url = `${host}/students/${$scope.key}.json`;
        $http.put(url, item).then(resp => {
            $scope.items[$scope.key] = resp.data;
            console.log("Success", resp);
        }).catch(error => {
            console.log("Error", error);
        });
    }
    $scope.delete = (key) => {
        var url = `${host}/students/${key}.json`;
        $http.delete(url).then(resp => {
            delete $scope.items[key];
            $scope.reset();
            console.log("Success", resp);
        }).catch(error => {
            console.log("Error", error);
        });
    }
    $scope.load_all();
    $scope.reset();
});
