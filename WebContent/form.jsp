<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>form</title>
<s:head theme="xhtml" /> 
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.1/angular.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://bootswatch.com/4/flatly/bootstrap.min.css">
<%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/css/form.css"> --%>
<script>

function MyController($scope,$http){
	$scope.Message = '測試';
	
	$scope.getDataFromServer = function(){
// 		$scope.empVO = {'eid':$scope.eid+' return','ename':$scope.Message};
		var parameter = {
				eid:$scope.eid
		};
		var parameterJson = angular.toJson(parameter);
		alert('running'+parameterJson);
		$http({
			method:'post',
			url:'<%=request.getContextPath()%>/angularAction.action',
			params:{
				eid:$scope.eid
			}
			
		}).success(function(data){
// 			$scope.empVO = {'eid':data.eid,'ename':data.ename};
			alert('sucess'+data);
			console.log(data);
			$scope.empVO = data;

		}).error(function(data){
			alert('fail');
			
		});
	};
}


</script>


</head>
<body>

<div class="container">
  <div class="jumbotron">
    <h1>Welcome</h1>
    <h2>Angular & Bootstrap Demo</h2>
  </div>
<!--   <div class="panel panel-primary"> -->
<!--     <div class="panel-heading">Status</div> -->
<!--     <div class="panel-body"> -->
<!--       <h3>{{title}}</h3> -->
<!--     </div> -->
<!--   </div> -->
</div>

<div class="container" >
	<div class="row">
		<div class="col-xs-12 col-md-4 block1 text-center">
			
			  <div class="panel panel-primary">
			    <div class="panel-heading">新增員工</div>
			    <div class="panel-body">
					<s:form action="add" namespace="/myNamespace">
					    <s:textfield name="empVO.ename" label="員工姓名"  value="peter666" />   
					    <s:submit value="送出showOne" />
					    <s:submit value="送出listAll" method="add" />    
					
					</s:form>
			    </div>
			  </div>
			

		</div>


		<div class="col-xs12 col-md-8" ng-app>
			<div class="row">
		        <div ng-controller="MyController" class="col-xs-6 col-md-6 block2 text-center" >
	        		  <div class="panel panel-info">
					    <div class="panel-heading">查詢員工(angular ajax)</div>
					    <div class="panel-body">
						    <input type="text" ng-model="eid">
			                <button ng-click="getDataFromServer()">Fetch data from server</button>
			                <p>員工編號 : {{ empVO.eid || 'guest' }}</p>		                
			                <p>員工姓名 : {{ empVO.ename ||Message }}</p>
					    </div>
					  </div>

		         </div>      
		         <div class="col-xs-12 col-md-6 block3 text-center" >
		         	  <div class="panel panel-danger">
					    <div class="panel-heading">angular 基本功能</div>
					    <div class="panel-body">
						    <p>{{cname || 'guest'}}! 你好</p>   
						    <input type="text" ng-model="cname"> 
					    </div>
					  </div>

		 		</div>
		 	</div>
	 	</div>
 	</div>
 </div>



</body>

<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</html>