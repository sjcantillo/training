"""Given the firs number of the sequence the increment and the
n numbers to calculate this fucntions calculate the sum of the n
numbers of the sequence"""


def arithmeticprogression(data):
    """Calculate sum of the first n menbers of given sequence"""
    temp = data.split("\n")
    res = ""
    tlist = []
    nrep = 0
    for i in range(0, int(temp[0])):
        tlist = temp[i+1].split(" ")
        for idx in range(0, int(tlist[2])):
            nrep += int(tlist[0]) + (idx * int(tlist[1]))
        res += str(nrep) + " "
        nrep = 0
    print res
