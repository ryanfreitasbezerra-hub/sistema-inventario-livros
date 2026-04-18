document.addEventListener("DOMContentLoaded", function () {
    const botao = document.getElementById("btnCadastrar");

    botao.addEventListener("click", function () {
        const nome = document.getElementById("nome").value.trim();
        const email = document.getElementById("email").value.trim();
        const senha = document.getElementById("senha").value.trim();
        const mensagem = document.getElementById("mensagem");

        if (nome === "" || email === "" || senha === "") {
            mensagem.textContent = "Preencha todos os campos.";
            mensagem.style.color = "red";
            return;
        }

        localStorage.setItem("nome", nome);
        localStorage.setItem("email", email);
        localStorage.setItem("senha", senha);

        mensagem.textContent = "Cadastro realizado com sucesso!";
        mensagem.style.color = "green";

        setTimeout(function () {
            window.location.href = "login.html";
        }, 1000);
    });
});