//Search for individual id / Username for specific account
function sensitiveAccountsSearchBy() {
        document.getElementById("").style.display = "block";
	}


 //delete button to get to the modal
 function deleteButton(id) {
      var idNumber = $("#accountIdentifier" + id).val();
      $("#deleteIDNumber").val(idNumber);
       document.getElementById("deleteButtonVerification").style.display = "block";
   }

   //close button in the delete account modal
   function closePromptButton() {
               document.getElementById("sensitiveAccountsMainPage").style.display = "block";
               document.getElementById("deleteButtonVerification").style.display = "none";
       	}

   //add new button to get to the modal
   function openNewAccount() {
               document.getElementById("addNewButton").style.display = "block";
   }

 //cancel button in the add new account modal
   function cancelDeleteButton() {
               document.getElementById("sensitiveAccountsData").style.display = "block";
               document.getElementById("addNewButton").style.display = "none";
   }

  function resetFilters(){
                window.location = ctxroot + "sensitiveaccounts/";

   }


