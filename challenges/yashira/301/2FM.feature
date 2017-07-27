# language: es

Característica: Resolver reto 301
  Del sitio yashira.org
  De la categoría Criptografía
  Con mi usuario  Kfer_forK

  Antecedentes:
    Dado estoy registrado en el sitio yashira.org
    Y tengo el S.O. Windows 10 versión 10.0.14393
    Y tengo acceso a internet
    Y he resuelto el reto 301
    Y a partir del alfabeto semáforo

  Escenario: Solución Exitosa
    Dado el archivo gif del reto 301
    Cuando investigo comunicación por señales banderas
    Y encuentro el alfabeto semáforo
    Y correspondo cada imagen con su respectiva letra
    Entonces resuelvo el reto
