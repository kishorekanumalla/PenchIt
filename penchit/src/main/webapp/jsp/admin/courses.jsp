
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
         Division : {{selectedDivisionLabel}}
    </div>
    <div class="btn-group" uib-dropdown uib-keyboard-nav style="margin:10px 0px 0px 300px">

         <button id="simple-btn-keyboard-nav" type="button" class="btn btn-primary"   uib-dropdown-toggle>
            {{selectedCourseLabel}} <span class="caret"></span>
        </button>
        <ul class="uib-dropdown-menu" role="menu" style="min-width:180px" aria-labelledby="simple-btn-keyboard-nav">
            <li ng-repeat="course in courseItems">
          <a  ng-click="selectCourse(groups);">{{course.groupName}}</a>
        </li>
        </ul>
    </div>