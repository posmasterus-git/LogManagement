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
	
		<script type="text/javascript">
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
                            <li><a href="<c:url value="javascript:logoutvoid()" />">
                            <script type="text/javascript">
                            function delete_cookie( name ) {
							  document.cookie = name + '=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
							}
                            
                            function logoutvoid(){
                            	var name= delete_cookie('username');
								$.ajax({
	                            type: "GET",
	                            url: "/LogManagement/login.jsp",
	                            success: function (data) {
	                            	 location.href = "/LogManagement"
	                            }
	                        })
                            }
                            </script>

<i class="material-icons">input</i>Sign Out</a></li>
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
                         <script>
								
									function logGroupHomemethod(){
										var name= readCookie('username');
										$.ajax({
			                            type: "GET",
			                            url: "/LogManagement/logGroupHome.html?username="+name,
			                            success: function (data) {
			                            	 location.href = "/LogManagement/logGroupHome.html?username="+name
			                            }
			                        })
								}
								</script>
                        <a href="<c:url value="javascript:logGroupHomemethod()" />">
                    
                        
                            <i class="material-icons">home</i>
                            <span>Logs</span>
                        </a>
                    </li>
                    <li>
                     
                    			  <script>
								
									function abc(){
										var name= readCookie('username');
										$.ajax({
			                            type: "GET",
			                            url: "/LogManagement/index.html?username="+name,
			                            success: function (data) {
			                            	 location.href = "/LogManagement/index.html?username="+name
			                            }
			                        })
								}
								</script>
                        <a href="<c:url value="javascript:abc()" />">
                        
                         
                            <i class="material-icons">face</i>
                            <span>Users</span>
                        </a>
                    </li>
                    <li>
                    <script>
								
									function logtypeViewmethod(){
										var name= readCookie('username');
										$.ajax({
			                            type: "GET",
			                            url: "/LogManagement/logTypeView.html?username="+name,
			                            success: function (data) {
			                            	 location.href = "/LogManagement/logTypeView.html?username="+name
			                            }
			                        })
								}
								</script>
                        <a href="<c:url value="javascript:logtypeViewmethod()" />">
                        <!-- <a href="<c:url value="/logTypeView.html" />"> -->
                            <i class="material-icons">list</i>
                            <span>LogType</span>
                        </a>
                    </li>
                    <li>
                    
                    	<script>
								
									function categoryViewmethod(){
										var name= readCookie('username');
										$.ajax({
			                            type: "GET",
			                            url: "/LogManagement/categoryView.html?username="+name,
			                            success: function (data) {
			                            	 location.href = "/LogManagement/categoryView.html?username="+name
			                            }
			                        })
								}
								</script>
                        <a href="<c:url value="javascript:categoryViewmethod()" />">
                    
                       <!-- <a href="<c:url value="/categoryView.html" />"> --> 
                            <i class="material-icons">layers</i>
                            <span>Category</span>
                        </a>
                    </li>
                    <li>
                    
                    	<script>
								
									function moduleViewmethod(){
										var name= readCookie('username');
										$.ajax({
			                            type: "GET",
			                            url: "/LogManagement/moduleView.html?username="+name,
			                            success: function (data) {
			                            	 location.href = "/LogManagement/moduleView.html?username="+name
			                            }
			                        })
								}
								</script>
                        <a href="<c:url value="javascript:moduleViewmethod()" />">
                    
                       <!--<a href="<c:url value="/moduleView.html" />">  --> 
                            <i class="material-icons">widgets</i>
                            <span>Module</span>
                        </a>
                    </li>
                    <li>
                     <a href="<c:url value="/apiList.html" />"> 
                    <i class="material-icons">view_list</i>
                    <span>APIs</span>
                    </a>
                    </li>
                    <li class="active"> </li>
                       
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
                            <h2>ADD LOG TYPE</h2>
                            
                        </div>
                        <div class="body">
                            <form id="form_advanced_validation" method="POST" action="/LogManagement/logTypeView.html">
                                <div class="form-group form-float">
                                    <div class="form-line">
                                        <input type="text" class="form-control" name="name" minlength="3" required/>
                                        <label class="form-label">Log-type</label>
                                    </div>
                                    <div class="help-info"></div>
                                </div>
                                <div class="form-group form-float">
                                    <div class="form-line">
                                        <input type="text" name="subcode" class="form-control" required/>
                                        <label class="form-label">SUB Code</label>
                                    </div>
                                   </div> 
                                  
                                     <div class="form-group form-float">
                                    <div class="form-line">
                                         <textarea rows="4" name="description" class="form-control no-resize" ></textarea>
                                        <label class="form-label">Description</label>
                                    </div>
                                    </div>
                                    
		                                    
										<input type="hidden" name="username" id="username2" value="">
                                        <script type="text/javascript">
                                    document.getElementById('username2').value = readCookie("username");
    							</script>
                                <div class="form-group form-float">
                                    <div class="form-line">
                                    		<input type="hidden" name="active">
                                            <input type="checkbox" name="active" class="filled-in" id="ig_checkbox" />
                                            <label for="ig_checkbox">Active</label>
                                       
                                    </div>
                                        
                                    </div>
                             
                              
                           <div class="body">
	                            <div class="row clearfix js-sweetalert">
	                                 <button class="btn btn-primary waves-effect" type="submit" onclick="location.href='logTypeView.html'">SUBMIT</button>
	                                 <button class="btn btn-primary waves-effect" data-type="cancel">CANCEL</button> 
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