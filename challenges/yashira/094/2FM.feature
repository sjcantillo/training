# language: es

Característica: Resolver reto 94
  Del sitio yashira.org
  De la categoría Esteganografía
  Con mi usuario  Kfer_forK

  Antecedentes:
    Dado estoy registrado en el sitio yashira.org
    Y tengo el S.O. Windows 10 versión 10.0.14393
    Y tengo acceso a internet
    Y tengo Photoshop CS6
    Y he resuelto el reto 94
    Y a partir de aplicar capas
    Y decodificar la palabra

  Escenario: Intento fallido
    Dado la imagen pcx del reto 94
    Cuando aplico capa de nivel
    Y encuentro la clave
    Y la introduzco en yashira
    Entonces no resuelvo el reto
    Pero concluyo leyendo la descripción que existe algo más

  Escenario: Solución Exitosa
    Dado la imagen pcx del reto 94
    Cuando vario a extremos la capa de nivel
    Y encuentro otra palabra
    Y sospecho que esta cifrada
    Y averiguo cómo cifrar palabras con clave
    Y encuentro Vigènere
    Entonces resuelvo el reto
