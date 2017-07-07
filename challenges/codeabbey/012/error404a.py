"""This function calculate the difference between tow date
of the same month
input data:
3
1 0 0 0 2 3 4 5
5 3 23 22 24 4 20 45
8 4 6 47 9 11 51 13"""


def moduletimediference(data):
    """Calculate the difference between tow dates of the same month"""
    temp = data.split("\n")
    tlist = []
    nuday1 = 0
    nuhour1 = 0
    numin1 = 0
    tdif1 = 0
    tdif2 = 0
    res = ""
    daytime = 60 * 60 * 24
    hourtime = 60 * 60
    for i in range(0, int(temp[0])):
        tlist = temp[i+1].split(" ")
        nuday1 = int(tlist[4]) * daytime
        nuhour1 = int(tlist[5]) * hourtime
        numin1 = int(tlist[6]) * 60
        tdif1 = nuday1 + nuhour1 + numin1 + int(tlist[7])
        nuday1 = int(tlist[0]) * daytime
        nuhour1 = int(tlist[1]) * hourtime
        numin1 = int(tlist[2]) * 60
        tdif2 = nuday1 + nuhour1 + numin1 + int(tlist[3])
        tdif1 = tdif1 - tdif2 
        nuday1 = tdif1 // daytime
        nuhour1 = (tdif1 % daytime) // hourtime
        numin1 = (tdif1 % hourtime) // 60
        res += "(" + str(nuday1) + " " + str(nuhour1) 
        res += " " + str(numin1) + " " + str(tdif1 % 60) + ") "
    print res
