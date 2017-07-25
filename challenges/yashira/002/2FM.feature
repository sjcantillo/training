Característica: Resolver reto 2
  Del sitio yashira.org
  De la categoría Cracking
  Con mi usuario  Kfer_forK

  Antecedentes:
    Dado estoy registrado en el sitio yashira.org
    Y tengo el S.O. Windows 10 versión 10.0.14393
    Y tengo acceso a internet
    Y he resuelto el reto 2
    Y a partir de la BdD Crackstation

  Escenario: Intento fallido
    Dado el valor hash del reto 2
    Cuando introduzco este en la BsD Hashtoolkit
    Y busco la palabra que genera la suma de control
    Y no se encuentra el hash descifrado
    Entonces no resuelvo el reto
    Pero concluyo que el hash puede tener codificación no soportada

  Escenario: Solución Exitosa
    Dado que Hashtoolkit no funcionó para el reto
    Cuando busco otra herramienta
    Y encuentro crackstation.net
    Y introduzco el hash
    Y busco la palabra que genera la suma de control
    Entonces resuelvo el reto
    Pero concluyo que el hash del reto 2 usa codificación md4
