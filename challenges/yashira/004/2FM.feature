# language: es

Característica: Resolver reto 4
  Del sitio yashira.org
  De la categoría Criptografía
  Con mi usuario Kfer_forK

  Antecedentes:
    Dado estoy registrado en el sitio yashira.org
    Y tengo el S.O. Windows 10 versión 10.0.14393
    Y tengo acceso a internet
    Y he resuelto el reto 4
    Y a partir de la página web base64decode

  Escenario: Primer Intento fallido
    Dado el texto plano del reto 4
    Cuando averiguo los tipos de cifrado existente
    Y al observar ejemplos de cada uno
    Y inferir cidrado base 64 debido a los ==
    Y decodificar el texto plano
    Entonces no resuelvo el reto
    Pero concluyo que el cifrado es base 64

  Escenario: Segundo Intento fallido
    Dado el texto plano del reto 4
    Cuando encuentro diferentes decodificadores base 64
    Y intento introducir el texto de diferentes maneras
    Entonces no resuelvo el reto
    Pero concluyo que debe existir un problema mas en el texto

  Escenario: Solución Exitosa
    Dado el texto plano del reto 4
    Cuando averiguo diversos hábitos de cifrado en base 64
    Y intento decodificar varias veces el mismo resultado
    Entonces resuelvo el reto
