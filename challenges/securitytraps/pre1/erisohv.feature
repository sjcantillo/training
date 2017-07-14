# language: es

Característica: Resolver retos "Pre-level"
  Del sitio http://www.securitytraps.pl
  De la categoría Pre-level

  Antecedentes:
    Dado que quiero registrarme en el sitio http://www.securitytraps.pl
    Y tengo el sistema operativo Linux Mint 18
    Y tengo instalado el software Firefox versión 54.0
    Y tengo instalado la extensión Firebug
    Y tengo acceso a internet
    Y he resuelto los retos del Pre-level

  Escenario: Solución exitosa nivel 1
    Dado que accedo al link de registro
    Y me presenta el primer reto
    Y leo la pista del titulo
    Y veo que el campo está de solo lectura
    Y elimino la propiedad de readonly del campo
    Y encuentro en el HTML el password (alamakota)
    Cuando ingreso la respuesta
    Entonces resuelvo el reto
    Y me muestra el segundo nivel

  Escenario: Solución exitosa nivel 2
    Dado que estoy en el segundo reto
    Y leo la pista
    Y reviso el header del document
    Y veo que hay un campo "Pass"
    Y uso un decodificador base64 online
    Cuando ingreso la respuesta (kotmapsa)
    Entonces resuelvo el reto
    Y me muestra el tercer nivel

  Escenario: Solución exitosa nivel 3
    Dado que estoy en el tercer reto
    Y reviso el HTML
    Y veo que el botón tienen un javascript en su evento onClick
    Y veo un if con una comparación contra el password
    Y hago ingeniería inversa del JavaScript para obtener el password
    Cuando ingreso la respuesta (olsah)
    Entonces resuelvo el reto
    Y me muestra el cuarto nivel

  Escenario: Solución exitosa nivel 4
    Dado que estoy en el cuarto reto
    Y debo votar 3 veces
    Y hago click en "Vote"
    Y veo que ya no me deja realizar más votos
    Cuando reviso las cookies con la extensión Firebug
    Entonces veo una cookie "vote" con valor 1
    Cuando borro la cookie
    Y refresco la página y aparece el botón
    Y repito el proceso
    Entonces resuelvo el reto
    Y me muestra el quinto nivel

  Escenario: Solución fallida 1 nivel 5
    Dado que estoy en el quinto reto
    Y veo que la pista dice "Just alert"
    Y asumo que debo disparar un alert desde el campo de texto
    Y escribo alert('Cross');
    Cuando presiono "Next"
    Entonces no sucede nada
    Y reviso el HTML del campo
    Y concluyo que debo manipular el value para que concatene un evento

  Escenario: Solución exitosa nivel 5
    Dado que estoy en el quinto reto
    Y escribo en el campo de texto hola' onload=javascript:alert('Cross')
    Y presiono "Next"
    Cuando refresco la página
    Entonces resuelvo el reto
