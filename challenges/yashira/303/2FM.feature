# language: es

Característica: Resolver reto 303
  Del sitio yashira.org
  De la categoría Esteganografía
  Con mi usuario  Kfer_forK

  Antecedentes:
    Dado estoy registrado en el sitio yashira.org
    Y tengo el S.O. Windows 10 versión 10.0.14393
    Y tengo software de edición de imágenes
    Y he resuelto el reto 303
    Y a partir de Photoshop CS6

  Escenario: Solución Exitosa
    Dado la cinta de colores del reto 303
    Cuando intuyo que el mensaje esta oculto en los colores
    Y abro la imagen con Photoshop CS6
    Y aplico capa de nivel
    Entonces resuelvo el reto
