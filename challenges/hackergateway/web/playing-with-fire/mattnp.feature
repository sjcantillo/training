# language: es

Característica: Resolver reto Playing with Fire
  Del sitio https://www.hackergateway.com/
  De la categoría Web
  Con mi usuario mattnp

  Antecedentes:
    Dado que estoy registrado en el sitio https://www.hackergateway.com/
    Y tengo el sistema operativo Windows 10 versión 1703
    Y he instalado el software Mozilla Firefox versión 54.0.1
    Y tengo acceso a internet

  Escenario: Primer intento fallido
    Dado que estoy autenticado con mi usuario mattnp
    Cuando ingreso al reto Playing with Fire
    Y el sitio me redirige a la página principal
    Y el sitio me muestra un mensaje que solicita que use un Galaxy Note 7 para ingresar a la página
    Entonces no resuelvo el reto
    Pero concluyo que debo cambiar el user-agent de mi navegador

  Escenario: Solución exitosa
    Dado que estoy autenticado con mi usuario mattnp
    Cuando averiguo el user-agent de un Samsung Galaxy Note 7
    Y utilizo una herramienta para cambiar el user-agent del navegador
    Y vuelvo a ingresar al reto Playing with Fire
    Y el sitio me muestra un texto con la respuesta
    Y digito la respuesta en el cuadro de diálogo
    Y presiono el botón
Entonces resuelvo el reto
