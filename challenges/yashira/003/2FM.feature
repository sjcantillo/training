# language: es

Característica: Resolver reto 3
  Del sitio yashira.org
  De la categoría Cracking
  Con mi usuario  Kfer_forK

  Antecedentes:
    Dado estoy registrado en el sitio yashira.org
    Y tengo el S.O. Windows 10 versión 10.0.14393
    Y tengo acceso a internet
    Y he resuelto el reto 3
    Y a partir de la BdD de hash Hashtoolkit

  Escenario: Solución Exitosa
    Dado el valor hash del reto 3
    Y longitud de 40 caracteres
    Cuando introduzco este en la BsD Hashtoolkit
    Y busco la palabra que genera la suma de control
    Entonces resuelvo el reto
    Pero concluyo que el hash del reto 3 usa codificación sha1
