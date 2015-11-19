<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html ng-app="headerApp">

<header> 
      <div id="logo" >
        <div id="logo_text" >
          <!-- class="logo_colour", allows you to change the colour of the text -->
          <h1> Pench <span class="logo_colour"> IT</span></h1>
          <h2>Simple.  Stable.  Consistent</h2>
        </div>
      </div>
      <nav>
        <ul class="sf-menu" id="nav"   ng-controller="locationController">
        
         <li>
	          <a title='<spring:message code="header.groups"/>'  href="#/groups">
	          		<p><spring:message code="header.groups"/></p>
	          </a>
         </li>
         <li>
	          <a title='<spring:message code="header.courses"/>'  href="#/courses">
	          		<p><spring:message code="header.courses"/></p>
	          </a>
         </li>
         <li>
	          <a title='<spring:message code="header.contact"/>'  href="#/contact">
	          		<p><spring:message code="header.contact"/></p>
	          </a>
         </li>
         
          <li><a href="about.html">Clients</a></li>
          <li><a href="portfolio.html">Gallery</a></li>
          <li><a href="contact.php">Reports</a></li>
          <li><a href="<c:url value='/logout' />" title='<spring:message code="header.logout"/>'><spring:message code="header.logout"/></a></li>
        </ul>
      </nav>
    </header>
     <script src="<c:url value='/resources/js/pages/header.js' />"></script>
     <script src="<c:url value='/resources/js/pages/groups.js' />"></script>
     <script src="<c:url value='/resources/js/pages/courses.js' />"></script>
     <script src="<c:url value='/resources/js/pages/contact.js' />"></script>
    
    </html>
