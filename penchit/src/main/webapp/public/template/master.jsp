<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html>
<head>
        <title><spring:message  code="project.title" /></title>
         <meta name="description" content="website description" />
  		<meta name="keywords" content="website keywords, website keywords" />
  		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  		<link href="<c:url value='/resources/css/main_style.css'/>" rel="stylesheet" type="text/css" />
        <link href="<c:url value='/resources/css/project_style.css'/>" rel="stylesheet" type="text/css" />
        <script src="<c:url value='/resources/js/angular.min.js' />"></script>
        <script src="<c:url value='/resources/js/angular-route.min.js' />"></script>
        <script src="<c:url value='/resources/js/ui-bootstrap-tpls-0.14.3.min.js' />"></script>
        <script src="<c:url value='/resources/js/jquery-1.9.1.min.js' />"></script>
        <script src="<c:url value='/resources/js/bootstrap-filestyle.min.js' />"></script>
        <script src="<c:url value='/resources/js/common.js' />"></script>
      	<link href="<c:url value='/resources/css/bootstrap.min.css'  />" rel="stylesheet" id="bootStrapId"/>
        
    
    </head>
<script type="text/javascript">
    var _contextPath = "${pageContext.request.contextPath}";
</script>
    <body>
        	<div id="main">
           
            <tiles:insertAttribute name="header" />

            <tiles:insertAttribute name="body" />
            
            <tiles:insertAttribute name="footer" />
        </div>

        <!--[if IE]>
            <script src="<c:url value='/resources/js/bootstrap.min.ie.js' />"></script>
        <![endif]-->
        <!--[if !IE]><!-->
            <script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
        <!--<![endif]-->

        
    </body>
</html>