
function openSMModalWindow(modalObj) { 
  var modalInstance = modalObj.open({
      animation: true,
      templateUrl: 'successModalContent.html',
      controller: 'ModalInstanceCtrl',
      size: 'sm'
    });
}