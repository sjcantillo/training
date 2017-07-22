# language: es

Característica: Resolver reto Gibberish
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
    Cuando veo que en la página se muestra una cadena con carácteres finalizada en ==
    Y averiguo que las cadenas terminadas corresponden a un codificado Base64
    Y encuentro una herramienta para decodificar una cadena en Base64
    Y encuentro la respuesta del reto
    Y escribo la respuesta en el cuadro de diálogo del reto
    Y presiono el botón
Entonces resuelvo el reto
