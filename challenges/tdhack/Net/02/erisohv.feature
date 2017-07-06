# language: es

Característica: Resolver reto Safe Java
  Del sitio http://www.tdhack.com
  De la categoría Net
  Con mi usuario erisohv

  Antecedentes:
    Dado que estoy registrado en el sitio http://www.tdhack.com
    Y tengo el sistema operativo Linux Mint 18
    Y tengo instalado el software Chrome versión 59.0.3071.109
    Y tengo acceso a internet
    Y he resuelto el reto Safe Java

  Escenario: Solución exitosa
    Dado que estoy autenticado con mi usuario erisohv
    Y accedo al reto
    E inspecciono el código con la herramienta de desarrolladores del navegador
    Y analizo el JavaScript
    Cuando ingreso el usuario y contraseña correctos
    Entonces resuelvo el reto

