# sumadigitos.py
# sumar entrada de datos digitos
nconta = 0
resulat = ""
nconta = int(raw_input("Por favor digitar N: "))  # lee N valores a procesar

for y in range(nconta):
    valores = raw_input("Dato %i:" % y)  # captura valores
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

    resulat = resulat + " " + str(resultado)  # concatena resultados

print resulat.strip()  # imprime resultado total
