
<div class="btn-group" uib-dropdown uib-keyboard-nav style="margin:0px 0px 0px 300px">

         <button id="simple-btn-keyboard-nav" type="button" class="btn btn-primary"   uib-dropdown-toggle>
            {{selectedGroupLabel}} <span class="caret"></span>
        </button>
        <ul class="uib-dropdown-menu" role="menu" style="min-width:180px" aria-labelledby="simple-btn-keyboard-nav">
            <li ng-repeat="groups in groupItems">
          <a  ng-click="selectGroup(groups);">{{groups.groupName}}</a>
        </li>
        </ul>
    </div>
    
    <div style="margin:10px 0px 0px 300px;">
        <strong> Division : </strong> {{selectedDivisionLabel}}
    </div>
    <div class="btn-group" uib-dropdown uib-keyboard-nav style="margin:10px 0px 0px 300px">

         <button id="simple-btn-keyboard-nav" type="button" class="btn btn-primary"   uib-dropdown-toggle>
            {{selectedCourseLabel}} <span class="caret"></span>
        </button>
        <ul class="uib-dropdown-menu" role="menu" style="min-width:180px" aria-labelledby="simple-btn-keyboard-nav">
            <li ng-repeat="course in courseItems">
          <a  ng-click="selectCourse(course);">{{course.courseName}}</a>
        </li>
        </ul>
        <button  ng-click="addNewGroup();removeAllErrorMessages();"  class="btn btn-success" style="margin-left:50px;">Add New Course</button>
    </div>
    
    <form class="form-horizontal" name="groupsForm" style="margin-top:50px;margin-left:250px" role="form">
    <div class="form-group">
        <label for="groupName" class="col-sm-3 control-label">Course name</label>
        
        <div class="col-sm-4">
          <input class="form-control" id="groupName" ng-model="groupName" ng-click="removeErrorMsgs('groupNameError');" placeholder="Group Name">
        </div>
        <div style="padding-top:5px;color:red;display:none" id="groupNameError">Please enter the course name</div>
      </div> 
      <div class="form-group">
        <label for="group1" class="col-sm-3 control-label">Course Description</label>
        <div class="col-sm-4">
			<textarea class="form-control custom-control" rows="3" style="resize:block"></textarea>   
        </div>
         <div style="padding-top:5px;color:red;" id="groupError1" ></div>
      </div>
      <div class="form-group">
        <label for="group2" class="col-sm-3 control-label">Course Syllabus</label>
        <div class="col-sm-4">
          <textarea class="form-control custom-control" rows="3" style="resize:block"></textarea>   
        </div>
        <div style="padding-top:5px;color:red;" id="groupError2" ></div>
      </div>
       <div class="form-group">
         <label class="control-label">Select File</label>
        <div class="col-sm-4">
          <input id="input-1" type="file" class="file">
        </div>
        <div style="padding-top:5px;color:red;" id="groupError2" ></div>
      </div>
     
	<div class="fileupload fileupload-new" data-provides="fileupload">
    <span class="btn btn-primary btn-file"><span class="fileupload-new">Select file</span>
    <span class="fileupload-exists">Change</span>         <input type="file" /></span>
    <span class="fileupload-preview"></span>
    <a href="#" class="close fileupload-exists" data-dismiss="fileupload" style="float: none">×</a>
  </div>
      <div class="form-group">
        <label for="group3" class="col-sm-3 control-label">Version</label>
        <div class="col-sm-4">
          <input class="form-control" id="group3" ng-model="group3" placeholder="Group3" ng-click="removeErrorMsgs('groupError3');">
        </div>
        <div style="padding-top:5px;color:red;" id="groupError3" ></div>
      </div>
      <div class="form-group">
        <label for="group4" class="col-sm-3 control-label">Course Price</label>
        <div class="col-sm-4">
          <input class="form-control" id="group4" ng-model="group4" placeholder="Group4" ng-click="removeErrorMsgs('groupError4');">
        </div>
        <div style="padding-top:5px;color:red;" id="groupError4" ></div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button  ng-click="addGroup();" class="btn btn-success" id="addGroupId" style="display:none">Submit</button>
          <button  ng-click="editGroup();" class="btn btn-success" id="editGroupId" style="display:none">Edit</button>
          <button  ng-click="deleteGroup();" style="margin-left:10px;" class="btn btn-success">Delete</button>
        </div>
          
        </div>
      </div>
</form>