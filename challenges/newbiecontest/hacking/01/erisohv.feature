# language: es

Característica: Resolver reto News en construction
  Del sitio https://www.newbiecontest.org
  De la categoría Hacking
  Con mi usuario erisohv

  Antecedentes:
    Dado que estoy registrado en el sitio https://www.newbiecontest.org
    Y tengo el sistema operativo Linux Mint 18
    Y tengo instalado el software Firefox versión 54.0
    Y tengo acceso a internet
    Y he resuelto el reto News en construction

  Escenario: Solución exitosa
    Dado que estoy autenticado con mi usuario erisohv
    Y accedo al link del reto
    Y luego accedo al sitio a donde debo buscar una vulnerabilidad
    Y leo que debo acceder como administrador
    Cuando reviso la url
    Y reviso las variables que se pasan por GET
    Y veo que hay una variable que dice admin=false
    Cuando cambio el valor de la variable
    Entonces resuelvo el reto
