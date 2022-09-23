function loadData(){
    let request = sendRequest('album/list', 'GET', '')
    let table = document.getElementById('album-table');
    table.innerHTML = "";
    request.onload = function(){
        
        let data = request.response;
        console.log(data);
        data.forEach((element, index) => {
            table.innerHTML += `
                <tr>
                    <th>${element.idAlbum}</th>
                    <td>${element.nombreAlbum}</td>
                    
                    <td>
                        <button type="button" class="btn btn-primary" onclick='window.location = "/form_album.html?id=${element.idAlbum}"'>Editar</button>
                        <button type="button" class="btn btn-danger" onclick='deleteAlbum(${element.idAlbum})'>Eliminar</button>
                    </td>
                </tr>

                `
        });
    }
    request.onerror = function(){
        table.innerHTML = `
            <tr>
                <td colspan="6">Error al recuperar los datos.</td>
            </tr>
        `;
    }
}

function loadAlbum(idAlbum){
    let request = sendRequest('album/list/'+idAlbum, 'GET', '')
    let name = document.getElementById('album-name')
    let id = document.getElementById('album-id')
    request.onload = function(){
        
        let data = request.response
        id.value = data.idAlbum
        name.value = data.nombreAlbum
        
    }
    request.onerror = function(){
        alert("Error al recuperar los datos.");
    }
}

function deleteAlbum(idAlbum){
    let request = sendRequest('album/'+idAlbum, 'DELETE', '')
    request.onload = function(){
        loadData()
    }
}

function saveAlbum(){
    let name = document.getElementById('album-name').value
    let id = document.getElementById('album-id').value
    let data = {'idAlbum': id,'nombreAlbum':name }
    let request = sendRequest('album/', id ? 'PUT' : 'POST', data)
    request.onload = function(){
        window.location = 'album.html';
    }
    request.onerror = function(){
        alert('Error al guardar los cambios.')
    }
}