# language: es

Característica: Resolver reto Herder but possible
  Del sitio http://www.bright-shadows.net/
  De la categoría Crypto
  Con mi usuario mattnp

  Antecedentes:
    Dado que estoy registrado en el sitio TheBlackSheep
    Y tengo el sistema operativo Windows 10 versión 1607
    Y he instalado el software Mozilla Firefox versión 54.0.1
    Y tengo acceso a internet

  Escenario: Primer intento fallido
    Dado que estoy autenticado con mi usuario mattnp
    Cuando veo que el reto es una cadena muy larga de carácteres
    Y uso una herramienta que decodifica cifrado del César
    Y ningún valor de corrimiento genera un texto legible
    Entonces no resuelvo el reto
    Pero concluyo que se trata de un cifrado por sustitución

  Escenario: Segundo intento fallido
    Dado que estoy autenticado con mi usuario mattnp
    Cuando encuentro una herramienta para decodificar cifrado por substitución
    Y encuentro un texto que tiene sentido
    Y obtengo la clave que es el alfabeto de sustitución
    Y encuentro un nombre de una persona en el alfabeto
Entonces resuelvo el reto
