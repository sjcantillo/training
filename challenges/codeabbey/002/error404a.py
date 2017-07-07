"""This function sum the number in array"""


def sumaloop1(data):
    """Sum the members of array"""
    temp = data.split("\n")
    tlist = []
    res = 0
    for i in range(0, int(temp[0])):
        tlist = temp[1].split(" ")
        res += int(tlist[i])
    print res
