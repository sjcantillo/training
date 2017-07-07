"""This function sum the number in array of length 2"""


def sumaloop(data):
    """Sum tow number in an array"""
    temp = data.split("\n")
    res = ""
    tlist = []
    nusum = 0
    for i in range(0, int(temp[0])):
        tlist = temp[i+1].split(" ")
        nusum = int(tlist[0]) + int(tlist[1])
        res += str(nusum) + " "
    print res
