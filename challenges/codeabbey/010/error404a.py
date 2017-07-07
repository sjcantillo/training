"""This functions determine a and b by two points
belonging to the function"""


def linearfunction(data):
    """Calculate a and b by tow points"""
    temp = data.split("\n")
    tlist = []
    parta = 0
    partb = 0
    res = ""
    for i in range(0, int(temp[0])):
        ttlist = temp[i+1].split(" ")
        parta = (int(tlist[3]) - int(tlist[1])) / (int(tlist[2]) - int(tlist[0]))
        partb = int(tlist[1]) - (parta * int(tlist[0]))
        res += "(" + str(int(parta)) + " " + str(int(partb)) + ") "
    print res
