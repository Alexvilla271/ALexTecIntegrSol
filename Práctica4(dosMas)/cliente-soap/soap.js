var mensaje = '<? xml version = "1.0" encoding = "utf-8" ?>' +
    '<Envelope xmlns="http://schemas.xslsoap.org/soap/envelope/">' +
    '<Body>' +
    '<SumarRequest xmlns= "http://www.example.org/calculadora">' +
    '<a>4</a>' + //Modificar esto ppara que acepte cualquier valor
    '<b>4</b>' + //Modificar esto ppara que acepte cualquier valor
    '</SumarRequest>' +
    '</Body>' +
    '</Envelope>';

function soap() {
    //alert('hola')
    axios.post("http://localhost:8080/ws/calculadora", mensaje, {
        headers:{
            'Content-Type' : 'text/xml'
        }
    })
    .then(sesponse => console.log(response.data)).catch(err => console.log(err));
}