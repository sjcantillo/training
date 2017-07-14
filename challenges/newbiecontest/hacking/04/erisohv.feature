# language: es

Característica: Resolver reto Envoi d'email
  Del sitio https://www.newbiecontest.org
  De la categoría Hacking
  Con mi usuario erisohv

  Antecedentes:
    Dado que estoy registrado en el sitio https://www.newbiecontest.org
    Y tengo el sistema operativo Linux Mint 18
    Y tengo instalado el software Firefox versión 54.0
    Y tengo acceso a internet
    Y he resuelto el reto Envoi d'email

  Escenario: Solución exitosa
    Dado que estoy autenticado con mi usuario erisohv
    Y accedo al link del reto
    Y veo que hay un formulario de envio de correo
    Y reviso el HTML del formulario
    Y veo que hay campos de correo
    Y cambio las direcciones de los campos de correo
    Cuando hago submit al form
    Entonces resuelvo el reto
