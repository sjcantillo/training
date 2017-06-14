# language: es

Característica: Resolver reto FTP 101
  Con comandos FTP
  Del sitio rankk.org
  De la categoría Level 1
  Con mi usuario Audrum

  Antecedentes:
    Dado estoy registrado en el sitio rankk.org
    Y tengo el sistema operativo Windows versión 10
    Y he instalado el software Firefox versión 53
    Y tengo acceso a internet
    Y he resuelto el reto FTP 101

  Escenario: Primer intento fallido
    Dado que estoy autenticado con mi usuario Audrum
    Cuando la página solicita un comando FTP
    Y no lo conozco
    Entonces no resuelvo el reto
    Pero concluyo que puedo consultar los comandos FTP existentes

  Escenario: Solución exitosa
    Dado que estoy auntenticado con mi usuario Audrum
    Cuando ingreso el comando PUT
    Y el nombre del archivo
    Entonces resuelvo el reto
