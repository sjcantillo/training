"""This functions calculate the round of a/b"""


def divround(data):
    """Calculate the round of a division"""
    temp = data.split("\n")
    res = ""
    tlist = []
    nudiv = 0
    for i in range(0, int(temp[0])):
        tlist = temp[i+1].split(" ")
        nudiv = round(int(tlist[0]) / int(tlist[1]))
        res += str(nudiv) + " "
    print res
