document.addEventListener('DOMContentLoaded', function() {
    // Función para cargar los tableros del usuario
    function cargarTableros() {
        fetch('/api/tableros', { method: 'GET' })
            .then(response => response.json())
            .then(data => {
                const tablerosContainer = document.getElementById('tableros');
                tablerosContainer.innerHTML = '';
                data.forEach(tablero => {
                    const tableroDiv = document.createElement('div');
                    tableroDiv.className = 'col-md-4';
                    tableroDiv.innerHTML = `
                        <div class="board shadow-sm">
                            <h2>${tablero.nombre}</h2>
                        </div>`;
                    tablerosContainer.appendChild(tableroDiv);
                });
            });
    }

    // Cargar los tableros al iniciar
    cargarTableros();

    // Agregar funcionalidad para crear un nuevo tablero
    document.getElementById('add-board').addEventListener('click', function() {
        const nombreTablero = prompt('Nombre del nuevo tablero:');
        if (nombreTablero) {
            fetch('/api/tableros', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ nombre: nombreTablero })
            })
            .then(() => cargarTableros());
        }
    });

    // Funcionalidad para cerrar sesión
    document.getElementById('logout').addEventListener('click', function() {
        // Lógica para cerrar sesión
        alert('Cerrando sesión...');
    });
});
