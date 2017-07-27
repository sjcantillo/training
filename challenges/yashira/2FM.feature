# language: es

Característica: Resolver reto 282
  Del sitio yashira.org
  De la categoría Esteganografía
  Con mi usuario  Kfer_forK

  Antecedentes:
    Dado estoy registrado en el sitio yashira.org
    Y tengo el S.O. Windows 10 versión 10.0.14393
    Y tengo acceso a internet
    Y tengo el software ExamDiff
    Y he resuelto el reto 282
    Y a partir de comparar los pdf

  Escenario: Solución Exitosa
    Dado los archivos pdf del reto 282
    Cuando busco herramientas para comparación de archivos
    Y encuentro ExamDiff
    Y comparo los archivos
    Y encuentro la única palabra que es diferente en los dos
    Entonces resuelvo el reto
