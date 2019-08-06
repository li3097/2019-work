function showMemberMenu() {

if(document.getElementById("memberUpdateClick").style.display = "none") {
         document.getElementById("packageTabClick").style.display = "none";
         document.getElementById("toolsTabClick").style.display = "none";
         document.getElementById("memberUpdateClick").style.display = "block";
      } else {
         document.getElementById("packageTabClick").style.display = "none";
         document.getElementById("toolsTabClick").style.display = "none";
         document.getElementById("memberUpdateClick").style.display = "none";
      }
 }

 function showPackageMenu() {

 if(document.getElementById("packageTabClick").style.display = "none") {
          document.getElementById("memberUpdateClick").style.display = "none";
          document.getElementById("toolsTabClick").style.display = "none";
          document.getElementById("packageTabClick").style.display = "block";
       } else {
          document.getElementById("toolsTabClick").style.display = "none";
          document.getElementById("packageTabClick").style.display = "none";
       }
  }

 function showToolsMenu() {

 if(document.getElementById("toolsTabClick").style.display = "none") {
          document.getElementById("packageTabClick").style.display = "none";
          document.getElementById("memberUpdateClick").style.display = "none";
          document.getElementById("toolsTabClick").style.display = "block";
       } else {
          document.getElementById("memberUpdateClick").style.display = "none";
          document.getElementById("packageTabClick").style.display = "none";
          document.getElementById("toolsTabClick").style.display = "none";
       }
  }

  function openRcLinks(){
    document.getElementById("openRcLinks").style.display = "none";
    document.getElementById("rcLinks").style.display = "block";
  }

  function openLinks(){
    document.getElementById("openLinks").style.display = "none";
    document.getElementById("mvpLinks").style.display = "block";
  }

