# sumadigitos.py
# sumar entrada de datos digitos

rangco = int(raw_input("Por favor digitar N: "))  # lee N valores a procesar
resultado2 = ""

for y in range(rangco):
    valores = raw_input("Dato %i:" % y)  # captura valores1
    valores = valores.split(" ")  # separa en cadena
    valor1 = int(valores[0])  # lee cada valor
    valor2 = int(valores[1])
    valor3 = int(valores[2])

    temporaldiv = 0
    resultado = 0
    temporal = (valor1 * valor2) + valor3   # suma valores
    nvalor = len(str(temporal))  # longitud de valores a sumar

    for i in range(nvalor):
        temporaldiv = (temporal % 10)  # usa modo para separar
        temporal = (temporal / 10)  # calcula siguiente numero
        resultado = resultado + temporaldiv  # suma cada valor

    resultado2 = resultado2 + " " + str(resultado)  # concatena resultados

print resultado2.strip()  # imprime resultado total
