const apihost = 'http://localhost:8081';


function apiCreateTask(name) {
    return fetch(
        apihost + '/order',
        {
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({name: name}),
            method: 'POST'
        }
    ).then(
        function (resp) {
            if (!resp.ok) {
                alert('Wystąpił błąd! Otwórz devtools i zakładkę Sieć/Network, i poszukaj przyczyny');
            }
            return resp.json();
        }
    )
}

document.addEventListener('DOMContentLoaded', function () {
    const addZ = document.querySelector('.js-task-adding-form');
    addZ.addEventListener('submit', function (event) {
        event.preventDefault();
        console.log(event.target.elements.name.value);
        apiCreateTask(event.target.elements.name.value).then(
            function (response) {
                return response;
            })
    });
});