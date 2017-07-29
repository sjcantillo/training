# language: es

Característica: Resolver reto 5
  Del sitio yashira.org
  De la categoría Cracking
  Con mi usuario  Kfer_forK

  Antecedentes:
    Dado estoy registrado en el sitio yashira.org
    Y tengo el S.O. Windows 10 versión 10.0.14393
    Y tengo acceso a internet
    Y he resuelto el reto 5
    Y a partir de rainbowtables.it64

  Escenario: Solución Exitosa
    Dado el texto plano del reto 5
    Cuando busco identificar cuál es su codificación
    Y encuentro hash-identifier de kali linux
    Y introduzco el hash
    Y encuentro codificación LM
    Y uso rainbowtables.it64
    Entonces resuelvo el reto
