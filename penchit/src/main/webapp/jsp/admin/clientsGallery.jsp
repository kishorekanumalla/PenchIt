    <form class="form-horizontal" name="clientsGalleryForm" style="margin-top:50px;margin-left:120px" role="form" enctype="multipart/form-data">
        
        <div class="form-group">
        <label for="group2" class="col-sm-3 control-label"></label>
        <div class="col-sm-5" id="imageUpload">
          <input type="file" class="filestyle" id="picId" name="picFile"   ng-click="removeErrorMessage('picError');" data-placeholder="Upload Picture">
        </div>
        <button  ng-click="uploadPicture();" class="btn btn-success" id="addPictureId" style="">Submit</button>
        <div style="padding-top:5px;color:red;display:none;margin-left:250px;" id="picError" >Please enter the Picture</div>
      </div>
      <div class="form-group" style="margin-right:200px;margin-top:80px;height:500px;">
      <div style="height: 100px;margin-left:10px;">
    	<uib-carousel interval="myInterval" no-wrap="noWrapSlides">
      		<uib-slide ng-repeat="slide in slides" active="">
        		<img ng-src="{{slide.image}}" style="margin:auto;cursor:pointer" ng-click="selectPicture(slide);">
        			<div class="carousel-caption">
          				<h4>Slide {{$index}}</h4>
          				<p>{{slide.clientGalleryName}}</p>
        			</div>
     		 </uib-slide>
    	</uib-carousel>
  		</div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
<!--           <button  ng-click="deleteCourse();" style="margin-left:10px;" class="btn btn-success">Delete</button> -->
        </div>
          
        </div>
      <input type="hidden" id="fromPage" value="${fromPage}"  />
      <input type="hidden" id="deletePicId"  />
</form>
<div  id="pictureContent" style="display:none">
        <div class="modal-header">
            <h3 class="modal-title">Image</h3>
        </div>
        <div class="modal-body" style="padding-left:80px;">
            <img src="#"  id="clientsPictureSrcId" style="height:120px;width:100px;" />
        </div>
        <div class="modal-footer">
            <button class="btn btn-primary" type="button" ng-click="closeImageDialog();">OK</button>
            <button class="btn btn-primary" type="button" ng-click="deleteImageDialog();">Delete</button>
        </div>
</div>


