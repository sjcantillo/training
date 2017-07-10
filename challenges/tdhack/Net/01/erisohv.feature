# language: es

Característica: Resolver reto Net 1 - Amateur job
  Del sitio http://www.tdhack.com
  De la categoría Net
  Con mi usuario erisohv

  Antecedentes:
    Dado que estoy registrado en el sitio http://www.tdhack.com
    Y tengo el sistema operativo Linux Mint 18
    Y tengo instalado el software Chrome versión 59.0.3071.109
    Y tengo acceso a internet
    Y he resuelto el reto Net 1 - Amateur job

  Escenario: Solución exitosa
    Dado que estoy autenticado con mi usuario erisohv
    Y accedo al link del reto
    Y reviso el HTML en busca de la respuesta
    Y encuentro un tag "meta" con la respuesta
    Cuando ingreso la respuesta
    Entonces resuelvo el reto
    Y concluyo que no deben colocarse contraseñas en el HTML
