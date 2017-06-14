# language: es

Característica: Resolver reto Easy Javascript
  Con código Javascript
  Del sitio rankk.org
  De la categoría Level 1
  Con mi usuario Audrum

  Antecedentes:
    Dado estoy registrado en el sitio rankk.org
    Y tengo el sistema operativo Windows versión 10
    Y he instalado el software Firefox versión 53
    Y tengo acceso a internet
    Y he resuelto el reto Easy Javascript

  Escenario: Primer intento fallido
    Dado que estoy autenticado con mi usuario Audrum
    Cuando la página solicita un usuario
    Y no lo conozco
    Entonces no resuelvo el reto
    Pero concluyo que puedo observar el código fuente

  Escenario: Solución exitosa
    Dado que estoy auntenticado con mi usuario Audrum
    Cuando observo el código fuente
    Y obtengo el usuario
    Entonces resuelvo el reto
