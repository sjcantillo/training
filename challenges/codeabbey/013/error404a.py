"""This function calculate the Weighted sum of digits"""


def sumawsdloop(data):
    """multiplying each digit by its position and then sum"""
    temp = data.split("\n")
    res = ""
    tlist = []
    weight = 0
    for inpt in range(0, int(temp[0])):
        tlist = temp[1].split(" ")
        for dig in range(0, len(tlist[inpt])):
            weight += (int(tlist[inpt][dig]) * (dig + 1))
        res += str(weight) + " "
        weight = 0;
    print res
