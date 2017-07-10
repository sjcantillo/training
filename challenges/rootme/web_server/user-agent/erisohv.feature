# language: es

Característica: Resolver reto User-agent
  Del sitio https://www.root-me.org
  De la categoría web-server
  Con mi usuario erisohv

  Antecedentes:
    Dado que estoy registrado en el sitio https://www.root-me.org
    Y tengo el sistema operativo Linux Mint 18
    Y tengo instalado el software Chrome versión 59.0.3071.109
    Y tengo acceso a internet
    Y he resuelto el reto User-agent

  Escenario: Solución exitosa
    Dado que estoy autenticado con mi usuario erisohv
    Y accedo al link del reto
    Y leo que no estoy usando el user-agent correcto
    E investigo como cambiar el user-agent en Chrome
    Y cambio el user-agent a "admin"
    Cuando refresco la página
    Entonces resuelvo el reto
