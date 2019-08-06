window.onload = function() {

     var memberUpdateRemoveEvent = document.getElementById('deleteBtn');
     var unShowUpdate = document.getElementById('deleteMemberForm');

     memberUpdateRemoveEvent.onclick = function(e) {
       e.preventDefault();
     if(unShowUpdate.style.display == "block") {

        document.getElementById('deleteMemberForm').style.display = "none";
        document.getElementById('deleteVerification').style.display = "block";
        memberUpdateClickEvent.style.fontWeight = "normal";
        memberUpdateClickEvent.style.boxShadow = "0px 0px 10px rgba(0, 0, 0, 0.12)";
     } else {
        document.getElementById('deleteMemberForm').style.display = "block";
        memberUpdateClickEvent.style.fontWeight = "bold";
        memberUpdateClickEvent.style.boxShadow = "0px 4px 10px rgba(0, 0, 0, 0.30)";

     }

    }
  };

var myForm;
function closePromptForm() {
        myForm.close();
    //document.getElementById("formBtn close").innerHTML = closePromptForm.close();
}

function openEditForm(idNumber) {

	  $.ajax({
		//  url: ctxroot+"/rest/question/" + idNumber,
		  url: "/rest/package/" + idNumber,
		  context: document.body
		}).done(function(data) {
			$("#editPackageForm #idNumber").val(data.id);
			$("#editPackageForm #custIDNumber").val(data.customerID);
			$("#editPackageForm #grpNumber").val(data.groupNumber);
		//	$("#editPackageForm #active").val(data.active);
		//	$("#editPackageForm #question").val(data.question);
		//	$("#editPackageForm #answer").val(data.answer);
		//	$("#editPackageForm #keyword").val(data.keyword);
			document.getElementById("editPackageForm").style.display = "block";
		});
	}

function openDeleteForm() {
    	document.getElementById("deleteMemberForm").style.display = "block";
}


function openRemoveForm() {
        document.getElementById("deleteMemberForm").style.display = "none";
        document.getElementById("deleteVerification").style.display = "block";
}

function searchBy(){

    var searchText = document.getElementById("deleteMemberSearchBarId").value;
    alert(searchText);

}
