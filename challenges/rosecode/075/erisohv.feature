# language: es

Característica: Resolver reto Question out of the Box
  Del sitio http://www.javaist.com/rosecode/
  De la categoría Hack
  Con mi usuario erisohv

  Antecedentes:
    Dado que estoy registrado en el sitio http://www.javaist.com/rosecode
    Y tengo el sistema operativo Linux Mint 18
    Y tengo instalado el software Chrome versión 59.0.3071.109
    Y tengo acceso a internet
    Y he resuelto el reto Question out of the Box

  Escenario: Solución exitosa
    Dado que estoy autenticado con mi usuario erisohv
    Y accedo al link del reto
    Y leo la descripción o pista
    Y veo que parece no haber manera de ingresar la respuesta
    E inspecciono el código fuente la página
    Y encuentro un formulario oculto
    Y manipulo el HTML del formulario para hacer los campos visibles
    Y obtengo el HTML path del formulario
    Cuando ingreso la respuesta
    Y con JQuery hago submit del formulario usando el path que obtuve
    Entonces resuelvo el reto
