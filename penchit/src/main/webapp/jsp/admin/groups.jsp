
<div class="btn-group" uib-dropdown uib-keyboard-nav style="margin-top:30px;margin-left:300px" >
        <button id="simple-btn-keyboard-nav" type="button" class="btn btn-primary" style="min-width:180px"  uib-dropdown-toggle>
            {{selectedGroupLabel}} <span class="caret"></span>
        </button>
        <ul class="uib-dropdown-menu" role="menu" style="min-width:180px" aria-labelledby="simple-btn-keyboard-nav">
            <li ng-repeat="groups in groupItems">
          <a  ng-click="selectGroup(groups);removeAllErrorMessages();">{{groups.groupName}}</a>
        </li>
        </ul>
        	<button  ng-click="addNewGroup();removeAllErrorMessages();"  class="btn btn-success" style="margin-left:50px;">Add New Group</button>
        	
         <div style="padding-top:5px;color:red;" id="groupUniqueNameError" ></div>
    </div>
    
    <form class="form-horizontal" name="groupsForm" style="margin-top:50px;margin-left:250px" role="form">
    <div class="form-group">
        <label for="groupName" class="col-sm-2 control-label">Group name</label>
        
        <div class="col-sm-4">
          <input class="form-control" id="groupName" ng-model="groupName" ng-click="removeErrorMsgs('groupNameError');" placeholder="Group Name">
        </div>
        <div style="padding-top:5px;color:red;display:none" id="groupNameError">Please enter the group name</div>
      </div> 
      <div class="form-group">
        <label for="group1" class="col-sm-2 control-label">Group 1</label>
        <div class="col-sm-4">
          <input class="form-control" id="group1" ng-model="group1" placeholder="Group1" ng-click="removeErrorMsgs('groupError1');">
        </div>
         <div style="padding-top:5px;color:red;" id="groupError1" ></div>
      </div>
      <div class="form-group">
        <label for="group2" class="col-sm-2 control-label">Group 2</label>
        <div class="col-sm-4">
          <input class="form-control" id="group2" ng-model="group2" placeholder="Group2" ng-click="removeErrorMsgs('groupError2');">
        </div>
        <div style="padding-top:5px;color:red;" id="groupError2" ></div>
      </div>
      <div class="form-group">
        <label for="group3" class="col-sm-2 control-label">Group 3</label>
        <div class="col-sm-4">
          <input class="form-control" id="group3" ng-model="group3" placeholder="Group3" ng-click="removeErrorMsgs('groupError3');">
        </div>
        <div style="padding-top:5px;color:red;" id="groupError3" ></div>
      </div>
      <div class="form-group">
        <label for="group4" class="col-sm-2 control-label">Group 4</label>
        <div class="col-sm-4">
          <input class="form-control" id="group4" ng-model="group4" placeholder="Group4" ng-click="removeErrorMsgs('groupError4');">
        </div>
        <div style="padding-top:5px;color:red;" id="groupError4" ></div>
      </div>
      <div class="form-group">
        <label for="group5" class="col-sm-2 control-label">Group 5</label>
        <div class="col-sm-4">
          <input class="form-control" id="group5" ng-model="group5" placeholder="Group5" ng-click="removeErrorMsgs('groupError5');">
        </div>
        <div style="padding-top:5px;color:red;" id="groupError5" ></div>
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

