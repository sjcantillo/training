# language: es

Característica: Resolver reto Password reminder
  Del sitio http://www.tdhack.com
  De la categoría Net
  Con mi usuario erisohv

  Antecedentes:
    Dado que estoy registrado en el sitio http://www.tdhack.com
    Y tengo el sistema operativo Linux Mint 18
    Y tengo instalado el software Chrome versión 59.0.3071.109
    Y tengo acceso a internet
    Y he resuelto el reto Password reminder

  Escenario: Solución exitosa
    Dado que estoy autenticado con mi usuario erisohv
    Y accedo al reto
    Y veo que hay un botón de recuperación de contraseña
    Y leo una pista que dice que se enviará la contraseña a un correo
    E inspecciono el código fuente de la página
    Y veo un campo oculto con un correo
    Y cambio la dirección de correo
    Y hago click en el botón
    Y Me redirecciona a la página con la respuesta
    Cuando ingreso la respuesta
    Entonces resuelvo el reto
