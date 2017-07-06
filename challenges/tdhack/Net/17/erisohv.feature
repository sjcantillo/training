# language: es

Característica: Resolver reto Source
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
    Y abro el link al web page que da el reto
    Y me redirige a otra página
    Y veo que no puedo utilizar click derecho
    Cuando utilizo la combinación de teclas de Chrome para acceder a la herramienta de desarrolladores
    Y veo un campo oculto con la contraseña
    Entonces resuelvo el reto

