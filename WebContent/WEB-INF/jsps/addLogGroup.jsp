<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Log Mgmt - Login</title>
	
	
	 <!-- Google Fonts -->
    <link href="<c:url value="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="https://fonts.googleapis.com/icon?family=Material+Icons" />" rel="stylesheet" type="text/css">

    <!-- Bootstrap Core Css -->
    <link href="<c:url value="/plugins/bootstrap/css/bootstrap.css" />" rel="stylesheet">

    <!-- Waves Effect Css -->
    <link href="<c:url value="/plugins/node-waves/waves.css" />" rel="stylesheet" />

    <!-- Animation Css -->
    <link href="<c:url value="/plugins/animate-css/animate.css" />" rel="stylesheet" />

      <!-- Custom Css -->
    <link href="<c:url value="/css/style.css" />" rel="stylesheet">

    <!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
    <link href="<c:url value="/css/themes/all-themes.css" />" rel="stylesheet" />
	
	
	<%-- <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css" />" />
	<link rel="stylesheet" href="<c:url value="/css/datepicker3.css" />"/>
	<link rel="stylesheet" href="<c:url value="/css/styles.css" />" /> --%>
	<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<script src="js/respond.min.js"></script>
	<![endif]-->
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
                        <a href="<c:url value="/moduleView.html" />" class="menu-toggle">
                            <i class="material-icons">widgets</i>
                            <span>Module</span>
                        </a>
                       
                    </li>
                 
                    <li class="active">
                       
                    </li>
                    
                       
                </ul>
            </div>
            <!-- #Menu -->
            <!-- Footer -->
            
            <!-- #Footer -->
        </aside>
	 
	 </section>
	 
	 <section class="content">
        <div class="container-fluid">
	  <!-- Advanced Validation -->
            <div class="row clearfix">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header">
                            <h2>ADD LOG GROUP</h2>
                            
                        </div>
                        <div class="body">
                            <form id="form_addLogGroup" method="POST" action="/LogManagement/logGroupHome.html">
                                <div class="form-group form-float">
                                    <div class="form-line">
                                        <input type="text" class="form-control" name="logroupid" maxlength="10" minlength="3" required/>
                                        <label class="form-label">LogGroup ID</label>
                                    </div>
                                    <div class="help-info">Group ID to identify log group</div>
                                </div>
                               
                               <div class="form-group form-float">
                                    <div class="form-line">
                                        <input type="text" name="name" class="form-control" />
                                        <label class="form-label">Name</label>
                                    </div>
                                   </div> 
                                <div class="form-group form-float">
                                    <div class="form-line">
                                         <textarea rows="4" name="description" class="form-control no-resize" ></textarea>
                                        <label class="form-label">Description</label>
                                    </div>
                                    </div>
                                    
		                                    <script>
											function readCookie(cname) {
										    var name = cname + "=";
										    var ca = document.cookie.split(';');
										    for(var i=0; i<ca.length; i++) {
										        var c = ca[i];
										        while (c.charAt(0)==' ') c = c.substring(1);
										        if (c.indexOf(name) == 0) return c.substring(name.length, c.length);
										    }
										    return "";
										}
										</script>
										<input type="hidden" name="username" id="username2" value="">
                                        <script type="text/javascript">
                                    document.getElementById('username2').value = readCookie("username");
    							</script>
                               
                                <div class="form-group form-float">
                                    <div class="form-line">
                                    		<input type="hidden" name="active">
                                            <input type="checkbox" name="active" class="filled-in" id="ig_checkbox" checked/>
                                            <label for="ig_checkbox">Active</label>
                                       
                                    </div>
                                </div>
                             
                              
                           <div class="body">
	                            <div class="row clearfix js-sweetalert">
	                                 <button class="btn btn-primary waves-effect" type="submit" onclick="location.href='index.html'">SUBMIT</button>
	                                 <button class="btn btn-primary waves-effect" data-type="cancel" onclick="myFunction()" value="Reset">CANCEL</button> 
	                            			<script>
										function myFunction() {
    										document.getElementById("form_addLogGroup").reset();
											}
											</script>
	                            </div>
                           </div>
                                 
                            </form>
                        </div>
                    </div>
                </div>
            </div>
	 
	 
	 
	 </div>
	 </section>
	
	
	
</body>


<script src="<c:url value="/plugins/jquery/jquery.min.js" />"></script>

    <!-- Bootstrap Core Js -->
    <script src="<c:url value="/plugins/bootstrap/js/bootstrap.js" />"></script>

    <!-- Select Plugin Js -->
    <script src="<c:url value="/plugins/bootstrap-select/js/bootstrap-select.js" />" ></script>

    <!-- Slimscroll Plugin Js -->
    <script src="<c:url value="/plugins/jquery-slimscroll/jquery.slimscroll.js" />"></script>

    <!-- Waves Effect Plugin Js -->
    <script src="<c:url value="/plugins/node-waves/waves.js" />"></script>
    
     <!-- SweetAlert Plugin Js -->
    <script src="<c:url value="/plugins/sweetalert/sweetalert.min.js" />"></script>
    <!-- Bootstrap Notify Plugin Js -->
    <script src="<c:url value="/plugins/bootstrap-notify/bootstrap-notify.js" />"></script>
    

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
	 <script src="<c:url value="/js/pages/ui/dialogs.js" />"></script>
    <!-- Demo Js -->
    <script src="<c:url value="/js/demo.js" />"></script>
</html>