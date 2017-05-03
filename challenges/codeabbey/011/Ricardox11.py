ncon = 0
resadot = ""
ncon = int(raw_input("Por favor digitar N: "))

for y in range(ncon):
    valores = raw_input("Dato %i:" % y)
    valores = valores.split(" ")
    valor1 = int(valores[0])
    valor2 = int(valores[1])
    valor3 = int(valores[2])

    temporaldiv = 0
    resultado = 0
    temporal = (valor1 * valor2) + valor3
    nvalor = len(str(temporal))

    for i in range(nvalor):
       temporaldiv = (temporal % 10)
       temporal = (temporal / 10)
       resultado = resultado + temporaldiv

    resadot = resadot + " " +  str(resultado)

print resadot.strip()
