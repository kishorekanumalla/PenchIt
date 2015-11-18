<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<body>
    <div id="site_content">
      <div id="sidebar_container">
       
      </div>
      <div id="content">
      <div id="welcomeContent">
	        <h1>Welcome to Pench IT</h1>
	        <p>This standards compliant, fixed width website template is released as an 'open source' design (under a <a href="http://creativecommons.org/licenses/by/3.0">Creative Commons Attribution 3.0 Licence</a>), which means that you are free to use it for anything you want (including modifying and amending it). All I ask is that you leave the 'design from css3templates.co.uk' link in the footer of the template. All of the photos were taken by me - use as you wish.</p>
	        <h3>Browser Compatibility</h3>
	        <p>This template has been tested in the following browsers:</p>
	        <ul>
	          <li>Internet Explorer 8</li>
	          <li>Internet Explorer 7</li>
	          <li>FireFox 10</li>
	          <li>Google Chrome 17</li>
	        </ul>
	      </div> 
	      
	         <div ng-view></div>
	 </div>
	 
        
      
    </div>
    
</body>

<script type="text/ng-template" id="successModalContent.html">
        <div class="modal-header">
            <h3 class="modal-title">SUCCESS</h3>
        </div>
        <div class="modal-body">
            Action performed successfully
        </div>
        <div class="modal-footer">
            <button class="btn btn-primary" type="button" ng-click="ok()">OK</button>
        </div>
</script>


