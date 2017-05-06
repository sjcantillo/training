"""This function order an array of numbers
and return the original index"""


def sortwithindex(data):
    temp = data.split("\n")
    repets = int(temp[0])
    temp = temp[1].split(" ")
    res = ""
    for i in range(0, repets):
        temp[i] = [temp[i],(i+1)]
    disorderflg = True
    swapflg = False
    while disorderflg:
        swapflg = False
        for i in range(0, (repets-1)):
            if int(temp[i+1][0]) < int(temp [i][0]):
                swapflg = True
                t = temp[i]
                temp[i] = temp[i+1]
                temp[i+1] = t
        if not(swapflg):
            disorderflg = False
    for n in temp:
        res += str(n[1]) + " "
    print res
