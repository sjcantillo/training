# language: es

Característica: Resolver reto Empire Secret
  Del sitio https://www.hackergateway.com/
  De la categoría Cryptography
  Con mi usuario mattnp

  Antecedentes:
    Dado que estoy registrado en el sitio https://www.hackergateway.com/
    Y tengo el sistema operativo Windows 10 versión 1703
    Y he instalado el software Mozilla Firefox versión 54.0.1
    Y tengo acceso a internet

  Escenario: Solución exitosa
    Dado que estoy autenticado con mi usuario mattnp
    Cuando veo que el mensaje cifrado muestra carácteres alfabéticos
    Y los carácteres parecen formar cuatro palabras
    Y la primera palabra es de tres letras, le segunda de seis y la tercera de dos
    Y supongo que las tres primeras palabras forman la frase "The answer is"
    Y deduzco que se trata de un cifrado del César
    Y uso la teoría del sistema de cifrado para encontrar el valor del corrimiento
    Y encuentro la respuesta del reto
    Y escribo la respuesta en el cuadro de diálogo del reto
    Y presiono el botón
Entonces resuelvo el reto
