# language: es

Característica: Resolver reto Basic 21
  Del sitio https://www.enigmagroup.org/
  De la categoría Basic SQL Injection Challenges
  Con mi usuario mattnp

  Antecedentes:
    Dado que estoy registrado en el sitio https://www.enigmagroup.org/
    Y tengo el sistema operativo Windows 10 versión 1703
    Y he instalado el software Mozilla Firefox versión 54.0.1
    Y tengo acceso a internet

  Escenario: Primer intento fallido
    Dado que estoy autenticado con mi usuario mattnp
    Cuando veo que el reto es de SQL Injection
    Y solicita una contraseña
    Y digito ' or 1=1
    Entonces no resuelvo el reto
    Pero concluyo que debo cambiar el código para explotar la vulnerabilidad

  Escenario: Solución exitosa
    Dado que estoy autenticado con mi usuario mattnp
    Cuando vuelvo a ingresar al reto
    Y escribo en el campo de contraseña el código ' or 1=1 -- v
    Y presiono el botón
Entonces resuelvo el reto
