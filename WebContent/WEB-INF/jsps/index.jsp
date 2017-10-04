<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
		<meta charset="utf-8">
	    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	    
	    
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

	 <script src="<c:url value="/plugins/sweetalert/sweetalert.min.js" />"></script>
	 <script src="<c:url value="/plugins/sweetalert/sweetalert-dev.js" />"></script>
	
    <!-- Custom Js -->
    
    <script src="<c:url value="/js/pages/ui/dialogs.js" />"></script>

    <!-- Demo Js -->
    <script src="<c:url value="/js/demo.js" />"></script>
	
	    
    <!-- Favicon-->
 <!-- Google Fonts -->
    <link href="<c:url value="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="https://fonts.googleapis.com/icon?family=Material+Icons" />" rel="stylesheet" type="text/css">

	<!-- SweetAlert CSS -->
	 <link href="<c:url value="/plugins/sweetalert/sweetalert.css" />" rel="stylesheet" type="text/css">


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
		
		
		<script type="text/javascript">
		
		
		function showConfirmMessage(id,username) {
			
			swal({
				 title: "Are you sure?",
			        text: "You will not be able to recover the deleted User!",
			        type: "warning",
			        showCancelButton: true,
			        confirmButtonColor: "#DD6B55",
			        confirmButtonText: "Yes, delete it!",
			        closeOnConfirm: false
				},
				function(isConfirm){
					 if (!isConfirm){ 
						 alert("Cannot even go to ajx request");
						 return;}
						$.ajax({
							url: "/LogManagement/deleteUser.html?id="+id+"&username="+username,
                            type: "GET",		
                            success: function () {
                            	
                	            location.href = "/LogManagement/index.html?username="+username
                            },
							error: function () {
							swal("Oops", "We couldn't connect to the server!!!Sorry!!!", "error");
							}
                        });         
										
				});
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
                            </script><i class="material-icons">input</i>Sign Out</a></li>
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
		<div class="block-header">
                <h2>
                    USER LIST
                    
                </h2>
                <br>
                <br>
                		<button type="button" class="btn bg-red waves-effect" onclick="location.href='addUser.html'">Add User</button>
     </div>
		<div class="row clearfix">
          <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <div class="card">
             <div class="header">
                            
              </div>
              
                  <div class="body">
                     <div class="table-responsive">
                   
                       
					    					    
										<input type="hidden" name="username" id="username2" value="">
                                        <script type="text/javascript">
                                    document.getElementById('username2').value = readCookie("username");
    							</script>		
                        <table class="table table-bordered table-striped table-hover dataTable js-exportable">
                          <thead>
                             <tr>
                                 <th>ID</th>
                                 <th>First Name</th>
                                 <th>Last Name</th>
                                 <th>Active</th>
                                 <th>Action</th>
                               </tr>
                          </thead>
                                    
                                    <tbody>
                                    
                                    <c:if test="${not empty userlist}">
		          						<c:forEach var="userlist" items="${userlist}">
	                                        <tr>
	                                        
	                                            <td><c:out value="${userlist.id}"></c:out>
	                                            
	                                          
	                                            </td>
	                                            <td><c:out value="${userlist.firstName}"></c:out></td>
	                                            <td><c:out value="${userlist.lastName}"></c:out></td>
	                                            <td> 
	                                            <c:if test="${userlist.isActive eq 1 }">
	                                            	<div class="switch">
                                            			<label><input type="checkbox" value="True" checked disabled><span class="lever switch-col-green"></span></label>
	                                        	</div>
	                                        	</c:if>
                                        		
                                        		<c:if test="${userlist.isActive eq 0 }">
	                                            	<div class="switch">
                                            			<label><input type="checkbox" disabled><span class="lever switch-col-green"></span></label>
	                                        	</div>
	                                        	</c:if>
                                        	              
	                                            </td>
	                                            
	                                             
	                                            
	                                            <td>
	                                            
		                                           <div class="row clearfix js-sweetalert">
		                                          
					    								
					    								
		                                             	<button type="button" class="btn btn-warning btn-circle waves-effect waves-circle waves-float" onclick="location.href='editUser.html?id=${userlist.id}'">
	                                    				<i class="material-icons">mode_edit</i>
	                                					</button>
		                                            
														<button type="button" class="btn bg-red btn-circle waves-effect waves-circle waves-float" onclick="showConfirmMessage('${userlist.id}',document.getElementById('username2').value)">
		                                    			<i class="material-icons">delete_forever</i>
		                                				</button>
	                                            	</div>
                                            	
	                                            </td>
	                                           
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
	

	
	
	
	
	
</body>
</html>