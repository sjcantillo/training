# language: es

Característica: Resolver reto 265
  Del sitio yashira.org
  De la categoría Esteganografía
  Con mi usuario Kfer_forK

  Antecedentes:
    Dado estoy registrado en el sitio yashira.org
    Y tengo el S.O. Windows 10 versión 10.0.14393
    Y tengo acceso a internet
    Y tengo Photoshop CS6
    Y app de lectura código QR
    Y he resuelto el reto 265
    Y a partir de resolver código QR oculto

  Escenario: Solución Exitosa
    Dado la imagen bmp del reto 265
    Cuando aplico capas de tono saturación
    Y encuentro código QR
    Y expongo adecuadamente el código
    Y escaneó con app de lectura QR
    Y encuetro la palabra
    Entonces resuelvo el reto
