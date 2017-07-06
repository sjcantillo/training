# language: es

Característica: Resolver reto Go Away
  Del sitio https://www.hackergateway.com
  De la categoría Web
  Con mi usuario erisohv

  Antecedentes:
    Dado que estoy registrado en el sitio https://www.hackergateway.com
    Y tengo el sistema operativo Linux Mint 18
    Y tengo instalado el software Chrome versión 59.0.3071.109
    Y tengo acceso a internet
    Y he resuelto el reto Go Away

  Escenario: Primer intento fallido
    Dado que estoy autenticado con mi usuario erisohv
    Y estoy en el listado de Challenges del sitio
    Y accedo al link del reto
    Y me redirige a otra página apenas entro al reto
    Y veo que esa página es https://www.hackergateway.com
    Entonces no resuelvo el reto
    Pero concluyo que debo poder quedarme en la página del reto para poder resolverlo

  Escenario: Solución exitosa
    Dado que estoy autenticado con mi usuario erisohv
    Y estoy en el listado de Challenges del sitio
    Y accedo al link del reto
    Y presiono la tecla Esc para poder quedarme en la página
    Y reviso el código fuente de la página
    Y busco el texto https://www.hackergateway.com en el código fuente
    Y veo que hay un comentario con la respuesta
    Cuando uso esa respuesta
    Entonces resuelvo el reto
