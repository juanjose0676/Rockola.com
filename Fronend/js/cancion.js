
function loadData(){
    let request = sendRequest('cancion/showall/', 'GET', '');
    let table = document.getElementById('cancion-table');
    table.innerHTML = "";
    request.onload = function(){
        
        let data = request.response;
        console.log(data);
        data.forEach((element, index) => {
            table.innerHTML += `
                <tr>
                    <th>${element.idCancion}</th>
                    <td>${element.nombreCancion}</td>
                    <td>
                        <a href="${element.link}" target="_blank" class="bi bi-play">Play
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-play-circle-fill" viewBox="0 0 16 16">
                            <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM6.79 5.093A.5.5 0 0 0 6 5.5v5a.5.5 0 0 0 .79.407l3.5-2.5a.5.5 0 0 0 0-.814l-3.5-2.5z"/>
                        </svg></a>
                    </td>
                    <td>${element.genero}</td>
                    <td>${element.artista}</td>
                    <td>${element.album}</td>
                    <td>
                        <button type="button" class="btn btn-primary" onclick='window.location = "/form_cancion.html?id=${element.idCancion}"'>Editar</button>
                        <button type="button" class="btn btn-danger" onclick='deleteCancion(${element.idCancion})'>Eliminar</button>
                    </td>
                </tr>

                `;
        });
    };
    request.onerror = function(){
        table.innerHTML = `
            <tr>
                <td colspan="6">Error al recuperar los datos.</td>
            </tr>
        `;
    };
}

function loadDataArtist(){
    let request = sendRequest('artista/list', 'GET', '');
    let ele = document.getElementById('sel-artista');
    
    request.onload = function(){
    let data = request.response;
    console.log(data);
    data.forEach((element, index) => {
        ele.innerHTML = ele.innerHTML +`
            <option value=${element.idartista} > ${element.nombreartista} </option>'
            `;
        });
    };
}

function loadDataGenero(){
    let request = sendRequest('genero/list', 'GET', '');
    let ele = document.getElementById('sel-genero');
    
    request.onload = function(){
    let data = request.response;
    console.log(data);
    data.forEach((element, index) => {
        ele.innerHTML = ele.innerHTML +`
            <option value=${element.idgenero} > ${element.nombregenero} </option>'
            `;
        });
    };
}

function loadDataAlbum(){
    let request = sendRequest('album/list', 'GET', '');
    let ele = document.getElementById('sel-album');
    
    request.onload = function(){
    let data = request.response;
    console.log(data);
    data.forEach((element, index) => {
        ele.innerHTML = ele.innerHTML +`
            <option value=${element.idAlbum} > ${element.nombreAlbum} </option>'
            `;
        });
    };
}

function loadCancion(idCancion){
    let request = sendRequest('cancion/list/'+idCancion, 'GET', '');
    let id = document.getElementById('cancion-id');
    let name = document.getElementById('cancion-name');
    let link = document.getElementById('cancion-link');
    let genero = document.getElementById('sel-genero');
    let album = document.getElementById('sel-album');
    let artista = document.getElementById('sel-artista');
    request.onload = function(){
        
        let data = request.response;
        id.value = data.idCancion;
        name.value = data.nombreCancion;
        link.value = data.link;
        genero.value = data.genero;
        album.value = data.album;
        artista.value = data.artista;
    };
    request.onerror = function(){
        alert("Error al recuperar los datos.");
    };
}

function deleteCancion(idCancion){
    let request = sendRequest('cancion/'+idCancion, 'DELETE', '');
    request.onload = function(){
        loadData();
    };
}

function saveCancion(){
    let idCancion = document.getElementById('cancion-id').value;
    let nombreCancion = document.getElementById('cancion-name').value;
    let Link = document.getElementById('cancion-link').value;
    let Genero = document.getElementById('sel-genero').value;
    let Album = document.getElementById('sel-album').value;
    let Artista = document.getElementById('sel-artista').value;
    let data = {'idCancion': idCancion,'nombreCancion':nombreCancion,'link': Link, 'genero': Genero, 'album':Album, 'artista':Artista };
    let request = sendRequest('cancion/', idCancion ? 'PUT' : 'POST', data);
    request.onload = function(){
        window.location = 'cancion.html';
    };
    request.onerror = function(){
        alert('Error al guardar los cambios.');
    };
}