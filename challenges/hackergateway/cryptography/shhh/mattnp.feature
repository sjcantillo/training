# language: es

Característica: Resolver reto Shhh
  Del sitio https://www.hackergateway.com/
  De la categoría Cryptography
  Con mi usuario mattnp

  Antecedentes:
    Dado que estoy registrado en el sitio https://www.hackergateway.com/
    Y tengo el sistema operativo Windows 10 versión 1703
    Y he instalado el software Mozilla Firefox versión 54.0.1
    Y tengo acceso a internet

  Escenario: Solución exitosa
    Dado que estoy autenticado con mi usuario mattnp
    Cuando veo que en la página se muestra una cadena de caracteres
    Y por el nombre del reto y el número de caracteres deduzco que se trata de un hash SHA-1
    Y encuentro una herramienta para decodificar un hash SHA-1
    Y encuentro la respuesta del reto
    Y escribo la respuesta en el cuadro de diálogo del reto
    Y presiono el botón
Entonces resuelvo el reto
