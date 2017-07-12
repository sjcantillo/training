# language: es

Característica: Resolver reto Realistic II
  Del sitio http://www.javaist.com/rosecode/
  De la categoría Hack
  Con mi usuario erisohv

  Antecedentes:
    Dado que estoy registrado en el sitio http://www.javaist.com/rosecode
    Y tengo el sistema operativo Linux Mint 18
    Y tengo instalado el software Chrome versión 59.0.3071.109
    Y tengo acceso a internet
    Y conozco la página www.google.com
    Y conozco la página sqltest.net
    E investigo acerca de SQL injection y mod_security de Apache
    E investigo algunos sentencias sql que me pueden servir
    Y practico algunos tutoriales
    Y he resuelto el reto Realistic II

  Escenario: Solución exitosa
    Dado que estoy autenticado con mi usuario erisohv
    Y accedo al link del reto
    Y accedo a la pagina que debo hackear
    Y practico algunos SQL a través del parámetro GET del enlace
    Y obtengo el nombre de la base de datos, la tabla y las columnas
    Y obtengo el nombre del usuario admin cambiando el parámetro GET
    Y utilizo otro SQL para obtener la contraseña de el administrador
    Y obtengo el MD5 de la contraseña
    Y desencripto el MD5 con una herramienta online
    Cuando accedo con las credenciales "Admin" - "onebrain"
    Entonces resuelvo el reto
