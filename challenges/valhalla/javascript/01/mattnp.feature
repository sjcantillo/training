# language: es

Característica: Resolver reto Javascript1
  Del sitio https://halls-of-valhalla.org
  De la categoría Javascript
  Con mi usuario mattnp

  Antecedentes:
    Dado que estoy registrado en el sitio https://halls-of-valhalla.org
    Y tengo el sistema operativo Windows 10 versión 1703
    Y he instalado el software Mozilla Firefox versión 54.0.1
    Y tengo acceso a internet

  Escenario: Solución exitosa
    Dado que estoy autenticado con mi usuario mattnp
    Cuando veo que la página muestra un código para verificar si un número es par o impar
    Y el código llama a una función en PHP que se llama getPassword
    Y pruebo la funcionalidad del algoritmo
    Y uso las herramientas para desarrollador del navegador para ver la petición que se envió
    Y encuentro que en la petición se envía el nombre del método
    Y cambio la petición para que ejecute el método getPassword
    Y encuentro que el sitio me da la respuesta donde antes mostraba si un número es par o impar
    Y escribo la respuesta en el cuadro de diálogo del reto
    Y presiono el botón
Entonces resuelvo el reto
