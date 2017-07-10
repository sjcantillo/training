# language: es

Característica: Resolver reto Net 3 - Once again, I forgot ;)
  Del sitio http://www.tdhack.com
  De la categoría Net
  Con mi usuario erisohv

  Antecedentes:
    Dado que estoy registrado en el sitio http://www.tdhack.com
    Y tengo el sistema operativo Linux Mint 18
    Y tengo instalado el software Chrome versión 59.0.3071.109
    Y tengo acceso a internet
    Y he resuelto el reto Net 1 - Amateur job

  Escenario: Primer intento fallido
    Dado que estoy autenticado con mi usuario erisohv
    Y accedo al link del reto
    Y leo la contraseña que me dan en la descripción
    Y veo la variable a la cual debo pasar la contraseña
    Y veo que el enlace a la que hay que pasarla es el mismo del reto
    E intento pasar la contraseña por GET
    Entonces no resuelvo el reto
    Pero concluyo que la respuesta se debe pasar por POST

  Escenario: Solución exitosa
    Dado que estoy autenticado con mi usuario erisohv
    Y accedo al link del reto
    Y modifico el HTML agregando un form con method="post" y action="#"
    Y agrego un campo con name="password"
    Y escribo la contraseña que está en la pista
    Cuando hago submit del form
    Entonces resuelvo el reto
