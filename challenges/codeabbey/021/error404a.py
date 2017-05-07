"""This function count the how many time
apear a element in an array"""


def arraycounters(data):
    """Count occurrences of an element in an array"""
    temp = data.split("\n")
    limits = temp[0].split(" ")
    datos = temp[1].split(" ")
    counter = []
    res = ""
    index = 0
    for i in range(0, int(limits[1])):
        counter.append(0)
    for x in range(0, int(limits[0])):
        index = int(datos[x]) - 1
        counter[index] += 1
    for p in counter:
        res += str(p) + " "
    print res
