
<div class="btn-group" uib-dropdown uib-keyboard-nav style="margin:0px 0px 0px 300px">

         <button id="simple-btn-keyboard-nav" type="button" class="btn btn-primary" style="min-width:180px"  uib-dropdown-toggle>
            {{selectedGroupLabel}} <span class="caret"></span>
        </button>
        <ul class="uib-dropdown-menu" role="menu" style="min-width:180px" aria-labelledby="simple-btn-keyboard-nav">
            <li ng-repeat="groups in groupItems">
         	 <a  ng-click="selectGroup(groups);removeAllErrorMessagesInCourse();">{{groups.groupName}}</a>
        	</li>
        </ul>
        <span style="padding:10px 0px 0px 20px;color:red;display:none" id="groupNameError">Please select the Group Name</span>
    </div>
    
    <div style="margin:10px 0px 0px 300px;">
        <strong> Division : </strong> {{selectedDivisionLabel}}
    </div>
    <div class="btn-group" uib-dropdown uib-keyboard-nav style="margin:10px 0px 0px 300px">

         <button id="simple-btn-keyboard-nav" type="button" class="btn btn-primary" style="min-width:180px"   uib-dropdown-toggle>
            {{selectedCourseLabel}} <span class="caret"></span>
        </button>
        <ul class="uib-dropdown-menu" role="menu" style="min-width:180px" aria-labelledby="simple-btn-keyboard-nav">
            <li ng-repeat="course in courseItems">
          <a  ng-click="selectCourse(course);">{{course.courseName}}</a>
        </li>
        </ul>
        <button  ng-click="addNewCourse();removeAllErrorMessagesInCourse();"  class="btn btn-success" style="margin-left:50px;">Add New Course</button>
        <div style="padding:10px 0px 0px 20px;color:red;display:none" id="courseNameEmptyError">Please select the Course Name</div>
        
    </div>
    
    <form class="form-horizontal" name="groupsForm" style="margin-top:50px;margin-left:250px" role="form">
    <div class="form-group">
        <label for="groupName" class="col-sm-3 control-label">Course name</label>
        
        <div class="col-sm-4">
          <input class="form-control" id="courseName" ng-model="courseName" ng-click="removeErrorMessage('courseNameError');" placeholder="Course Name">
        </div>
        <div style="padding-top:5px;color:red;display:none" id="courseNameError">Please enter the Course Name</div>
      </div> 
      <div class="form-group">
        <label for="group1" class="col-sm-3 control-label">Course Description</label>
        <div class="col-sm-4">
			<textarea class="form-control custom-control" id="courseDesc" ng-model="courseDesc" ng-click="removeErrorMessage('courseDescError');"  rows="3" style="resize:block" placeholder="Course Description"></textarea>   
        </div>
         <div style="padding-top:5px;color:red;display:none" id="courseDescError" >Please enter the Course Description</div>
      </div>
      <div class="form-group">
        <label for="group2" class="col-sm-3 control-label">Course Syllabus</label>
        <div class="col-sm-4">
          <textarea class="form-control custom-control" rows="3" id="courseSyllabus" ng-model="courseSyllabus" ng-click="removeErrorMessage('courseSyllabusError');" style="resize:block" placeholder="Course Syllabus"></textarea>   
        </div>
        <div style="padding-top:5px;color:red;display:none" id="courseSyllabusError" >Please enter the Course Syllabus</div>
      </div>
      <div class="form-group">
        <label for="group2" class="col-sm-3 control-label">Upload Logo</label>
        <div class="col-sm-5">
          <input type="file" class="filestyle" id="logoId" onchange="angular.element(this).scope().uploadFile(this.files)"  id="courseLogo"  ng-click="removeErrorMessage('courseLogoError');" data-placeholder="No file">
        </div>
        <div style="padding-top:5px;color:red;display:none" id="courseLogoError" >Please enter the Course Logo</div>
      </div>
      
      <div class="form-group" style="display:none" id="viewLogo">
        <label for="group2" class="col-sm-3 control-label">View Logo</label>
        <div class="col-sm-5" style="padding-top:8px">
           <a  ng-click="viewLogo();" id="logoName"  style="cursor: pointer;"  ></a>
        </div>
        <div style="padding-top:5px;color:red;display:none" id="courseLogoError" >Please enter the Course Logo</div>
      </div>
       
     

      <div class="form-group">
        <label for="group3" class="col-sm-3 control-label">Version</label>
        <div class="col-sm-4">
          <input class="form-control" id="versionId" ng-model="versionId" placeholder="Version" ng-click="removeErrorMessage('versionError');">
        </div>
        <div style="padding-top:5px;color:red;display:none" id="versionError" ></div>
      </div>
      <div class="form-group">
        <label for="group4" class="col-sm-3 control-label">Course Price</label>
        <div class="col-sm-4">
          <input class="form-control" id="coursePrice" ng-model="coursePrice" placeholder="Course Price" ng-click="removeErrorMessage('coursePriceError');">
        </div>
        <div style="padding-top:5px;color:red;display:none" id="coursePriceError" >Please enter the Course Price</div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button  ng-click="addCourse();" class="btn btn-success" id="addCourseId" style="display:none">Submit</button>
          <button  ng-click="editCourse();" class="btn btn-success" id="editCourseId" style="display:none">Edit</button>
          <button  ng-click="deleteCourse();" style="margin-left:10px;" class="btn btn-success">Delete</button>
        </div>
          
        </div>
      </div>
      <div id="courseLogoContent" style="display:none" />
       <div id="courseId" style="display:none" />
       <div id="courseLogoNameId" style="display:none" />
</form>
<div  id="imageModalContent">
        <div class="modal-header">
            <h3 class="modal-title">Image</h3>
        </div>
        <div class="modal-body" style="padding-left:80px;">
            <img src="#"  id="imgSrcId" style="height:120px;width:100px;" />
        </div>
        <div class="modal-footer">
            <button class="btn btn-primary" type="button" ng-click="closeImageDialog();">OK</button>
        </div>
</div>