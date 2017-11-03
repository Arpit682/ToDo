(function(){
    var app = angular.module("myApp", []);

    app.controller("TaskController",['$http', '$scope', function($http, $scope){
        var self = this;
        self.deleteTask = function(task){
            $http.delete("/api/deleteTask/"+ task.id).then(function(data){
                var index = $scope.tasks.indexOf(task);
                $scope.tasks.splice(index, 1);
            });
        };

        this.addTask = function(){
            var task = this.task;
            $http.post("/api/newTask", task).then(function (data) { 
                $scope.tasks.push(data.data);
                task.taskDescription = "";
            });
        };

        this.markComplete = function(task){
            $http.put("api/markComplete/" + task.id).then(function(data){
                task.taskStatus = "Completed";
                task.completionDate = data.data.completionDate;
            });
        };

        this.isCompleted = function(taskStatus){
            return taskStatus != "Completed"? true:false;
        };

        this.tab = function(tab, status){
            if(tab==1) {
                return true;
            }
            if(tab==2 && status=="Completed") {
                return true;
            }
            if(tab==3 && status=="Pending") {
                return true;
            }
        }

        $http.get("/api/allTasks.json").then(function(data){
            $scope.tasks = data.data;
        });
    }]);
})();