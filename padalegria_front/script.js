// Definição das informações sobre os pães
const paoTypes = ["Francês", "Pão Bolacha", "Carteiro", "Doce", "Doce com Côco", "Pão Baiano"];
const paoColors = ["#FF5733", "#FFC300", "#33FF57", "#33D6FF", "#336CFF", "#9233FF"];

// Definição das listas de pães e fornadas (usaremos arrays para simular o armazenamento temporário)
let listaPaes = [];
let listaFornadas = [];

// Função para criar os botões de cadastro de fornada
function createBakeButtons() {
    const breadButtons = document.getElementById("bread-buttons");
    breadButtons.innerHTML = "";
    paoTypes.forEach((type, index) => {
        const button = document.createElement("button");
        button.classList.add("bake-button");
        button.style.backgroundColor = paoColors[index];
        button.innerText = type;
        breadButtons.appendChild(button);
    });
    bindBakeButtons();
}

// Função para registrar a fornada
function registrarFornada(index) {
    const type = paoTypes[index];
    const now = new Date();
    const time = Math.floor(Math.random() * 120) + 30; // Tempo de preparo aleatório entre 30 e 150 minutos
    const description = `Fornada ${listaFornadas.length + 1}`;
    const fornada = { type, description, date: now, time };
    listaFornadas.push(fornada);
}

// Função para mostrar as últimas fornadas na tela do cliente
function showRecentFornadasCliente() {
    const breadInfo = document.getElementById("bread-info");
    if (breadInfo) {
        breadInfo.innerHTML = "";
        listaPaes.forEach((pao) => {
            const fornadasPao = listaFornadas.filter((fornada) => fornada.type === pao);
            if (fornadasPao.length > 0) {
                fornadasPao.forEach((fornada) => {
                    const now = new Date();
                    const timeDiff = (fornada.date.getTime() + fornada.time * 60000) - now.getTime();
                    const timeRemaining = Math.ceil(timeDiff / 1000 / 60);
                    const timeDisplay = timeRemaining > 0 ? `Falta ${timeRemaining} minutos` : "Pronto!";
                    const info = document.createElement("p");
                    info.innerText = `${fornada.type} (${fornada.description}): ${fornada.date.toLocaleTimeString()} - ${timeDisplay}`;
                    breadInfo.appendChild(info);
                });
            }
        });
    }
}

// Evento de cadastro de fornada pelo cliente
function bindBakeButtons() {
    const bakeButtons = document.querySelectorAll(".bake-button");
    bakeButtons.forEach((button, index) => {
        button.addEventListener("click", () => {
            registrarFornada(index);
            showRecentFornadasCliente();
        });
    });
}

// Inicialização da página para listar pães cadastrados ou fornadas recentes
const currentPage = window.location.pathname.split("/").pop();
if (currentPage === "cadastro-paes.html") {
    createBreadButtons();
} else if (currentPage === "cadastro-fornada.html") {
    createBakeButtons();
} else if (currentPage === "ultimas-fornadas.html") {
    showRecentFornadasCliente();
}
