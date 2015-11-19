<div class="form-group">
        <h3 style="margin-left:350px;color:#3276b1"><strong>Contact Info</strong></h3>
    <form class="form-horizontal" name="contactForm" style="margin-top:50px;margin-left:150px" role="form">
    
    
    <div class="form-group">
        <label for="contactName" class="col-sm-4 control-label">Contact name</label>
        
        <div class="col-sm-4">
          <input class="form-control" id="contactName" ng-model="contactName" ng-click="" placeholder="Contact Name">
        </div>
      </div> 
      <div class="form-group">
        <label for="contactEmailId" class="col-sm-4 control-label">Contact Email Id</label>
        <div class="col-sm-4">
          <input class="form-control" id="contactEmailId" ng-model="contactEmailId" placeholder="Contact Email Id" ng-click="">
        </div>
      </div>
      <div class="form-group">
        <label for="contactLandLineNo" class="col-sm-4 control-label">Contact LandLine Number</label>
        <div class="col-sm-4">
          <input class="form-control" id="contactLandLineNo" ng-model="contactLandLineNo" placeholder="Contact LandLine Number" ng-click="">
        </div>
      </div>
      <div class="form-group">
        <label for="contactMobileNo" class="col-sm-4 control-label">Contact Mobile Number</label>
        <div class="col-sm-4">
          <input class="form-control" id="contactMobileNo" ng-model="contactMobileNo" placeholder="Contact Mobile Number" ng-click="">
        </div>
      </div>
      <div class="form-group" style="margin-left:200px">
        <label for="aboutUs" class="col-sm-4 control-label">About Us</label>
      </div>
      <div class="form-group">
      <div class="col-sm-4" id="summerNote">
        </div>
        </div>
     
      <div class="form-group" style="margin-left:150px">
        <div class="col-sm-offset-2 col-sm-10">
          <button  ng-click="submitContact();" class="btn btn-success" id="addGroupId">Submit</button>
        </div>
          
        </div>
      </div>
      <input type="hidden" id="contactId">
</form>

