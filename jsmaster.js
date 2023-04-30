function clearError(){
    errors=document.getElementsByClassName('form-error');
    for(let item of errors){
        item.innerHTML="";
    }    
}
function validate(){
    clearError();
    var id = document.getElementById("id").value;
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    if(id == "" || isNaN(id)){
        document.getElementById("id-error").innerHTML="Id can't be null & contains only digits";
        return false;
    }
    if(name == "" || !isNaN(name)){
        document.getElementById("name-error").innerHTML="Name should not contains any digit";
        return false;
    }
    let atPos = email.indexOf('@');
    let dotPos = email.indexOf('.');
    if(email == "" || atPos<=0 || dotPos<=0){
        document.getElementById("email-error").innerHTML="Enter a valid email address like example@odisha.com";
        return false;
    }
    if(password.length <7 || password.length>16){
        document.getElementById("password-error").innerHTML="Password length should be 8 to 15";
        return false;
    }
}