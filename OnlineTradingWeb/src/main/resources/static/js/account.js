const LoginForm = document.getElementById("LoginForm");
const RegisterForm = document.getElementById("RegisterForm");
const Indicator = document.getElementById("Indicator");

function registerToggle() {
    RegisterForm.style.transform = "translateX(0px)";
    LoginForm.style.transform = "translateX(0px)";
    Indicator.style.transform = "translateX(100px)";
}

function loginToggle() {
    RegisterForm.style.transform = "translateX(300px)";
    LoginForm.style.transform = "translateX(300px)";
    Indicator.style.transform = "translateX(0px)";
}