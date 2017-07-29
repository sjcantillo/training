# language: es

Característica: Resolver reto 6
  Del sitio yashira.org
  De la categoría Cracking
  Con mi usuario  Kfer_forK

  Antecedentes:
    Dado estoy registrado en el sitio yashira.org
    Y tengo el S.O. Windows 10 versión 10.0.14393
    Y tengo acceso a internet
    Y he resuelto el reto 6
    Y a partir de hashkiller.co.uk

  Escenario: Intento fallido
    Dado el texto plano del reto 6
    Cuando uso hash-identifier
    Y al intentar HavaL128 entre otros 2
    Entonces no resuelvo el reto
    Pero concluyo que el cifrado puede ser NTLM

  Escenario: Solución Exitosa
    Dado el texto plano del reto 6
    Cuando busco herramientas de decifrado NTLM
    Y encuentro hashkiller.co.uk
    Y introduzco el hash
    Entonces resuelvo el reto
