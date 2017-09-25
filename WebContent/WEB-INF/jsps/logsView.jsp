<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
		<meta charset="utf-8">
	    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Favicon-->
 <!-- Google Fonts -->
    <link href="<c:url value="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="https://fonts.googleapis.com/icon?family=Material+Icons" />" rel="stylesheet" type="text/css">

    <!-- Bootstrap Core Css -->
    <link href="<c:url value="/plugins/bootstrap/css/bootstrap.css" />" rel="stylesheet">

    <!-- Waves Effect Css -->
    <link href="<c:url value="/plugins/node-waves/waves.css" />" rel="stylesheet" />

    <!-- Animation Css -->
    <link href="<c:url value="/plugins/animate-css/animate.css" />" rel="stylesheet" />

    <!-- Colorpicker Css -->
    <link href="<c:url value="/plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.css" />" rel="stylesheet" />

    <!-- Dropzone Css -->
    <link href="<c:url value="/plugins/dropzone/dropzone.css" />" rel="stylesheet">

    <!-- Multi Select Css -->
    <link href="<c:url value="/plugins/multi-select/css/multi-select.css" />" rel="stylesheet">

    <!-- Bootstrap Spinner Css -->
    <link href="<c:url value="/plugins/jquery-spinner/css/bootstrap-spinner.css" />" rel="stylesheet">

    <!-- Bootstrap Tagsinput Css -->
    <link href="<c:url value="/plugins/bootstrap-tagsinput/bootstrap-tagsinput.css" />" rel="stylesheet">

    <!-- Bootstrap Select Css -->
    <link href="<c:url value="/plugins/bootstrap-select/css/bootstrap-select.css" />" rel="stylesheet" />

    <!-- noUISlider Css -->
    <link href="<c:url value="/plugins/nouislider/nouislider.min.css" />" rel="stylesheet" />

    <!-- Custom Css -->
    <link href="<c:url value="/css/style.css" />" rel="stylesheet">

    <!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
    <link href="<c:url value="/css/themes/all-themes.css" />" rel="stylesheet" />
		<!--[if lt IE 9]>
		<script src="js/html5shiv.js"></script>
		<script src="js/respond.min.js"></script>
		<![endif]-->
		
		<script type="text/javascript">
		
		function viewAccordingLCM(){
			
			var logtypeselect = document.getElementById('logtypeselect');
			var categoryselect = document.getElementById('categoryselect');
			var moduleselect = document.getElementById('moduleselect');
			var selItems1 = "";
			var selItems2 = "";
			var selItems3 = "";
			for(i=0;i<logtypeselect.options.length;i+=1){
			  if(logtypeselect.options[i].selected){
			    selItems1 = selItems1 + logtypeselect.options[i].value + "&";
			  }
			}
			// Remove the last splitter
			selItems1 = selItems1.substr(0,selItems1.length-1);
			
			
			for(i=0;i<categoryselect.options.length;i+=1){
				  if(categoryselect.options[i].selected){
				    selItems2 = selItems2 + categoryselect.options[i].value + "&";
				  }
				}
				// Remove the last splitter
				selItems2 = selItems2.substr(0,selItems2.length-1);
				
				for(i=0;i<moduleselect.options.length;i+=1){
					  if(moduleselect.options[i].selected){
					    selItems3 = selItems3 + moduleselect.options[i].value + "&";
					  }
					}
					// Remove the last splitter
					selItems3 = selItems3.substr(0,selItems3.length-1);
			alert("logtype->"+selItems1+"category->"+selItems2+"module->"+selItems3);
			
			
				
				$.ajax({
                    type: "GET",
                    url: "/LogManagement/logViewSelect.html?logtype="+selItems1+"&module="+selItems2+"&category="+selItems3,
                    success: function (data) {
                    	
                    }
                })
                .done(function(data) {
    	            swal("Deleted!", "Your user was successfully deleted!", "success");
    	            location.href = "/LogManagement/index.html"
    	          })
    	          .error(function(data) {
    	            swal("Oops", "We couldn't connect to the server!", "error");
    	          });
				
			
		
			
			
			
			
			//logViewSelect.html?logtype=${logtype},category=${category},module=${module}
		}
		
		</script>
		
		
		
		
	</head>
<body class="theme-red">
			<nav class="navbar">
        <div class="container-fluid">
            <div class="navbar-header">
                <a href="javascript:void(0);" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false"></a>
                <a href="javascript:void(0);" class="bars"></a>
                <a class="navbar-brand" href="../../index.html">LOG MANAGEMENT</a>
            </div>
            <div class="collapse navbar-collapse" id="navbar-collapse">
                
            </div>
        </div>
    </nav>
		
	 <section>
	 		 <aside id="leftsidebar" class="sidebar">
            <!-- User Info -->
            <div class="user-info">
                <div class="image">
                    <img src="<c:url value="/images/user.png" />" width="48" height="48" alt="User" />
                </div>
                <div class="info-container">
                    <div class="name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Master</div>
                    
                    <div class="btn-group user-helper-dropdown">
                        <i class="material-icons" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">keyboard_arrow_down</i>
                        <ul class="dropdown-menu pull-right">
                            
                            <li role="seperator" class="divider"></li>
                            <li><a href="<c:url value="/login.jsp" />"><i class="material-icons">input</i>Sign Out</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- #User Info -->
            <!-- Menu -->
           <div class="menu">
                <ul class="list">
                    <li class="header">MAIN NAVIGATION</li>
                    <li>
                        <a href="<c:url value="/logGroupHome.html" />">
                            <i class="material-icons">home</i>
                            <span>Logs</span>
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/index.html" />">
                            <i class="material-icons">face</i>
                            <span>Users</span>
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/logTypeView.html" />">
                            <i class="material-icons">list</i>
                            <span>LogType</span>
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/categoryView.html" />">
                            <i class="material-icons">layers</i>
                            <span>Category</span>
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/moduleView.html" />">
                            <i class="material-icons">widgets</i>
                            <span>Module</span>
                        </a>
                       
                    </li>
                    <li class="active"></li>
                </ul>
            </div>
            <!-- #Menu -->
            <!-- Footer -->
            
            <!-- #Footer -->
        </aside>
	 
	 </section>
	
	
	
	<section class="content">
	<div class="container-fluid">
		<div class="block-header">
                <h2>
                    LOG GROUP LIST
                    
                </h2>
                <br>
                <br>
                <div class="row clearfix">
                <form:form method="POST" action="/LogManagement/logsView.html">
                                
                               <c:if test="${not empty logtype && not empty category && not empty module}">
                               <div class="col-sm-2">
                             LOGTYPE: <select id="logtypeselect" class="form-control show-tick" name="logtypeselect" multiple>
                                     
		          						<c:forEach var="logtype" items="${logtype}">
                                        <option value="<c:out value="${logtype}"></c:out>"  <c:if test="${paramValues.path == logtype}"> selected="selected"</c:if>><c:out value="${logtype}"></c:out></option>
                                       </c:forEach>
                                   
                                    </select>
                                    
                                </div>
                                 <div class="col-sm-2">
                                   CATEGORY: <select id="categoryselect" class="form-control show-tick" name="category" multiple>
                                       
                                       <c:forEach var="category" items="${category}">
                                        <option value="<c:out value="${category}"></c:out>"><c:out value="${category}"></c:out></option>
                                        </c:forEach>
                                    </select>
                                </div>
                                 <div class="col-sm-2">
                                  MODULE:  <select id="moduleselect" class="form-control show-tick" name="module" multiple>
                                       <c:forEach var="module" items="${module}">
                                        <option value="<c:out value="${module}"></c:out>"><c:out value="${module}"></c:out></option>
                                        </c:forEach>
                                    </select>
                                </div>
                              <br><button type="button" class="btn bg-red waves-effect" onclick="viewAccordingLCM()">Search</button> <!-- location.href='logViewSelect.html?logtype=${logtype},category=${category},module=${module}'  -->
                              <button type="button" class="btn bg-red waves-effect" onclick="location.href='logGroupHome.html'">Log Group Page</button>
                              </c:if>
                              </form:form>
                            </div>
            </div>
			<div class="row clearfix">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header">
                                                        
                        </div>
                        <div class="body">
                            <div class="table-responsive">
                                <table class="table table-bordered table-striped table-hover dataTable js-exportable">
                                    <thead>
                                        <tr>
                                            <th>Function ID</th>
                                            <th>Test Code</th>
                                            <th>Message</th>
                                            <th>Filename</th>
                                            <th>Location</th>
                                            <th>Line</th>
                                            
                                        </tr>
                                    </thead>
                                    
                                    <tbody>
                                    <c:if test="${not empty logslist}">
		          						<c:forEach var="logslist" items="${logslist}">
	                                        <tr>
	                                            <td><c:out value="${logslist.functionId}"></c:out></td>
	                                            <td><c:out value="${logslist.testCode}"></c:out></td>
	                                           <td><c:out value="${logslist.message}"></c:out></td>
	                                           <td><c:out value="${logslist.filename}"></c:out></td>
	                                            <td><c:out value="${logslist.location}"></c:out></td>
	                                            <td><c:out value="${logslist.line}"></c:out></td>
	                                            
	                                           
	                                        </tr>
                                       </c:forEach>
                                    </c:if>
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
			</div><!--/.row-->
		
	
	</section>
	

	
	<script src="<c:url value="/plugins/jquery/jquery.min.js" />"></script>

    <!-- Bootstrap Core Js -->
    <script src="<c:url value="/plugins/bootstrap/js/bootstrap.js" />"></script>

    <!-- Select Plugin Js -->
    <script src="<c:url value="/plugins/bootstrap-select/js/bootstrap-select.js" />" ></script>

    <!-- Slimscroll Plugin Js -->
    <script src="<c:url value="/plugins/jquery-slimscroll/jquery.slimscroll.js" />"></script>

    <!-- Waves Effect Plugin Js -->
    <script src="<c:url value="/plugins/node-waves/waves.js" />"></script>

    <!-- Jquery DataTable Plugin Js -->
    <script src="<c:url value="/plugins/jquery-datatable/jquery.dataTables.js" />"></script>
    <script src="<c:url value="/plugins/jquery-datatable/skin/bootstrap/js/dataTables.bootstrap.js" />"></script>
    <script src="<c:url value="/plugins/jquery-datatable/extensions/export/dataTables.buttons.min.js" />"></script>
    <script src="<c:url value="/plugins/jquery-datatable/extensions/export/buttons.flash.min.js" />"></script>
    <script src="<c:url value="/plugins/jquery-datatable/extensions/export/jszip.min.js" />"></script>
    <script src="<c:url value="/plugins/jquery-datatable/extensions/export/pdfmake.min.js" />"></script>
    <script src="<c:url value="/plugins/jquery-datatable/extensions/export/vfs_fonts.js" />"></script>
    <script src="<c:url value="/plugins/jquery-datatable/extensions/export/buttons.html5.min.js" />"></script>
    <script src="<c:url value="/plugins/jquery-datatable/extensions/export/buttons.print.min.js" />"></script>

    <!-- Custom Js -->
    <script src="<c:url value="/js/admin.js" />"></script>
    <script src="<c:url value="/js/pages/tables/jquery-datatable.js" />"></script>

    <!-- Demo Js -->
    <script src="<c:url value="/js/demo.js" />"></script>
	
	
	
	
</body>
</html>









<%-- <section class="content">
	<div class="container-fluid">
		<div class="block-header">
                <h2>
                    LOG LIST
                    
                </h2>
                <br>
                <br>
                	
                            <div class="row clearfix">
                                <div class="col-sm-2">
                                    <select class="form-control show-tick" name="Logtype">
                                        <option value="">-- LOGTYPE --</option>
                                        <option value="10">10</option>
                                        <option value="20">20</option>
                                        <option value="30">30</option>
                                        <option value="40">40</option>
                                        <option value="50">50</option>
                                    </select>
                                </div>
                                 <div class="col-sm-2">
                                    <select class="form-control show-tick" name="category">
                                        <option value="">-- CATEGORY --</option>
                                        <option value="10">10</option>
                                        <option value="20">20</option>
                                        <option value="30">30</option>
                                        <option value="40">40</option>
                                        <option value="50">50</option>
                                    </select>
                                </div>
                                 <div class="col-sm-2">
                                    <select class="form-control show-tick" name="module">
                                        <option value="">-- MODULE --</option>
                                        <option value="10">10</option>
                                        <option value="20">20</option>
                                        <option value="30">30</option>
                                        <option value="40">40</option>
                                        <option value="50">50</option>
                                    </select>
                                </div>
                              <button type="button" class="btn bg-red waves-effect" onclick="location.href='addUser.html'">Search</button>
                                                           
                            </div>
                        
                
            </div>
			<div class="row clearfix">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header">
                            
                            
                        </div>
                        <div class="body">
                            <div class="table-responsive">
                                <table class="table table-bordered table-striped table-hover dataTable js-exportable">
                                    <thead>
                                        <tr>
                                            <th>Function ID</th>
                                            <th>Test Code</th>
                                            <th>Message</th>
                                            <th>Filename</th>
                                            <th>Action</th>
                                            
                                        </tr>
                                    </thead>
                                    
                                    <tbody>
                                    <c:if test="${not empty userlist}">
		          						<c:forEach var="userlist" items="${userlist}"> 
	                                        <tr>
	                                            <td><c:out value="${userlist.id}"></c:out></td>
	                                            <td><c:out value="${userlist.firstName}"></c:out></td>
	                                            <td><c:out value="${userlist.lastName}"></c:out></td>
	                                            <td>
	                                            <input type="checkbox" class="filled-in" checked />                            
	                                            </td>
	                                            <td></td>
	                                           
	                                        </tr>
                                      </c:forEach>
                                    </c:if> 
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
			</div><!--/.row-->
		
	
	</section>
	 --%>
