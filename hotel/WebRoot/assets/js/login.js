window.onload=function(){
var verifyObj = document.getElementById("Verify");
    verifyObj.onclick=function(){
        this.src="../Security/SecurityCodeImageAction?timestamp="+new Date().getTime();
    };
};
