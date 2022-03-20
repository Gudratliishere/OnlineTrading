const LoginForm = document.getElementById("LoginForm");
const RegisterForm = document.getElementById("RegisterForm");
const Indicator = document.getElementById("Indicator");
const FormContainer = document.getElementById("FormContainer");

function registerToggle() {
    RegisterForm.style.transform = "translateX(0px)";
    FormContainer.style.height = "520px";
    LoginForm.style.transform = "translateX(0px)";
    Indicator.style.transform = "translateX(100px)";
}

function loginToggle() {
    RegisterForm.style.transform = "translateX(300px)";
    FormContainer.style.height = "400px";
    LoginForm.style.transform = "translateX(300px)";
    Indicator.style.transform = "translateX(0px)";
}