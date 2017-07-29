# language: es

Característica: Resolver reto 119
  Del sitio yashira.org
  De la categoría Esteganografía
  Con mi usuario  Kfer_forK

  Antecedentes:
    Dado estoy registrado en el sitio yashira.org
    Y tengo el S.O. Windows 10 versión 10.0.14393
    Y tengo acceso a internet
    Y tengo WinRAR versión 5.31
    Y he resuelto el reto 119
    Y a partir de reparar el archivo

  Escenario: Intento fallido
    Dado el archivo zip del reto 119
    Cuando uso buscar de WinRAR
    Y al intentar encontrar archivos ocultos
    Entonces no resuelvo el reto
    Pero concluyo que WinRAR funciona para este reto

  Escenario: Solución Exitosa
    Dado el archivo zip del reto 119
    Cuando reparo el archivo para encontrar archivos ocultos
    Y encuentro sera.txt
    Entonces resuelvo el reto
