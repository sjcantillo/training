# language: es

Característica: Resolver reto 72
  Del sitio yashira.org
  De la categoría Esteganografía
  Con mi usuario  Kfer_forK

  Antecedentes:
    Dado estoy registrado en el sitio yashira.org
    Y tengo el S.O. Windows 10 versión 10.0.14393
    Y he resuelto el reto 303
    Y a partir de detallar bien la imagen

  Escenario: Solución Exitosa
    Dado la imagen del reto 303
    Cuando leo las notas adjuntas
    Y abro la imagen
    Y detallo cada parte de ella
    Entonces resuelvo el reto
