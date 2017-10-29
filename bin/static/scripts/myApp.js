(function(){
	var app = angular.module("myApp", []);
		
	var tasks = {};
	app.controller("TaskController",['$http', function($http){
		var self = this;
		self.deleteTask = function(taskId){
			$http.delete("/api/deleteTask/"+ taskId ).then(function(data){
				self.tasks = data.data;
			});
		}
		
		
		this.addTask = function(tasks){
			$http.post("/api/newTask", this.task).then(function (data) { 
				self.tasks = data.data;
				this.task = {};
			});
		};
		
		this.markComplete = function(taskId){
			$http.put("api/markComplete/" + taskId).then(function(data){
				self.tasks = data.data;
			});
		};
		
		this.isCompleted = function(taskStatus){
			return taskStatus != "Completed"? true:false;
		}

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
			self.tasks = data.data;
		});
	}]);
})();