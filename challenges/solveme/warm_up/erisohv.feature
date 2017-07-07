# language: es

Característica: Resolver reto Go Away
  Del sitio http://solveme.kr/
  De la categoría Challenge
  Con mi usuario erisohv

  Antecedentes:
    Dado que estoy registrado en el sitio http://solveme.kr/
    Y tengo el sistema operativo Linux Mint 18
    Y tengo instalado el software Chrome versión 59.0.3071.109
    Y tengo acceso a internet
    Y he resuelto el reto Warm Up

  Escenario: Solución exitosa
    Dado que estoy autenticado con mi usuario erisohv
    Y accedo al link del reto
    Y veo al inicio unos caracteres
    Y veo un código en PHP
    Y determino por el código PHP que los caracteres están en base64
    Y accedo al sitio https://www.base64decode.org/
    E ingreso los caracteres
    Cuando escribo la respuesta
    Entonces resuelvo el reto

