"""This function calculate the sum of the digits
of the result of multiplaying a * b + c"""


def sumadigitloop(data):
    """Calculate de digit sum"""
    temp = data.split("\n")
    res = ""
    tlist = []
    opres = 0
    digsum = 0
    for i in range(0, int(temp[0])):
        tlist = temp[i+1].split(" ")
        opres = (int(tlist[0]) * int(tlist[1])) + int(tlist[2])
        for i in str(opres):
            digsum += int(i)
        res += str(digsum) + " "
        digsum = 0
    print res
